package cl.schedulator.api.usecases;

import cl.schedulator.api.domain.entities.Task;
import cl.schedulator.api.domain.entities.DailyTask;
import cl.schedulator.api.domain.entities.TaskSummary;
import cl.schedulator.api.domain.entities.TemporaryTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskOptimizer {
    private List<Task> tasks;
    private List<TemporaryTask> temporaryTasks;
    private TaskSummary summary;
    private final int MAX_DURATION = 8;

    private TaskOptimizer(List<Task> tasks) {
        this.tasks = tasks;
        this.summary = new TaskSummary(this.tasks.size());
        this.sortTasks();
        this.prepareTemporaryElements();
    }

    public static TaskOptimizer createOptimizer(List<Task> tasks) {
        return new TaskOptimizer(tasks);
    }

    private void sortTasks() {
        Collections.sort(this.tasks);
    }

    private void prepareTemporaryElements() {
        this.temporaryTasks = new ArrayList<>();
        this.tasks.stream().forEach(t -> {
            temporaryTasks.add(new TemporaryTask(t.getTaskId(), t.getTaskName(), t.getDuration()));
        });
        String xxx = "";
    }

    public TaskSummary optimizeTaskDistribution() {
        List<DailyTask> dailyTasks = new ArrayList<>();
        int dayCounter = 1;
        for (Task t : this.tasks) {
            disableTemporaryElement(t.getTaskId());
            dailyTasks.add(this.searchTasks(t, dayCounter, t.getDuration()));
            dayCounter++;
        }
        dailyTasks.stream().forEach(d -> this.summary.addDaylyTask(d));
        return this.summary;
    }

    private void disableTemporaryElement(String currentTaskId) {
        for (TemporaryTask t : temporaryTasks) {
            if (t.getTaskId().equals(currentTaskId)) {
                t.changeAvailability(false);
            }
        }
    }

    private DailyTask searchTasks(Task currentTask, int dayCounter, int currentDuration) {
        DailyTask dt = new DailyTask(dayCounter);
        dt.addTask(currentTask);
        List<TemporaryTask> tmpTasks = this.temporaryTasks.stream()
                .filter(t -> t.isAvailable())
                .collect(Collectors.toList());
        for (TemporaryTask t : tmpTasks) {
            if (evaluateConstrains(currentDuration, currentTask, t)) {
                dt.addTask(new Task(t.getTaskId(), t.getTaskName(), t.getDuration()));
                disableTemporaryElement(t.getTaskId());
                currentDuration += t.getDuration();
            }
        }
        ;
        return dt;
    }

    private Boolean evaluateConstrains(int hoursQuantities, Task currentTask, TemporaryTask evaluateTask) {
        if (currentTask.getTaskId().equals((evaluateTask.getTaskId()))) return false;
        if (!evaluateTask.isAvailable()) return false;
        if ((hoursQuantities + evaluateTask.getDuration()) > MAX_DURATION) return false;
        return true;
    }


}

package cl.schedulator.api.domain.entities;


import javax.sound.sampled.DataLine;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class TaskSummary {
    private int totalTask;
    private int totalDays;
    private List<DailyTask> days;

    public TaskSummary(int totalTask){
        this.totalTask=totalTask;
        this.days = new ArrayList<>();
        this.totalDays=0;
    }

    public void  addDaylyTask(DailyTask dailyTask){
        this.days.add(dailyTask);
    }

    public int getTotalTasks(){
        return this.totalTask;
    }

    public List<DailyTask> getTaskPerDay(){
        return this.days;
    }

    public int totalDays(){
        this.totalDays = this.days.size();
        return this.totalDays;
    }
}

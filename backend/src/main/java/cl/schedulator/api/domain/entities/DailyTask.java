package cl.schedulator.api.domain.entities;


import java.util.ArrayList;
import java.util.List;

public class DailyTask {
    private List<Task> tasks;
    private int dayNumber;

    public DailyTask(int dayNumber){
        this.dayNumber = dayNumber;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public int getDayNumber(){
        return this.dayNumber;
    }

    public List<Task> getTasks(){
        return this.tasks;
    }

    public int getTaskQuantity(){
        return this.tasks.size();
    }

}

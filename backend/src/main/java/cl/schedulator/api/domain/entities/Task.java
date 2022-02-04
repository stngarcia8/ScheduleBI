package cl.schedulator.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Task implements Comparable<Task> {
    @JsonProperty("task_id")
    private String taskId;

    @JsonProperty("task_name")
    private String taskName;

    @JsonProperty("duration")
    private Integer duration;

    public Task() {
    }

    public Task(String taskId, String taskName, Integer duration) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.duration = duration;
    }

    @Override
    public int compareTo(Task comparableTask){
        if(comparableTask == null || this.duration == null ) return 0;
        if(this.duration < comparableTask.duration) return 1;
        if(this.duration > comparableTask.duration) return -1;
        return 0;
    }

    public String getTaskId(){
        return this.taskId;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public int getDuration(){
        return this.duration;
    }

}

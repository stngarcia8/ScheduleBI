package cl.schedulator.api.domain.entities;

public class TemporaryTask {
    private final String taskId;
    private final String taskName;
    private final Integer duration;
    private Boolean available;

    public TemporaryTask(String taskId, String taskName, Integer duration) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.duration = duration;
        this.available = true;
    }

    public String getTaskId(){
        return this.taskId;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public int getDuration() {
        return this.duration;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public void changeAvailability(Boolean status) {
        this.available = status;
    }
}



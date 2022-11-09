package practicejavacore.com;

public class Task {

    public String nameTask;
    public String descriptionTask;
    private StatusTask statusTask;
    protected static int idGlobal = 1;
    private final int id;

    public Task(String nameTask, String descriptionTask) {
        this.nameTask = nameTask;
        this.descriptionTask = descriptionTask;
        this.statusTask = StatusTask.NEW;
        this.id = idGlobal++;
    }

    public Task() {
        this.id = idGlobal++;
    }

    //    public Task() {
//        this.id = idGlobal++;
//    }
    public String getNameTask() {
        return this.nameTask;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public int getId() {
        return id;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    @Override
    public String toString() {
        return "это обычный таск - " + getNameTask();
    }
}

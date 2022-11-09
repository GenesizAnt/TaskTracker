package practicejavacore.com;

public class SubTask extends Task {

    private StatusTask statusTask;
    private final int id;
    private EpicTask epicTask;


    public SubTask(String nameTask, String descriptionTask, EpicTask epicTask) {
        this.nameTask = nameTask;
        this.descriptionTask = descriptionTask;
        this.epicTask = epicTask;
        this.epicTask.addNewSubTask(this);
        this.statusTask = StatusTask.NEW;
        this.id = idGlobal++;
    }

    @Override
    public String getNameTask() {
        return this.nameTask;
    }

    @Override
    public StatusTask getStatusTask() {
        return statusTask;
    }

    @Override
    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    @Override
    public int getId() {
        return id;
    }

    public EpicTask getEpicTask() {
        return epicTask;
    }

    @Override
    public String toString() {
        return "это подтаск задачи - " + epicTask.getNameTask() + " Название сабтаска: " + getNameTask() + "; ";
    }
}

package practicejavacore.com;

public class SubTask extends Task {

    private StatusTask statusTask;
    private final int id;
    private final int idEpicTask;


    public SubTask(String nameTask, String descriptionTask, int idEpicTask) {
        super(nameTask, descriptionTask);
        this.idEpicTask = idEpicTask;
        this.statusTask = StatusTask.NEW;
        this.id = idGlobal++;
    }


    @Override
    public String getNameTask() {
        return super.getNameTask();
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

    public int getIdEpicTask() {
        return idEpicTask;
    }

    @Override
    public String toString() {
        return "это подтаск" + getNameTask();
    }
}

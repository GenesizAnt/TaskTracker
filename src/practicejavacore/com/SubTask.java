package practicejavacore.com;
import static practicejavacore.com.InMemoryTaskManager.idGlobal;

public class SubTask implements Taskable {

    private String nameTask;
    private String descriptionTask;
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

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public int getId() {
        return id;
    }

    public EpicTask getEpicTask() {
        return epicTask;
    }

    @Override
    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    @Override
    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public void setEpicTask(EpicTask epicTask) {
        this.epicTask = epicTask;
    }

    @Override
    public String toString() {
        return "это подтаск задачи - " + epicTask.getNameTask() + " Название сабтаска: " + getNameTask() + "; ";
    }
}

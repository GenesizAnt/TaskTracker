package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;
import static practicejavacore.com.InMemoryTaskManager.idGlobal;

public class EpicTask implements Taskable {

    private String nameTask;
    private String descriptionTask;
    private StatusTask statusTask;
    private List<SubTask> subTasks = new ArrayList<>();
    private SubTask subTask;
    private final int id;


    public EpicTask(String nameTask, String descriptionTask) {
        this.nameTask = nameTask;
        this.descriptionTask = descriptionTask;
        this.id = idGlobal++;
        statusTask = StatusTask.NEW;
    }

    public void addNewSubTask(SubTask subTask) {
        subTasks.add(subTask);
    }

    public List<SubTask> getSubTasks() {
        return subTasks;
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

    public SubTask getSubTaskByID(int id) {
        return subTasks.get(id);
    }

    @Override
    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    @Override
    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    @Override
    public String toString() {
        return "это супертаск - " + getNameTask();
    }
}

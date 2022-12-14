package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {

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


    @Override
    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    @Override
    public int getId() {
        return id;
    }

    public SubTask getSubTaskByID(int id) {
        return subTasks.get(id);
    }

    @Override
    public String toString() {
        return "это супертаск - " + getNameTask();

    }
}

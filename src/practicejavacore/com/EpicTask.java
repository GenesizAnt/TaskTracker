package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;

public class EpicTask extends Task {

    private StatusTask statusTask;
    private List<SubTask> statusTasks = new ArrayList<>();
    private SubTask subTask;
    private final int id;


    public EpicTask(String nameTask, String descriptionTask) {
        super(nameTask, descriptionTask);
        this.id = idGlobal++;
        statusTask = StatusTask.NEW;
    }

    public void addNewSubTask(SubTask subTask) {
        statusTasks.add(subTask);
    }

    @Override
    public String getNameTask() {
        return super.getNameTask();
    }


    @Override
    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setSubTask(SubTask subTask) {
        this.subTask = subTask;
    }


    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        System.out.println("это супертаск " + getNameTask());
        for (SubTask task : statusTasks) {
            System.out.println(task);
        }
        return "";
    }
}

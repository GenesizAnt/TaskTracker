package practicejavacore.com;

public interface ManagerTask {

    void addTaskInManager(Taskable task);

    void viewTaskList();

    void removeAllTask();

    void getTaskByID(int id);

    void createNewTask(String name, String description, int varTask);

    void updateAllInfoTask(String name, String description, int statusTask, int id);

    void updateTaskName(String name, int id);

    void updateTaskDescription(String description, int id);

    void updateTaskStatus(int statusTask, int id);

    void checkStatusEpicTask();

    void checkStatusSubTask();

    void removeTaskByID(int id);

    void viewSubTaskByEpic(EpicTask epicTask);

    void viewTaskByType(int varType);

}

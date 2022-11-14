package practicejavacore.com;

interface Taskable {

    int getId();

    void setNameTask(String name);

    void setDescriptionTask(String description);

    void setStatusTask(StatusTask statusTask);

    StatusTask getStatusTask();

    String getNameTask();
}

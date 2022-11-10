package practicejavacore.com;

public enum StatusTask {
    NEW(1), IN_PROGRESS(2), DONE(0);

    private int statusID;

    StatusTask(int statusID) {
        this.statusID = statusID;
    }

    public void getDescribeStatusTask(StatusTask statusTask) {
        switch (statusTask){
            case NEW -> System.out.println("Задача только создана, к выполнению не приступали");
            case IN_PROGRESS -> System.out.println("Над задачей ведется работа");
            case DONE -> System.out.println("Задача выполнена");
        }
    }

    public int getStatusID() {
        return statusID;
    }
}

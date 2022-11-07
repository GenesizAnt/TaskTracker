package practicejavacore.com;

public enum StatusTask {

    NEW, IN_PROGRESS, DONE;

    public void getDescribeStatusTask(StatusTask statusTask) {
        switch (statusTask){
            case NEW -> System.out.println("Задача только создана, к выполнению не приступали");
            case IN_PROGRESS -> System.out.println("Над задачей ведется работа");
            case DONE -> System.out.println("Задача выполнена");
        }
    }

}

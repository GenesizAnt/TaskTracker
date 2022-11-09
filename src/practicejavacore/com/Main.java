package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ManagerTask managerTask = new ManagerTask();

        Task task = new Task("test", "test");
        Task task1 = new Task("test1", "test1");
        EpicTask epicTask = new EpicTask("epicTest", "Epictest");
        EpicTask epicTask1 = new EpicTask("testEpic1", "testEpic1");
        SubTask subTask = new SubTask("testSub", "testSub", epicTask);
        SubTask subTask1 = new SubTask("testSub1", "testSub1", epicTask);
        SubTask subTask2 = new SubTask("testSub2", "testSub2", epicTask1);

//        managerTask.addTaskInManager(task1);
//        managerTask.addTaskInManager(epicTask);
//        managerTask.addTaskInManager(subTask);
//        managerTask.addTaskInManager(task);
//

        managerTask.createNewTask("test", "test", 1);
        managerTask.createNewTask("test", "test", 3);

        managerTask.viewTaskList();

//        managerTask.getTaskByID(1);

//        System.out.println(task);
//        System.out.println(epicTask);

    }
}

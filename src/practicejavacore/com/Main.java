package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Task task = new Task("test", "test");
        EpicTask epicTask = new EpicTask("epicTest", "Epictest");
        EpicTask epicTask1 = new EpicTask("testEpic1", "testEpic1");
        SubTask subTask = new SubTask("testSub", "testSub", epicTask.getId());
        SubTask subTask1 = new SubTask("testSub1", "testSub1", epicTask.getId());
        SubTask subTask2 = new SubTask("testSub2", "testSub2", epicTask1.getId());
        epicTask.addNewSubTask(subTask);
        epicTask.addNewSubTask(subTask1);
        epicTask1.addNewSubTask(subTask2);

        System.out.println(task);
        System.out.println(epicTask);

    }
}

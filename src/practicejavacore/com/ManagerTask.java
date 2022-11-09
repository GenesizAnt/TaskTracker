package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static practicejavacore.com.Task.idGlobal;

public class ManagerTask {

    private List<Task> taskList = new ArrayList<>();

    public void addTaskInManager(Task task) {
        if (task instanceof SubTask) {
            System.out.println("Подзадача не может существовать отдельно, добавьте задачу - " + task.getNameTask() + " как обычную задачу");
        } else {
            taskList.add(task);
        }
    }

    public void viewTaskList() {
        if (taskList.isEmpty()) {
            System.out.println("Список задач пуст");
        } else {
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(taskList.get(i));
            }
        }
    }

    public void removeAllTask() {
        if (taskList.isEmpty()) {
            System.out.println("Список задач уже пуст");
        } else {
            taskList.removeAll(taskList);
        }
    }

    public void getTaskByID(int id) {
        if (idGlobal <= 0) {
            System.out.println("Таких задач не бывет, ID начинаются с 1");
        } else if (id > idGlobal) {
            System.out.println("Такую задачу еще не создали");
        } else {
            for (Task task : taskList) {
                if (task.getId() == id) {
                    System.out.println(task);
                    break;
                }
            }
        }
    }

    public void createNewTask(String name, String description, int varTask) {
//        System.out.println("Какую задачу вы хотите добавить? ВНИМАНИЕ - порзадачи добавляются только к большим задачам!\n" +
//                "1 - обычная задача" +
//                "2 - большая задача" +
//                "3 - подзадача");
        switch (varTask) {
            case 1 -> taskList.add(new Task(name, description));
            case 2 -> taskList.add(new EpicTask(name, description));
            case 3 -> {
                System.out.println("Введите наименование большой задачи");
                Scanner scanner = new Scanner(System.in);
                String nameEpicTask = scanner.next();
                for (Task task : taskList) {
                    if (task.getNameTask().equals(nameEpicTask)) {
                        taskList.add(new SubTask(name, description, (EpicTask) task));
                    } else {
                        System.out.println("Большая задача для подзадачи не найдена");
                    }
                }
            }
            default -> System.out.println("Такого типа задач нет");
        }

    }

    public void removeTaskByID(int id) {
        taskList.remove(id);
    }

}

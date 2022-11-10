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
        } else if (task instanceof EpicTask) {
            taskList.add(task);
            taskList.addAll(((EpicTask) task).getSubTasks());
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

    public void updateAllInfoTask(String name, String description, int statusTask, int id) {
//        System.out.println("Какой статус установить задаче\n" +
//                "1 - работа на задачей ведется" +
//                "2 - задача выполнена");
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setNameTask(name);
                task.setDescriptionTask(description);
                switch (statusTask) {
                    case 1 -> task.setStatusTask(StatusTask.IN_PROGRESS);
                    case 2 -> task.setStatusTask(StatusTask.DONE);
                    default -> System.out.println("Такого вида задачи нет");
                }
            }
            System.out.println("Задача не найдена!");
        }
    }

    public void updateTaskName(String name, int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setNameTask(name);
            }
            System.out.println("Задача не найдена!");
        }
    }

    public void updateTaskDescription(String description, int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                task.setDescriptionTask(description);
            }
            System.out.println("Задача не найдена!");
        }
    }

    public void updateTaskStatus(int statusTask, int id) {
//        System.out.println("Какой статус установить задаче\n" +
//                "1 - работа на задачей ведется" +
//                "2 - задача выполнена");
        for (Task task : taskList) {
            if (task.getId() == id) {
                switch (statusTask) {
                    case 1 -> {
                        task.setStatusTask(StatusTask.IN_PROGRESS);
                        checkStatusEpicTask();
                        checkStatusSubTask();
                    }
                    case 2 -> {
                        task.setStatusTask(StatusTask.DONE);
                        checkStatusEpicTask();
                        checkStatusSubTask();
                    }
                    default -> System.out.println("Такого вида задачи нет");
                }
            }
        }
    }

    public void checkStatusEpicTask() {
        int checkStatus = 0;
        for (Task task : taskList) {
            if (task instanceof EpicTask) {
                for (int i = 0; i < ((EpicTask) task).getSubTasks().size(); i++) {
                    checkStatus += ((EpicTask) task).getSubTasks().get(i).getStatusTask().getStatusID();
                }
                if (checkStatus == 0) {
                    task.setStatusTask(StatusTask.DONE);
                } else {
                    task.setStatusTask(StatusTask.IN_PROGRESS);
                }
            }
        }
    }

    public void checkStatusSubTask() {
        for (Task task : taskList) {
            if (task.getClass() == EpicTask.class) {
                if (task.getStatusTask() == StatusTask.DONE) {
                    for (int i = 0; i < ((EpicTask) task).getSubTasks().size(); i++) {
                        ((EpicTask) task).getSubTasks().get(i).setStatusTask(StatusTask.DONE);
                    }
                }
            }
        }
    }

    public void removeTaskByID(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                taskList.remove(i);
            }
        }
    }

    public void viewSubTaskByEpic(EpicTask epicTask) {
        for (SubTask task : epicTask.getSubTasks()) {
            System.out.println(task);
        }
    }

    public void viewTaskByType(int varType) {
//        System.out.println("Какой вид задач хотите посмотреть?\n" +
//                "1 - обычные задачи" +
//                "2 - большие задачи" +
//                "3 - подзадачи");
        switch (varType) {
            case 1: {
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).getClass() == Task.class) {
                        System.out.println(taskList.get(i));
                    }
                }
            }
            break;
            case 2: {
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).getClass() == EpicTask.class) {
                        System.out.println(taskList.get(i));
                    }
                }
            }
            break;
            case 3: {
                for (int i = 0; i < taskList.size(); i++) {
                    if (taskList.get(i).getClass() == SubTask.class) {
                        System.out.println(taskList.get(i));
                    }
                }
            }
            break;
            default: {
                System.out.println("Такого вида задач нет");
            }
        }

    }

}

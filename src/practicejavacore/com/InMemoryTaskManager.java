package practicejavacore.com;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class InMemoryTaskManager implements ManagerTask {

    static int idGlobal = 1;

    private List<Taskable> allTaskList = new ArrayList<>();
    private HashMap<Integer, Task> taskList = new HashMap<>();
    private HashMap<Integer, EpicTask> epicTaskList = new HashMap<>();
    private HashMap<Integer, SubTask> subTaskList = new HashMap<>();

    public List<Taskable> lastViewTask() {



        return null;
    }

    public void addTask() {
        System.out.println("Какую задачу Вы хотите добавить?\n" +
                "1 - Обычная задача\n" +
                "2 - Большая задача\n" +
                "3 - Подзадача для большой задачи");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1: {
                System.out.println("Введите наименование задачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                Task task = new Task(name, description);
                taskList.put(task.getId(), task);
                System.out.println("Задача " + name + " добавлена");
                break;
            }
            case 2: {
                System.out.println("Введите наименование большой задачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                epicTaskList.put(name, description);
                System.out.println("Задача " + name + " добавлена");
                break;
            }
            case 3: {
                System.out.println("Введите наименование большой задачи для добавления");
                String nameEpicTask = scanner.next();
                System.out.println("Введите наименование подзадачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                subTaskList.put(name, description);
            }
            default -> System.out.println("Такого типа задач нет");
        }

    }



    public void addTaskInManager(Taskable task) {
        if (task instanceof SubTask) {
            System.out.println("Подзадача не может существовать отдельно, добавьте задачу - " + task.getNameTask() + " как обычную задачу");
        } else if (task instanceof EpicTask) {
            allTaskList.add(task);
            allTaskList.addAll(((EpicTask) task).getSubTasks());
        } else {
            allTaskList.add(task);
        }
    }

    public void viewTaskList() {
        if (allTaskList.isEmpty()) {
            System.out.println("Список задач пуст");
        } else {
            for (Taskable taskable : allTaskList) {
                System.out.println(taskable);
            }
        }
    }

    public void removeAllTask() {
        if (allTaskList.isEmpty()) {
            System.out.println("Список задач уже пуст");
        } else {
            allTaskList.removeAll(allTaskList);
        }
    }

    public void getTaskByID(int id) {
        if (idGlobal <= 0) {
            System.out.println("Таких задач не бывет, ID начинаются с 1");
        } else if (id > idGlobal) {
            System.out.println("Такую задачу еще не создали");
        } else {
            for (Taskable task : allTaskList) {
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
            case 1 -> allTaskList.add(new Task(name, description));
            case 2 -> allTaskList.add(new EpicTask(name, description));
            case 3 -> {
                System.out.println("Введите наименование большой задачи");
                Scanner scanner = new Scanner(System.in);
                String nameEpicTask = scanner.next();
                for (Taskable task : allTaskList) {
                    if (task.getNameTask().equals(nameEpicTask)) {
                        allTaskList.add(new SubTask(name, description, (EpicTask) task));
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
        for (Taskable task : allTaskList) {
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
        for (Taskable task : allTaskList) {
            if (task.getId() == id) {
                task.setNameTask(name);
            }
            System.out.println("Задача не найдена!");
        }
    }

    public void updateTaskDescription(String description, int id) {
        for (Taskable task : allTaskList) {
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
        for (Taskable task : allTaskList) {
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
        for (Taskable task : allTaskList) {
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
        for (Taskable task : allTaskList) {
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
        for (int i = 0; i < allTaskList.size(); i++) {
            if (allTaskList.get(i).getId() == id) {
                allTaskList.remove(i);
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
                for (int i = 0; i < allTaskList.size(); i++) {
                    if (allTaskList.get(i).getClass() == Task.class) {
                        System.out.println(allTaskList.get(i));
                    }
                }
            }
            break;
            case 2: {
                for (int i = 0; i < allTaskList.size(); i++) {
                    if (allTaskList.get(i).getClass() == EpicTask.class) {
                        System.out.println(allTaskList.get(i));
                    }
                }
            }
            break;
            case 3: {
                for (int i = 0; i < allTaskList.size(); i++) {
                    if (allTaskList.get(i).getClass() == SubTask.class) {
                        System.out.println(allTaskList.get(i));
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

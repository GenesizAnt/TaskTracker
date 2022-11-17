package practicejavacore.com;

import java.util.*;

public class InMemoryTaskManager implements ManagerTask {

    HistoryManager historyManager = Manager.getDefaultHistory();

    static int idGlobal = 1;

    private List<Taskable> allTaskList = new ArrayList<>();
    private HashMap<String, Task> taskList = new HashMap<>();
    private HashMap<String, EpicTask> epicTaskList = new HashMap<>();
    private HashMap<String, SubTask> subTaskList = new HashMap<>();
    List<String> listNameHistory = new ArrayList<>();




    public List<Taskable> lastViewTask() {
        List<Taskable> listTask = new ArrayList<>();
        for (String s : listNameHistory) {
            for (int j = 0; j < taskList.size(); j++) {
                if (taskList.containsKey(s)) {
                    listTask.add(taskList.get(s));
                }
            }
            for (int j = 0; j < epicTaskList.size(); j++) {
                if (epicTaskList.containsKey(s)) {
                    listTask.add(epicTaskList.get(s));
                }
            }
            for (int j = 0; j < subTaskList.size(); j++) {
                if (subTaskList.containsKey(s)) {
                    listTask.add(subTaskList.get(s));
                }
            }
        }
        return listTask;
    }

    public void historyAdd(String name) {
        if (listNameHistory.size() < 10) {
            listNameHistory.add(name);
        } else {
            listNameHistory.set(0, name);
        }

    }

    public void getTask(String name) {
        historyManager.add(taskList.get(name));
    }

    public void addTask() {
        System.out.println("""
                Какую задачу Вы хотите добавить?
                1 - Обычная задача
                2 - Большая задача
                3 - Подзадача для большой задачи""");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                System.out.println("Введите наименование задачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                Task task = new Task(name, description);
                taskList.put(name, task);
                System.out.println("Задача " + name + " добавлена");
            }
            case 2 -> {
                System.out.println("Введите наименование большой задачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                EpicTask epicTask = new EpicTask(name, description);
                epicTaskList.put(name, epicTask);
                System.out.println("Задача " + name + " добавлена");
            }
            case 3 -> {
                System.out.println("Введите наименование большой задачи для добавления");
                String nameEpicTask = scanner.next();
                System.out.println("Введите наименование подзадачи");
                String name = scanner.next();
                System.out.println("Введите описание задачи");
                String description = scanner.next();
                SubTask subTask = new SubTask(nameEpicTask, description, epicTaskList.get(nameEpicTask));
                subTaskList.put(name, subTask);
                System.out.println("Задача " + name + " добавлена");
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
        if (id <= 0) {
            System.out.println("Таких задач не бывет, ID начинаются с 1");
        } else if (id > idGlobal) {
            System.out.println("Такую задачу еще не создали");
        } else {
            for (Taskable task : allTaskList) {
                if (task.getId() == id) {
                    System.out.println(task);
                    historyManager.add(task);
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

    public HistoryManager getHistoryManager() {
        return historyManager;
    }
}

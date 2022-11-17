package practicejavacore.com;

public class Main {
    public static void main(String[] args) {

//        HistoryManager historyManager = new HistoryManager();

        ManagerTask taskManager = Manager.getDefault();
        HistoryManager historyManager = Manager.getDefaultHistory();


        Task task1 = new Task("Task1", "DTask1");
        Task task2 = new Task("Task2", "DTask2");
        Task task3 = new Task("Task3", "DTask3");
        Task task4 = new Task("Task4", "DTask4");
        Task task5 = new Task("Task5", "DTask5");
        Task task6 = new Task("Task6", "DTask6");
        Task task7 = new Task("Task7", "DTask7");
        Task task8 = new Task("Task8", "DTask8");
        Task task9 = new Task("Task9", "DTask9");
        Task task10 = new Task("Task10", "DTask10");
        Task task11 = new Task("Task11", "DTask11");
        Task task12 = new Task("Task12", "DTask12");
        Task task13 = new Task("Task13", "DTask13");
        Task task14 = new Task("Task14", "DTask14");


        taskManager.addTaskInManager(task1);
        taskManager.addTaskInManager(task2);
        taskManager.addTaskInManager(task3);
        taskManager.addTaskInManager(task4);
        taskManager.addTaskInManager(task5);
        taskManager.addTaskInManager(task6);
        taskManager.addTaskInManager(task7);
        taskManager.addTaskInManager(task8);
        taskManager.addTaskInManager(task9);
        taskManager.addTaskInManager(task10);
        taskManager.addTaskInManager(task11);
        taskManager.addTaskInManager(task12);
        taskManager.addTaskInManager(task13);
        taskManager.addTaskInManager(task14);
        taskManager.getTaskByID(1);
        taskManager.getTaskByID(2);
        taskManager.getTaskByID(3);
        taskManager.getTaskByID(4);
        taskManager.getTaskByID(5);
        taskManager.getTaskByID(6);
        taskManager.getTaskByID(7);
        taskManager.getTaskByID(8);
        taskManager.getTaskByID(9);
        taskManager.getTaskByID(10);
        taskManager.getTaskByID(11);
        taskManager.getTaskByID(12);


//        historyManager.add(task1);
//        historyManager.add(task2);
//        historyManager.add(task3);
//        historyManager.add(task4);
//        historyManager.add(task5);
//        historyManager.add(task6);
//        historyManager.add(task7);
//        historyManager.add(task8);
//        historyManager.add(task9);
//        historyManager.add(task10);
//        historyManager.add(task11);
//        historyManager.add(task12);
//        historyManager.add(task13);
//        historyManager.add(task14);
        taskManager.getHistoryManager().getHistory();

//        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();
//        System.out.println("Привет! Это Просто менеджер задач, давай начнем работу!");
//
//        while (true) {
//            printMenu();
//            Scanner scanner = new Scanner(System.in);
//            int choose = scanner.nextInt();
//            break;
//        }

    }

    public static void printMenu() {
        System.out.println("Выбери, что хочешь сделать: \n" +
                "1 - создать задачу\n" +
                "2 - посмотреть задачу\n" +
                "3 - удалить задачу по ID\n" +
                "4 - удалить все задачи\n" +
                "5 - обновить всю информацию о задаче\n" +
                "6 - обновить имя задачи\n" +
                "7 - обновить описние задачи\n" +
                "8 - обновить статус задачи\n" +
                "9 - посмотреть список подзадач\n" +
                "10 - посмотреть список задач по типу\n" +
                "11 - посмотреть список всех задач\n" +
                "13 - завершить программу");
    }
}

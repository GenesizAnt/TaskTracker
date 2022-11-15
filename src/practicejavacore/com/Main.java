package practicejavacore.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HistoryManager historyManager = new HistoryManager();

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
//        Task task13 = new Task("Task13", "DTask13");
//        Task task14 = new Task("Task14", "DTask14");

        historyManager.historyAdd(task1);
        historyManager.historyAdd(task2);
        historyManager.historyAdd(task3);
        historyManager.historyAdd(task4);
        historyManager.historyAdd(task5);
        historyManager.historyAdd(task6);
        historyManager.historyAdd(task7);
        historyManager.historyAdd(task8);
        historyManager.historyAdd(task9);
        historyManager.historyAdd(task10);
        historyManager.historyAdd(task11);
        historyManager.historyAdd(task12);
//        historyManager.historyAdd(task13);
//        historyManager.historyAdd(task14);
        historyManager.history();

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

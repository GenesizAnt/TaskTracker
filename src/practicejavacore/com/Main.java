package practicejavacore.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagerTask managerTask = new ManagerTask();
        System.out.println("Привет! Это Просто менеджер задач, давай начнем работу!");

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            break;
        }

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

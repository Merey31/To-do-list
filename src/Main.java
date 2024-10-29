import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Выберите команду: ");
            int command = scanner.nextInt();
            switch (command) {
                case (1) -> addTask(scanner);
                case (2) -> printList();
                case (3) -> removeTask(scanner);
                case (0) -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неправильный ввод.");
            }
        }

    }

    static void printMenu() {
        System.out.println("""
                1. Добавить задачу
                2. Вывести список задач
                3. Удалить задачу
                0. Выйти""");
    }

    static void addTask(Scanner scanner) {
        System.out.println("Введите задачу для планирования: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("Задача была добавлена.");
    }

    static void printList() {
        if (tasks.isEmpty()) {
            System.out.println("Запланированных дел нет. ");
        } else {
            System.out.println("Список запланированных дел: ");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void removeTask(Scanner scanner) {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available to remove.");
        } else {
            printList();
            System.out.print("Введите номер задачи для удаления: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= tasks.size()) {
                System.out.println("Удалена задача '" + tasks.get(index - 1) + "'.");
                tasks.remove(index - 1);
            } else {
                System.out.println("Некорректный номер.");
            }
        }
    }
}
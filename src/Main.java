import java.util.Scanner;

// Главный класс для запуска программы
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Основное меню
            System.out.println("\n1. Показать меню");
            System.out.println("2. Внести деньги");
            System.out.println("3. Выбрать напиток");
            System.out.println("4. Выйти");

            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    machine.showMenu(); // Показать меню
                    break;
                case "2":
                    System.out.print("Введите сумму для внесения: ");
                    try {
                        int amount = Integer.parseInt(scanner.nextLine());
                        machine.addMoney(amount); // Внести деньги
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите корректное число.");
                    }
                    break;
                case "3":
                    System.out.print("Введите номер напитка: ");
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        machine.selectDrink(number); // Выбрать напиток
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите корректный номер.");
                    }
                    break;
                case "4":
                    System.out.println("Спасибо за использование вендингового автомата!"); // Завершение работы
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}

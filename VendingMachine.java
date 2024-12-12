import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Drink {
    String name;
    int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class VendingMachine {
    private Map<Integer, Drink> menu;
    private int balance;

    public VendingMachine() {
        menu = new HashMap<>();
        menu.put(1, new Drink("Кока-Кола", 50));
        menu.put(2, new Drink("Пепси", 45));
        menu.put(3, new Drink("Сок", 60));
        menu.put(4, new Drink("Вода", 30));
        balance = 0;
    }

    public void showMenu() {
        System.out.println("\nМеню напитков:");
        for (Map.Entry<Integer, Drink> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name + " - " + entry.getValue().price + " руб.");
        }
    }

    public void addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной!");
            return;
        }
        balance += amount;
        System.out.println("Вы внесли " + amount + " руб. Ваш баланс: " + balance + " руб.");
    }

    public void selectDrink(int number) {
        if (!menu.containsKey(number)) {
            System.out.println("Неверный номер напитка. Пожалуйста, выберите существующий номер.");
            return;
        }

        Drink drink = menu.get(number);
        if (balance < drink.price) {
            System.out.println("Недостаточно средств для покупки " + drink.name + ". Необходимо " + drink.price + " руб., у вас " + balance + " руб.");
        } else {
            balance -= drink.price;
            System.out.println("Вы купили " + drink.name + ". Остаток на счету: " + balance + " руб.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Показать меню");
            System.out.println("2. Внести деньги");
            System.out.println("3. Выбрать напиток");
            System.out.println("4. Выйти");

            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    machine.showMenu();
                    break;
                case "2":
                    System.out.print("Введите сумму для внесения: ");
                    try {
                        int amount = Integer.parseInt(scanner.nextLine());
                        machine.addMoney(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите корректное число.");
                    }
                    break;
                case "3":
                    System.out.print("Введите номер напитка: ");
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        machine.selectDrink(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Пожалуйста, введите корректный номер.");
                    }
                    break;
                case "4":
                    System.out.println("Спасибо за использование вендингового автомата!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;

// Класс для вендингового автомата
public class VendingMachine {
    private Map<Integer, Drink> menu; // Меню напитков
    private int balance; // Баланс пользователя

    public VendingMachine() {
        menu = new HashMap<>();
        // Инициализация меню
        menu.put(1, new Drink("Кока-Кола", 50));
        menu.put(2, new Drink("Пепси", 45));
        menu.put(3, new Drink("Сок", 60));
        menu.put(4, new Drink("Вода", 30));
        balance = 0; // Начальный баланс
    }

    // Метод для отображения меню
    public void showMenu() {
        System.out.println("\nМеню напитков:");
        for (Map.Entry<Integer, Drink> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().name + " - " + entry.getValue().price + " руб.");
        }
    }

    // Метод для внесения денег
    public void addMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Сумма должна быть положительной!");
            return;
        }
        balance += amount;
        System.out.println("Вы внесли " + amount + " руб. Ваш баланс: " + balance + " руб.");
    }

    // Метод для выбора напитка
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

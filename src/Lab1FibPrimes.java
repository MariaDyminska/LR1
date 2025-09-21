import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Клас для роботи з числами Фібоначчі
class FibonacciNumber {
    private int index;   // номер числа
    private long value;  // значення числа Фібоначчі

    // Конструктор
    public FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    // Отримати номер
    public int getIndex() {
        return index;
    }

    // Отримати значення
    public long getValue() {
        return value;
    }

    // Перевірка, чи є число простим
    public boolean isPrime() {
        if (value < 2) return false;
        for (long i = 2; i * i <= value; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }
}

// Головний клас програми
public class Lab1FibPrimes {

    // Генерує перші n чисел Фібоначчі
    public static List<FibonacciNumber> generateFibonacci(int n) {
        List<FibonacciNumber> sequence = new ArrayList<>();
        long a = 1, b = 1;
        for (int i = 1; i <= n; i++) {
            sequence.add(new FibonacciNumber(i, a));
            long next = a + b;
            a = b;
            b = next;
        }
        return sequence;
    }

    public static void main(String[] args) {
        int n;

        // введення даних
        if (args.length > 0) {
            n = Integer.parseInt(args[0]); // якщо передали аргумент
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Введіть N (кількість чисел Фібоначчі): ");
           // вводимо з клавіатури
            n = sc.nextInt();
        }

        // обчислення
        List<FibonacciNumber> fibs = generateFibonacci(n);

        // вивід усіх чисел
        System.out.println("\nПерші " + n + " чисел Фібоначчі:");
        for (FibonacciNumber f : fibs) {
            System.out.print(f.getValue() + " ");
        }

        // вивід простих чисел
        System.out.println("\n\nПрості числа серед них:");
        for (FibonacciNumber f : fibs) {
            if (f.isPrime()) {
                System.out.println("F(" + f.getIndex() + ") = " + f.getValue());
            }
        }
    }
}

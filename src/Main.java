import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int number = handleUserInput();
        fizzBuzz(number);
    }

    private static void fizzBuzz(int limit) {
        for (int i = 1; i <= limit; i++) {
            System.out.println(getFizzBuzzValue(i));
        }
    }

    private static int handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Enter a positive number: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    break;
                }
            }
            scanner.nextLine(); // حذف مقدار نامعتبر ورودی
            System.out.println("Invalid input! Please enter a positive integer.");
        }
        scanner.close();
        return number;
    }

    private static String getFizzBuzzValue(int num) {
        String result = "";
        if (num % 3 == 0) {
            result = result.concat("Fizz");
        }
        if (num % 5 == 0) {
            result = result.concat("Buzz");
        }

        return result.isEmpty() ? String.valueOf(num) : result;
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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


}

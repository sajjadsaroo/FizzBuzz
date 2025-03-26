import java.util.*;

public class Main {
    public static void main(String[] args) {
        int number = handleUserInput();
        fizzBuzz(number);
    }

    private static void fizzBuzz(int limit) {
        List<FizzBuzzRule> rules = getDefaultRules();
        
        for (int i = 1; i <= limit; i++) {
            System.out.println(getFizzBuzzValue(i, rules));
        }
    }
    private static List<FizzBuzzRule> getDefaultRules() {
        return Arrays.asList(
            new FizzRule(),
            new BuzzRule()
        );
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
            scanner.nextLine();
            System.out.println("Invalid input! Please enter a positive integer.");
        }
        scanner.close();
        return number;
    }

    private static String getFizzBuzzValue(int num, List<FizzBuzzRule> rules) {
        StringBuilder result = new StringBuilder();
        
        for (FizzBuzzRule rule : rules) {
            if (rule.matches(num)) {
                result.append(rule.getOutput());
            }
        }

        return result.length() == 0 ? String.valueOf(num) : result.toString();
    }
}

interface FizzBuzzRule {
    boolean matches(int number);
    String getOutput();
}

class FizzRule implements FizzBuzzRule {
    @Override
    public boolean matches(int number) {
        return number % 3 == 0;
    }

    @Override
    public String getOutput() {
        return "Fizz";
    }
}

class BuzzRule implements FizzBuzzRule {
    @Override
    public boolean matches(int number) {
        return number % 5 == 0;
    }

    @Override
    public String getOutput() {
        return "Buzz";
    }
}

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check its strength:");
        String password = scanner.nextLine();
        scanner.close();

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) score++;

        System.out.print("Password Strength: ");
        switch (score) {
            case 5 -> System.out.println("Very Strong");
            case 4 -> System.out.println("Strong");
            case 3 -> System.out.println("Moderate");
            case 2 -> System.out.println("Weak");
            default -> System.out.println("Very Weak");
        }
    }
}

import java.util.Scanner;
 
public class PasswordStrengthChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a password to check its strength:");
            String password = scanner.nextLine();
            
            int score = checkStrength(password);
            showResult(score);
        }
    }
    
    private static int checkStrength(String pwd) {
        int score = 0;
        int len = pwd.length();
        
        // Length (most important)
        if (len >= 8) score++;
        if (len >= 12) score += 2;
        
        // Character types
        if (pwd.matches(".*[A-Z].*")) score++;
        if (pwd.matches(".*[a-z].*")) score++;
        if (pwd.matches(".*\\d.*")) score++;
        if (pwd.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) score++;
        
        // Penalties
        if (pwd.toLowerCase().matches(".*(password|123456|qwerty).*")) score -= 3;
        if (pwd.matches(".*(.)\\1{2,}.*")) score--; // repeated chars (aaa, 111)
        
        return Math.max(0, score);
    }
    
    private static void showResult(int score) {
        System.out.print("Password Strength: ");
        if (score >= 7) System.out.println("Very Strong 💚");
        else if (score >= 5) System.out.println("Strong 🟢");
        else if (score >= 3) System.out.println("Moderate 🟡");
        else if (score >= 2) System.out.println("Weak 🟠");
        else System.out.println("Very Weak 🔴");
        
        System.out.println("Score: " + score + "/8");
    }
}

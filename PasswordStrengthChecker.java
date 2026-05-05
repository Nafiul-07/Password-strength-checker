import java.util.Scanner;
 
public class PasswordStrengthChecker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a password to check its strength:");
            String password = scanner.nextLine();
            
            // Handle empty input
            if (password == null || password.isEmpty()) {
                System.out.println("Error: Password cannot be empty!");
                return;
            }
            
            int score = checkStrength(password);
            showResult(score, password.length());
        }
    }
    
    private static int checkStrength(String pwd) {
        int score = 0;
        int len = pwd.length();
        String lower = pwd.toLowerCase();
        
        // Length (most important)
        if (len >= 8) score++;
        if (len >= 12) score += 2;
        if (len >= 16) score++;
        
        // Character types
        if (pwd.matches(".*[A-Z].*")) score++;
        if (pwd.matches(".*[a-z].*")) score++;
        if (pwd.matches(".*\\d.*")) score++;
        if (pwd.matches(".*[!@#$%^&*(),.?\":{}|<>_\\-].*")) score++;
        
        // Penalties
        if (lower.matches(".*(password|123456|qwerty|abc123|letmein).*")) {
            score -= 3;
            System.out.println("⚠️  Common password detected!");
        }
        if (pwd.matches(".*(.)\\1{2,}.*")) {
            score--;
            System.out.println("⚠️  Repeated characters detected!");
        }
        if (lower.matches(".*(abc|bcd|cde|123|234|345|456|567|678|789).*")) {
            score--;
            System.out.println("⚠️  Sequential pattern detected!");
        }
        
        return Math.max(0, score);
    }
    
    private static void showResult(int score, int length) {
        System.out.println("\n--- Results ---");
        System.out.print("Strength: ");
        
        if (score >= 7) System.out.println("Very Strong 💚");
        else if (score >= 5) System.out.println("Strong 🟢");
        else if (score >= 3) System.out.println("Moderate 🟡");
        else if (score >= 2) System.out.println("Weak 🟠");
        else System.out.println("Very Weak 🔴");
        
        System.out.println("Score: " + score + "/9");
        System.out.println("Length: " + length + " characters");
        
        // Quick tip
        if (score < 5) {
            System.out.println("\n💡 Tip: Use 12+ characters with mixed types!");
        }
    }
}

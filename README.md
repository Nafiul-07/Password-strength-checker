Password Strength Checker (Java)
A Java console application that intelligently checks password strength with smart detection for common vulnerabilities.
 Features
What It Checks

Length scoring (8+, 12+, 16+ characters with weighted points)
Character variety (uppercase, lowercase, digits, special characters)
Common passwords (detects "password", "123456", "qwerty", etc.)
Sequential patterns (catches "abc", "123", "456", etc.)
Repeated characters (flags "aaa", "111", etc.)
Empty input validation (prevents crashes)

Smart Scoring System

Score range: 0-9 points
Length is weighted more heavily (longer = more secure)
Penalties for weak patterns and common passwords
Real-time warnings for detected vulnerabilities

 How to Run

Compile the code:

bash   javac PasswordStrengthChecker.java

Run the program:

bash   java PasswordStrengthChecker

Enter any password and get instant feedback with warnings and recommendations.

Example Output
Strong Password:
Enter a password to check its strength:
MyS3cur3P@ssw0rd!

--- Results ---
Strength: Very Strong 
Score: 8/9
Length: 16 characters
Weak Password with Warnings:
Enter a password to check its strength:
password123

 Common password detected!
 Sequential pattern detected!

--- Results ---
Strength: Very Weak 
Score: 1/9
Length: 11 characters

 Tip: Use 12+ characters with mixed types!
 Strength Ratings
ScoreRatingSymbol7-9Very Strong 5-6Strong 3-4Moderate  2Weak 0-1Very Weak
 Security Features

 Detects 5+ common weak passwords
Identifies sequential character patterns
 Flags repeated characters (3+ in a row)
 Validates input to prevent crashes
 Uses try-with-resources for proper memory management
 Provides actionable security recommendations

 Password Tips
For a strong password:

Use at least 12 characters (16+ is better)
Mix uppercase, lowercase, numbers, and symbols
Avoid common words, names, or patterns
Don't use sequential characters (abc, 123)
Avoid repeated characters (aaa, 111)

 Author
NAFIUL FERDOUS ARONNYAS
Cybersecurity student project demonstrating Java fundamentals and password security analysis.
 Tags
java cybersecurity password-security student-project security-tools password-validation

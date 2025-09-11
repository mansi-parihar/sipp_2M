import java.util.regex.*;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }
}

public class InsurancePortal {
    public static void main(String[] args) {
        String[] testPasswords = {
                "abc123",
                "Password123",
                "Pass@123",
                "secure@2025A",
                "weakpass@"
        };

        for (String pwd : testPasswords) {
            if (SecurityUtils.isStrongPassword(pwd)) {
                System.out.println("✅ Strong password: " + pwd);
            } else {
                System.out.println("❌ Weak password: " + pwd);
            }
        }
    }
}

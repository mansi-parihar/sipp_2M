import java.util.function.Function;
public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> getLength = str -> str.length();

        int limit = 20;

        String[] messages = {
            "Hello!",
            "Java is powerful.",
            "This message is way too long and exceeds the limit."
        };

        for (String msg : messages) {
            int length = getLength.apply(msg);
            if (length > limit) {
                System.out.println("⚠️ Message exceeds limit (" + length + " characters): " + msg);
            } else {
                System.out.println("✅ Message within limit (" + length + " characters): " + msg);
            }
        }
    }
}

}

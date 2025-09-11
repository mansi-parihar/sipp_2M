interface SensitiveData {
}

class UserCredentials implements SensitiveData {
    String username;
    String password;

    UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserCredentials{username='" + username + "', password='" + password + "'}";
    }
}

class PaymentInfo implements SensitiveData {
    String cardNumber;
    String cvv;

    PaymentInfo(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "PaymentInfo{cardNumber='" + cardNumber + "', cvv='" + cvv + "'}";
    }
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

class EncryptionProcessor {
    public static void process(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("🔒 Encrypting sensitive data: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("✅ No encryption needed: " + obj.getClass().getSimpleName());
        }
    }
}

public class SensitiveDataTagging {
    public static void main(String[] args) {
        UserCredentials creds = new UserCredentials("alice", "mypassword123");
        PaymentInfo payment = new PaymentInfo("4111111111111111", "123");
        Product product = new Product("Laptop", 75000);

        EncryptionProcessor.process(creds);
        EncryptionProcessor.process(payment);
        EncryptionProcessor.process(product);
    }
}

}

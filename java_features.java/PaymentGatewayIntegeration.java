public class PaymentGatewayIntegeration {
    public interface PaymentProcessor {
        void processPayment(double amount);

        default void refund(double amount) {
            System.out.println("Refund of $" + amount + " is not supported by this provider.");
        }
    }

    class PayPalProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing PayPal payment of $" + amount);
        }

        @Override
        public void refund(double amount) {
            System.out.println("Refunding $" + amount + " via PayPal.");
        }
    }

    class StripeProcessor implements PaymentProcessor {
        @Override
        public void processPayment(double amount) {
            System.out.println("Processing Stripe payment of $" + amount);
        }
    }

    public class PaymentGatewayDemo {
        public static void main(String[] args) {
            PaymentProcessor paypal = new PayPalProcessor();
            paypal.processPayment(100);
            paypal.refund(50);

            PaymentProcessor stripe = new StripeProcessor();
            stripe.processPayment(200);
            stripe.refund(75);
        }
    }

}

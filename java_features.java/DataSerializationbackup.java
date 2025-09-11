public class DataSerializationbackup {
    interface BackupSerializable {
    }

    class Customer implements BackupSerializable {
        String name;
        int id;

        Customer(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    class Order implements BackupSerializable {
        int orderId;
        double amount;

        Order(int orderId, double amount) {
            this.orderId = orderId;
            this.amount = amount;
        }
    }

    class TempCache {
        String data = "Temporary data";
    }

    class BackupProcessor {
        public static void backup(Object obj) {
            if (obj instanceof BackupSerializable) {
                System.out.println("Backing up: " + obj.getClass().getSimpleName());
            } else {
                System.out.println("❌ Cannot backup " + obj.getClass().getSimpleName() +
                        " (not marked as BackupSerializable)");
            }
        }
    }

    public class BackupDemo {
        public static void main(String[] args) {
            Customer c = new Customer("Alice", 101);
            Order o = new Order(5001, 2500.75);
            TempCache t = new TempCache();

            BackupProcessor.backup(c);
            BackupProcessor.backup(o);
            BackupProcessor.backup(t);
        }
    }

}

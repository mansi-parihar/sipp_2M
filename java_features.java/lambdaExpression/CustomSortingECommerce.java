package lambdaExpression;
import java.util.*;
public class CustomSortingECommerce {
    static class Product {
        String name;
        double price;
        double rating;
        double discount;

        Product(String name, double price, double rating, double discount) {
            this.name = name;
            this.price = price;
            this.rating = rating;
            this.discount = discount;
        }

        @Override
        public String toString() {
            return name + " [Price=" + price + ", Rating=" + rating + ", Discount=" + discount + "]";
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200, 4.5, 10));
        products.add(new Product("Phone", 800, 4.7, 20));
        products.add(new Product("Tablet", 500, 4.3, 15));
        products.add(new Product("Monitor", 300, 4.6, 5));

        Comparator<Product> sortByPrice = (p1, p2) -> Double.compare(p1.price, p2.price);
        Comparator<Product> sortByRating = (p1, p2) -> Double.compare(p2.rating, p1.rating);
        Comparator<Product> sortByDiscount = (p1, p2) -> Double.compare(p2.discount, p1.discount);

        System.out.println("Sort by Price:");
        products.stream().sorted(sortByPrice).forEach(System.out::println);

        System.out.println("\nSort by Rating:");
        products.stream().sorted(sortByRating).forEach(System.out::println);

        System.out.println("\nSort by Discount:");
        products.stream().sorted(sortByDiscount).forEach(System.out::println);
    }
}    
}

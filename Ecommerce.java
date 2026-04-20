import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

class Cart {
    ArrayList<Product> items = new ArrayList<>();

    void addProduct(Product p) {
        items.add(p);
        System.out.println(p.name + " added to cart");
    }

    void showBill() {
        double total = 0;
        System.out.println("\nItems:");
        for (Product p : items) {
            System.out.println(p.name + " - Rs." + p.price);
            total += p.price;
        }
        System.out.println("Total: Rs." + total);
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Phone", 20000));
        products.add(new Product(3, "Headphones", 2000));

        Cart cart = new Cart();

        while (true) {
            System.out.println("\n1. Show Products\n2. Add to Cart\n3. Bill\n4. Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                for (Product p : products)
                    System.out.println(p.id + " " + p.name + " Rs." + p.price);
            } else if (ch == 2) {
                int id = sc.nextInt();
                for (Product p : products)
                    if (p.id == id) cart.addProduct(p);
            } else if (ch == 3) {
                cart.showBill();
            } else break;
        }
    }
}

public class Product {
    private final String code;
    private final String name;
    private final double price;

    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return code + " - " + name + " - $" + price;
    }

    public double getPrice() {
        return price;
    }
}
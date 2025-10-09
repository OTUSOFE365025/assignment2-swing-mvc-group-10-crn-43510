import java.io.*;
import java.util.*;

public class Model {
    private Map<String, Product> productMap = new HashMap<>();
    private List<Product> scannedItems = new ArrayList<>();

    public Model(String filePath) {
        loadProducts(filePath);
    }

    private void loadProducts(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length >= 3) {
                    String code = parts[0];
                    String name = parts[1];
                    double price = Double.parseDouble(parts[2].replace("$", ""));
                    productMap.put(code, new Product(code, name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product getRandomProduct() {
        List<Product> products = new ArrayList<>(productMap.values());
        return products.get(new Random().nextInt(products.size()));
    }

    public void addProduct(Product p) {
        scannedItems.add(p);
    }

    public List<Product> getScannedItems() {
        return scannedItems;
    }

    public double getSubtotal() {
        return scannedItems.stream().mapToDouble(Product::getPrice).sum();
    }
}

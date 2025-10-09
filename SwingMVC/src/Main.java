public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            Model model = new Model("products.txt");
            View view = new View();
            new Controller(model, view);
            view.setVisible(true);
        });
    }
}

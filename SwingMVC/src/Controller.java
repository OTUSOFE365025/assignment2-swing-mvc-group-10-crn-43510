import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.addScanListener(new ScanListener());
    }

    class ScanListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product p = model.getRandomProduct();
            model.addProduct(p);
            view.updateDisplay(model.getScannedItems(), model.getSubtotal());
        }
    }
}

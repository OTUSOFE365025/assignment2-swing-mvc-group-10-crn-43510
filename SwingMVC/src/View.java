import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View extends JFrame {
    private JTextArea displayArea;
    private JLabel subtotalLabel;
    private JButton scanButton;

    public View() {
        setTitle("Cash Register");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        subtotalLabel = new JLabel("Subtotal: $0.00");
        scanButton = new JButton("Scan");


        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);


        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(subtotalLabel)
                                .addGap(20)
                                .addComponent(scanButton)))
        );


        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subtotalLabel)
                        .addComponent(scanButton))
        );

        add(panel);
    }

    public void addScanListener(ActionListener listener) {
        scanButton.addActionListener(listener);
    }

    public void updateDisplay(List<Product> items, double subtotal) {
        displayArea.setText("");
        for (Product p : items) {
            displayArea.append(p.toString() + "\n");
        }
        subtotalLabel.setText(String.format("Subtotal: $%.2f", subtotal));
    }
}

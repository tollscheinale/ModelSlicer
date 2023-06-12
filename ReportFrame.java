import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ReportFrame extends JFrame implements ActionListener {

    ModelCheck mc = new ModelCheck();

    JFrame frame;
    JPanel contPanel; // Model informations
    JPanel butPanel; // Alle Buttons in einem Panel
    JPanel sysPanel; // Ausgabe aller System relevanten Befehle
    JButton butOK; // Zurück ins MainFrame
    JButton butSave; // Speichern des Report
    JButton butMore; // Erweitern der Ansicht(Detailansicht)
    JLabel NameTypeSize; // Name, Type und größe der Datei
    JLabel sysLabel;

    String name;
    String type;
    double size;
    String path;

    public ReportFrame() {
        frame = new JFrame();
        frame.setSize(500, 750);
        frame.setTitle("Model Report | " + name);
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());

        butPanel = new JPanel();
        butPanel.setBackground(Color.lightGray);
        butPanel.setLayout(new FlowLayout());

        butOK = new JButton();
        butOK.setText("OK");

        butSave = new JButton();
        butSave.setText("Save");

        butMore = new JButton();
        butMore.setText("Extend");

        butPanel.add(butOK);
        butPanel.add(butSave);
        butPanel.add(butMore);

        frame.add(butPanel);
        frame.add(butPanel);
    }

    public static void main(String[] args){
        new ReportFrame();
    }

    public void open(String name, String type, double size, String path) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.path = path;

        new ReportFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        /**
         * Wenn der Button Ok gedrückt wird, soll das aktuelle Fenster geschlossen
         * werden.
         */
        if (e.getSource() == butOK) {
            System.exit(1);
        }
        /**
         * wenn der Button Save gefdrückt wird, soll das aktuelle Model in einem
         * xml/json File ausgegeben werden
         */
        if (e.getSource() == butSave) {
            System.out.println("Save function is not programmed!");
            sysLabel.setText("Save function is not programmed!");
        }
    }
}

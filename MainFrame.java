import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    ModelCheck mc = new ModelCheck();

    JPanel contPanel;
    JPanel butPanel;
    JPanel infoPanel;
    JPanel FilamentPanel;

    JButton check;
    JButton report;
    JButton save;
    JButton create;
    JButton loadData;

    JComboBox<String> printer;
    JComboBox<String> procedure;
    JComboBox<String> filament;

    String printerList[] = { "PrinterLowCost", "PrinterMidCost", "PrinterHightCost" };
    String procedureList[] = { "FDM", "SLA", "SLS" };
    String FilamentList[] = { "ABS", "PLA", "NYLON", "ASA" };

    JList<String> list;
    DefaultListModel<String> listModel;
    JScrollPane scrollPane;

    public MainFrame() {
        setTitle("TEST");
        setBackground(Color.LIGHT_GRAY);
        setSize(750, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contPanel = new JPanel();
        contPanel.setBorder(new TitledBorder(null, "Models", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        scrollPane = new JScrollPane(list);
        contPanel.add(scrollPane);

        butPanel = new JPanel();
        check = new JButton("Check Models");
        check.addActionListener(this);
        report = new JButton("Report");
        report.setEnabled(false);
        report.addActionListener(this);
        save = new JButton("Save");
        save.setEnabled(false);
        save.addActionListener(this);
        create = new JButton("Create GCODE");
        create.setEnabled(false);
        create.addActionListener(this);
        loadData = new JButton("Load printer data");
        loadData.setEnabled(false);
        loadData.addActionListener(this);
        butPanel.add(check);
        butPanel.add(report);
        butPanel.add(save);
        butPanel.add(create);
        butPanel.add(loadData);

        infoPanel = new JPanel();
        infoPanel.setBorder(new TitledBorder(null, "Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        infoPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel printerName = new JLabel("Printer: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(printerName, gbc);

        printer = new JComboBox<>(printerList);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(printer, gbc);

        JLabel procedureName = new JLabel("Procedure: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(procedureName, gbc);

        procedure = new JComboBox<>(procedureList);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(procedure, gbc);

        JLabel filamentName = new JLabel("Filament: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(filamentName, gbc);

        filament = new JComboBox<>(FilamentList);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        infoPanel.add(filament, gbc);

        FilamentPanel = new JPanel();
        FilamentPanel.setBorder(new TitledBorder(null, "Filament", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        FilamentPanel.setLayout(new GridLayout(3, 1));
        JLabel labPrinterNozzleTemp = new JLabel("   Nozzle temp.:    |");
        JLabel labPrinterBedTemp = new JLabel("   Bed temp.:    |");
        JLabel VANStat = new JLabel("   Van ON:    |");
        FilamentPanel.add(labPrinterNozzleTemp);
        FilamentPanel.add(labPrinterBedTemp);
        FilamentPanel.add(VANStat);

        setLayout(new BorderLayout());
        add(contPanel, BorderLayout.CENTER);
        add(butPanel, BorderLayout.SOUTH);
        add(infoPanel, BorderLayout.NORTH);
        add(FilamentPanel, BorderLayout.EAST);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            System.out.print("ModelCheck wird ausgeführt ... ");

            mc.FolderAnalyse();

            System.out.println("DONE!");

            DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String file : mc.allFiles) {
                if (!listModel.contains(file)) {
                    listModel.addElement(file);
                }
            }
            list.setModel(listModel);

            report.setEnabled(true);
            save.setEnabled(true);
            create.setEnabled(true);
            loadData.setEnabled(true);
        }
        if (e.getSource() == report) {
            // Handle the report button action
        }
    }
}

package models;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import utils.Constants;

public class Table extends JPanel {
    // private JScrollPane scrollPane;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel tableModel;
    public static  String data[][];
    public Table() {
        setLayout(null);
        String column[] = { "id", "Name", "Email", "Phone", "Address", "Time" };
        data =new String[][]{};
        // add(scrollPane);
        tableModel =new DefaultTableModel(data, column);
        table = new JTable(tableModel);
        setColumnWidths();
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        JTableHeader header = table.getTableHeader();
        header.setFont(Constants.fontTable());
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 600, 400);
        add(scrollPane);

    }

    public void addRow(String[] rowData) {
        // Add a new row to the table
        ((javax.swing.table.DefaultTableModel) table.getModel()).addRow(rowData);
    }

    private void setColumnWidths() {
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(170);
        table.getColumnModel().getColumn(2).setPreferredWidth(170);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
    }
}

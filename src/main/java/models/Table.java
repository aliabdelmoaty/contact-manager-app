package models;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import utils.Constants;

public class Table extends JPanel {
    private JScrollPane scrollPane;
    public JTable table;
    private DefaultTableModel tableModel;
    public static String data[][];

    public Table() {
        setLayout(null);
        String column[] = { "id", "Name", "Email", "Phone", "Address", "Time" };
        data = new String[][] {};
        tableModel = new DefaultTableModel(data, column);
        table = new JTable(tableModel);
        setColumnWidths();
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        JTableHeader header = table.getTableHeader();
        header.setFont(Constants.fontTable());
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 600, 400);
        add(scrollPane);

        addTableSelectionListener();
    }

    public void addRow(String[] rowData) {
        ((DefaultTableModel) table.getModel()).addRow(rowData);
    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
    }

    public int getSelectedRow() {
        return table.getSelectedRow();
    }
    public void deleteContact(int selectedRow){
        ((DefaultTableModel) table.getModel()).removeRow(selectedRow);
    }
    public Object getValueAt(int row, int column) {
        return table.getValueAt(row, column);
    }
    private void addTableSelectionListener() {
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    
                }
            }
        });
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

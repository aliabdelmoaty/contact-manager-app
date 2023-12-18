package models;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Table extends JPanel {
    // private JScrollPane scrollPane;
    private JScrollPane scrollPane;
    private JTable table;

    public Table() {
        setLayout(null);

        String column[] = { "Name", "Email", "Phone", "Address" };
        String data[][] = { { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" },
                { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12", "aa" }, { "Ali", "mo", "12aa", "aa" }, };
        // add(scrollPane);
        table = new JTable(data, column);
        scrollPane = new JScrollPane(table);

        scrollPane.setBounds(250, 10, 500, 400);
        add(scrollPane);

    }

}

package ca.uwo.csd.cs2212.team05;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class SortTable {
  public static void main(String args[]) {
    Runnable runner = new Runnable() {
     public void run() {
        JFrame frame = new JFrame("Sorting JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object rows[][]= {
            {"Amazon", 41.28},
            {"eBay", 41.57},
            {"Google", 388.33},
            {"Microsoft", 26.56},
            {"Nokia Corp", 17.13},
            {"Oracle Corp.", 12.52},
            {"Sun Microsystems", 3.86},
            {"Time Warner", 17.66},
            {"Vodafone Group", 26.02},
            {"Yahoo!", 37.69}
          };
        String columns[] = {"Name", "Price"};
        TableModel model =
            new DefaultTableModel(rows, columns) {
          public Class getColumnClass(int column) {
            Class returnValue;
            if ((column >= 0) && (column < getColumnCount())) {
              returnValue = getValueAt(0, column).getClass();
            } else {
              returnValue = Object.class;
            }
            return returnValue;
          }
        };

        JTable table = new JTable(model);
        RowSorter<TableModel> sorter =
          new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        frame.setSize(300, 150);
        frame.setVisible(true);
      }
    };
    EventQueue.invokeLater(runner);
  }
} 
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class History {
    History(String[][] row){
        
        String[] col = {"Sr no","From", "To", "Price", "UID", "Type", "Platform"};
        
        JTable table = new JTable(row,col);
        table.setRowHeight(25);
        
        
        JFrame frame = new JFrame("History");
        
        frame.add(new JScrollPane(table));
        
//        frame.setSize(500,400);
        frame.setTitle("History");
        frame.setBounds(400,400,500,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String...a){
        String[][] r = {
            {"1","malad", "Goregoan", "30", "grq423", "Bus", "4"},
            {"2","malad", "Goregoan", "30", "grq423", "Bus", "4"}
        };
        
        
        
        new History(r);
    }
}

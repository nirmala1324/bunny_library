/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Jframe;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author nirma
 */
public class MultiLineJTable extends JTextArea implements TableCellRenderer{
    
    private List<List<Integer>> rowColHeight = new ArrayList<>();
    
        public MultiLineJTable(){
            setLineWrap(true);
            setWrapStyleWord(true);
        }
        
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        setText((value == null)? "" : value.toString());
        setEditable(false);
        return this;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.util.Observer;
import java.awt.event.ActionListener;
import java.util.Observable;
/**
 *
 * @author fvx3255
 */
public class View extends JFrame implements Observer{
      private JPanel idPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    private JLabel id = new JLabel("Student ID: ");
    private JTextField idInput = new JTextField(7);
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton idSearchButton = new JButton("Search");
    
    public View(){
        this.setDefaultCloseOperation();
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
    }
    
    
}

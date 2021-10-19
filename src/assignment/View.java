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
    private JLabel id = new JLabel("Student ID: ");
    private JTextField idInput = new JTextField(7);
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton idSearchButton = new JButton("Search");
    private JButton regiButton = new JButton("Register new student");
    private JButton listButton = new JButton("Show list of student");
    
    public View(){
        this.setDefaultCloseOperation();
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.idPanel.add(id);
        this.idPanel.add(idInput);
        this.idPanel.add(idSearchButton);
        this.idPanel.add(regiButton);
        this.idPanel.add(listButton);
        this.add(idPanel);
        this.setVisible(true);
    }
    
    public void startInfo(){
        
    }
    
    public void registerInfo(){
        
    }
    public void startList(){
        
    }
    
    public void addActionListener(ActionListener listener){
        this.idSearchButton.addActionListener(listener);
        this.regiButton.addActionListener(listener);
        this.listButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg){
        Student student = (Student) arg; //get student object
    }
}

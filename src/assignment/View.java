/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.Color;
import java.awt.Font;
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
    private JLabel welcome = new JLabel("Welcome!");
    private JLabel noid = new JLabel("Can't find student ID?");
    private JTextField idInput = new JTextField(7);
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton idSearchButton = new JButton("Search");
    private JButton regiButton = new JButton("Register new student");
    private JButton listButton = new JButton("Show list of student");
    
    public View(){
        this.setTitle("Student Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,250);
        this.setLocationRelativeTo(null);
        this.idPanel.setLayout(null);
        this.welcome.setBounds(250,10,100,50);
        this.noid.setBounds(220,100,150,50);
        this.id.setBounds(150,50,100,50);
        this.idInput.setBounds(235,60,100,30);
        this.idSearchButton.setBounds(360, 60, 80, 30);
        this.idSearchButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setFont(new Font("Arial", Font.BOLD, 11));
        this.listButton.setFont(new Font("Arial", Font.BOLD, 11));
        this.regiButton.setBackground(Color.LIGHT_GRAY);
        this.listButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setBounds(100,150,170,30);
        this.listButton.setBounds(300,150,170,30);
        this.idPanel.add(id);
        this.idPanel.add(welcome);
        this.idPanel.add(noid);
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

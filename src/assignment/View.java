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
    private JLabel idLabel = new JLabel("Student ID: ");
    private JLabel welcomeLabel = new JLabel("Welcome ! Input student ID to see the information");
    private JLabel noidLabel = new JLabel("Can't find student ID?");
    private JLabel autLabel = new JLabel("AUT");
    public JTextField idInput = new JTextField(7);
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton idSearchButton = new JButton("Search");
    private JButton regiButton = new JButton("Register new student");
    private JButton listButton = new JButton("Show list of student");
    
    public View(){
        this.setTitle("AUT Student Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.idPanel.setLayout(null);
        this.idPanel.setBackground(Color.black);
        this.welcomeLabel.setBounds(250,210,300,50);
        this.noidLabel.setBounds(330,300,150,50);
        this.idLabel.setBounds(260,250,100,50);
        this.idInput.setBounds(330,260,100,30);
        this.autLabel.setBounds(320,100,300,100);
        this.idSearchButton.setBounds(450, 260, 80, 30);
        this.idSearchButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.listButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.noidLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
        this.noidLabel.setForeground(Color.white);
        this.autLabel.setFont(new Font("Dialog", Font.BOLD, 70));
        this.autLabel.setForeground(Color.white);
        this.welcomeLabel.setForeground(Color.white);
        this.idLabel.setForeground(Color.white);
        this.regiButton.setBackground(Color.LIGHT_GRAY);
        this.listButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setBounds(200,350,170,30);
        this.listButton.setBounds(400,350,170,30);
        this.idPanel.add(autLabel);
        this.idPanel.add(idLabel);
        this.idPanel.add(welcomeLabel);
        this.idPanel.add(noidLabel);
        this.idPanel.add(idInput);
        this.idPanel.add(idSearchButton);
        this.idPanel.add(regiButton);
        this.idPanel.add(listButton);
        this.add(idPanel);
        this.setVisible(true);
    }
    
    public void startInfo(){
        JPanel infoPanel = new JPanel();
        this.getContentPane().removeAll();
        infoPanel.setVisible(true);
        this.revalidate();
        this.repaint();
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
        if(!student.idFlag){ //if login fails, empty idInput
            this.idInput.setText("");
            this.idNotFound.setBounds(300,300,200,50);
            this.idNotFound.setForeground(Color.red);
            this.idPanel.add(idNotFound);
        }
        //if student is found start display their information
        else{
            this.startInfo();
        }
    }
}

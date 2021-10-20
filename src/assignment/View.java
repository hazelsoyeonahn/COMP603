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
    public JTextField idField = new JTextField();
    public JTextField nameField = new JTextField();
    public JTextField genderField = new JTextField();
    public JTextField bdayField = new JTextField();
    public JTextField majorField = new JTextField();
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID");
    private JButton idSearchButton = new JButton("Search");
    private JButton regiButton = new JButton("Register new student");
    private JButton listButton = new JButton("Show list of student");
    private JButton goMainButton = new JButton("Back to Main");
    private JButton createStuButton = new JButton("Create student information");
    public static boolean goMainFlag = false;
    public static boolean goRegiPage = false;
    public static boolean idError = false;
    public static boolean nameError = false;
    public static boolean genderError = false;
    public static boolean bdayError = false;
    public static boolean majorError = false;
    
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
    
    public void startInfo(Student stu){
        //design new panel and labels
        JPanel infoPanel = new JPanel();
        JLabel stId = new JLabel("ID: "+String.valueOf(stu.id));
        JLabel stName = new JLabel("Name: "+stu.name);
        JLabel stBirth = new JLabel("Birthday: "+stu.birthday);
        JLabel stGender = new JLabel("Gender: "+stu.gender);
        JLabel stMajor = new JLabel("Major: "+stu.major);
        
        stId.setForeground(Color.white);
        stName.setForeground(Color.white);
        stBirth.setForeground(Color.white);
        stGender.setForeground(Color.white);
        stMajor.setForeground(Color.white);
        stId.setFont(new Font("Dialog", Font.PLAIN, 15));
        stName.setFont(new Font("Dialog", Font.PLAIN, 15));
        stBirth.setFont(new Font("Dialog", Font.PLAIN, 15));
        stGender.setFont(new Font("Dialog", Font.PLAIN, 15));
        stMajor.setFont(new Font("Dialog", Font.PLAIN, 15));
        stId.setBounds(30,50,100,30);
        stName.setBounds(30,80,200,30);
        stBirth.setBounds(30,140,200,30);
        stGender.setBounds(30,110,100,30);
        stMajor.setBounds(30,170,100,30);
        this.goMainButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.goMainButton.setBackground(Color.LIGHT_GRAY);
        this.goMainButton.setBounds(10,10,170,30);
        
        this.getContentPane().removeAll();
        infoPanel.setLayout(null);
        infoPanel.setBackground(Color.black);
        infoPanel.add(stId);
        infoPanel.add(stName);
        infoPanel.add(stBirth);
        infoPanel.add(stGender);
        infoPanel.add(stMajor);
        infoPanel.add(goMainButton);
        infoPanel.setVisible(true);
        this.add(infoPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void registerInfo(){
        this.goRegiPage = false;
        this.getContentPane().removeAll();

        //create new register panel
        JPanel regiPanel = new JPanel();
        JLabel regiMessage = new JLabel("Please fill in the blank with new student's information with suggested form");
        JLabel regiId = new JLabel("ID (7 digits): ");
        JLabel regiName = new JLabel("Name (Full name): ");
        JLabel regiGender = new JLabel("Gender (M/F): ");
        JLabel regiBirthday = new JLabel("Birthday (00/00/00): ");
        JLabel regiMajor = new JLabel("Major (BCIS/BSC/BEN/MSC/MEN/DSC): ");;
        
        //decorate panel, label, button and textfield
        regiPanel.setBackground(Color.black);
        regiPanel.setLayout(null);
        regiMessage.setFont(new Font("Dialog", Font.BOLD, 12));
        regiMessage.setForeground(Color.white);
        regiMessage.setBounds(180, 100, 500, 30);
        regiId.setFont(new Font("Dialog", Font.BOLD, 12));
        regiId.setForeground(Color.white);
        regiId.setBounds(295,150,70,30);
        this.idField.setBounds(380,150,100,30);
        regiName.setFont(new Font("Dialog", Font.BOLD, 12));
        regiName.setForeground(Color.white);
        regiName.setBounds(260,200,140,30);
        this.nameField.setBounds(380,200,150,30);
        regiGender.setFont(new Font("Dialog", Font.BOLD, 12));
        regiGender.setForeground(Color.white);
        regiGender.setBounds(287,250,90,30);
        this.genderField.setBounds(380,250,100,30);
        regiBirthday.setFont(new Font("Dialog", Font.BOLD, 12));
        regiBirthday.setForeground(Color.white);
        regiBirthday.setBounds(250,300,140,30);
        this.bdayField.setBounds(380,300,100,30);
        regiMajor.setFont(new Font("Dialog", Font.BOLD, 12));
        regiMajor.setForeground(Color.white);
        regiMajor.setBounds(150,350,250,30);
        this.majorField.setBounds(380,350,100,30);
        this.goMainButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.goMainButton.setBackground(Color.LIGHT_GRAY);
        this.goMainButton.setBounds(10,10,170,30);
        this.createStuButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.createStuButton.setBackground(Color.LIGHT_GRAY);
        this.createStuButton.setBounds(290,400,190,30);
        
        regiPanel.add(this.goMainButton);
        regiPanel.add(regiMessage);
        regiPanel.add(regiId);
        regiPanel.add(idField);
        regiPanel.add(regiName);
        regiPanel.add(nameField);
        regiPanel.add(regiGender);
        regiPanel.add(genderField);
        regiPanel.add(regiBirthday);
        regiPanel.add(bdayField);
        regiPanel.add(regiMajor);
        regiPanel.add(majorField);
        regiPanel.add(createStuButton);
        this.add(regiPanel);
        this.revalidate();
        this.repaint();
    }
    public void startList(){
        
    }
    
    public void goBackMain(){
       this.goMainFlag = false;
       this.getContentPane().removeAll();
       idPanel.setVisible(true);
       this.add(idPanel);
       this.revalidate();
       this.repaint();
    }
    
    public void addActionListener(ActionListener listener){
        this.idSearchButton.addActionListener(listener);
        this.regiButton.addActionListener(listener);
        this.listButton.addActionListener(listener);
        this.goMainButton.addActionListener(listener);
        this.createStuButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg){       
        Student student = (Student) arg; //get student object
        if(student != null){
            if(!student.idFlag){ //if login fails, empty idInput
               this.idInput.setText("");
               this.idNotFound.setBounds(300,300,200,50);
               this.idNotFound.setForeground(Color.red);
               this.idPanel.add(idNotFound);
           }
           //if student is found start display their information
           else{
               this.startInfo(student);
           } 
        }else{
            if(goMainFlag){
              this.idInput.setText("");
              this.goBackMain();
            }
            if(goRegiPage){
               this.registerInfo(); 
            }
        }
    }
}

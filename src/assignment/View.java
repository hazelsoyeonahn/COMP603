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
import java.util.ArrayList;
import java.awt.*;
import javax.swing.JComboBox;

/**
 * This class is a view of MVC Design Pattern.
 * This class extends JFrame and implements Observer.
 * This class controls view of this application.
 * @author fvx3255
 */
public class View extends JFrame implements Observer{
    
    //id panel variables
    private JPanel idPanel = new JPanel();
    private JLabel idLabel = new JLabel("Student ID: ");
    private JLabel welcomeLabel = new JLabel("Welcome ! Input student ID to see the information");
    private JLabel noidLabel = new JLabel("Can't find student ID?");
    private JLabel autLabel = new JLabel("AUT");
    private JLabel idNotFound = new JLabel("Student not found, please type correct student ID"); //error label
    public JTextField idInput = new JTextField(7); //for searching
    private JButton idSearchButton = new JButton("Search");
    private JButton regiButton = new JButton("Register new student");
    private JButton listButton = new JButton("Show list of student");
    public static boolean idSearchError = false; //flag for id search error
    public static boolean goRegiPage = false; //flag to go to regiPanel
    
    //go back to main button
    private JButton goMainButton = new JButton("Back to Main");
    public static boolean goMainFlag = false;
    
    //info panel
    public AmbassadorBooking ambBookings = new AmbassadorBooking();
    public MentorBooking menBookings = new MentorBooking();
    public Paper paper = new Paper();
    public JPanel infoPanel = new JPanel(){
            protected void paintComponent(Graphics g){         
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setColor(Color.LIGHT_GRAY);
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(30, 75, 30, 260);
                g2.drawLine(30, 75, 110, 75);
                g2.drawLine(200, 75, 270, 75);
                g2.drawLine(270,75,270,260);
                g2.drawLine(30,260,270,260);
                
                g2.drawLine(30,325,330,325);
                g2.drawLine(30,325,30,530);
                g2.drawLine(460,325,750,325);
                g2.drawLine(750,325,750,530);
                g2.drawLine(30,530,750,530);
            }
        };
    private JButton bookAmButton = new JButton("Book Ambassador");
    private JButton bookMeButton = new JButton("Book Mentor");
    private JButton findSessionButton = new JButton("Find mentor session");
    public JComboBox ambBox = new JComboBox(ambBookings.getArray()); 
    public JComboBox papBox = new JComboBox(menBookings.getPaperArray());
    public JComboBox menBox = new JComboBox();
    private JLabel foundMentorLabel = null;
    private JLabel mentorBookedLabel = new JLabel("Mentor is Booked!");
    private JLabel noMentorLabel = new JLabel("No mentor is available");
    private JLabel ambBookedLabel = new JLabel("Ambassador is booked!");
    private JLabel unenrolPaperLabel = new JLabel();
    private JLabel enrolPaperLabel = new JLabel();
    public static boolean ambBooked = false;
    public static boolean noMentorError = false;
    public static boolean mentBooked = false;
    public static boolean enrolError = false;
    private String enrolPaper = "";
    private String unenrolPaper = "";
    
    //regi panel 
    private JPanel regiPanel = new JPanel();
    public JTextField idField = new JTextField();
    public JTextField nameField = new JTextField();
    public JTextField genderField = new JTextField();
    public JTextField bdayField = new JTextField();
    public JTextField majorField = new JTextField();
    private JButton createStuButton = new JButton("Create student information");
    private JLabel idErrorLabel = new JLabel("ID must be 7 digits only");
    private JLabel existIdLabel = new JLabel("ID already exist, please try different ID");
    private JLabel nameErrorLabel = new JLabel("Name must be alphabetic only");
    private JLabel genderErrorLabel = new JLabel("Gender must be F or M");
    private JLabel bdayErrorLabel = new JLabel("Birthday must be in 00/00/00 form");
    private JLabel majorErrorLabel = new JLabel("Please input an available major");
    private JLabel regiSucLabel = new JLabel("Student is registered!");
    public static boolean idError = false;
    public static boolean nameError = false;
    public static boolean genderError = false;
    public static boolean bdayError = false;
    public static boolean majorError = false;
    public static boolean existIdError = false;
    public static boolean registerSucceed = false;
 
    //constructor; sets id panel(first page) and frame
    public View(){
        //frame
        this.setTitle("AUT Student Information");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        //id panel
        this.idPanel.setLayout(null);
        this.idPanel.setBackground(Color.black);
        //labels
        this.welcomeLabel.setBounds(250,210,300,50);
        this.noidLabel.setBounds(330,300,150,50);
        this.idLabel.setBounds(260,250,100,50);
        this.idInput.setBounds(330,260,100,30);
        this.autLabel.setBounds(320,100,300,100);
        this.noidLabel.setFont(new Font("Dialog", Font.PLAIN, 11));
        this.autLabel.setFont(new Font("Dialog", Font.BOLD, 70));
        this.noidLabel.setForeground(Color.white);
        this.autLabel.setForeground(Color.white);
        this.welcomeLabel.setForeground(Color.white);
        this.idLabel.setForeground(Color.white);
        //buttons
        this.idSearchButton.setBounds(450, 260, 80, 30);
        this.idSearchButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.listButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.regiButton.setBackground(Color.LIGHT_GRAY);
        this.listButton.setBackground(Color.LIGHT_GRAY);
        this.regiButton.setBounds(200,350,170,30);
        this.listButton.setBounds(400,350,170,30);
        this.goMainButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.goMainButton.setBackground(Color.LIGHT_GRAY);
        this.goMainButton.setBounds(10,10,170,30);
        //add to id panel
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
    
    //display student information, infoPanel
    public void startInfo(Student stu){
        this.getContentPane().removeAll();
        
        //labels
        JLabel stIdLabel = new JLabel("ID: "+String.valueOf(stu.id));
        JLabel stNameLabel = new JLabel("Name: "+stu.name);
        JLabel stBirthLabel = new JLabel("Birthday: "+stu.birthday);
        JLabel stGenderLabel = new JLabel("Gender: "+stu.gender);
        JLabel stMajorLabel = new JLabel("Major: "+stu.major);
        JLabel infoLabel = new JLabel("Information");
        JLabel paperLabel = new JLabel("Paper Enrolment");  
        stIdLabel.setForeground(Color.white);
        stNameLabel.setForeground(Color.white);
        stBirthLabel.setForeground(Color.white);
        stGenderLabel.setForeground(Color.white);
        stMajorLabel.setForeground(Color.white);
        infoLabel.setForeground(Color.LIGHT_GRAY);
        paperLabel.setForeground(Color.LIGHT_GRAY);       
        stIdLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        stNameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        stBirthLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        stGenderLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        stMajorLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
        infoLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        paperLabel.setFont(new Font("Dialog", Font.BOLD, 13));    
        stIdLabel.setBounds(60,100,100,30);
        stNameLabel.setBounds(60,130,200,30);
        stBirthLabel.setBounds(60,160,200,30);
        stGenderLabel.setBounds(60,190,100,30);
        stMajorLabel.setBounds(60,220,100,30);
        infoLabel.setBounds(120,60,100,30);
        paperLabel.setBounds(340,310,160,30);
        
        //ambassador info
        this.bookAmButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.bookAmButton.setBackground(Color.LIGHT_GRAY);
        this.bookAmButton.setBounds(600,70,160,30);
        ambBox.setBounds(300,70,300,30);
        
        //mentor info
        this.findSessionButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.findSessionButton.setBackground(Color.LIGHT_GRAY);
        this.findSessionButton.setBounds(450,170,160,30);
        papBox.setBounds(300,170,100,30);
        
        //paper enrol info
        JLabel enrollLabel = new JLabel("Enrolled papers");
        JLabel unenrollLabel = new JLabel("Unenrolled papers");
        enrollLabel.setForeground(Color.white);
        enrollLabel.setBounds(50,430,240,30);
        unenrollLabel.setForeground(Color.white);
        unenrollLabel.setBounds(50,350,240,30);

        this.enrolPaper = "";
        this.enrolPaper = stu.paper; //get this student's enrolled paper
        this.unenrolPaper = paper.getUnenrolPaper(stu); //get this student's unenrolled paper
        unenrolPaperLabel.setVisible(true);
        enrolPaperLabel.setVisible(true);
        unenrolPaperLabel.setText(unenrolPaper);
        enrolPaperLabel.setText(enrolPaper);
        unenrolPaperLabel.setForeground(Color.white);
        unenrolPaperLabel.setBounds(50,390,500,30);
        enrolPaperLabel.setForeground(Color.white);
        enrolPaperLabel.setBounds(50, 470,500,30);
        
        infoPanel.setLayout(null);
        infoPanel.setBackground(Color.black);
      
        infoPanel.add(stIdLabel);
        infoPanel.add(stNameLabel);
        infoPanel.add(stBirthLabel);
        infoPanel.add(stGenderLabel);
        infoPanel.add(stMajorLabel);
        infoPanel.add(infoLabel);
        infoPanel.add(paperLabel);
        infoPanel.add(enrollLabel);
        infoPanel.add(unenrollLabel);
        infoPanel.add(unenrolPaperLabel);
        infoPanel.add(enrolPaperLabel);
        infoPanel.add(goMainButton);
        infoPanel.add(bookAmButton);
        infoPanel.add(findSessionButton);
        infoPanel.add(ambBox);
        infoPanel.add(papBox);
        infoPanel.setVisible(true);
        this.add(infoPanel);
        this.revalidate();
        this.repaint();
    
    }
    
    //this method creates regiPanel which provides interface to register a new Student.
    public void registerInfo(){
        this.goRegiPage = false; //once in this method, turn off the flag
        this.getContentPane().removeAll();

        //decorate panel, label, button and textfield
        this.regiPanel.setBackground(Color.black);
        this.regiPanel.setLayout(null);
        
        //labels
        JLabel regiMessage = new JLabel("Please fill in the blank with new student's information with suggested form");
        JLabel regiId = new JLabel("ID (7 digits): ");
        JLabel regiName = new JLabel("Name (Full name): ");
        JLabel regiGender = new JLabel("Gender (M/F): ");
        JLabel regiBirthday = new JLabel("Birthday (00/00/00): ");
        JLabel regiMajor = new JLabel("Major (BCIS/BSC/BEN/MSC/MEN/DSC): ");
        regiMessage.setFont(new Font("Dialog", Font.BOLD, 12));
        regiMessage.setForeground(Color.white);
        regiMessage.setBounds(180, 100, 500, 30);
        regiId.setFont(new Font("Dialog", Font.BOLD, 12));
        regiId.setForeground(Color.white);
        regiId.setBounds(295,150,70,30);
        regiName.setFont(new Font("Dialog", Font.BOLD, 12));
        regiName.setForeground(Color.white);
        regiName.setBounds(260,200,140,30);
        regiGender.setFont(new Font("Dialog", Font.BOLD, 12));
        regiGender.setForeground(Color.white);
        regiGender.setBounds(287,250,90,30);
        regiBirthday.setFont(new Font("Dialog", Font.BOLD, 12));
        regiBirthday.setForeground(Color.white);
        regiBirthday.setBounds(250,300,140,30);
        regiMajor.setFont(new Font("Dialog", Font.BOLD, 12));
        regiMajor.setForeground(Color.white);
        regiMajor.setBounds(150,350,250,30);
        
        //fields
        this.idField.setBounds(380,150,100,30);
        this.nameField.setBounds(380,200,150,30);
        this.genderField.setBounds(380,250,100,30);
        this.bdayField.setBounds(380,300,100,30);
        this.majorField.setBounds(380,350,100,30);
        
        //buttons
        this.createStuButton.setFont(new Font("Dialog", Font.BOLD, 11));
        this.createStuButton.setBackground(Color.LIGHT_GRAY);
        this.createStuButton.setBounds(290,400,190,30);
        
        this.regiPanel.add(this.goMainButton); //add button to go back to Main(idPanel)
        this.regiPanel.add(regiMessage);
        this.regiPanel.add(regiId);
        this.regiPanel.add(idField);
        this.regiPanel.add(regiName);
        this.regiPanel.add(nameField);
        this.regiPanel.add(regiGender);
        this.regiPanel.add(genderField);
        this.regiPanel.add(regiBirthday);
        this.regiPanel.add(bdayField);
        this.regiPanel.add(regiMajor);
        this.regiPanel.add(majorField);
        this.regiPanel.add(createStuButton);
        this.add(regiPanel);
        this.revalidate();
        this.repaint();
    }
    
    //listPanel that displays list of students in Database
    public void startList(StudentList stList){
        StudentList students = stList;
        ArrayList<Student> list = students.returnList();
        this.getContentPane().removeAll();
        
        //list Panel
        JPanel listPanel = new JPanel();
        listPanel.setLayout(null);
        listPanel.setBackground(Color.black);
        listPanel.add(goMainButton);
        
        //make array of students label
        JLabel[] student = new JLabel[list.size()];
        int i1=60; int ii = 30;
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++){
            String info = "";
            info+=list.get(i).id;
            info+=" ";
            info+=list.get(i).name;
            student[i] = new JLabel(info);
            student[i].setForeground(Color.white);
            student[i].setBounds(ii, i1, 200, 30);
            listPanel.add(student[i]);
            i1+= 15;
            if(i!=0 && i % 30 == 0){
             //tried to add scroll pane but failed, so increase x axis
                ii+=120;
                i1 = 60;
            }     
        }
        
        this.setVisible(true);
        this.add(listPanel);
        this.revalidate();
        this.repaint();
    }
    
    //this method is called when goBackMain button pushed. It go back page to idPanel(first page)
    public void goBackMain(){
       this.goMainFlag = false;
       this.getContentPane().removeAll();
       idPanel.setVisible(true);
       this.add(idPanel);
       this.revalidate();
       this.repaint();
    }
    
    //this method creates regiSucPanel which shows message to users.
    public void regiSucceed(){
        this.getContentPane().removeAll();
        this.registerSucceed = false;  //flag off 
        
        //create succeed Panel
        JPanel regiSucPanel = new JPanel();
        JLabel regiSucLabel = new JLabel("New student register is successful!");
        regiSucPanel.setLayout(null);
        regiSucLabel.setForeground(Color.white);
        regiSucLabel.setFont(new Font("Dialog", Font.BOLD, 13));
        regiSucLabel.setBounds(280,200,300,30);      
        regiSucPanel.setBackground(Color.black);
        regiSucPanel.add(regiSucLabel);
        regiSucPanel.add(goMainButton);
        this.add(regiSucPanel);
        this.revalidate();
        this.repaint();
    }
    
    //make some variables to default setting
    public void makeDefault(){
              this.idInput.setText("");
              this.idField.setText("");
              this.nameField.setText("");
              this.genderField.setText("");
              this.bdayField.setText("");
              this.majorField.setText("");
              this.idError = false;
              this.existIdError = false;
              this.nameError = false;
              this.genderError = false;
              this.bdayError = false;
              this.majorError = false;
              this.ambBooked = false;
              this.mentBooked = false;
              this.enrolError = false;
              unenrolPaperLabel.setVisible(false);
              enrolPaperLabel.setVisible(false);
              this.menBox.setVisible(false);
              this.bookMeButton.setVisible(false);
    }
    
    //this method add listener on buttons
    public void addActionListener(ActionListener listener){
        this.idSearchButton.addActionListener(listener);
        this.regiButton.addActionListener(listener);
        this.listButton.addActionListener(listener);
        this.goMainButton.addActionListener(listener);
        this.createStuButton.addActionListener(listener);
        this.bookAmButton.addActionListener(listener);
        this.bookMeButton.addActionListener(listener);
        this.findSessionButton.addActionListener(listener);
    }

    //this method override update of Observer which receives input from Observable Model
    @Override
    public void update(Observable o, Object arg){ 
        //validate which argument
        Student student = null;
        try{
            student = (Student) arg;//get Student object
        }catch(ClassCastException ex){    
        }
        StudentList stList = null;
        try{
           stList = (StudentList) arg;//get StudentList object 
        }catch(ClassCastException ex){
        }
        Mentor mentor = null;
        try{
            mentor = (Mentor) arg;
        }catch(ClassCastException ex){
        }
        
        //if argument student
        if(student != null){
            if(student.idFlag){ //if student found, start info
               this.startInfo(student);
           }  
        }
        //if argument studentList
        else if(stList != null){
           this.startList(stList); //go to listPanel
        }
        //if argument mentor
        else if(mentor != null){
            mentor.getDay();
            menBox.removeAllItems();
             
            int date1 = mentor.firstDate(mentor.day1);
            int date2 = mentor.firstDate(mentor.day2);
             
            //4 weeks of session is available to book
            for(int i=0; i<4; ++i){
                String session1 = mentor.name+" "+date1+"/"+"10 "+mentor.ava1;
                String session2 = mentor.name+" "+date2+"/"+"10 "+mentor.ava2;
                date1 += 7;
                date2 += 7;
                menBox.addItem(session1);
                menBox.addItem(session2);
            }
            menBox.setBounds(300,220,280,30);
            this.bookMeButton.setVisible(true);
            this.bookMeButton.setFont(new Font("Dialog", Font.BOLD, 11));
            this.bookMeButton.setBackground(Color.LIGHT_GRAY);
            this.bookMeButton.setBounds(600,220,160,30);
            infoPanel.add(menBox);
            infoPanel.add(bookMeButton);
            this.revalidate();
            this.repaint();
        }
        //if argument other
        else{
            //goMainButton pushed
            if(goMainFlag){
              this.makeDefault(); //if go back to main page, set some attributes to default values.
              this.idSearchError = false;
              this.goBackMain();
            }
            ///idPage///
            //if id not found, show error message
            if(idSearchError){
                this.idInput.setText("");
                this.idNotFound.setForeground(Color.red);
                this.idNotFound.setBounds(260, 285, 300, 30);
                this.idNotFound.setVisible(true);
                this.idPanel.add(idNotFound);
                this.revalidate();
                this.repaint();
            }
            if(!idSearchError){
                this.idNotFound.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            ////regiPage////
            //if register button pushed, go regiPanel
            if(goRegiPage){
               this.registerInfo();
            }
            //if id is not in a right form, give instruction
            if(idError){ 
               this.idField.setText("");
               this.idErrorLabel.setForeground(Color.red);
               this.idErrorLabel.setBounds(490, 150, 200, 30);
               this.idErrorLabel.setVisible(true);
               this.regiPanel.add(idErrorLabel);
               this.revalidate();
               this.repaint();
            }
            if(!idError){
                this.idErrorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if id already exists in Database, give error
            if(existIdError){
                this.idField.setText("");
                this.existIdLabel.setForeground(Color.red);
                this.existIdLabel.setBounds(490,150,250,30);
                this.existIdLabel.setVisible(true);
                this.regiPanel.add(existIdLabel);
                this.revalidate();
                this.repaint();
            }
            if(!existIdError){
                this.existIdLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if name is not in right form give error
            if(nameError){
               this.nameField.setText("");
               this.nameErrorLabel.setForeground(Color.red);
               this.nameErrorLabel.setBounds(540,200,200,30);
               this.nameErrorLabel.setVisible(true);
               this.regiPanel.add(nameErrorLabel);
               this.revalidate();
               this.repaint();
            }
            if(!nameError){
                this.nameErrorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if gender is not in right form give error
            if(genderError){
                this.genderField.setText("");
                this.genderErrorLabel.setForeground(Color.red);
                this.genderErrorLabel.setBounds(500,250,200,30);
                this.genderErrorLabel.setVisible(true);
                this.regiPanel.add(genderErrorLabel);
                this.revalidate();
                this.repaint();
            }
            if(!genderError){
                this.genderErrorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if birthday not in right form, give error
            if(bdayError){
                this.bdayField.setText("");
                this.bdayErrorLabel.setForeground(Color.red);
                this.bdayErrorLabel.setBounds(500, 300, 200, 30);
                this.bdayErrorLabel.setVisible(true);
                this.regiPanel.add(bdayErrorLabel);
                this.revalidate();
                this.repaint();
            }
            if(!bdayError){
                this.bdayErrorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if major not chosed correctly, give error
            if(majorError){
                this.majorField.setText("");
                this.majorErrorLabel.setForeground(Color.red);
                this.majorErrorLabel.setBounds(500,350,200,30);
                this.majorErrorLabel.setVisible(true);
                this.regiPanel.add(majorErrorLabel);
                this.revalidate();
                this.repaint();
            }
            if(!majorError){
                this.majorErrorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
            //if a new student is registered, go to regiSucPanel
            if(registerSucceed){
               this.regiSucceed();
            }
            ///info page///
            //if ambassador is booked, give message and change comboBox
            if(ambBooked){
                this.ambBookedLabel.setForeground(Color.red);
                this.ambBookedLabel.setBounds(400,110,200,30);
                this.ambBookedLabel.setVisible(true);
                this.infoPanel.add(ambBookedLabel);
                String select =(String) this.ambBox.getItemAt(this.ambBox.getSelectedIndex());
                ambBookings.availableAmList.remove(select);
                this.ambBox.removeItem(this.ambBox.getItemAt(this.ambBox.getSelectedIndex()));
                this.revalidate();
                this.repaint();
                
            }
            if(!ambBooked){
                this.ambBookedLabel.setVisible(false);
                this.ambBox = new JComboBox(ambBookings.getArray());
                this.revalidate();
                this.repaint();
            }
            //if no matching mentor, give error
            if(noMentorError){
                this.noMentorLabel.setVisible(true);
                this.noMentorLabel.setBounds(300,110,200,30);
                this.noMentorLabel.setForeground(Color.red);
                this.infoPanel.add(noMentorLabel);
                this.revalidate();
                this.repaint();
            }
            if(!noMentorError){
                this.noMentorLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            } 
            //if mentor is booked, give message and change comboBox
            if(mentBooked){
                this.mentorBookedLabel.setForeground(Color.red);
                this.mentorBookedLabel.setBounds(400,260,200,30);
                this.mentorBookedLabel.setVisible(true);
                this.infoPanel.add(mentorBookedLabel); 
                this.unenrolPaperLabel.setVisible(true);
                this.enrolPaperLabel.setVisible(true);
                this.menBox.removeItem(this.menBox.getItemAt(this.menBox.getSelectedIndex()));
                this.revalidate();
                this.repaint(); 
            }
            if(!mentBooked){
                this.mentorBookedLabel.setVisible(false);
                this.revalidate();
                this.repaint();
            }
        }
    }
}

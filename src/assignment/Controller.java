/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author fvx3255
 */
public class Controller implements ActionListener{
    public Model model;
    public View view;
    
    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
        this.view.addActionListener(this);
    }
    
    public boolean isNumeric(String id){
        try{
            Integer.parseInt(id);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public boolean isCharacter(String name){
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if(!(c == ' ') || (((c<= 'A' && c >= 'Z')&&(c<='a' && c>='z')))){
                return false;
            }      
        }
        return true;
    }

    public boolean checkBday(String bday){
        if(bday.length() != 8)
            return false;
        else{
            //check if it is in the right form with /
            if(bday.charAt(2) == '/' && bday.charAt(5) == '/'){
               for(int i=0; i<8; i++){
                   if(i != 2 && i != 5){
                       char c = bday.charAt(i);
                        if(!(c >='0') && (c <= '9'))
                           return false;
                        return true;
                   }      
               }              
            }   
            else
                return false;
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        switch(command){
            case "Search":
                //id search button
                int id = Integer.parseInt(this.view.idInput.getText()); //get searchable id
                
                this.model.checkID(id);
                break;
            case "Register new student":
                //register new student button
                this.model.registerIdPage();
                break;
            case "Show list of student":
                //show list of student button
            case "Back to Main":
                //back to main page button
                this.model.backToMain();
                break;
            case "Create student information":
                //create student button on registerIdPage
                if(this.view.idField.getText().length() != 7 || !isNumeric(this.view.idField.getText()))
                    view.idError = true;
                if(!isCharacter(this.view.nameField.getText()))
                    view.nameError = true;
                if(!this.view.genderField.getText().equalsIgnoreCase("F")||!this.view.genderField.getText().equalsIgnoreCase("M"))
                    view.genderError = true;
                if(!checkBday(this.view.bdayField.getText()))
                    view.bdayError = true;
                if(!this.view.majorField.getText().equals("BSC")||
                        !this.view.majorField.getText().equals("BSIS")||
                        !this.view.majorField.getText().equals("BEN")||
                        !this.view.majorField.getText().equals("MSC")||
                        !this.view.majorField.getText().equals("MEN")||
                        !this.view.majorField.getText().equals("DSC"))
                    view.majorError = true;
        
                    
                      
                break;
            default:
                break;
        }
    }
}

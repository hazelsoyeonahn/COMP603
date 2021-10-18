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
    //    this.view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}

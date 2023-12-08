package offense.management.admin;

import javax.swing.*;
import java.awt.*;

public class AdminController{
  static JFrame frame = new JFrame();
  public static void main(String args[]){
    int mark = 0;
    frame.setSize(847, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);
    
    ImageIcon bgImg = new ImageIcon("admin.png");
    ImageIcon bgImg2 = new ImageIcon("adminS.png");

    JPanel optionPanel = new JPanel();
    AdminView.addPanel(frame, optionPanel, 26,114, 211, 400, 0x797166);
    optionPanel.setOpaque(false);

    JLabel fileOffenseBtn = new JLabel("File Offense");
    JLabel requestBtn = new JLabel("Accept Request");
    JLabel pendingBtn = new JLabel("Pending Appeal");

    AdminView.addLabel(optionPanel, fileOffenseBtn, 0, 50, 211, 40, 22, "Roboto", 0xE8E8E8);
    AdminView.addLabel(optionPanel, requestBtn, 0, 120, 211, 40, 22, "Roboto", 0xE8E8E8);
    AdminView.addLabel(optionPanel, pendingBtn, 0, 190, 211, 40, 22, "Roboto", 0xE8E8E8);

      if(mark == 0){
        AdminView.addLabel(optionPanel, fileOffenseBtn, 0, 50, 211, 60, 28, "Roboto", 0xFFFFFF);
        fileOffenseBtn.setBackground(new Color(0x6B6257));
        fileOffenseBtn.setOpaque(true);
      }else if(mark == 1){
        AdminView.addLabel(optionPanel, requestBtn, 0, 110, 211, 60, 28, "Roboto", 0xFFFFFF);
        requestBtn.setBackground(new Color(0x6B6257));
        requestBtn.setOpaque(true);
      }else{
        AdminView.addLabel(optionPanel, pendingBtn, 0, 180, 211, 60, 28, "Roboto", 0xFFFFFF);
        pendingBtn.setBackground(new Color(0x6B6257));
        pendingBtn.setOpaque(true);
      }

    JPanel logutPanel = new JPanel();
    AdminView.addPanel(frame, logutPanel, 26,520, 211, 80, 0x626262);
    logutPanel.setOpaque(false);

    JLabel logoutBtn = new JLabel("LOGOUT");
    AdminView.addLabel(logutPanel, logoutBtn, 30, 20, 150, 40, 22, "Roboto", 0xE8E8E8);

    if(mark == 0){
      addFileOffenseWindow();
    }
    else if(mark == 1){
      addRequestWindow();
    }
    else if(mark == 2){
      addPendingWindow();
    }


    JPanel adminPanel = new JPanel();

    if(mark == 0){
      AdminView.addPanel(frame, adminPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
      AdminView.addImage(adminPanel, bgImg, 0, 0);
    }else{
      AdminView.addPanel(frame, adminPanel, 10,0, bgImg2.getIconWidth(), bgImg2.getIconHeight(), 0xCCCCCC);
      AdminView.addImage(adminPanel, bgImg2, 0, 0);
    }

    frame.setVisible(true);
  }

  static void addFileOffenseWindow(){
    JPanel displayPanel = new JPanel();
    AdminView.addPanel(frame, displayPanel, 249,114, 551, 440, 0xE8E8E8);
    displayPanel.setOpaque(false);

      JTextField addOffenseTxt = new JTextField();
      AdminView.addTextField(displayPanel, addOffenseTxt, 20, 45, 500, 40, "Roboto", 20);

      JCheckBox minorCB = new JCheckBox();
      AdminView.addCheckBox(displayPanel, minorCB, 25, 182, 30, 30);

      JCheckBox majorCB = new JCheckBox();
      AdminView.addCheckBox(displayPanel, majorCB, 25, 218, 30, 30);

      JCheckBox seriousCB = new JCheckBox();
      AdminView.addCheckBox(displayPanel, seriousCB, 260, 182, 30, 30);

      JCheckBox verySCB = new JCheckBox();
      AdminView.addCheckBox(displayPanel, verySCB, 260, 218, 30, 30);

      JTextField commitTxt = new JTextField();
      AdminView.addTextField(displayPanel, commitTxt, 235, 262, 230, 30, "Roboto", 18, " MM/DD/YY");

      JTextField reportTxt = new JTextField();
      AdminView.addTextField(displayPanel, reportTxt, 235, 297, 230, 30, "Roboto", 18, " MM/DD/YY");

      JTextField reportByTxt = new JTextField();
      AdminView.addTextField(displayPanel, reportByTxt, 235, 332, 230, 30, "Roboto", 18);

      JTextField departmentTxt = new JTextField();
      AdminView.addTextField(displayPanel, departmentTxt, 235, 367, 230, 30, "Roboto", 18);

      JTextField IDTxt = new JTextField();
      AdminView.addTextField(displayPanel, IDTxt, 235, 402, 230, 30, "Roboto", 18);

    JPanel cancelSubmitPanel = new JPanel();
    AdminView.addPanel(frame, cancelSubmitPanel, 249, 555, 551, 50, 0x626262);
    cancelSubmitPanel.setOpaque(false);

      JLabel cancelBtn = new JLabel("CANCEL");
      AdminView.addLabel(cancelSubmitPanel, cancelBtn, 91, 5, 150, 40, 18, "Roboto", 0xE8E8E8);

      JLabel submitBtn = new JLabel("SUBMIT");
      AdminView.addLabel(cancelSubmitPanel, submitBtn, 300, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
  }

  static void addRequestWindow(){

  }

  static void addPendingWindow(){

  }
  
}
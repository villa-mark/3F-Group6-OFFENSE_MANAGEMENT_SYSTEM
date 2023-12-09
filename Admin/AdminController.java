package offense.management.admin;

import offense.management.login.LoginController;
import offense.management.component.Component;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AdminController extends Component implements MouseListener{
 
  static int mark = 0;
  JLabel fileOffenseBtn, requestBtn, pendingBtn, logoutBtn, clearlBtn, submitBtn;

  public AdminController(){
    ImageIcon bgImg = new ImageIcon("admin.png");
    ImageIcon bgImg2 = new ImageIcon("adminS.png");

    JPanel optionPanel = new JPanel();
    AdminView.addPanel(window, optionPanel, 26,114, 211, 400, 0x797166);
    optionPanel.setOpaque(false);

    fileOffenseBtn = new JLabel("File Offense");
    AdminView.addLabel(optionPanel, fileOffenseBtn, 0, 50, 211, 40, 22, "Roboto", 0xE8E8E8);
    fileOffenseBtn.addMouseListener(this);

    requestBtn = new JLabel("Accept Request");
    AdminView.addLabel(optionPanel, requestBtn, 0, 120, 211, 40, 22, "Roboto", 0xE8E8E8);
    requestBtn.addMouseListener(this);

    pendingBtn = new JLabel("Pending Appeal");
    AdminView.addLabel(optionPanel, pendingBtn, 0, 190, 211, 40, 22, "Roboto", 0xE8E8E8);
    pendingBtn.addMouseListener(this);

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
    AdminView.addPanel(window, logutPanel, 26,520, 211, 80, 0x626262);
    logutPanel.setOpaque(false);

    logoutBtn = new JLabel("LOGOUT");
    AdminView.addLabel(logutPanel, logoutBtn, 30, 20, 150, 40, 22, "Roboto", 0xE8E8E8);
    logoutBtn.addMouseListener(this);

    if(mark == 0){
      clearlBtn = new JLabel("CLEAR");
      clearlBtn.addMouseListener(this);

      submitBtn = new JLabel("SUBMIT");
      submitBtn.addMouseListener(this);
      
      addFileOffenseWindow(clearlBtn, submitBtn);
    }
    else if(mark == 1){
      addRequestWindow();
    }
    else if(mark == 2){
      addPendingWindow();
    }

    JPanel adminPanel = new JPanel();
      if(mark == 0){
        AdminView.addPanel(window, adminPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
        AdminView.addImage(adminPanel, bgImg, 0, 0);
      }else{
        AdminView.addPanel(window, adminPanel, 10,0, bgImg2.getIconWidth(), bgImg2.getIconHeight(), 0xCCCCCC);
        AdminView.addImage(adminPanel, bgImg2, 0, 0);
      }

    window.setVisible(true);
  }

  static void addFileOffenseWindow(JLabel clearlBtn, JLabel submitBtn){
    JPanel displayPanel = new JPanel();
    AdminView.addPanel(window, displayPanel, 249,114, 551, 440, 0xE8E8E8);
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
    AdminView.addPanel(window, cancelSubmitPanel, 249, 555, 551, 50, 0x626262);
    cancelSubmitPanel.setOpaque(false);

      AdminView.addLabel(cancelSubmitPanel, clearlBtn, 91, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
  
      AdminView.addLabel(cancelSubmitPanel, submitBtn, 300, 5, 150, 40, 18, "Roboto", 0xE8E8E8);

  }

  static void addRequestWindow(){
    ArrayList<String> pendingData = new ArrayList<String>();
  }

  static void addPendingWindow(){

  }

  @Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == fileOffenseBtn){
        AdminView.clearFrame(window);
        mark = 0;
        new AdminController();
      }
      if(event.getSource() == requestBtn){
        AdminView.clearFrame(window);
        mark = 1;
        new AdminController();
      }
      if(event.getSource() == pendingBtn){
        AdminView.clearFrame(window);
        mark = 2;
        new AdminController();
      }
      if(event.getSource() == logoutBtn){
        AdminView.clearFrame(window);
        mark = 0;
        new LoginController();
      }
  }
@Override
  public void mouseEntered(MouseEvent event){
    if(event.getSource() == fileOffenseBtn){
        if(mark == 1 || mark == 2){
          AdminView.changeButton(fileOffenseBtn, "Roboto", 25, 0x000000);
        }
      }
    if(event.getSource() == requestBtn){
       if(mark == 0 || mark == 2){
          AdminView.changeButton(requestBtn, "Roboto", 25, 0x000000);
        }
      }
    if(event.getSource() == pendingBtn){
         if(mark == 0 || mark == 1){
          AdminView.changeButton(pendingBtn, "Roboto", 25, 0x000000);
        }
      }
    if(event.getSource() == logoutBtn){
        AdminView.changeButton(logoutBtn, "Roboto", 25, 0xFD0000);
      }
    if(event.getSource() == submitBtn){
        AdminView.changeButton(submitBtn, "Roboto", 19, 0x00FF47);
      }
    if(event.getSource() == clearlBtn){
        AdminView.changeButton(clearlBtn, "Roboto", 19, 0xFF0000);
      }
  }
@Override
  public void mouseExited(MouseEvent event){
    if(event.getSource() == fileOffenseBtn){
        if(mark == 1 || mark == 2){
          AdminView.changeButton(fileOffenseBtn, "Roboto", 22, 0xE8E8E8);
        }
      }
    if(event.getSource() == requestBtn){
       if(mark == 0 || mark == 2){
          AdminView.changeButton(requestBtn, "Roboto", 22, 0xE8E8E8);
        }
      }
    if(event.getSource() == pendingBtn){
         if(mark == 0 || mark == 1){
          AdminView.changeButton(pendingBtn, "Roboto", 22, 0xE8E8E8);
        }
      }
    if(event.getSource() == logoutBtn){
        AdminView.changeButton(logoutBtn, "Roboto", 22, 0xE8E8E8);
      }
    if(event.getSource() == submitBtn){
        AdminView.changeButton(submitBtn, "Roboto", 18, 0xE8E8E8);
      }
    if(event.getSource() == clearlBtn){
        AdminView.changeButton(clearlBtn, "Roboto", 18, 0xE8E8E8);
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
  
}
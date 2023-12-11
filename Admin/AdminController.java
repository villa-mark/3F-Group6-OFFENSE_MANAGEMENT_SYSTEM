package offense.management.admin;

import offense.management.login.LoginController;
import offense.management.component.Component;
import offense.management.filehandle.FileHandleController;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AdminController extends Component implements MouseListener, ActionListener{
 
  static int mark = 0;
  static int idCheck = 0;
  JLabel fileOffenseBtn, requestBtn, pendingBtn, logoutBtn, clearBtn, submitBtn;
  JButton[] acceptBtn;
  JButton[] declineBtn;
  JButton[] approveBtn;
  JButton[] rejectBtn;
  ArrayList<String> pendingData;
  ArrayList<ArrayList<String>> appealData;
  JTextField commitTxt, reportTxt, reportByTxt, departmentTxt, IDTxt;
  JTextArea addOffenseTxt;
  JCheckBox minorCB, majorCB, seriousCB, verySCB;
  static String severity = "MINOR";
  static String offense = null;
  static String commit = null;
  static String report = null;
  static String reportBy = null;
  static String deparment = null;


  public AdminController(){
    ImageIcon bgImg = new ImageIcon("Images//admin.png");
    ImageIcon bgImg2 = new ImageIcon("Images//adminS.png");

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
      JPanel displayPanel = new JPanel();
      AdminView.addPanel(window, displayPanel, 249,114, 551, 440, 0xE8E8E8);
      displayPanel.setOpaque(false);

        addOffenseTxt = new JTextArea();
        AdminView.addTextArea(displayPanel, addOffenseTxt, 20, 45, 500, 90, "Roboto", 20);

        minorCB = new JCheckBox();
        AdminView.addCheckBox(displayPanel, minorCB, 25, 182, 30, 30);
        minorCB.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
              severity = "MINOR";
              majorCB.setSelected(false);
              seriousCB.setSelected(false);
              verySCB.setSelected(false);
            }
          }
        });

        majorCB = new JCheckBox();
        AdminView.addCheckBox(displayPanel, majorCB, 25, 218, 30, 30);
        majorCB.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
              severity = "MAJOR";
              minorCB.setSelected(false);
              seriousCB.setSelected(false);
              verySCB.setSelected(false);
            }
          }
        });

        seriousCB = new JCheckBox();
        AdminView.addCheckBox(displayPanel, seriousCB, 260, 182, 30, 30);
        seriousCB.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
              severity = "SERIOUS";
              minorCB.setSelected(false);
              majorCB.setSelected(false);
              verySCB.setSelected(false);
            }
          }
        });

        verySCB = new JCheckBox();
        AdminView.addCheckBox(displayPanel, verySCB, 260, 218, 30, 30);
        verySCB.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED){
              severity = "VERY SERIOUS";
              minorCB.setSelected(false);
              majorCB.setSelected(false);
              seriousCB.setSelected(false);
            }
          }
        });

        commitTxt = new JTextField();
        AdminView.addTextField(displayPanel, commitTxt, 235, 262, 230, 30, "Roboto", 18, " MM/DD/YY");
        commitTxt.addMouseListener(this);

        reportTxt = new JTextField();
        AdminView.addTextField(displayPanel, reportTxt, 235, 297, 230, 30, "Roboto", 18, " MM/DD/YY");
        reportTxt.addMouseListener(this);

        reportByTxt = new JTextField();
        AdminView.addTextField(displayPanel, reportByTxt, 235, 332, 230, 30, "Roboto", 18);

        departmentTxt = new JTextField();
        AdminView.addTextField(displayPanel, departmentTxt, 235, 367, 230, 30, "Roboto", 18);

        IDTxt = new JTextField();
        AdminView.addTextField(displayPanel, IDTxt, 175, 402, 150, 30, "Roboto", 18);
        
        JLabel warnId;
        if(idCheck == 1 || idCheck == 2){
          if(idCheck == 1){warnId = new JLabel("ID does not Exist!!!");}
          else{warnId = new JLabel("Fill the blank");}
          AdminView.addLabel(displayPanel, warnId, 330, 402, 180, 30, 18, "Roboto", 0xFD0000);
          addOffenseTxt.setText(offense);
          commitTxt.setText(commit);
          reportTxt.setText(report);
          reportByTxt.setText(reportBy);
          departmentTxt.setText(deparment);
        }else if(idCheck == 3){
          warnId = new JLabel("FILED");
          AdminView.addLabel(displayPanel, warnId, 330, 402, 100, 30, 25, "Roboto", 0x14FF00);
        }
        

      JPanel cancelSubmitPanel = new JPanel();
      AdminView.addPanel(window, cancelSubmitPanel, 249, 555, 551, 50, 0x626262);
      cancelSubmitPanel.setOpaque(false);

        submitBtn = new JLabel("SUBMIT");
        AdminView.addLabel(cancelSubmitPanel, submitBtn, 300, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
        submitBtn.addMouseListener(this);
    
        clearBtn = new JLabel("CLEAR");
        AdminView.addLabel(cancelSubmitPanel, clearBtn, 91, 5, 150, 40, 18, "Roboto", 0xE8E8E8);
        clearBtn.addMouseListener(this);
        
    }
    else if(mark == 1){
      pendingData = new ArrayList<String>();
      int size = FileHandleController.convertDataFile(pendingData);
      
      JPanel requestPanel = new JPanel();
      AdminView.addPanel(window, requestPanel, 248,115, 550, 486, 0xE8E8E8);
      requestPanel.setOpaque(false);

      if(pendingData.size() == 0){
        JLabel emptyLbl = new JLabel("NO REQUEST");
        AdminView.addLabel(requestPanel, emptyLbl, 0, 220, 550, 40, 32, "Roboto", 0xFF0000);
      }else{

        JLabel[] userRequest = new JLabel[pendingData.size()];
        acceptBtn = new JButton[pendingData.size()];
        declineBtn = new JButton[pendingData.size()];
        int y = 30, num = 0;;

        while(num != pendingData.size()){

          userRequest[num] = new JLabel(pendingData.get(num));
          AdminView.addLabel(requestPanel, userRequest[num], 20, y, 278, 30, 22, "Roboto", 0xFFFFFF);
          userRequest[num].setBackground(new Color(0x5F5F5F));
          userRequest[num].setOpaque(true);

          acceptBtn[num] = new JButton("ACCEPT");
          AdminView.addButton(requestPanel, acceptBtn[num], 303, y, 115, 30, 22, "Roboto", 0x00A638, 0xFFFFFF);
          acceptBtn[num].addActionListener(this);

          declineBtn[num] = new JButton("DECLINE");
          AdminView.addButton(requestPanel, declineBtn[num], 423, y, 115, 30, 22, "Roboto", 0xA80000, 0xFFFFFF);
          declineBtn[num].addActionListener(this);
          
          y+=35;
          num++;
    }}}
    else if(mark == 2){
      appealData = new ArrayList<>();
      FileHandleController.covert2DArrayPending(appealData);
      
      JPanel pendingPanel = new JPanel();
      AdminView.addPanel(window, pendingPanel, 248,115, 550, 486, 0xE8E8E8);
      pendingPanel.setOpaque(false);

      if(appealData.size() == 0){
        JLabel emptyLbl = new JLabel("NO PENDING APPEAL");
        AdminView.addLabel(pendingPanel, emptyLbl, 0, 220, 550, 40, 32, "Roboto", 0xFF0000);
      }else{
        JLabel[] userRequest = new JLabel[appealData.size()];
        approveBtn = new JButton[appealData.size()];
        rejectBtn = new JButton[appealData.size()];
        int y = 30, num = 0;;

        while(num != appealData.size()){

          userRequest[num] = new JLabel(appealData.get(num).get(1));
          AdminView.addLabel(pendingPanel, userRequest[num], 20, y, 278, 30, 22, "Roboto", 0xFFFFFF);
          userRequest[num].setBackground(new Color(0x5F5F5F));
          userRequest[num].setOpaque(true);

          approveBtn[num] = new JButton("APPROVE");
          AdminView.addButton(pendingPanel, approveBtn[num], 303, y, 115, 30, 22, "Roboto", 0x00A638, 0xFFFFFF);
          approveBtn[num].addActionListener(this);

          rejectBtn[num] = new JButton("REJECT");
          AdminView.addButton(pendingPanel, rejectBtn[num], 423, y, 115, 30, 22, "Roboto", 0xA80000, 0xFFFFFF);
          rejectBtn[num].addActionListener(this);
          
          y+=35;
          num++;
        }
      }
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

  @Override
  public void actionPerformed(ActionEvent event){
    int num = 0;
    if(mark == 1){
      while(num != pendingData.size()){
        if(event.getSource() == declineBtn[num]){
          AdminView.clearFrame(window);
          FileHandleController.removeDataPending(pendingData.get(num));
          new AdminController();
        }
        if(event.getSource() == acceptBtn[num]){
          AdminView.clearFrame(window);
          ArrayList<ArrayList<String>> colRowData = new ArrayList<>();
          FileHandleController.convertDataWhole(colRowData);
          FileHandleController.addDataInUserInfo(colRowData.get(num).get(0), colRowData.get(num).get(1), colRowData.get(num).get(2), colRowData.get(num).get(3));
          FileHandleController.removeDataPending(pendingData.get(num));
          new AdminController();
        }
        num++;
      }
    }
    if(mark == 2){
      while(num != appealData.size()){
        if(event.getSource() == rejectBtn[num]){
          AdminView.clearFrame(window);
          FileHandleController.removeDataPending(appealData.get(num).get(1), appealData.get(num).get(2) );
          new AdminController();
        }
        if(event.getSource() == approveBtn[num]){
          AdminView.clearFrame(window);
          ArrayList<ArrayList<String>> colRowData = new ArrayList<>();
          FileHandleController.convertDataFilePending(colRowData);
          FileHandleController.updateOffenseRecord(colRowData.get(num).get(2));
          FileHandleController.removeDataPending(appealData.get(num).get(1), appealData.get(num).get(2) );
          new AdminController();
        }
        num++;
      }
    }
      
  }
  @Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == fileOffenseBtn){
        AdminView.clearFrame(window);
        mark = 0;
        idCheck = 0;
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
        idCheck = 0;
        new LoginController();
      }
      if(event.getSource() == clearBtn){
        AdminView.clearFrame(window);
        mark = 0;
        offense = null;
        commit = null;
        report = null;
        reportBy = null;
        deparment = null;
        new AdminController();
      }
      if(event.getSource() == submitBtn){
        AdminView.clearFrame(window);
        if(addOffenseTxt.getText().isEmpty() || commitTxt.getText().isEmpty() ||  reportTxt.getText().isEmpty() ||  reportByTxt.getText().isEmpty() ||  departmentTxt.getText().isEmpty() ||  IDTxt.getText().isEmpty()){
          idCheck = 2;
        }else{
          mark = 0;
          int checkId = FileHandleController.addOffenseToUser(addOffenseTxt.getText(), severity, commitTxt.getText(), reportTxt.getText(), reportByTxt.getText(), departmentTxt.getText(), IDTxt.getText());
          if(checkId == 0){
            idCheck = 1;
          }else{idCheck = 3;}
        }
        offense = addOffenseTxt.getText();
        commit = commitTxt.getText();
        report = reportTxt.getText();
        reportBy = reportByTxt.getText();
        deparment = departmentTxt.getText();
        new AdminController();
      }
      if(event.getSource() == commitTxt){
        if(commitTxt.getText().equals(" MM/DD/YY") || commitTxt.getText().isEmpty()){
           commitTxt.setText(null);
           commitTxt.setForeground(Color.black);
        }
      }
      if(event.getSource() == reportTxt){
       if(reportTxt.getText().equals(" MM/DD/YY") || reportTxt.getText().isEmpty()){
           reportTxt.setText(null);
           reportTxt.setForeground(Color.black);
        }
      }
  }
@Override
  public void mouseEntered(MouseEvent event){
    if(event.getSource() == fileOffenseBtn){
        if(mark == 1 || mark == 2){
          idCheck = 0;
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
    if(event.getSource() == clearBtn){
        AdminView.changeButton(clearBtn, "Roboto", 19, 0xFF0000);
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
    if(event.getSource() == clearBtn){
        AdminView.changeButton(clearBtn, "Roboto", 18, 0xE8E8E8);
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
  
}
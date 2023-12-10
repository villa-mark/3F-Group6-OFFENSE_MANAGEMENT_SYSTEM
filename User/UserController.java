package offense.management.user;

import offense.management.login.LoginController;
import offense.management.component.Component;
import offense.management.filehandle.FileHandleController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class UserController extends Component implements MouseListener{

  private static int mark = 0;
  static int explainFrame = 0;
  static int numEx = 0;
  JLabel logoutBtn;
  JButton recordButton, pendingButton, appealBtn, explainBtn, closeBtn, submitBtn;
  JLabel[] offenses;
  JTextArea explainAppealField;
  ArrayList<ArrayList<String>> userOffense = new ArrayList<>();
  ArrayList<ArrayList<String>> pendingAppeal = new ArrayList<>();


  public UserController(){
    ImageIcon bgImg = new ImageIcon("user.png");

    JPanel userInfoPanel = new JPanel();
    UserView.addPanel(window, userInfoPanel, 140, 10, 490, 100, bgC);
    userInfoPanel.setOpaque(false);

    JLabel nameLbl = new JLabel(FileHandleController.getName());
    UserView.addLabel(userInfoPanel, nameLbl, 5, 15, 485, 40, 25, "Roboto");

    JLabel IDLbl = new JLabel("ID: " + FileHandleController.getID());
    UserView.addLabel(userInfoPanel, IDLbl, 5, 50, 485, 40, 20, "Roboto");

    JPanel logoutPanel = new JPanel();
    UserView.addPanel(window, logoutPanel, 630, 10, 180, 100, btnC);
    logoutPanel.setOpaque(false);

    logoutBtn = new JLabel("LOGOUT");
    UserView.addLabel(logoutPanel, logoutBtn, 10, 10, 150, 40, 28, "Roboto", bgC);
    logoutBtn.addMouseListener(this);

    JPanel buttonPanel = new JPanel();
    UserView.addPanel(window, buttonPanel, 60, 150, 712, 50, 0x000000);
    buttonPanel.setOpaque(false);

    recordButton = new JButton("RECORD");
    recordButton.addMouseListener(this);

    pendingButton = new JButton("PENDING");
    pendingButton.addMouseListener(this);

    if(mark == 0){
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", btnC, 0xD9D9D9);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", 0xD9D9D9, btnC);
    }else if(mark == 1){
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", 0xD9D9D9, btnC);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", btnC, 0xD9D9D9);
    }
 
    if(mark == 0){
      JPanel recordPanel = new JPanel();
      UserView.addPanel(window, recordPanel, 65, 205, 700, 380, 0xD9D9D9);

      try{
        String idS = FileHandleController.getID();
        FileHandleController.userOffenses(userOffense, FileHandleController.getID());

        // System.out.print(userOffense);
        if(userOffense.size() == 0){
          JLabel warnEmpty = new JLabel("NO RECORD");
          UserView.addLabel(recordPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
        }else{
          int col = 0;
          int y = 20;
          offenses = new JLabel[userOffense.size()];
          JLabel[] filedNotFiled = new JLabel[userOffense.size()];
          JLabel[] severityLbl = new JLabel[userOffense.size()];

          if(explainFrame == 1 || explainFrame == 2){
              window.setLocation(510,20);
              JPanel appealPanel = new JPanel();
              UserView.addPanel(appealFrame, appealPanel, 0, 0, 500, 580, 0xD9D9D9);
              appealPanel.setOpaque(false);

              JLabel offLbl = new JLabel("Offense:");
              UserView.addLabel(appealPanel, offLbl, 10, 10, 450, 40, 28, "Roboto", 0x000000);
              JLabel offDLbl = new JLabel(userOffense.get(numEx).get(0));
              UserView.addLabel(appealPanel, offDLbl, 10, 50, 450, 40, 23, "Roboto", 0xF04545);

              JLabel comLbl = new JLabel("Date Committed:");
              UserView.addLabel(appealPanel, comLbl, 10, 110, 170, 30, 20, "Roboto");
              JLabel comDLbl = new JLabel(userOffense.get(numEx).get(3));
              UserView.addLabel(appealPanel, comDLbl, 180, 110, 170, 30, 20, "Roboto");

              JLabel repLbl = new JLabel("Date Reported:");
              UserView.addLabel(appealPanel, repLbl, 10, 150, 170, 30, 20, "Roboto");
              JLabel repDLbl = new JLabel(userOffense.get(numEx).get(4));
              UserView.addLabel(appealPanel, repDLbl, 180, 150, 170, 30, 20, "Roboto");

              JLabel repByLbl = new JLabel("Reported By:");
              UserView.addLabel(appealPanel, repByLbl, 10, 190, 170, 30, 20, "Roboto");
              JLabel repByDLbl = new JLabel(userOffense.get(numEx).get(5));
              UserView.addLabel(appealPanel, repByDLbl, 180, 190, 170, 30, 20, "Roboto");

              JLabel depLbl = new JLabel("Department:");
              UserView.addLabel(appealPanel, depLbl, 10, 230, 170, 30, 20, "Roboto");
              JLabel depDLbl = new JLabel(userOffense.get(numEx).get(6));
              UserView.addLabel(appealPanel, depDLbl, 180, 230, 170, 30, 20, "Roboto");

              appealBtn = new JButton("APPEAL");
              appealBtn.addMouseListener(this);

              explainBtn = new JButton("EXPLANATION");
              explainBtn.addMouseListener(this);

              if(explainFrame == 1){
                UserView.addButton(appealPanel, appealBtn, 10, 270, 225, 30, 20, "Roboto", 0xFFFFFF, 0x686363);
                UserView.addButton(appealPanel, explainBtn, 235, 270, 225, 30, 20, "Roboto", 0x686363, 0xFFFFFF);
              }else{
                UserView.addButton(appealPanel, appealBtn, 10, 270, 225, 30, 20, "Roboto", 0x686363, 0xFFFFFF);
                UserView.addButton(appealPanel, explainBtn, 235, 270, 225, 30, 20, "Roboto", 0xFFFFFF, 0x686363);
              }
              explainAppealField = new JTextArea(); 
              UserView.addTextArea(appealPanel, explainAppealField, 10, 300, 450, 110, "Roboto", 20);

              closeBtn = new JButton("CLOSE");
              UserView.addButton(appealPanel, closeBtn, 10, 410, 225, 30, 23, "Roboto", 0x9B5151, 0xFFFFFF);
              closeBtn.addMouseListener(this);

              submitBtn = new JButton("SUBMIT");
              UserView.addButton(appealPanel, submitBtn, 235, 410, 225, 30, 23, "Roboto", 0x63975E, 0x000000);
              submitBtn.addMouseListener(this);

            appealFrame.setVisible(true);
          }
          int index = 0;
          int not = 0;
          while(col != userOffense.size()){
            if(userOffense.get(col).get(8).equals(FileHandleController.getID())){
              offenses[index] = new JLabel(userOffense.get(col).get(0));
              UserView.addLabel(recordPanel, offenses[index], 20, y, 350, 30, 20, "Roboto", 0x000000);
              offenses[index].setBackground(Color.white);
              offenses[index].setOpaque(true);

              filedNotFiled[index] = new JLabel(userOffense.get(index).get(2));
              UserView.addLabel(recordPanel, filedNotFiled[index], 370, y, 150, 30, 18, "Roboto", 0x000000);
              if(userOffense.get(index).get(2).equals("NOT FILED")){
                filedNotFiled[index].setBackground(new Color(0xF04545));
                offenses[index].addMouseListener(this);
              }else{
                filedNotFiled[index].setBackground(new Color(0x45F060));
              }
              filedNotFiled[index].setOpaque(true);

              severityLbl[index] = new JLabel(userOffense.get(index).get(1));
              UserView.addLabel(recordPanel, severityLbl[index], 520, y, 150, 30, 18, "Roboto", 0x000000);
              severityLbl[index].setBackground(new Color(0xF04545));
              severityLbl[index].setOpaque(true);

              y+=35;
              index++;}else{
                ++not;
                if(not == userOffense.size()-1){
                  JLabel warnEmpty = new JLabel("NO RECORD");
                  UserView.addLabel(recordPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
                }
              }
            ++col;
          }
         
          
        }
     }catch(Exception e){}

    }else{
      try{
        JPanel pendingPanel = new JPanel();
        UserView.addPanel(window, pendingPanel, 65, 205, 700, 380, 0xD9D9D9);

        FileHandleController.covert2DArrayPending(pendingAppeal, FileHandleController.getID());
        if(pendingAppeal.size() == 0){
          JLabel warnEmpty = new JLabel("NO PENDING");
          UserView.addLabel(pendingPanel, warnEmpty, 0, 190, 700, 30, 35, "Roboto", 0x000000);
        }else{
          int colN = 0;
          JLabel[] pendingL = new JLabel[pendingAppeal.size()];
          int y =20;
          while(colN != pendingAppeal.size()){
           
            pendingL[colN] = new JLabel(pendingAppeal.get(colN).get(1));
            UserView.addLabel(pendingPanel, pendingL[colN], 20, y, 650, 30, 20, "Roboto", 0x000000);
            pendingL[colN].setBackground(Color.white);
            pendingL[colN].setOpaque(true);

            y+=35;
            ++colN;
          }
        }}catch(Exception e){}
      }
      
      JPanel userPanel = new JPanel();
      UserView.addPanel(window, userPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), bgC);
      UserView.addImage(userPanel, bgImg, 0, 0);

      window.setVisible(true);
  }

  @Override
  public void mouseClicked(MouseEvent event){
      if(event.getSource() == logoutBtn){
        UserView.clearFrame(window);
        mark = 0;
        explainFrame = 0;
        numEx = 0;
        new LoginController();
      }
      if(event.getSource() == recordButton){
        UserView.clearFrame(window);
        mark = 0;
        explainFrame = 0;
        new UserController();
      }
      if(event.getSource() == pendingButton){
        UserView.clearFrame(window);
        mark = 1;
        explainFrame = 0;
        new UserController();
      }
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.clearFrame(window);
            explainFrame = 1;
            numEx = num;
            new UserController();
          }
          num++;
        }
      }
      if(event.getSource() == appealBtn){
        UserView.clearFrame(appealFrame);
        explainFrame = 1;
        new UserController();
      }
      if(event.getSource() == explainBtn){
        UserView.clearFrame(appealFrame);
        explainFrame = 2;
        new UserController();
      }
      if(event.getSource() == closeBtn){
        UserView.clearFrame(appealFrame);
        window.setLocationRelativeTo(null);
        explainFrame = 0;
        appealFrame.dispose();
        new UserController();
      }
      if(event.getSource() == submitBtn){
        UserView.clearFrame(appealFrame);
        window.setLocationRelativeTo(null);
        explainFrame = 0;
        appealFrame.dispose();
        FileHandleController.writePending(explainAppealField.getText(), FileHandleController.getID(), userOffense.get(numEx).get(7));
        userOffense.clear();
        new UserController();
      }
  }
@Override
  public void mouseEntered(MouseEvent event){
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.changeButton(offenses[num], "Roboto", 23, 0xFFFFFF);
              offenses[num].setBackground(new Color(0xA19595));
          }
          num++;
        }
      }
      if(event.getSource() == logoutBtn){
        UserView.changeButton(logoutBtn, "Roboto", 28, 0xFF0000);
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 32, 0xFFFFFF);
          recordButton.setBackground(new Color(0xA19595));
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
          UserView.changeButton(pendingButton, "Roboto", 32, 0xFFFFFF);
          pendingButton.setBackground(new Color(0xA19595));
        }
      }
  }
@Override
  public void mouseExited(MouseEvent event){
      if(mark == 0){
        int num = 0;
        while(num != userOffense.size()){
          if(event.getSource() == offenses[num]){
            UserView.changeButton(offenses[num], "Roboto", 20, 0x000000);
            offenses[num].setBackground(Color.white);
          }
          num++;
        }
      }
      if(event.getSource() == logoutBtn){
        UserView.changeButton(logoutBtn, "Roboto", 28, bgC);
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 28, 0x626262);
          recordButton.setBackground(new Color(0xD9D9D9));
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
           UserView.changeButton(pendingButton, "Roboto", 28, 0x626262);
           pendingButton.setBackground(new Color(0xD9D9D9));
        }
      }
  }
@Override
  public void mousePressed(MouseEvent event){
    
  }
@Override
  public void mouseReleased(MouseEvent event){
    
  }
}

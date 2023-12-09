package offense.management.user;

import offense.management.login.LoginController;
import offense.management.component.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserController extends Component implements MouseListener{

  private static int mark = 0;
  JLabel logoutBtn;
  JButton recordButton, pendingButton;


  public UserController(){
    ImageIcon bgImg = new ImageIcon("user.png");

    JPanel userInfoPanel = new JPanel();
    UserView.addPanel(window, userInfoPanel, 140, 10, 490, 100, bgC);
    userInfoPanel.setOpaque(false);

    JLabel nameLbl = new JLabel("Mark Anthony");
    UserView.addLabel(userInfoPanel, nameLbl, 5, 15, 485, 40, 28, "Roboto");

    JLabel IDLbl = new JLabel("ID: CITE-Offense-01");
    UserView.addLabel(userInfoPanel, IDLbl, 5, 50, 485, 40, 22, "Roboto");

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
    }else{
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", 0xD9D9D9, btnC);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", btnC, 0xD9D9D9);
    }
 
    if(mark == 0){
      JPanel recordPanel = new JPanel();
      UserView.addPanel(window, recordPanel, 65, 205, 700, 380, 0xD9D9D9);
    }else{
      JPanel pendingPanel = new JPanel();
      UserView.addPanel(window, pendingPanel, 65, 205, 700, 380, 0xD9D9D9);
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
        new LoginController();
      }
      if(event.getSource() == recordButton){
        UserView.clearFrame(window);
        mark = 0;
        new UserController();
      }
      if(event.getSource() == pendingButton){
        UserView.clearFrame(window);
        mark = 1;
        new UserController();
      }
  }
@Override
  public void mouseEntered(MouseEvent event){
      if(event.getSource() == logoutBtn){
        UserView.changeButton(logoutBtn, "Roboto", 28, 0xFF0000);
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 32, 0xFFFFFF);
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
          UserView.changeButton(pendingButton, "Roboto", 32, 0xFFFFFF);
        }
      }
  }
@Override
  public void mouseExited(MouseEvent event){
      if(event.getSource() == logoutBtn){
        UserView.changeButton(logoutBtn, "Roboto", 28, bgC);
      }
      if(event.getSource() == recordButton){
        if(mark == 1){
          UserView.changeButton(recordButton, "Roboto", 28, 0x626262);
        }
      }
      if(event.getSource() == pendingButton){
        if(mark == 0){
           UserView.changeButton(pendingButton, "Roboto", 28, 0x626262);
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

package offense.management.user;

import javax.swing.*;
import java.awt.*;

public class UserController{
  public static void main(String args[]){
    int mark = 0;
    JFrame frame = new JFrame();
    frame.setSize(847, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);

    ImageIcon bgImg = new ImageIcon("user.png");

    JPanel userInfoPanel = new JPanel();
    UserView.addPanel(frame, userInfoPanel, 140, 10, 490, 100, 0xCCCCCC);
    userInfoPanel.setOpaque(false);

    JLabel nameLbl = new JLabel("Mark Anthony");
    UserView.addLabel(userInfoPanel, nameLbl, 5, 15, 485, 40, 28, "Roboto");

    JLabel IDLbl = new JLabel("ID: CITE-Offense-01");
    UserView.addLabel(userInfoPanel, IDLbl, 5, 50, 485, 40, 22, "Roboto");

    JPanel logoutPanel = new JPanel();
    UserView.addPanel(frame, logoutPanel, 630, 10, 180, 100, 0x626262);
    logoutPanel.setOpaque(false);

    JLabel logoutBtn = new JLabel("LOGOUT");
    UserView.addLabel(logoutPanel, logoutBtn, 10, 10, 150, 40, 28, "Roboto", 0xCCCCCC);

    JPanel buttonPanel = new JPanel();
    UserView.addPanel(frame, buttonPanel, 60, 150, 712, 50, 0x000000);
    buttonPanel.setOpaque(false);

    JButton recordButton = new JButton("RECORD");
    JButton pendingButton = new JButton("PENDING");
    if(mark == 0){
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", 0x626262, 0xD9D9D9);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", 0xD9D9D9, 0x626262);
    }else{
      UserView.addButton(buttonPanel, recordButton, 0, 1, 358, 49, 28, "Roboto", 0xD9D9D9, 0x626262);
      UserView.addButton(buttonPanel, pendingButton, 358, 1, 358, 49, 28, "Roboto", 0x626262, 0xD9D9D9);
    }
 
    if(mark == 0){
      JPanel recordPanel = new JPanel();
      UserView.addPanel(frame, recordPanel, 65, 205, 700, 380, 0xD9D9D9);
    }else{
      JPanel pendingPanel = new JPanel();
      UserView.addPanel(frame, pendingPanel, 65, 205, 700, 380, 0xD9D9D9);
    }
    
    

    JPanel userPanel = new JPanel();
    UserView.addPanel(frame, userPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
    UserView.addImage(userPanel, bgImg, 0, 0);

    frame.setVisible(true);
  }
}
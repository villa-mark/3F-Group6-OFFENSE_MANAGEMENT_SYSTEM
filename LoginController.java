package offense.management.login;

import javax.swing.*;
import java.awt.*;

public class LoginController{
  public static void main(String args[]){
    JFrame frame = new JFrame();
    frame.setSize(835, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);

    ImageIcon bgImg = new ImageIcon("login.png");
    JLabel imgHold = new JLabel(bgImg);
    LoginView.addImage(frame, imgHold, bgImg, 10, 0);

    ImageIcon bgImg2 = new ImageIcon("woman.png");
    JLabel imgHold2 = new JLabel(bgImg2);
    LoginView.addImage(frame, imgHold2, bgImg2, bgImg.getIconWidth(), 0);

    JPanel loginPanel = new JPanel();
    LoginView.addPanel(frame, loginPanel, 10,170,358, 452, 0xCCCCCC);

    JLabel usernameLbl = new JLabel("Username:");
    LoginView.addLabel(loginPanel, usernameLbl, 50, 10, 120, 40, 20, "Roboto");

    JTextField usernameTxt = new JTextField();
    LoginView.addTextField(loginPanel, usernameTxt, 50, 60, 250, 40, "Roboto", 20);

    JLabel passwordLbl = new JLabel("Password:");
    LoginView.addLabel(loginPanel, passwordLbl, 50, 120, 120, 40, 20, "Roboto");

    JPasswordField passwordTxt = new JPasswordField();
    LoginView.addJPasswordField(loginPanel, passwordTxt, 50, 170, 250, 40, "Roboto", 20);

    JButton loginButton = new JButton("LOGIN");
    LoginView.addButton(loginPanel, loginButton, 50, 270,259, 41, "Roboto", 28, 0xC5C5C5, 0x626262  );

    JLabel createLbl = new JLabel("Create an Account? ");
    LoginView.addLabel(loginPanel, createLbl, 20, 420, 170, 20, 18, "Roboto");

    JLabel registerLbl = new JLabel("REGISTER");
    LoginView.addLabel(loginPanel, registerLbl, 190, 420, 170, 20, 18, "Roboto", 0xFF0000);


    frame.setVisible(true);
  }
}
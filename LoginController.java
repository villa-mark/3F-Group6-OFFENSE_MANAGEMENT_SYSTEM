package offense.management.login;

import javax.swing.*;
import java.awt.*;

public class LoginController{
  public static void main(String args[]){
    JFrame frame = new JFrame();
    frame.setSize(847, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);

    ImageIcon bgImg = new ImageIcon("login.png");
 
    JPanel loginInputPanel = new JPanel();
    LoginView.addPanel(frame, loginInputPanel, 10, 170, 363, 290, 0xcccccc);
    loginInputPanel.setOpaque(false);

    JTextField usernameTxt = new JTextField();
    LoginView.addTextField(loginInputPanel, usernameTxt, 30, 63, 300, 40, "Roboto", 20);

    JPasswordField passwordTxt = new JPasswordField();
    LoginView.addJPasswordField(loginInputPanel, passwordTxt, 30, 190, 300, 40, "Roboto", 20);

    JPanel loginButtonPanel = new JPanel();
    LoginView.addPanel(frame, loginButtonPanel, 10, 460, 363, 60, 0x626262);
    loginButtonPanel.setOpaque(false);

    JLabel loginButton = new JLabel("LOGIN");
    LoginView.addLabel(loginButtonPanel, loginButton, 55, 8,250, 38, 28, "Roboto", 0xCCCCCC);

    JPanel loginRegisterPanel = new JPanel();
    LoginView.addPanel(frame, loginRegisterPanel, 10, 550, 363, 60, 0xcccccc);
    loginRegisterPanel.setOpaque(false);
  
    JLabel registerLbl = new JLabel("REGISTER");
    LoginView.addLabel(loginRegisterPanel, registerLbl, 208, 35, 100, 20, 18, "Roboto", 0xFF0000);

    JPanel loginPanel = new JPanel();
    LoginView.addPanel(frame, loginPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
    LoginView.addImage(loginPanel, bgImg, 0, 0);

    frame.setVisible(true);
  }
}
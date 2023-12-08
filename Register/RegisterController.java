package offense.management.register;

import javax.swing.*;
import java.awt.*;

public class RegisterController{
  public static void main(String args[]){
    JFrame frame = new JFrame();
    frame.setSize(847, 670);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.black);

    ImageIcon bgImg = new ImageIcon("register.png");

    JPanel registerInputPanel = new JPanel();
    RegisterView.addPanel(frame, registerInputPanel, 10, 140, 363, 370, 0xcccccc);
    registerInputPanel.setOpaque(false);

    JTextField firstnameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, firstnameTxt, 35, 50, 296, 40, "Roboto", 20);

    JTextField lastnameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, lastnameTxt, 35, 130, 296, 40, "Roboto", 20);

    JTextField usernameTxt = new JTextField();
    RegisterView.addTextField(registerInputPanel, usernameTxt, 35, 210, 296, 40, "Roboto", 20);

    JPasswordField passwordTxt = new JPasswordField();
    RegisterView.addJPasswordField(registerInputPanel, passwordTxt, 35, 290, 296, 40, "Roboto", 20);

    JPanel buttonPanel = new JPanel();
    RegisterView.addPanel(frame, buttonPanel, 10, 515, 363, 100, 0x626262);
    buttonPanel.setOpaque(false);

    JLabel cancelButton = new JLabel("CANCEL");
    RegisterView.addLabel(buttonPanel, cancelButton, 18, 43,160, 30, 20, "Roboto", 0xcccccc);

    JLabel registerButton = new JLabel("REGISTER");
    RegisterView.addLabel(buttonPanel, registerButton, 185, 43,160, 30, 20, "Roboto", 0xcccccc);


    JPanel registerPanel = new JPanel();
    RegisterView.addPanel(frame, registerPanel, 10,0, bgImg.getIconWidth(), bgImg.getIconHeight(), 0xCCCCCC);
    RegisterView.addImage(registerPanel, bgImg, 0, 0);

    frame.setVisible(true);
  }
}
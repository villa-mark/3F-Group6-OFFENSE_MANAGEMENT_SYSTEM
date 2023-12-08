package offense.management.admin;

import javax.swing.*;
import java.awt.*;

class AdminView{

  static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color){
    label.setBounds(x, y, width, height);
    label.setBackground(null);
    label.setForeground(new Color(color));
    label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    label.setHorizontalAlignment(JLabel.CENTER);

    panel.add(label);
  }

  static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize){
      textField.setBounds(x, y, width, height);
      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
      textField.setBorder(null);
    
      panel.add(textField); 
    }  
  static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize, String text){
      textField.setBounds(x, y, width, height);
      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
      textField.setBorder(null);
      textField.setText("  DD/MM/YY");
      textField.setForeground(new Color(0x838383));
    
      panel.add(textField); 
    }  

    static void addJPasswordField(JPanel panel, JPasswordField passField, int x, int y, int width, int height, String fontStyle, int fontSize){
      passField.setBounds(x, y, width, height);
      passField.setBackground(null);
      passField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
      passField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
    
      panel.add(passField); 
    } 

    static void addCheckBox(JPanel panel, JCheckBox checkBox, int x, int y, int width, int height){
      checkBox.setBounds(x, y, width, height);
      checkBox.setBackground(null);

      panel.add(checkBox);
    }

    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color){
      panel.setBounds(x, y, width, height);
      panel.setOpaque(true);
      panel.setBackground(new Color(color));
      panel.setLayout(null);  

      frame.add(panel);
    }
    static void addImage(JPanel panel, ImageIcon img, int x, int y){
      JLabel label = new JLabel(img);
      label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
      panel.add(label);
    }
}
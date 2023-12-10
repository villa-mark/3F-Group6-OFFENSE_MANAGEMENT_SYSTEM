package offense.management.user;

import javax.swing.*;
import java.awt.*;

class UserView{

  static void addButton(JPanel panel, JButton button, int x, int y, int width, int height, int fontSize, String fontStyle, int color, int foreColor){
    button.setBounds(x, y, width, height);
    button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    button.setBackground(new Color(color));
    button.setForeground(new Color(foreColor));
    button.setBorder(null);
    button.setFocusable(false);

    panel.add(button);
  }
  static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color){
    label.setBounds(x, y, width, height);
    label.setBackground(null);
    label.setForeground(new Color(color));
    label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
    label.setHorizontalAlignment(JLabel.CENTER);

    panel.add(label);
  }

  static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle){
    label.setBounds(x, y, width, height);
    label.setBackground(Color.white);
    label.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
    label.setHorizontalAlignment(JLabel.LEFT);

    panel.add(label);
  }

  static void addTextArea(JPanel panel, JTextArea textField, int x, int y, int width, int height, String fontStyle, int fontSize){
      textField.setBounds(x, y, width, height);
      textField.setBackground(Color.white);
      textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
      textField.setLineWrap(true);
      textField.setWrapStyleWord(true);
    
      panel.add(textField); 
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

  static void clearFrame(JFrame frame){
      frame.getContentPane().removeAll();
      frame.repaint();
      frame.validate();
    }

  static void changeButton(JLabel label, String fontStyle, int fontSize, int color){
      label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
      label.setForeground(new Color(color));
    }

  static void changeButton(JButton button, String fontStyle, int fontSize, int color){
      button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
      button.setForeground(new Color(color));
    }
}

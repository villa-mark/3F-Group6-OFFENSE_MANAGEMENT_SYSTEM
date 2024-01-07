package offense.management.login;

//PRE-DEFINED PACKAGES
import javax.swing.*;
import java.awt.*;

//CLASS LOGIN_VIEW - contains all the gui manipulation for login window
class LoginView {

    /**********************************************************************************
     * Adds a styled label to a panel.
     *
     * @param panel      A JPanel object where to add the label component.
     * @param label      The JLabel object to be modified.
     * @param x          The x-coordinate of the label's position.
     * @param y          The y-coordinate of the label's position.
     * @param width      The width of the label.
     * @param height     The height of the label.
     * @param fontSize   The font size of the label's text.
     * @param fontStyle  The font style of the label's text.
     * @param color      The text color of the label. Default is set to BOLD, CENTERED, with NULL background.
     *********************************************************************************/
	    static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color) {
	        label.setBounds(x, y, width, height);
	        label.setBackground(null);
	        label.setForeground(new Color(color));
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setHorizontalAlignment(JLabel.CENTER);
	
	        panel.add(label);
	    }

    /**********************************************************************************
     * Adds a styled text field to a panel.
     *
     * @param panel      A JPanel object where to add the text field component.
     * @param textField  The JTextField object to be modified.
     * @param x          The x-coordinate of the text field's position.
     * @param y          The y-coordinate of the text field's position.
     * @param width      The width of the text field.
     * @param height     The height of the text field.
     * @param fontStyle  The font style of the text field's text.
     * @param fontSize   The font size of the text field's text.
     *
     * BY DEFAULT:
     *   * the BACKGROUND is set to NULL
     *   * the BORDER is set to 0, 0, 1, 0, colorBlack
     *   * the TEXT is PLAIN
     *********************************************************************************/
	    static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        textField.setBounds(x, y, width, height);
	        textField.setBackground(null);
	        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	
	        panel.add(textField);
	    }

    /**********************************************************************************
     * Adds a styled password field to a panel.
     *
     * @param panel      A JPanel object where to add the password field component.
     * @param passField  The JPasswordField object to be modified.
     * @param x          The x-coordinate of the password field's position.
     * @param y          The y-coordinate of the password field's position.
     * @param width      The width of the password field.
     * @param height     The height of the password field.
     * @param fontStyle  The font style of the password field's text.
     * @param fontSize   The font size of the password field's text.
     *
     * BY DEFAULT:
     *   * the BACKGROUND is set to NULL
     *   * the BORDER is set to 0, 0, 1, 0, colorBlack
     *   * the TEXT is PLAIN
     *********************************************************************************/
	    static void addJPasswordField(JPanel panel, JPasswordField passField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        passField.setBounds(x, y, width, height);
	        passField.setBackground(null);
	        passField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	        passField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	
	        panel.add(passField);
	    }

    /**********************************************************************************
     * Adds a styled panel to a frame.
     *
     * @param frame      A JFrame object where to add the panel component.
     * @param panel      The JPanel object to be modified.
     * @param x          The x-coordinate of the panel's position.
     * @param y          The y-coordinate of the panel's position.
     * @param width      The width of the panel.
     * @param height     The height of the panel.
     * @param color      The background color of the panel. Default is set to FALSE opacity, NULL layout manager.
     *********************************************************************************/
	    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	        panel.setOpaque(false);
	
	        frame.add(panel);
	    }

    /**********************************************************************************
     * Adds an image label to a panel.
     *
     * @param panel      The JPanel object where to add the JLabel object.
     * @param img        The ImageIcon object to be added.
     * @param x          The x-coordinate of the panel's position.
     * @param y          The y-coordinate of the panel's position.
     *
     * BY DEFAULT:
     *   * the label width and height would base on the image width and height.
     *********************************************************************************/
	    static void addImage(JPanel panel, ImageIcon img, int x, int y) {
	        JLabel label = new JLabel(img);
	        label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
	        panel.add(label);
	    }

    /**********************************************************************************
     * Clears all contents of a frame.
     *
     * @param frame      The JFrame object to be cleaned.
     *********************************************************************************/
	    static void clearFrame(JFrame frame) {
	        frame.getContentPane().removeAll();
	        frame.repaint();
	        frame.validate();
	    }

    /**********************************************************************************
     * Changes the style of a label acting as a button.
     *
     * @param label      The JLabel object to be modified.
     * @param fontStyle  The font style of the label's text.
     * @param fontSize   The font size of the label's text.
     * @param color      The text color of the label. Default is set to BOLD.
     *********************************************************************************/
	    static void changeButton(JLabel label, String fontStyle, int fontSize, int color) {
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setForeground(new Color(color));
	    }
}

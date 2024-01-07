package offense.management.register;

// Importing predefined packages
import javax.swing.*;
import java.awt.*;

/**
 * The RegisterView class contains methods for GUI manipulation in the register window.
 */
class RegisterView {

    /**********************************************************************************
     * Adds a label to a panel with specified attributes.
     *
     * @param panel      A JPanel object where to add the label component.
     * @param label      The JLabel object to be modified.
     * @param x          The integer value representing the x-axis position.
     * @param y          The integer value representing the y-axis position.
     * @param width      The integer value representing the label width.
     * @param height     The integer value representing the label height.
     * @param fontSize   The integer value representing the font size.
     * @param fontStyle  The font style.
     * @param color      The integer value representing the color.
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
     * Adds a text field to a panel with specified attributes.
     *
     * @param panel      A JPanel object where to add the text field component.
     * @param textField  The JTextField object to be modified.
     * @param x          The integer value representing the x-axis position.
     * @param y          The integer value representing the y-axis position.
     * @param width      The integer value representing the text field width.
     * @param height     The integer value representing the text field height.
     * @param fontStyle  The font style.
     * @param fontSize   The integer value representing the font size.
     *********************************************************************************/
	    static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        textField.setBounds(x, y, width, height);
	        textField.setBackground(null);
	        textField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	
	        panel.add(textField);
	    }

    /**********************************************************************************
     * Adds a password field to a panel with specified attributes.
     *
     * @param panel      A JPanel object where to add the password field component.
     * @param passField  The JPasswordField object to be modified.
     * @param x          The integer value representing the x-axis position.
     * @param y          The integer value representing the y-axis position.
     * @param width      The integer value representing the password field width.
     * @param height     The integer value representing the password field height.
     * @param fontStyle  The font style.
     * @param fontSize   The integer value representing the font size.
     *********************************************************************************/
	    static void addJPasswordField(JPanel panel, JPasswordField passField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        passField.setBounds(x, y, width, height);
	        passField.setBackground(null);
	        passField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
	        passField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	
	        panel.add(passField);
	    }

    /**********************************************************************************
     * Adds a panel to a frame with specified attributes.
     *
     * @param frame  A JFrame object where to add the panel component.
     * @param panel  The JPanel object to be modified.
     * @param x      The integer value representing the x-axis position.
     * @param y      The integer value representing the y-axis position.
     * @param width  The integer value representing the panel width.
     * @param height The integer value representing the panel height.
     * @param color  The integer value representing panel color.
     *********************************************************************************/
	    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setOpaque(true);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	
	        frame.add(panel);
	    }

    /**********************************************************************************
     * Adds a panel to another panel with specified attributes.
     *
     * @param panelOut  The outer JPanel object where to add the inner panel component.
     * @param panel     The inner JPanel object to be modified.
     * @param x         The integer value representing the x-axis position.
     * @param y         The integer value representing the y-axis position.
     * @param width     The integer value representing the inner panel width.
     * @param height    The integer value representing the inner panel height.
     * @param color     The integer value representing inner panel color.
     *********************************************************************************/
	    static void addPanel(JPanel panelOut, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setOpaque(true);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	
	        panelOut.add(panel);
	    }

    /**********************************************************************************
     * Adds an image to a panel with specified attributes.
     *
     * @param panel  The JPanel object where to add the JLabel object with the image.
     * @param img    The ImageIcon object to be added.
     * @param x      The integer value representing the x-axis position.
     * @param y      The integer value representing the y-axis position.
     *********************************************************************************/
	    static void addImage(JPanel panel, ImageIcon img, int x, int y) {
	        JLabel label = new JLabel(img);
	        label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
	        panel.add(label);
	    }

    /**********************************************************************************
     * Clears all contents of a frame and repaints it.
     *
     * @param frame  A JFrame object to be cleaned.
     *********************************************************************************/
	    static void clearFrame(JFrame frame) {
	        frame.getContentPane().removeAll();
	        frame.repaint();
	        frame.validate();
	    }

    /**********************************************************************************
     * Clears all contents of a panel and repaints it.
     *
     * @param panel  A JPanel object to be cleaned.
     *********************************************************************************/
	    static void clearPanel(JPanel panel) {
	        panel.removeAll();
	        panel.repaint();
	        panel.validate();
	    }

    /**********************************************************************************
     * Modifies the attributes of a label to change it as a button.
     *
     * @param label      The JLabel object to be modified.
     * @param fontStyle  The font style.
     * @param fontSize   The integer value representing the font size.
     * @param color      The integer value representing the color.
     *********************************************************************************/
	    static void changeButton(JLabel label, String fontStyle, int fontSize, int color) {
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setForeground(new Color(color));
	    }

    /**********************************************************************************
     * Adds a modified combo box to a panel with specified attributes.
     *
     * @param panel   The panel object where to add the modified combo box.
     * @param combo   The JComboBox to be modified.
     * @param x       The integer value representing the x-axis position.
     * @param y       The integer value representing the y-axis position.
     * @param width   The integer value representing the combo box width.
     * @param height  The integer value representing the combo box height.
     *********************************************************************************/
    @SuppressWarnings("rawtypes")
	    static void addComboBox(JPanel panel, JComboBox combo, int x, int y, int width, int height) {
	        combo.setBounds(x, y, width, height);
	        combo.setFont(new Font("Roboto", Font.BOLD, 20));
	
	        panel.add(combo);
	    }
}

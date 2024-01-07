package offense.management.user;

import javax.swing.*;
import java.awt.*;

class UserView {

    /**********************************************************************************
     * Adds a styled button to a panel.
     *
     * @param panel      The JPanel where the button is added.
     * @param button     The JButton object to be added and modified.
     * @param x          The x-coordinate of the button's position.
     * @param y          The y-coordinate of the button's position.
     * @param width      The width of the button.
     * @param height     The height of the button.
     * @param fontSize   The font size of the button's text.
     * @param fontStyle  The font style of the button's text.
     * @param color      The background color of the button.
     * @param foreColor  The text color of the button.
     *********************************************************************************/
	    static void addButton(JPanel panel, JButton button, int x, int y, int width, int height, int fontSize, String fontStyle, int color, int foreColor) {
	        button.setBounds(x, y, width, height);
	        button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        button.setBackground(new Color(color));
	        button.setForeground(new Color(foreColor));
	        button.setBorder(null);
	        button.setFocusable(false);
	
	        panel.add(button);
	    }

    /**********************************************************************************
     * Adds a styled label to a panel.
     *
     * @param panel      The JPanel where the label is added.
     * @param label      The JLabel object to be added and modified.
     * @param x          The x-coordinate of the label's position.
     * @param y          The y-coordinate of the label's position.
     * @param width      The width of the label.
     * @param height     The height of the label.
     * @param fontSize   The font size of the label's text.
     * @param fontStyle  The font style of the label's text.
     * @param color      The text color of the label.
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
     * Adds a different style of label to a panel.
     *
     * @param panel      The JPanel where the label is added.
     * @param label      The JLabel object to be added and modified.
     * @param x          The x-coordinate of the label's position.
     * @param y          The y-coordinate of the label's position.
     * @param width      The width of the label.
     * @param height     The height of the label.
     * @param fontSize   The font size of the label's text.
     * @param fontStyle  The font style of the label's text.
     *********************************************************************************/
	    static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle) {
	        label.setBounds(x, y, width, height);
	        label.setBackground(Color.white);
	        label.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        label.setHorizontalAlignment(JLabel.LEFT);
	
	        panel.add(label);
	    }

    /**********************************************************************************
     * Adds a styled text area to a panel with scrolling.
     *
     * @param panel      The JPanel where the text area is added.
     * @param textField  The JTextArea object to be added and modified.
     * @param x          The x-coordinate of the text area's position.
     * @param y          The y-coordinate of the text area's position.
     * @param width      The width of the text area.
     * @param height     The height of the text area.
     * @param fontStyle  The font style of the text area's text.
     * @param fontSize   The font size of the text area's text.
     *********************************************************************************/
	    static void addTextArea(JPanel panel, JTextArea textField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        textField.setBounds(x, y, width, height);
	        textField.setBackground(Color.white);
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        textField.setLineWrap(true);
	        textField.setWrapStyleWord(true);
	
	        JScrollPane scroll = new JScrollPane(textField);
	        scroll.setBounds(x, y, width, height);
	        scroll.setBorder(null);
	
	        panel.add(scroll);
	    }

    /**********************************************************************************
     * Adds a styled panel to a frame.
     *
     * @param frame      The JFrame where the panel is added.
     * @param panel      The JPanel object to be added and modified.
     * @param x          The x-coordinate of the panel's position.
     * @param y          The y-coordinate of the panel's position.
     * @param width      The width of the panel.
     * @param height     The height of the panel.
     * @param color      The background color of the panel.
     *********************************************************************************/
	    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setOpaque(true);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	
	        frame.add(panel);
	    }

    /**********************************************************************************
     * Overloaded method to add a styled panel to another panel.
     *
     * @param panelOut   The outer JPanel where the panel is added.
     * @param panel      The inner JPanel object to be added and modified.
     * @param x          The x-coordinate of the panel's position.
     * @param y          The y-coordinate of the panel's position.
     * @param width      The width of the panel.
     * @param height     The height of the panel.
     * @param color      The background color of the panel.
     *********************************************************************************/
	    static void addPanel(JPanel panelOut, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setOpaque(true);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	
	        panelOut.add(panel);
	    }

    /**********************************************************************************
     * Adds an image label to a panel.
     *
     * @param panel      The JPanel where the image label is added.
     * @param img        The ImageIcon object to be added.
     * @param x          The x-coordinate of the image label's position.
     * @param y          The y-coordinate of the image label's position.
     *********************************************************************************/
	    static void addImage(JPanel panel, ImageIcon img, int x, int y) {
	        JLabel label = new JLabel(img);
	        label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
	        panel.add(label);
	    }

    /**********************************************************************************
     * Clears all contents of a frame.
     *
     * @param frame      The JFrame to be cleaned.
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
     * @param color      The text color of the label.
     *********************************************************************************/
	    static void changeButton(JLabel label, String fontStyle, int fontSize, int color) {
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setForeground(new Color(color));
	    }

    /**********************************************************************************
     * Overloaded method to change the style of a button.
     *
     * @param button     The JButton object to be modified.
     * @param fontStyle  The font style of the button's text.
     * @param fontSize   The font size of the button's text.
     * @param color      The text color of the button.
     *********************************************************************************/
	    static void changeButton(JButton button, String fontStyle, int fontSize, int color) {
	        button.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        button.setForeground(new Color(color));
	    }
}

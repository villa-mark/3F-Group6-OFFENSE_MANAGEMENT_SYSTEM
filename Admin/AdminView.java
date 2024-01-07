package offense.management.admin;

//Pre-Defined Packages for GUIs
	import javax.swing.*;
	import java.awt.*;

// CLASS ADMIN_VIEW - contains all the GUI manipulation for the admin window
class AdminView {

    /*********************************************************************************
     * ADD_LABEL METHODS
     * - Allows modification of LABEL component instantly
     *
     * @param JPanel panel      - A JPanel object where to add the label component
     * @param JLabel label      - The JLabel object to be modified
     * @param int x             - The integer value indicating the x-axis position of the label
     * @param int y             - The integer value indicating the y-axis position of the label
     * @param int width         - The integer value of the label width
     * @param int height        - The integer value of the label height
     * @param int fontSize      - The integer value of the font size
     * @param String fontStyle  - The font style
     * @param int color         - The integer value of the color
     *
     * BY DEFAULT:
     * * the BACKGROUND is set to NULL
     * * the TEXT is BOLD
     * * the TEXT is CENTERED
     *********************************************************************************/
	    static void addLabel(JPanel panel, JLabel label, int x, int y, int width, int height, int fontSize, String fontStyle, int color) {
	        label.setBounds(x, y, width, height);
	        label.setBackground(null);
	        label.setForeground(new Color(color));
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setHorizontalAlignment(JLabel.CENTER);
	
	        panel.add(label);
	    }

    /*********************************************************************************
     * ADD_BUTTON METHODS
     * - Allows modification of BUTTON component instantly
     *
     * @param JPanel panel      - A JPanel object where to add the button component
     * @param JButton button    - The JButton object to be modified
     * @param int x             - The integer value indicating the x-axis position of the button
     * @param int y             - The integer value indicating the y-axis position of the button
     * @param int width         - The integer value of the button width
     * @param int height        - The integer value of the button height
     * @param int fontSize      - The integer value of the font size
     * @param String fontStyle  - The font style
     * @param int color         - The integer value of the background color
     * @param int foreColor     - The integer value of the foreground color
     *
     * BY DEFAULT:
     * * the TEXT is BOLD
     * * the BORDER is NULL
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

    /*********************************************************************************
     * ADD_TEXTFIELD METHODS
     * - Allows modification of TEXTFIELD component instantly
     * - Method overloading
     *
     * @param JPanel panel         - A JPanel object where to add the textfield component
     * @param JTextField textField - The JTextField object to be modified
     * @param int x                - The integer value indicating the x-axis position of the textfield
     * @param int y                - The integer value indicating the y-axis position of the textfield
     * @param int width            - The integer value of the textfield width
     * @param int height           - The integer value of the textfield height
     * @param String fontStyle     - The font style
     * @param int fontSize         - The integer value of the font size
     *
     * BY DEFAULT:
     * * the BORDER is NULL
     * * the TEXT is PLAIN
     *********************************************************************************/
	    static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        textField.setBounds(x, y, width, height);
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        textField.setBorder(null);
	
	        panel.add(textField);
	    }

    /*********************************************************************************
     * ADD_TEXTFIELD METHODS
     * - Allows modification of TEXTFIELD component instantly
     * - Method overloading
     *
     * @param JPanel panel         - A JPanel object where to add the textfield component
     * @param JTextField textField - The JTextField object to be modified
     * @param int x                - The integer value indicating the x-axis position of the textfield
     * @param int y                - The integer value indicating the y-axis position of the textfield
     * @param int width            - The integer value of the textfield width
     * @param int height           - The integer value of the textfield height
     * @param String fontStyle     - The font style
     * @param int fontSize         - The integer value of the font size
     * @param String text          - The text to be displayed in the textfield
     *
     * BY DEFAULT:
     * * the BORDER is NULL
     * * the TEXT is PLAIN
     * * the FOREGROUND color is set to 0x838383
     *********************************************************************************/
	    static void addTextField(JPanel panel, JTextField textField, int x, int y, int width, int height, String fontStyle, int fontSize, String text) {
	        textField.setBounds(x, y, width, height);
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        textField.setBorder(null);
	        textField.setText(text);
	        textField.setForeground(new Color(0x838383));
	
	        panel.add(textField);
	    }

    /*********************************************************************************
     * ADD_TEXTAREA METHODS
     * - Allows modification of TEXTAREA component instantly
     *
     * @param JPanel panel          - A JPanel object where to add the textfield component
     * @param JTextArea textField   - The JTextArea object to be modified
     * @param int x                 - The integer value indicating the x-axis position of the textfield
     * @param int y                 - The integer value indicating the y-axis position of the textfield
     * @param int width             - The integer value of the textfield width
     * @param int height            - The integer value of the textfield height
     * @param String fontStyle      - The font style
     * @param int fontSize          - The integer value of the font size
     *
     * BY DEFAULT:
     * * the TEXT is PLAIN
     * * LINEWRAP is set to TRUE
     * * WRAPSTYLEWORD is set to TRUE
     *********************************************************************************/
	    static void addTextArea(JPanel panel, JTextArea textField, int x, int y, int width, int height, String fontStyle, int fontSize) {
	        textField.setBounds(0, 0, width, height);  // Set the bounds of the text area relative to the scroll pane
	        textField.setBackground(Color.WHITE);
	        textField.setFont(new Font(fontStyle, Font.PLAIN, fontSize));
	        textField.setLineWrap(true);
	        textField.setWrapStyleWord(true);
	
	        JScrollPane scroll = new JScrollPane(textField);
	        scroll.setBounds(x, y, width, height);  // Set the bounds of the scroll pane within the panel
	        scroll.setBorder(null);
	
	        panel.add(scroll);
	    }

    /*********************************************************************************
     * ADD_CHECKBOX METHODS
     * - Allows modification of CHECKBOX component instantly
     *
     * @param JPanel panel       - A JPanel object where to add the textfield component
     * @param JCheckBox checkBox - The JCheckBox object to be modified
     * @param int x              - The integer value indicating the x-axis position of the textfield
     * @param int y              - The integer value indicating the y-axis position of the textfield
     * @param int width          - The integer value of the textfield width
     * @param int height         - The integer value of the textfield height
     *
     * BY DEFAULT:
     * * the BORDER is NULL
     * * the TEXT is PLAIN
     * * the FOREGROUND color is set to 0x838383
     *********************************************************************************/
	    static void addCheckBox(JPanel panel, JCheckBox checkBox, int x, int y, int width, int height) {
	        checkBox.setBounds(x, y, width, height);
	        checkBox.setBackground(null);
	
	        panel.add(checkBox);
	    }

    /*********************************************************************************
     * ADD_PANEL METHODS
     * - Allows modification of PANEL component instantly
     *
     * @param JFrame frame  - A JFrame object where to add the panel component
     * @param JPanel panel  - The JPanel object to be modified
     * @param int x         - The integer value indicating the x-axis position of the panel
     * @param int y         - The integer value indicating the y-axis position of the panel
     * @param int width     - The integer value of the panel width
     * @param int height    - The integer value of the panel height
     * @param int color     - The integer value of panel color
     *
     * BY DEFAULT:
     * * the OPACITY is set to TRUE
     * * the LAYOUT manager is NULL
     *********************************************************************************/
	    static void addPanel(JFrame frame, JPanel panel, int x, int y, int width, int height, int color) {
	        panel.setBounds(x, y, width, height);
	        panel.setOpaque(true);
	        panel.setBackground(new Color(color));
	        panel.setLayout(null);
	
	        frame.add(panel);
	    }

    /*********************************************************************************
     * ADD_IMAGE METHODS
     * - Adds IMAGE to a panel
     *
     * @param JPanel panel      - The JPanel object where to add the JLabel obj
     * @param ImageIcon img     - The ImageIcon object to be added
     * @param int x             - The integer value indicating the x-axis position of the panel
     * @param int y             - The integer value indicating the y-axis position of the panel
     *
     * BY DEFAULT:
     * * the label width and height would base on the image width and height
     *********************************************************************************/
	    static void addImage(JPanel panel, ImageIcon img, int x, int y) {
	        JLabel label = new JLabel(img);
	        label.setBounds(x, y, img.getIconWidth(), img.getIconHeight());
	        panel.add(label);
	    }

    /*********************************************************************************
     * CLEAR_FRAME METHODS
     * - Clears all the frame contents and repaints it
     *
     * @param JFrame frame - A JFrame object to be cleaned
     *********************************************************************************/
	    static void clearFrame(JFrame frame) {
	        frame.getContentPane().removeAll();
	        frame.repaint();
	        frame.validate();
	    }

    /*********************************************************************************
     * CHANGE_BUTTON METHODS
     * - Allows modification/change of LABEL component instantly
     *
     * @param JLabel label     - The JLabel object to be modified
     * @param String fontStyle - The font style
     * @param int fontSize     - The integer value of the font size
     * @param int color        - The integer value of the color
     *
     * BY DEFAULT:
     * * the TEXT is BOLD
     *********************************************************************************/
	    static void changeButton(JLabel label, String fontStyle, int fontSize, int color) {
	        label.setFont(new Font(fontStyle, Font.BOLD, fontSize));
	        label.setForeground(new Color(color));
	    }
}

package offense.management.component;

//Pre-Defined Package for GUI Frame
	import javax.swing.JFrame;

/*
 * This abstract class, Component, serves as the foundation for GUI components in the offense management system.
 * It provides shared attributes and functionalities to be inherited by specific components.
 * The class includes two static JFrame instances for the main window and appeal frame, along with color constants for background and button elements.
 */

abstract public class Component {
    public static JFrame window = new JFrame();
    public static JFrame appealFrame = new JFrame();
    public int bgC = 0xCCCCCC;  // Background color constant
    public int btnC = 0x626262;  // Button color constant
}

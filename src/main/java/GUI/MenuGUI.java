package GUI;

import javax.swing.*;

public class MenuGUI extends JFrame{
    private JPanel menuPanel;
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";

    private JButton comb1Button;
    private JButton comb2Button;
    private JButton comb3Button;
    private JButton comb4Button;
    private JLabel menuLabel;

    public MenuGUI(){
        super("Menu");
        setSize(500,500);
        setContentPane(menuPanel);
    }
}

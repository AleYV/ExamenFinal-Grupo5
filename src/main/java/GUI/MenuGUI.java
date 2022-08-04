package GUI;

import javax.swing.*;

public class MenuGUI extends JFrame{
    private JPanel menuPanel;
    private static final String PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\img\\";

    Icon icon1 = new ImageIcon(PATH+"pizza1.jpg");
    Icon icon2 = new ImageIcon(PATH+"pizza2.jpg");
    Icon icon3 = new ImageIcon(PATH+"pizza2.jpg");
    Icon icon4 = new ImageIcon(PATH+"pizza2.jpg");

    private JButton comb1Button = new JButton(icon1);
    private JButton comb2Button = new JButton(icon2);
    private JButton comb3Button = new JButton(icon3);
    private JButton comb4Button = new JButton(icon4);
    private JLabel menuLabel;

    public MenuGUI(){
        super("Menu");
        setSize(500,500);
        setContentPane(menuPanel);
    }
}

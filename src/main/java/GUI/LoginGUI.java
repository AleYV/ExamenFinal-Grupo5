package GUI;

import javax.swing.*;

public class LoginGUI extends JFrame{
    private JPanel loginPanel;
    private JTextField nameField;
    private JTextField passwordField;
    private JButton LoginButton;
    private JLabel nameLabel;
    private JLabel passwordLabel;

    public LoginGUI(){
        super("Login");
        setSize(250,200 );
        setContentPane(loginPanel);
    }
}

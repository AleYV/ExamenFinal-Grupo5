package GUI;

import javax.swing.*;

public class SelectionGUI extends JFrame{
    private JPanel selectionPanel;
    private JLabel foodLabel;
    private JButton chickenButton;
    private JButton hamburgerButton;
    private JButton pizzaButton;
    private JLabel branchField;
    private JComboBox branchBox;
    private JButton deliveryButton;
    private JButton recojoButton;
    private JButton nextButton;
    private JTextPane notificationPane;
    private JButton payButton;


    public SelectionGUI(){
        super("Selection");
        setSize(450,300);
        setContentPane(selectionPanel);
    }
}

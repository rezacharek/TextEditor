package editor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Editor extends JFrame
{   
    public Editor()
    {
        super("Text Editor v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,300);
        setLocationRelativeTo(null);

        startLayout();

        setLayout(null);
        setVisible(true);
    }

    private void startLayout()
    {       
        JTextField writingField = new JTextField();
        writingField.setBounds(20,20, 410, 240);
        // writingField.addActionListener(enter);
        add(writingField);

        Color mainInterfaceColor = new Color(247, 236, 166);
        JPanel mainInterface = new JPanel();
        mainInterface.setBounds(20,20, 410, 240);
        mainInterface.setLayout(new BorderLayout());
        mainInterface.setBackground(mainInterfaceColor);
        add(mainInterface);
    }


    public static void main(String[] argc)
    {
        new Editor();
    }
}

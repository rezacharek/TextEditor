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
        Color writingFieldColor = new Color(247, 236, 166);


        JTextArea writingField = new JTextArea(); // TextArea
        writingField.setName("TextArea");
        writingField.setBounds(20,20, 410, 240);
        writingField.setBackground(writingFieldColor);
        add(writingField);

        JPanel mainInterface = new JPanel();
        mainInterface.setBounds(20,20, 410, 240);
        mainInterface.setLayout(new BorderLayout());
        add(mainInterface);
    }


    public static void main(String[] argc)
    {
        new Editor();
    }
}

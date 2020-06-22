package editor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;  

public class Editor extends JFrame
{   
    public Editor()
    {
        // super("Text Editor v1.0");
        final JFrame frame = new JFrame("Text Editor v1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,320);
        setLocationRelativeTo(null);

        startLayout();

        // setLayout();
        setVisible(true);
    }

    private void startLayout()
    {       
        Color writingFieldColor = new Color(247, 236, 166);

        getContentPane().setLayout(new FlowLayout());
        JTextArea textArea = new JTextArea(15,35);
        JScrollPane scrollableTextArea = new JScrollPane(textArea);

        JTextField textField = new JTextField(10);
        add(textField);
        JButton SaveButton = new JButton("SaveButton");
        add(SaveButton, BorderLayout.NORTH);
        JButton LoadButton = new JButton("LoadButton");
        add(LoadButton, BorderLayout.NORTH);

        // add(new JButton("SaveButton"), BorderLayout.NORTH);
        
        
        // SaveButton.addActionListener(new ActionEvent() {
        //     // @Override
        //     public void actionPerformed(ActionEvent e)
        //     {
        //         Object source = e.getSource();
        //         if (source instanceof JButton) {
        //             JButton btn = (JButton)source;
        //             String butSrcTxt = btn.getText();
        //         }

        //     }
        // }
        // );
        // String number = SaveButton.getText();
        
        
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
  
        getContentPane().add(scrollableTextArea); 

        
    }


    public static void main(String[] argc)
    {
        new Editor();
    }
}

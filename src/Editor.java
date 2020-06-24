package editor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*; 
import java.io.*; 
import java.awt.Desktop;
import javax.swing.text.*;

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

        SaveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {
                String fileName;
                fileName = textField.getText();
                // System.out.println(fileName);

                FileWriter writer = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(writer);
                textArea.write(bw);
                bw.close();
                textArea.requestFocus();


            }
            catch(Exception e2) { System.out.println(e2);}
            }
        }
        );

        JButton LoadButton = new JButton("LoadButton");
        add(LoadButton, BorderLayout.NORTH);
        LoadButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {   
                Desktop desktop = Desktop.getDesktop();
                String fileName;
                fileName = textField.getText();
                // System.out.println(fileName);

                FileReader reader = new FileReader(fileName);
                BufferedReader br = new BufferedReader(reader);
                textArea.read(br, null);
                br.close();
                textArea.requestFocus();

            }
            catch(Exception e2) { System.out.println(e2);}
        }
        }
        );



        


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


    public static void main(String []argc)
    {
        new Editor();
    }
}

package editor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*; 
import java.io.*; 
import java.awt.Desktop;
import javax.swing.text.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Editor extends JFrame
{   
    private static final int WIDTH = 350;
    private static final int HEIGHT = 450;

    final JFrame frame = new JFrame("Text Editor v1.0");
    private JTextArea textArea;
    private JScrollPane scrollableTextArea;
    private JTextField textField;


    public Editor()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(HEIGHT,WIDTH);
        setLocationRelativeTo(null);
        startLayout();
        setVisible(true);
    }

    public void Save(JButton SaveB)
    {
        SaveB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {
                String fileName;
                fileName = textField.getText();
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
    }

    public void Save(JMenuItem SaveB)
    {
        SaveB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {
                String fileName;
                fileName = textField.getText();
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
    }

    public void Load(JButton LoadB)
    {
        LoadB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {   
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    Desktop desktop = Desktop.getDesktop();

                    FileReader reader = new FileReader(selectedFile.getAbsolutePath());
                    BufferedReader br = new BufferedReader(reader);
                    textArea.read(br, null);
                    br.close();
                    textArea.requestFocus();
                }
                

            }
            catch(Exception e2) { 
                textArea.setText("");
                // FilenameField.setText("");
            }
        }
        }
        );
    }

    public void Load(JMenuItem LoadB)
    {
        LoadB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
            try
            {   
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                int returnValue = jfc.showOpenDialog(null);
                // int returnValue = jfc.showSaveDialog(null);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    Desktop desktop = Desktop.getDesktop();

                    FileReader reader = new FileReader(selectedFile.getAbsolutePath());
                    BufferedReader br = new BufferedReader(reader);
                    textArea.read(br, null);
                    br.close();
                    textArea.requestFocus();
                }

            }
            catch(Exception e2) { 
                textArea.setText("");
                // FilenameField.setText("");
            }
        }
        }
        );

    }

    public void Exit(JMenuItem ExitB)
    {
        ExitB.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                System.exit(0);
            }
        });
    }

    private void startLayout()
    {       
        getContentPane().setLayout(new FlowLayout());
        textArea = new JTextArea(15,35);
        scrollableTextArea = new JScrollPane(textArea);


        textField = new JTextField(10);
        add(textField);
        Icon SaveIcon = new ImageIcon("iconfinder_floppy_285657(1).png");
        JButton SaveButton = new JButton(SaveIcon);
        add(SaveButton, BorderLayout.NORTH);
        Save(SaveButton);


        Icon LoadIcon = new ImageIcon("24-24-b4aca2646abdbb1f4284919e3d1198e6.png");
        JButton LoadButton = new JButton(LoadIcon);
        add(LoadButton, BorderLayout.NORTH);
        Load(LoadButton);
        
        
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        getContentPane().add(scrollableTextArea); 

        Menu(textArea, textField);
    }

    public void Menu(JTextArea textArea, JTextField textField)
    {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem MenuLoad = new JMenuItem("Load");
        MenuLoad.setName("MenuLoad");
        Load(MenuLoad);

        JMenuItem MenuSave = new JMenuItem("Save");
        MenuSave.setName("MenuSave");
        Save(MenuSave);

        JMenuItem MenuExit = new JMenuItem("Exit");
        MenuExit.setName("MenuExit");
        Exit(MenuExit);
        
        fileMenu.add(MenuLoad);
        fileMenu.add(MenuSave);
        fileMenu.addSeparator();
        fileMenu.add(MenuExit);  
    }

    public static void main(String []argc)
    {
        new Editor();
    }
}

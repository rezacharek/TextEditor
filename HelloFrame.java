import javax.swing.*;

public class HelloFrame extends JFrame {
    public HelloFrame() {
        // super("My First Swing App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new HelloFrame();
    }
}
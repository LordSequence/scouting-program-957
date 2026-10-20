import javax.swing.*;
import java.awt.*;

public class App {

    public static JLabel titleLabel = new JLabel("Insert_Title_Card");
    static{
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.YELLOW);
    }

    public static void main(String[] args) throws Exception {
        startApp();
    }

    public static void startApp(){
        JFrame applicationFrame = new JFrame("Scouting Application");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setSize(800, 600);
        applicationFrame.getContentPane().add(titleLabel);
        applicationFrame.setVisible(true);
        applicationFrame.getContentPane().setBackground(Color.BLACK);
        applicationFrame.setLayout(new FlowLayout());
    }


}

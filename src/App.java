import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    public static JLabel titleLabel = new JLabel("Insert_Title_Card");
    static{
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.YELLOW);
        //titleLabel.setBounds(250, 50, 300, 50);
        //titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public static void main(String[] args) throws Exception {
        startApp();
    }

    public static void startApp(){
        JFrame applicationFrame = new JFrame("Scouting Application");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applicationFrame.getContentPane().setLayout(new GridBagLayout());
        applicationFrame.getContentPane().setBackground(Color.BLACK);
        applicationFrame.getContentPane().add(titleLabel);
        applicationFrame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowOpened(WindowEvent e) {
            int screenWidth = applicationFrame.getContentPane().getWidth();
            titleLabel.setBounds((screenWidth / 2) - 150, 50, 300, 50);
        }
        });
        applicationFrame.setVisible(true);
    }


}

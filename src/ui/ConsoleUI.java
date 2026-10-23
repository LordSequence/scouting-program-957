package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;

public final class ConsoleUI {
    
    Scanner dataScanner = new Scanner(System.in);

    private ConsoleUI() {
        throw new AssertionError("Cannot instantiate ConsoleUI");
    }

    public static class MainMenu{
        // Implementation of MainMenu class
        public static JTextField yearSearchMain = new JTextField(10);
        public static JLabel titleLabel = new JLabel("Hive Mind");
        static{
        titleLabel.setFont(new Font("Arial", Font.BOLD, 84));
        titleLabel.setForeground(Color.YELLOW);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        yearSearchMain.setFont(new Font("Arial", Font.PLAIN, 24));
        yearSearchMain.setForeground(Color.BLACK);
        yearSearchMain.setBackground(Color.WHITE);
        yearSearchMain.setHorizontalAlignment(JTextField.CENTER);
        }

        public static void OnStartUp(JFrame applicationFrame){
            applicationFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                int screenWidth = applicationFrame.getContentPane().getWidth();
                titleLabel.setBounds((screenWidth / 2) - 300, 50, 600, 100);
                yearSearchMain.setBounds((screenWidth / 2) - 200, 500, 400, 50);
            }
            });
        }

        public static void OnYearSearchSubmit(JFrame applicationFrame){
            yearSearchMain.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String yearInput = yearSearchMain.getText();
                }
            });
        }
    }

    public static class SettingsMenu{
        // Implementation of SettingsMenu class
    }

    public static class TeamsListMenu{
        // Implementation of TeamsListMenu class
    }

    public static class RegionsMenu{
        // Implementation of RegionsMenu class
    }

    public static class EventsMenu{
        // Implementation of EventsMenu class
    }

    public static class TeamDataMenu{
        // Implementation of TeamDataMenu class
    }


}

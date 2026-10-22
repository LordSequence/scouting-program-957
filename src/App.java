import javax.swing.*;
import ui.ConsoleUI;
import java.awt.*;
//import java.awt.event.*;

public class App {

    public static void main(String[] args) throws Exception {
        startApp();
    }

    public static void startApp(){
        JFrame applicationFrame = new JFrame("Scouting Application");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        applicationFrame.getContentPane().setBackground(Color.BLACK);
        applicationFrame.getContentPane().add(ConsoleUI.MainMenu.titleLabel);
        applicationFrame.getContentPane().add(ConsoleUI.MainMenu.yearSearchMain);
        applicationFrame.setVisible(true);
        ConsoleUI.MainMenu.OnStartUp(applicationFrame);
    }

}

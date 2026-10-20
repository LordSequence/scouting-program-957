import javax.swing.*;


public class App {
    public static void main(String[] args) throws Exception {
        startApp();
    }

    public static void startApp(){
        JFrame applicationFrame = new JFrame("Scouting Application");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setSize(800, 600);
        applicationFrame.setVisible(true);
        
    }
}

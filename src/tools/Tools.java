package tools;

import javax.swing.JTextField;

public class Tools{
    
    public Tools(){
        System.out.println("I beg of you, do not create an instance of this class.");
    }

    public static String getInput(JTextField field){
        return field.getText();
    }



}

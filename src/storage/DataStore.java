package storage;
import java.io.*;
import java.io.Serializable;
//Need to completely redo the logic of writing and reading data once TeamData format is settled.
public class DataStore {
    public static String getData(String path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            String dataLine;
            while((dataLine = reader.readLine()) != null){
                stringBuilder.append(dataLine);
                stringBuilder.append(System.lineSeparator());
            }
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveData(String data){
        // Code to save data
    }

    public static void createFile(String fileName){
        // Code to create a new file
    }
}

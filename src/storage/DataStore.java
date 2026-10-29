package storage;
import java.io.*;
import java.io.Serializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
//Need to completely redo the logic of writing and reading data once TeamData format is settled.
public class DataStore {
    public static String getData(String path){
        return null;
    }

    public static void saveData(String data, String file){
        ObjectMapper mapper = new ObjectMapper();
        
    }

    public static void createFile(String fileName, String type){
        if(type.toLowerCase() == "json"){
            if(fileName.contains(".json")){
            File file = new File(fileName);
        } else {
            File file = new File(fileName + ".json");
        }
        } else if(type.toLowerCase() == "text" || type.toLowerCase() == "txt"){
            if(fileName.contains(".txt")){
                File file = new File(fileName);
            } else {
                File file = new File(fileName + ".txt");
            }
        }
        
        
        
    }
}

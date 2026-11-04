package storage;
import java.io.*;
import java.io.Serializable;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
//Need to completely redo the logic of writing and reading data once TeamData format is settled.
public class DataStore {
    public static String getData(String path){
        return null;
        //This needs to contain code on how to search for a specific written unqiue tag
        //identifier to pull out a full team object instance to anayltics.
    }

    public static void saveData(String data, String file){
        ObjectMapper mapper = new ObjectMapper();
        //Fill this in with code to access a specific file BY NAME to write to it.
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

package storage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

//import model.Team;
//Need to completely redo the logic of writing and reading data once TeamData format is settled.
public class DataStore {
    public static List<List<Integer>> getData(String path, int teamNum) throws StreamReadException, DatabindException, IOException{
        ObjectMapper mapper = new ObjectMapper();
        Reader reader = Files.newBufferedReader(Paths.get(path));
        MappingIterator<List> iterator = mapper.readerFor(List.class).readValues(reader);
        List<List<Integer>> data;
        while(iterator.hasNext()){
            try {
                List<List<Integer>> currentList = (List<List<Integer>>) iterator.next();
            if(currentList.get(0).get(0) == teamNum){
                data = currentList;
                return data;
            }
            } catch (ClassCastException e) {
                Runtime.getRuntime().halt(1);
            }
        }
        return null;
    }

    public static void saveData(ArrayList<ArrayList<Integer>> data, String file) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arraynode = (ArrayNode) mapper.readTree(file);
        arraynode.addPOJO(data);
        mapper.writeValue(new File(file), data);
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

package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTextField;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import tools.Tools;

public class Team implements Serializable{

    private String teamName;
    private int teamNumber;
    private int numSeasonsPlayed;

    public ArrayList<ArrayList<Integer>> gameYears = new ArrayList<>();
    public ArrayList<ArrayList<String>> gameDicts = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> teams = new ArrayList<>();
    static{
        for(int u = 0; u <= 9; u++){
            teams.add(new ArrayList<Integer>());
        }
    }

    public Team(String name, int number, int seasons){
        this.teamName = name;
        this.teamNumber = number;
        this.numSeasonsPlayed = seasons;
        String tempName = Integer.toString(number);
        teams.get(Integer.valueOf(tempName.charAt(0))).add(number);
    }

    public void addField(int searchYear, int val, int index){
        int year = -1;
        for(int i = 0; i < gameYears.size(); i++){
            if(gameYears.get(i).get(0) == searchYear){
                year = i;
                break;
            }
        }
        if(!(year < 0)){
            if((index-1) > gameYears.get(year).size()){
            gameYears.get(year).add(val);
        } else {
            gameYears.get(year).add(index, val);
        }
        } else {
            System.out.println("You have seriously messed up my friend.");
        }
    }

    public void manageDict(int entry, int year, String tag){
        //Tag is meant to be a description of the purpose of this entry, to give users a dynamic manual as to where to 
        //input any given field values, like autonomous score or endgame.
        int searchYear = -1;
        for(int i = 0; i < gameYears.size(); i++){
            if(gameYears.get(i).get(0) == year){
                searchYear = i;
                break;
            }
        }
        if(!(year < 0)){
            if((entry-1) > gameYears.get(year).size()){
            gameDicts.get(searchYear).add(tag);
        } else {
            gameDicts.get(searchYear).add(entry, tag);
        }
        } else {
            System.out.println("You have seriously messed up my friend.");
        }
    }

    public void updateDict(){
        for(int i = 0; i < gameYears.size(); i++){
            if(gameYears.get(i).size() != gameDicts.get(i).size()){
                if(gameYears.get(i).size() > gameDicts.get(i).size()){
                    for(int a = 0; a <= gameYears.get(i).size() - gameDicts.get(i).size(); a++){
                        gameDicts.get(i).add("NULL_FILLER");
                    }
                } else if(gameYears.get(i).size() < gameDicts.get(i).size()){
                    for(int b = 0; b <= gameDicts.get(i).size() - gameYears.get(i).size(); b++){
                        gameDicts.get(i).remove(gameDicts.get(i).size() - 1);
                    }
                }
            }
        }
    }

    public ArrayList<Integer> getFields(){
        return null;
    }
    
    public void addSeason(int year){
        ArrayList<Integer> gameStats = new ArrayList<>();
        ArrayList<String> statsDict = new ArrayList<>();
        gameStats.add(year);
        statsDict.add("This is the season year (year that championship occured)");
        gameYears.add(gameStats);
        gameDicts.add(statsDict);
    }

    public void removeSeaon(int year, JTextField input){
        String warningOne = "Are you sure you want to delete this team's " + year + " season?";
        String warningTwo = "This data has no recovery support. Are you absolutely sure?";
        String warningThree = "Enter \"I understand the risk of deleting a season's data\"";
        String confirmation = Tools.getInput(input);
        if(confirmation == "I understand the risk of deleting a season's data"){
            for(int h = 0; h < gameYears.size(); h++){
                if(gameYears.get(h).get(0) == year){
                    gameYears.remove(h);
                    break;
                }
            }
        }
    }

    public String toString(){
        String overview = "This is Team " + (teamNumber) + " " + (teamName) + ". They have competed in " + (numSeasonsPlayed) + "(s).";
        return overview;
    }
    
}

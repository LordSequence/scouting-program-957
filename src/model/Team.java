package model;

import java.io.Serializable;
//import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team implements Serializable{

    private String teamName;
    private int teamNumber;
    private int numSeasonsPlayed;

    public ArrayList<ArrayList<Integer>> gameYears = new ArrayList<>();
    public ArrayList<ArrayList<String>> gameDicts = new ArrayList<>();

    public Team(String name, int number, int seasons){
        this.teamName = name;
        this.teamNumber = number;
        this.numSeasonsPlayed = seasons;
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

    public String toString(){
        String overview = "This is Team " + (teamNumber) + " " + (teamName) + ". They have competed in " + (numSeasonsPlayed) + "(s).";
        return overview;
    }




    
}

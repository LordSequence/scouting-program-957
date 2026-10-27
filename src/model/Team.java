package model;

import java.io.Serializable;
//import java.lang.reflect.Array;
import java.util.ArrayList;

public class Team implements Serializable{

    private String teamName;
    private int teamNumber;
    private int numSeasonsPlayed;

    public ArrayList<ArrayList<Integer>> gameYears = new ArrayList<>();

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
    

    public void addSeason(int year){
        ArrayList<Integer> gameStats = new ArrayList<>();
        gameStats.add(year);
        gameYears.add(gameStats);
    }




    
}

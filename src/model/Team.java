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
    
    //gameYyears stores the integer representing the game year in the 0 index
    //of the array with the team's quantitative measures being stored in the indexs above it. Ordering
    //Of the indexes is up to the user to decide using the gameDicts array list 
    //where it stores a corresponding String that functions as a descriptive 
    //label of each measure.
    public ArrayList<ArrayList<Integer>> gameYears = new ArrayList<>();
    ArrayList<Integer> zeroArray = new ArrayList<>();
    {
        zeroArray.add(0);
        gameYears.add(zeroArray);
    }
    /*Note that gameYears can only store an integer rating of quantitative data point*/
    public ArrayList<ArrayList<String>> gameDicts = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> teams = new ArrayList<>();
    static{
        //Organizes teams into 9 groups based off of the starting number in the team number.
        //Significantly reduces computational complexity when searching for teams especially by splitting 1 and 2 into distinct groups.
        for(int u = 0; u <= 9; u++){
            teams.add(new ArrayList<Integer>());
        }
        //Note that there is no label for each of the indexes.
        //Additionally, the zero index is NOT used but rather should remain empty to make searching by team number simpler for programmers
        //e.g. team 2910 corresponds to index 2 instead of index 1.
    }

    //Constructor for creating a team!
    public Team(String name, int number, int seasons){
        this.teamName = name;
        this.teamNumber = number;
        this.numSeasonsPlayed = seasons;
        //Creates a temporary String of the passed integer for the team's number.
        //Then checks the first integer value of the team number and accordingly sorts the team
        //into the teams array list based off of that result.
        String tempName = Integer.toString(number);
        teams.get(Integer.valueOf(tempName.charAt(0))).add(number);
        gameYears.get(0).add(0, number);
    }

    //This is the function to add a new quantitative field into the array list for gameYears
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
                //Need to add prompt to update gameDicts
        } else {
                //Need to add prompt to update gameDicts
                gameYears.get(year).add(index, val);
        }
        } else {
            System.out.println("Game year not found! Please try again or report error!");
        }
    }

    public void manageDict(int entry, int year, String tag){
        //Tag is meant to be a description of the purpose of this entry, to give users a dynamic manual as to where to 
        //input any given field values, like autonomous score or endgame.
        //!!!!!!! MUST ADD CHECK WARNING FOR USER TO BE SURE THEY ARE ADDING CORRECT FIELD TO CORRECT INDEX (APPLIES TO ADDFIELD) 
        //It is entirely up to the user (at the moment) to ensure all things are properly labeled!
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
            System.out.println("Oops! Game year not found! Please check entry, saved data, or report the bug!");
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

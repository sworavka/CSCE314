package model;

import java.util.ArrayDeque;
import java.util.Deque;

private interface Command {
    void execute();
    void undo();
    String toString();
}

public void execute(Command command){
    command.execute();
    history.push(command);
}

public class Scoreboard {

    private String homeTeamName = null;
    private String awayTeamName = null;
    private int homeScore = 0;
    private int awayScore = 0;
    private final Deque<Command> history = new ArrayDeque<>();

    public Scoreboard(){}

    public void setTeamNames(String home, String away){
        if((home == null || away == null)||(home.trim().isEmpty() || away.trim().isEmpty())){
            throw new IllegalArgumentException("Team names cannot be null.");
        }else{
            homeTeamName = home;
            awayTeamName = away;
        }
    }

    public String getHomeTeamName(){
        return homeTeamName;
    }
    public String getAwayTeamName(){
        return awayTeamName;
    }

    public int getHomeScore(){
        return homeScore;
    }
    public int getAwayScore(){
        return awayScore;
    }

    public void addPointsToHome(int points){
        String scoreType = validateScore(points);
        execute(new Command(){
            @Override
            public void execute() {
                homeScore += points;
            }

            @Override
            public void undo() {
                homeScore -= points;
            }
            @Override
            public String toString() {
                return "Home +" + points + " (" + scoreType + ")";
            }
        });
    }
    public void addPointsToAway(int points){
        String scoreType = validateScore(points);
        execute(new Command(){
            @Override
            public void execute() {
                awayScore += points;
            }

            @Override
            public void undo() {
                awayScore -= points;
            }
            @Override
            public String toString() {
                return "Away +" + points + " (" + scoreType + ")";
            }
        });
    }

    public void undoLast(){
        if(!history.isEmpty()){
            history.pop().undo();
        }
    }

    public void clearGame(){
        homeScore = 0;
        awayScore = 0;
        history.clear();
    }

    public String validateScore(int points){
        if(homeTeamName == null || awayTeamName == null){
            throw new IllegalStateException("Team names must be set before teams can score.");
        }
        switch(points){
            case 1:
                return "Extra point";
            case 2: 
                return "Safety";
            case 3:
                return "Field goal";
            case 6:
                return "Touchdown";
            default:
            throw new IllegalArgumentException("Points must be 1, 2, 3, or 6.");
        }
    }

    public String getLastOperation(){
        if (history.isEmpty()){
            return "History clear";
        } else {
            return history.peek().toString();
        }
    }

    public static void main(String[] args){}
}
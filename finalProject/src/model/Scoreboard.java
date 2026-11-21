package model;

public class Scoreboard {

    private String homeTeamName = null;
    private String awayTeamName = null;
    private int homeScore = 0;
    private int awayScore = 0;
    private 

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
        if(homeTeamName == null || awayTeamName == null){
            throw new IllegalStateException("Team names must be set before teams can score.");
        }else{
            switch(points){
                case 1:
                    homeScore += 1;
                    break;
                case 2:
                    homeScore += 2;
                    break;
                case 3:
                    homeScore += 3;
                    break;
                case 6:
                    homeScore += 6;
                    break;
                default:
                    throw new IllegalArgumentException("Points must be 1, 2, 3, or 6.");
            }
        }
    }
    public void addPointsToAway(int points){
        if(homeTeamName == null || awayTeamName == null){
            throw new IllegalStateException("Team names must be set before teams can score.");
        }else{
            switch(points){
                case 1:
                    awayScore += 1;
                    break;
                case 2:
                    awayScore += 2;
                    break;
                case 3:
                    awayScore += 3;
                    break;
                case 6:
                    awayScore += 6;
                    break;
                default:
                    throw new IllegalArgumentException("Points must be 1, 2, 3, or 6.");
            }
        }
    }

    public void undoLast(){}
    public void clearGame(){
        homeScore = 0;
        awayScore = 0;
    }
}
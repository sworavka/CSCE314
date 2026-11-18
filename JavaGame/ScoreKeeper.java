public class ScoreKeeper {
    public static int addScore(int currentScore, int points){
        currentScore += points;
        return currentScore;
    }
    public static int addScore(int currentScore, int points, int multiplier){
        return addScore(currentScore, points * multiplier);
    }
    public static int totalScore(int[] scores){
        int total = 0;
        for(int score : scores){
            total += score;
        }
        return total;
    }
    public static void main(String[] args){
        int score = 0;
        score = addScore(score, 10);
        System.out.println("Score after adding 10 points: " + score);
        score = addScore(score, 5, 2);
        System.out.println("Score after adding 5 points with a multiplier of 2: " + score);
        int[] scores = {10, 20, 30};
        int total = totalScore(scores);
        System.out.println("Total score from array: " + total);
    }
}

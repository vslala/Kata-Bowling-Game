package main.java.com.bitwiseglobal.bowlingame;

/**
 * Created by varunsh on 7/25/2016.
 */
public class Game {

    private int rolls[] = new int [21];
    private int currentRoll = 0;

    ScoreCard sc = new ScoreCard();

    public void roll(int pins) {
        this.rolls[this.currentRoll++] = pins;
    }

    public int getScore() {
        return calculateScore();
    }

    private int calculateScore() {
        int score = 0;
        int frameIndex = 0;
        for (int frame=0; frame  < 10; frame++) {
            if (isStrike(rolls[frameIndex])) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex ++ ;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareBonus(rolls[frameIndex + 2]);
                frameIndex += 2;
            } else {
                score += rolls[frameIndex] + this.rolls[frameIndex + 1];
                frameIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private int spareBonus(int roll) {
        return roll;
    }

    private int strikeBonus(int frameIndex) {
        return this.rolls[frameIndex + 1] + this.rolls[frameIndex + 2];
    }

    private boolean isSpare(int frameIndex) {
        return this.rolls[frameIndex] + this.rolls[frameIndex+1] == 10;
    }

    public void startGame () {
        String scores = sc.getScoresFromUser();
        this.rolls = sc.createValidScoreFormat(scores);
        System.out.println (this.getScore());
    }

    public static void main (String [] args) {
        new Game().startGame();
    }

}

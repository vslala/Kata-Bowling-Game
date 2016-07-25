package main.java.com.bitwiseglobal.bowlingame;

import java.util.Scanner;

/**
 * Created by varunsh on 7/25/2016.
 */
public class ScoreCard {
    int [] scores = new int [21];

    public String getScoresFromUser () {
        String scoresString = "";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the score string");
        try {
            scoresString = in.nextLine();
        } catch (Exception e) {
            this.getScoresFromUser();
        }

        return scoresString;
    }

    public int[] createValidScoreFormat(String inputScore1) {
        int index = 0;
        char [] inputScore = inputScore1.toCharArray();
        for (char c: inputScore) {
            if (c == 'X' || c == 'x') {
                scores[index++] = 10;
            } else if (c == '-') {
                scores[index++] = 0;
            } else if (c == '/') {
                scores[index++] = 5;
                scores[index++] = 5;
            } else {
                scores[index++] = Integer.parseInt(c+"");
            }

        }

        return scores;
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        for (int i: this.scores) {
            sb.append(i + ",");
        }
        return sb.toString();
    }
}

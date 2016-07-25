package test.main.java.com.bitwiseglobal.bowlingame;

import main.java.com.bitwiseglobal.bowlingame.Game;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by varunsh on 7/25/2016.
 */
public class BowlingGameTest {

    Game game;

    public BowlingGameTest () {
        game = new Game ();

    }

    @Test
    public void itShouldTestBowlingGame() {
        int n = 20;
        int pins = 0;
        rollMany(n, pins);
        Assert.assertEquals(0, game.getScore());
    }

    private void rollMany(int n, int pins) {
        for (int i=0; i < n; i++)
            game.roll(pins);
    }

    @Test
    public void itShouldTestForAllOnes() {
        rollMany(20, 1);
        Assert.assertEquals(20, game.getScore());
    }

    @Test
    public void itShouldTestForOneSpare () {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        Assert.assertEquals(16, game.getScore());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5); //spare
    }

    @Test
    public void itShouldTestForOneStrike () {
        rollStrike(10);
        game.roll(3);
        game.roll(4);
        rollMany(17, 0);
        Assert.assertEquals(24, game.getScore());
    }

    private void rollStrike(int pins) {
        game.roll(pins); // strike
    }

    @Test
    public void itShouldTestForAPerfectGame () {
        rollMany(12, 10);
        Assert.assertEquals(300, game.getScore());
    }

    @Test
    public void itShouldTestForScoreWithoutAnySparesAndStrikes () {
        rollWithoutSpareNorStrike();
        Assert.assertEquals(60, game.getScore());
    }

    private void rollWithoutSpareNorStrike() {
        int pinsPerRound = 0;
        for (int i=1; i <= 20; i++) {
            pinsPerRound++;
            System.out.print (pinsPerRound);
            game.roll(pinsPerRound);
            if (pinsPerRound % 5 == 0)
                pinsPerRound = 0;
        }
    }
}

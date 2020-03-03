package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame3 implements TennisGame {

    private int p1Score;
    private int p2Score;


    public String getScore() {
        if (p2Score < 4 && p1Score < 4 && !isP1P2EqualsSix()) {
            Score[] scores = Score.values();
            String value = scores[p2Score].getValue();
            return (p2Score == p1Score) ? value + ALL_PREF : value + PREFIX + scores[p1Score].getValue();
        } else {
            if (p2Score == p1Score)
                return Score.DEUCE.getValue();
            String player = p2Score > p1Score ? PLAYER1 : PLAYER2;
            return isP2P1DiffOne() ? Score.ADVANTAGE.getValue() + SPACE
                    + player : WIN + player;

        }
    }

    private boolean isP1P2EqualsSix() {
        return p2Score + p1Score == 6;
    }

    private boolean isP2P1DiffOne() {
        return (p2Score - p1Score) * (p2Score - p1Score) == 1;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            this.p2Score += 1;
        else
            this.p1Score += 1;

    }

}
package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame2 implements TennisGame {
    private int p1Score = 0;
    private int p2Score = 0;


    public String getScore() {
        Score[] scores = Score.values();
        String score = "";
        if (p1Score == p2Score) {
            if (p1Score < 3) {
                score = scores[p1Score].getValue() + ALL_PREF;
            } else {
                score = Score.DEUCE.getValue();
            }
        }

        if (p1Score > 0 && p2Score == 0 || p2Score > 0 && p1Score == 0) {
            String p1Result = scores[p1Score].getValue();
            String p2Result = scores[p2Score].getValue();
            score = p1Result + PREFIX + p2Result;

        }

        if (p1Score > p2Score || p2Score > p1Score) {
            if (p1Score < 4 || p2Score < 4) {
                String p1Result = scores[p1Score].getValue();
                String p2Result = scores[p2Score].getValue();
                score = p1Result + PREFIX + p2Result;
            }
            if (p1Score > p2Score && p2Score >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER1;
            }

            if (p2Score > p1Score && p1Score >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER2;
            }

        }


        if (p1Score >= 4)
            if (isP1MoreThanP2Two()) {
                score = WIN + PLAYER1;
            }
        if (p2Score >= 4)
            if (isP2MoreThanP1Two()) {
                score = WIN + PLAYER2;
            }
        return score;
    }

    private boolean isP2MoreThanP1Two() {
        return (p2Score - p1Score) >= 2;
    }

    private boolean isP1MoreThanP2Two() {
        return (p1Score - p2Score) >= 2;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER1))
            p1Score++;
        else
            p2Score++;
    }
}
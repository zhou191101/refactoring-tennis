package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame2 implements TennisGame {
    private int p1Point = 0;
    private int p2Point = 0;


    private String p1Res = "";
    private String p2Res = "";

    public String getScore() {
        Score[] scores = Score.values();
        String score = "";
        if (p1Point == p2Point) {
            if (p1Point < 3) {
                score = scores[p1Point].getValue() + ALL_PREF;
            } else {
                score = Score.DEUCE.getValue();
            }
        }

        if (p1Point > 0 && p2Point == 0 || p2Point > 0 && p1Point == 0) {
            p1Res = scores[p1Point].getValue();
            p2Res = scores[p2Point].getValue();
            score = p1Res + PREFIX + p2Res;

        }

        if (p1Point > p2Point || p2Point > p1Point) {
            if (p1Point < 4 || p2Point < 4) {
                p1Res = scores[p1Point].getValue();
                p2Res = scores[p2Point].getValue();
                score = p1Res + PREFIX + p2Res;
            }
            if (p1Point > p2Point && p2Point >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER1;
            }

            if (p2Point > p1Point && p1Point >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER2;
            }

        }


        if (p1Point >= 4)
            if (isP1MoreThanP2Two()) {
                score = WIN + PLAYER1;
            }
        if (p2Point >= 4)
            if (isP2MoreThanP1Two()) {
                score = WIN + PLAYER2;
            }
        return score;
    }

    private boolean isP2MoreThanP1Two() {
        return (p2Point - p1Point) >= 2;
    }

    private boolean isP1MoreThanP2Two() {
        return (p1Point - p2Point) >= 2;
    }

    private void P1Score() {
        p1Point++;
    }

    private void P2Score() {
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER1))
            P1Score();
        else
            P2Score();
    }
}
package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame2 implements TennisGame {
    public int p1Point = 0;
    public int p2Point = 0;


    public String p1Res = "";
    public String p2Res = "";

    public String getScore() {
        Score[] scores = Score.values();
        String score = "";
        if (p1Point == p2Point) {
            if (p1Point < 3) {
                score = scores[p1Point].getValue() + "-All";
            } else {
                score = Score.DEUCE.getValue();
            }
        }

        if (p1Point > 0 )
            if (p2Point == 0) {
                p1Res = scores[p1Point].getValue();
                p2Res = scores[p2Point].getValue();
                score = p1Res + "-" + p2Res;
            }
        if (p2Point > 0)
            if (p1Point == 0) {
                p1Res = scores[p1Point].getValue();
                p2Res = scores[p2Point].getValue();
                score = p1Res + "-" + p2Res;
            }

        if (p1Point > p2Point)
            if (p1Point < 4) {
                if (p1Point == 2)
                    p1Res = "Thirty";
                if (p1Point == 3)
                    p1Res = "Forty";
                if (p2Point == 1)
                    p2Res = "Fifteen";
                if (p2Point == 2)
                    p2Res = "Thirty";
                score = p1Res + "-" + p2Res;
            }
        if (p2Point > p1Point)
            if (p2Point < 4) {
                if (p2Point == 2)
                    p2Res = "Thirty";
                if (p2Point == 3)
                    p2Res = "Forty";
                if (p1Point == 1)
                    p1Res = "Fifteen";
                if (p1Point == 2)
                    p1Res = "Thirty";
                score = p1Res + "-" + p2Res;
            }

        if (p1Point > p2Point)
            if (p2Point >= 3) {
                score = "Advantage player1";
            }

        if (p2Point > p1Point)
            if (p1Point >= 3) {
                score = "Advantage player2";
            }

        if (p1Point >= 4)
            if (p2Point >= 0)
                if ((p1Point - p2Point) >= 2) {
                    score = "Win for player1";
                }
        if (p2Point >= 4)
            if (p1Point >= 0)
                if ((p2Point - p1Point) >= 2) {
                    score = "Win for player2";
                }
        return score;
    }

    public void P1Score() {
        p1Point++;
    }

    public void P2Score() {
        p2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER1))
            P1Score();
        else
            P2Score();
    }
}
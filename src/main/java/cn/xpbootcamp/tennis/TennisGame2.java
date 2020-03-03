package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame2 implements TennisGame {
    private int mScore1 = 0;
    private int mScore2 = 0;


    private String p1Res = "";
    private String p2Res = "";

    public String getScore() {
        Score[] scores = Score.values();
        String score = "";
        if (mScore1 == mScore2) {
            if (mScore1 < 3) {
                score = scores[mScore1].getValue() + ALL_PREF;
            } else {
                score = Score.DEUCE.getValue();
            }
        }

        if (mScore1 > 0 && mScore2 == 0 || mScore2 > 0 && mScore1 == 0) {
            p1Res = scores[mScore1].getValue();
            p2Res = scores[mScore2].getValue();
            score = p1Res + PREFIX + p2Res;

        }

        if (mScore1 > mScore2 || mScore2 > mScore1) {
            if (mScore1 < 4 || mScore2 < 4) {
                p1Res = scores[mScore1].getValue();
                p2Res = scores[mScore2].getValue();
                score = p1Res + PREFIX + p2Res;
            }
            if (mScore1 > mScore2 && mScore2 >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER1;
            }

            if (mScore2 > mScore1 && mScore1 >= 3) {
                score = Score.ADVANTAGE.getValue() + SPACE + PLAYER2;
            }

        }


        if (mScore1 >= 4)
            if (isP1MoreThanP2Two()) {
                score = WIN + PLAYER1;
            }
        if (mScore2 >= 4)
            if (isP2MoreThanP1Two()) {
                score = WIN + PLAYER2;
            }
        return score;
    }

    private boolean isP2MoreThanP1Two() {
        return (mScore2 - mScore1) >= 2;
    }

    private boolean isP1MoreThanP2Two() {
        return (mScore1 - mScore2) >= 2;
    }

    private void P1Score() {
        mScore1++;
    }

    private void P2Score() {
        mScore2++;
    }

    public void wonPoint(String player) {
        if (player.equals(PLAYER1))
            P1Score();
        else
            P2Score();
    }
}
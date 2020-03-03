package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (mScore1 == mScore2) {
            Score[] scores = Score.values();
            if (mScore1 < 3) {
                score.append(scores[mScore1].getValue()).append(ALL_PREF);
            } else {
                score.append(scores[4].getValue());
            }
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) score.append(Score.ADVANTAGE.getValue()).append(SPACE).append(PLAYER1);
            else if (minusResult == -1) score.append(Score.ADVANTAGE.getValue()).append(SPACE).append(PLAYER2);
            else if (minusResult >= 2) score.append(WIN).append(PLAYER1);
            else score.append(WIN).append(PLAYER2);
        } else {
            for (int i = 1; i < 3; i++) {
                Score[] scores = Score.values();
                if (i == 1) score.append(scores[mScore1].getValue());
                else {
                    score.append(PREFIX).append(scores[mScore2].getValue());
                }
            }
        }
        return score.toString();
    }
}
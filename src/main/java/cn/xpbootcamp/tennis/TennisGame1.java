package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame1 implements TennisGame {

    private int p1Score = 0;
    private int p2Score = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            p1Score += 1;
        else
            p2Score += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (p1Score == p2Score) {
            Score[] scores = Score.values();
            if (p1Score < 3) {
                score.append(scores[p1Score].getValue()).append(ALL_PREF);
            } else {
                score.append(scores[4].getValue());
            }
        } else if (isScoreMoreThanFour()) {
            int minusResult = p1Score - p2Score;
            if (minusResult == 1) score.append(Score.ADVANTAGE.getValue()).append(SPACE).append(PLAYER1);
            else if (minusResult == -1) score.append(Score.ADVANTAGE.getValue()).append(SPACE).append(PLAYER2);
            else if (minusResult >= 2) score.append(WIN).append(PLAYER1);
            else score.append(WIN).append(PLAYER2);
        } else {
            for (int i = 1; i < 3; i++) {
                Score[] scores = Score.values();
                if (i == 1) score.append(scores[p1Score].getValue());
                else {
                    score.append(PREFIX).append(scores[p2Score].getValue());
                }
            }
        }
        return score.toString();
    }

    private boolean isScoreMoreThanFour() {
        return p1Score >= 4 || p2Score >= 4;
    }
}
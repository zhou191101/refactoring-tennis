package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;

    private static final String PLAYER1 = "player1";
    private static final String PLAYER2 = "player2";
    private static final String ALL_PREF = "-All";
    private static final String WIN = "Win for ";

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            mScore1 += 1;
        else
            mScore2 += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (mScore1 == mScore2) {
            Score[] scores = Score.values();
            if (mScore1 < 3) {
                score.append(scores[mScore1].getValue()).append(ALL_PREF);
            } else {
                score.append(scores[4].getValue());
            }
        } else if (mScore1 >= 4 || mScore2 >= 4) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) score.append(Score.ADVANTAGE.getValue()).append(" ").append(PLAYER1);
            else if (minusResult == -1) score.append(Score.ADVANTAGE.getValue()).append(" ").append(PLAYER2);
            else if (minusResult >= 2) score.append(WIN).append(PLAYER1);
            else score.append(WIN).append(PLAYER2);
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = mScore1;
                else {
                    score.append("-");
                    tempScore = mScore2;
                }
                score.append(Score.values()[tempScore].getValue());
            }
        }
        return score.toString();
    }
}
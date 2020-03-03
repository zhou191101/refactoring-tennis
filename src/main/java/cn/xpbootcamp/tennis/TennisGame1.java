package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;

    private static final String PLAYER = "player1";
    private static final String ALL_PREF = "-All";

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER))
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
            if (minusResult == 1) score = new StringBuilder("Advantage player1");
            else if (minusResult == -1) score = new StringBuilder("Advantage player2");
            else if (minusResult >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = mScore1;
                else {
                    score.append("-");
                    tempScore = mScore2;
                }
                switch (tempScore) {
                    case 0:
                        score.append(Score.LOVE.getValue());
                        break;
                    case 1:
                        score.append(Score.FIFTEEN.getValue());
                        break;
                    case 2:
                        score.append(Score.THIRTY.getValue());
                        break;
                    case 3:
                        score.append(Score.FORTY.getValue());
                        break;
                }
            }
        }
        return score.toString();
    }
}
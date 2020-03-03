package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame3 implements TennisGame {

    private int mScore1;
    private int mScore2;


    public String getScore() {
        String s;
        if (mScore2 < 4 && mScore1 < 4 && !(mScore2 + mScore1 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[mScore2];
            return (mScore2 == mScore1) ? s + "-All" : s + "-" + p[mScore1];
        } else {
            if (mScore2 == mScore1)
                return "Deuce";
            s = mScore2 > mScore1 ? PLAYER1 : PLAYER2;
            return ((mScore2 - mScore1) * (mScore2 - mScore1) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            this.mScore2 += 1;
        else
            this.mScore1 += 1;

    }

}
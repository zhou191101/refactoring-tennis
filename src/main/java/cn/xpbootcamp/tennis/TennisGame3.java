package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame3 implements TennisGame {

    private int p1Score;
    private int p2Score;


    public String getScore() {
        String s;
        if (p2Score < 4 && p1Score < 4 && !(p2Score + p1Score == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p2Score];
            return (p2Score == p1Score) ? s + "-All" : s + "-" + p[p1Score];
        } else {
            if (p2Score == p1Score)
                return "Deuce";
            s = p2Score > p1Score ? PLAYER1 : PLAYER2;
            return ((p2Score - p1Score) * (p2Score - p1Score) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            this.p2Score += 1;
        else
            this.p1Score += 1;

    }

}
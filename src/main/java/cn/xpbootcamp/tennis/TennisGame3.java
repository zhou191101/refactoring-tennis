package cn.xpbootcamp.tennis;

import static cn.xpbootcamp.tennis.Constant.*;

public class TennisGame3 implements TennisGame {

    private int p2;
    private int p1;


    public String getScore() {
        String s;
        if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[p1];
            return (p1 == p2) ? s + "-All" : s + "-" + p[p2];
        } else {
            if (p1 == p2)
                return "Deuce";
            s = p1 > p2 ? PLAYER1 : PLAYER2;
            return ((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER1))
            this.p1 += 1;
        else
            this.p2 += 1;

    }

}
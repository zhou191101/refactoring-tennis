package cn.xpbootcamp.tennis;

public enum Score {
    LOVE("Love"),
    FIFTEEN("Fifteen"),
    THIRTY("Thirty"),
    FORTY("Forty"),
    DEUCE("Deuce"),
    ADVANTAGE("Advantage");

    private String value;

    Score(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

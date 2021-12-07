package lec12.trump;

public enum Mark {
    SPADE("スペード"),
    CLUB("クラブ"),
    DIAMOND("ダイヤ"),
    HEART("ハート");

    private final String japanese;

    Mark(String japanese) {
        this.japanese = japanese;
    }

    public String getJapanese() {
        return japanese;
    }
}

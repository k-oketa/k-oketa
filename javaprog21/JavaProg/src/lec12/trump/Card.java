package lec12.trump;

public record Card(Mark mark, Number number) {

    @Override
    public String toString() {
        return mark.getJapanese() + "の" + number.getValue();
    }
}

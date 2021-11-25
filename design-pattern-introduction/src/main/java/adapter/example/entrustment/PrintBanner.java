package adapter.example.entrustment;

import adapter.example.Banner;

public class PrintBanner extends Print {

    private final Banner banner;

    PrintBanner(String string) {
        banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}

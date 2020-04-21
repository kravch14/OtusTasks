package enums;

public enum BrowserName {
    CHROME,
    FIREFOX;

    private static final String CHROME_BROWSER = "CHROME";
    private static final String FIREFOX_BROWSER = "FIREFOX";

    public static BrowserName getBrowserName(String browserName) {
        switch (browserName) {
            case CHROME_BROWSER:
                return CHROME;
            case FIREFOX_BROWSER:
                return FIREFOX;
            default:
                throw new IllegalArgumentException("Method argument value should be one of the enum constants");
        }
    }
}

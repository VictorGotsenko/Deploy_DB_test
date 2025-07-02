package database.example.dto;

public class BasePage {
    private static String flash;
    private static String flashType;

    public BasePage(String flash, String flashType) {
        BasePage.flash = flash;
        BasePage.flashType = flashType;
    }

    public static void setFlash(String flash) {
        BasePage.flash = flash;
    }

    public static void setFlashType(String flashType) {
        BasePage.flashType = flashType;
    }

    public static String getFlash() {
        return flash;
    }

    public static String getFlashType() {
        return flashType;
    }
}

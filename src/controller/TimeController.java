package src.controller;

public class TimeController {
    private static boolean isFinish = false;

    public static boolean isFinish() {
        return isFinish;
    }

    public static void finish() {
        TimeController.isFinish = !isFinish;
    }

}

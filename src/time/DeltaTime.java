package src.time;

import src.controller.TimeController;

public class DeltaTime implements Runnable {
    private static long startTime;
    private static String elapsedTime;

    public static String getElapsedTime() {
        return elapsedTime;
    }

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static String finish() {
        long endTime = System.currentTimeMillis();
        long elapsedTimeTimeInMillis = endTime - startTime;
        long horas = elapsedTimeTimeInMillis / 3600000;
        elapsedTimeTimeInMillis %= 3600000;
        long minutos = elapsedTimeTimeInMillis / 60000;
        elapsedTimeTimeInMillis %= 60000;
        long segundos = elapsedTimeTimeInMillis / 1000;
        elapsedTimeTimeInMillis %= 1000;
        long milesegundos = elapsedTimeTimeInMillis;
        String elapsedTime = horas + " horas," + minutos + " minutos," + segundos
                + " segundos," + milesegundos + " milesimos de segundos";
        return elapsedTime;
    }

    public static String elapsedTime() {
        // ClearConsole.clearConsole();
        String time = "Elapsedtime: " + finish();
        DeltaTime.elapsedTime = time;
        return time;
    }

    @Override
    public void run() {
        start();
        while (!TimeController.isFinish()) {
            System.out.println(elapsedTime());
        }
        DeltaTime.elapsedTime = elapsedTime();
    }
}
package ru.sping.lesson8;

public class classicalMusic implements Music {
    private classicalMusic() {}

    public static classicalMusic getClassicalMusic() {
        return new classicalMusic();
    }

    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

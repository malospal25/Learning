package ru.sping.lesson8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        classicalMusic classicalMusic = context.getBean("musicBean", ru.sping.lesson8.classicalMusic.class);

        System.out.println(classicalMusic.getSong());

        // Music music = context.getBean("musicBean", Music.class);
        // MusicPlayer musicPlayer = new MusicPlayer(music);

//        MusicPlayer firstMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//        MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        boolean comprarison = firstMusicPlayer == secondMusicPlayer;
//
//        System.out.println(firstMusicPlayer);
//        System.out.println(secondMusicPlayer);
//        System.out.println(comprarison);
//
//        firstMusicPlayer.setVolume(10);
//
//        System.out.println(firstMusicPlayer.getVolume());
//        System.out.println(secondMusicPlayer.getVolume());

//      System.out.println(musicPlayer.getName());
//      System.out.println(musicPlayer.getVolume());

        context.close();
    }
}

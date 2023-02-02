package ru.sping.lesson8;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );
        // Value, Scope
        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer.getName());
        System.out.println(musicPlayer.getVolume());

        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
        ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);

        System.out.println(classicalMusic == classicalMusic1);

//        //init and destroy
//        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//        System.out.println(musicPlayer.getName());
//        System.out.println(musicPlayer.getVolume());
//
//        ClassicalMusic classicalMusic = context.getBean("classicalMusic", ClassicalMusic.class);
//
//        context.close();
    }
}

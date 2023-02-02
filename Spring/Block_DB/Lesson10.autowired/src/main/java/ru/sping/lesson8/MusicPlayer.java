package ru.sping.lesson8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//// для работы через конструктор
//@Component
//public class MusicPlayer {
//    private Music music;
//
//    @Autowired
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }
//    public void playMusic() {
//        System.out.println("Playing: " + music.getSong());
//    }
//}

//// Через setter
//@Component
//public class MusicPlayer {
//    private Music music;
//
//    public MusicPlayer(Music music) {
//        this.music = music;
//    }
//    @Autowired
//    public void setMusic(Music music) {
//        this.music = music;
//    }
//
//    public void playMusic() {
//        System.out.println("Playing: " + music.getSong());
//    }
//}

//// через поле
//@Component
//public class MusicPlayer {
//    @Autowired
//    private Music music;
//
//
//    public void playMusic() {
//        System.out.println("Playing: " + music.getSong());
//    }
//}

//// Сразу две зависимости
//@Component
//public class MusicPlayer {
//    private ClassicalMusic classicalMusic;
//    private RockMusic rockMusic;
//    @Autowired
//    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
//        this.classicalMusic = classicalMusic;
//        this.rockMusic = rockMusic;
//    }
//
//    public void playMusic() {
//        System.out.println("Playing: " + classicalMusic.getSong());
//        System.out.println("Playing: " + rockMusic.getSong());
//    }
//}

//// одна зависимость зависит от другой
@Component
public class MusicPlayer {
    private ClassicalMusic classicalMusic;
    private RockMusic rockMusic;
    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.rockMusic = rockMusic;
    }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong();
    }
}

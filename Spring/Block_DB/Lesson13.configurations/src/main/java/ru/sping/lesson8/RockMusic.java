package ru.sping.lesson8;

import org.springframework.stereotype.Component;


//public class RockMusic implements Music {
//    @Override
//    public String getSong() {
//        return "Wind cries Mary";
//    }
//}

// для двух зависимостей
//@Component
// для автоматического создания
public class RockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}
package ru.sping.lesson8;

import org.springframework.stereotype.Component;

@Component
public class rockMusic implements Music {
    @Override
    public String getSong() {
        return "Wind cries Mary";
    }
}

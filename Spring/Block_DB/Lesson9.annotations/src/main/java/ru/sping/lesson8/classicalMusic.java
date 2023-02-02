package ru.sping.lesson8;

import org.springframework.stereotype.Component;

@Component
public class classicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

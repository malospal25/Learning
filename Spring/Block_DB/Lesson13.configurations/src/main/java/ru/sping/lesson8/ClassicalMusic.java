package ru.sping.lesson8;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// создание автоматически
//Singleton
//@Component
//@Scope("singleton")
//public class ClassicalMusic implements Music {
//    @Override
//    public String getSong() {
//        return "Hungarian Rhapsody";
//    }
//}

//// Создание вручную
////Singleton
//@Component
//@Scope("singleton")
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }
}

//Prototype
//@Component
//@Scope("prototype")
//public class ClassicalMusic implements Music {
//    @Override
//    public String getSong() {
//        return "Hungarian Rhapsody";
//    }
//}

//Init and Destroy
//@Component
//public class ClassicalMusic implements Music {
//    @PostConstruct
//    public void doMyInit() {
//        System.out.println("Doing my initialization");
//    }
//    @PreDestroy
//    public void doMyDestroy() {
//        System.out.println("Doing my destruction");
//    }
//
//    @Override
//    public String getSong() {
//        return "Hungarian Rhapsody";
//    }
//}
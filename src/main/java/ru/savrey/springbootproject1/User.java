package ru.savrey.springbootproject1;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

@Data
public class User {

    private static long idCounter = 0L;

    private long id;
    private String name;

//    @JsonCreator
//    public User(long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public User(String name) {
        this.id = idCounter++;
        this.name = name;
    }
}

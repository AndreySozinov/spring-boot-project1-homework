package ru.savrey.springbootproject1.homework;

import lombok.Data;

@Data
public class Student {

    private long id;
    private String name;
    private String groupName;

    private static long idCounter = 0L;

    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }

}

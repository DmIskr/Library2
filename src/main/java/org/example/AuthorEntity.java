package org.example;

import lombok.Data;

@Data
public class AuthorEntity {
    private String Name;
    private String Lastname;
    private String Surname;

    @Override
    public String toString() {
        return  "'" + Name + '\'' +
                ",'" + Lastname + '\'' +
                ",'" + Surname + '\'' +
                ')';
    }
}
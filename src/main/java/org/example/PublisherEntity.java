package org.example;

import lombok.Data;
import lombok.ToString;

@Data

public class PublisherEntity {
    private String publisher;
    private String city;

    @Override
    public String toString() {
        return  "'" + publisher + '\'' +
                ", город издания: '" + city + '\'';
    }
}
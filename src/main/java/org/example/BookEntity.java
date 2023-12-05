package org.example;

import lombok.Data;

@Data

public class BookEntity {
    private String title;
    private AuthorEntity author;
    private PublisherEntity publishing;

    public void Book() {
        this.title = title;
        this.author = author;
        this.publishing = publishing;
    }

    @Override
    public String toString() {
        return "Книга " +
                "'" + title + '\'' +
                ", Автор ( " + author +
                ", Издательство: " + publishing ;
    }

}

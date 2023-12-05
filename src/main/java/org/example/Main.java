package org.example;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Books books = new Books();

        File file = new File("D:file.txt");
        try (FileReader fileReader = new FileReader(file)) {
            Scanner fileScanner = new Scanner(fileReader);
            if (fileScanner.hasNextLine()) {
                String str2 = fileScanner.nextLine();
                Gson gson = new Gson();
                books = gson.fromJson(str2, Books.class);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int menu = 0;
        do {
            System.out.println("1 - Добавить книгу");
            System.out.println("2 - Вывести");
            System.out.println("3 - Удалить");
            System.out.println("4 - Найти книгу");
            System.out.println("5 - Записать и выйти");
            menu = scanner.nextInt();
            if (menu > 5){
                System.out.println("Цифры больше 5 не вводить!");
            }
            AuthorEntity author = new AuthorEntity();
            PublisherEntity publisher = new PublisherEntity();
            BookEntity book = new BookEntity();
            switch (menu) {
                case 1:

                    //  addBook();

                    scanner.nextLine();
                    System.out.println("Введите фамилию автора");
                    author.setLastname(scanner.nextLine());
                    System.out.println("Введите имя автора");
                    author.setName(scanner.nextLine());
                    System.out.println("Введите отчество автора");
                    author.setSurname(scanner.nextLine());

                    System.out.println("Введите издательство");
                    publisher.setPublisher(scanner.nextLine());
                    System.out.println("Введите город издания");
                    publisher.setCity(scanner.nextLine());

                    book.setPublishing(publisher);
                    book.setAuthor(author);
                    System.out.println("Введите название книги");
                    book.setTitle(scanner.nextLine());

                    if (books.getData()==null) {
                        List temp = new ArrayList<>();
                        temp.add(book);
                        books.setData(temp);
                    }else {
                        books.getData().add(book);
                    }

                    break;

                case 2:
                    if (books.getData() != null) {
                    books.getData().forEach(System.out::println);
                    }else
                        System.out.println("Книг нету");
                    break;
                case 3:
                    if (books.getData() != null) {
                        System.out.println("Введите название книги, которую хотите удалить: ");
                        scanner.nextLine();
                        String del = scanner.nextLine();

                        BookEntity bookToRemove = null;

                        for (int i = 0; i < books.getData().size(); i++) {
                            book = books.getData().get(i);
                            if (book.getTitle().equals(del)) {
                                bookToRemove = book;
                                break;
                            }
                        }

                        if (bookToRemove != null) {
                            books.getData().remove(bookToRemove);
                            System.out.println("Книга удалена из списка.");
                        } else {
                            System.out.println("Книга не найдена в списке.");
                        }
                    } else
                        System.out.println("Книг нету");
                    break;

                case 4:
                    if (books.getData() != null) {
                        System.out.println("Введите название книги: ");
                        scanner.nextLine();
                        String find = scanner.nextLine();
                        BookEntity findedBook = null;

                        for (int i = 0; i < books.getData().size(); i++) {
                            book = books.getData().get(i);
                            if (book.getTitle().equals(find)) {
                                findedBook = book;
                                break;
                            }

                        }
                        if (findedBook != null) {
                            System.out.println("Книга найдена: " + books.getData());
                        }else System.out.println("Книга не найдена");
                    } else
                        System.out.println("Книг нету");
                    break;
                case 5:
                    try (FileWriter filewriter = new FileWriter(file)) {
                        Gson gson = new Gson();
                        String str = gson.toJson(books);
                        filewriter.write(str);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    System.out.println("Успешно записано!");
                    break;
            }
        }       while (menu != 5);



    }

    public static void addBook() {

     /*   Scanner scanner = new Scanner(System.in);

        ListBooks books = new ListBooks();

        AuthorEntity author = new AuthorEntity();

        System.out.println("Введите фамилию автора");
        author.setLastname(scanner.nextLine());
        System.out.println("Введите имя автора");
        author.setName(scanner.nextLine());
        System.out.println("Введите отчество автора");
        author.setSurname(scanner.nextLine());

        PublisherEntity publisher = new PublisherEntity();

        System.out.println("Введите издательство");
        publisher.setPublisher(scanner.nextLine());
        System.out.println("Введите город издания");
        publisher.setCity(scanner.nextLine());

        BookEntity book = new BookEntity();

        book.setPublishing(publisher);
        book.setAuthor(author);
        System.out.println("Введите название книги");
        book.setTitle(scanner.nextLine());

        if (books.getData()==null) {
            List temp = new ArrayList<>();
            temp.add(book);
            books.setData(temp);
        }else {
            books.getData().add(book);
        }
    }
    */
    }
}
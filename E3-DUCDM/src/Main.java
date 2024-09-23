import Entity.Author;
import Entity.Book;
import Entity.BookManager;
import Entity.Gender;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        Scanner scanner = new Scanner(System.in);

        Author author1 = new Author("Messi", "Messi@example.com", Gender.M);
        Author author2 = new Author("Ronaldo", "Ronaldojane@example.com", Gender.F);
        bookManager.addAuthor(author1);
        bookManager.addAuthor(author2);

        Book book1 = new Book("Java", author1, 29, 100);
        Book book2 = new Book("Python", author2, 24, 150);
        Book book3 = new Book("JavaScript", author1, 22, 170);
        Book book4 = new Book("C++", author2, 21, 110);
        bookManager.addBook(book1);
        bookManager.addBook(book2);
        bookManager.addBook(book3);
        bookManager.addBook(book4);

        bookManager.sortBookByName();
        bookManager.displayBooks();

        Book maxPriceBook = bookManager.maxPrice();
        System.out.println("Book max price: \n" + maxPriceBook);

        System.out.println("Nhap ten tac gia de tim sach: " );
        String authorName = scanner.nextLine();
        System.out.println("Sach cua tac gia " + authorName + ":");
        bookManager.getBookName(authorName).forEach(System.out::println);

    }
}
package Entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public void addBook(Book book) {
        if (books.stream().noneMatch(b -> b.getName().equals(book.getName()))) {
            books.add(book);
        } else {
            System.out.println("Book already exists");
        }
    }

    public void addAuthor(Author author) {
        if (authors.stream().noneMatch(a -> a.getName().equals(author.getName()))) {
            authors.add(author);
        } else {
            System.out.println("Author already exists");
        }
    }

    public void sortBookByName() {
        books.sort(Comparator.comparing(Book::getName));
    }

    public Book maxPrice() {
        return books.stream().max(Comparator.comparing(Book::getPrice)).orElse(null);
    }

    public List<Book> getBookName(String authorName) {
        return books.stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .toList();
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}
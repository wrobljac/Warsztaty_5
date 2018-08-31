package pl.coderslab.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService {
    List<Book> books;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book("9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        books.add(new Book("9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.add(new Book("9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook (Book book){
        books.add(book);
    }

    public Book getBookById (long id){
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .collect(Collectors.toList()).get(0);
        return book;
    }

    public void editBook (Book book){
        long id = book.getId();
        books.stream()
                .filter(b -> b.getId() == id)
                .forEach(b->{
                    b.setIsbn(book.getIsbn());
                    b.setTitle(book.getTitle());
                    b.setAuthor(book.getAuthor());
                    b.setPublisher(book.getPublisher());
                    b.setType(book.getType());
                });
    }

    public void deleteBook (long id){
        books.removeIf(b->b.getId()==id);
    }

}

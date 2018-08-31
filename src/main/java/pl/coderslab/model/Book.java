package pl.coderslab.model;

public class Book {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String type;
    private long lastId = 1l;

    public Book() {
    }

    public Book(String isbn, String title, String author, String publisher, String type) {
        this.id = setId();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    private long setId() {
        id = lastId;
        lastId++;
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getType() {
        return type;
    }

    public Book setType(String type) {
        this.type = type;
        return this;
    }

}

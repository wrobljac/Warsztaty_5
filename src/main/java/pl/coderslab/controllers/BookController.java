package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book("9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/showBooks")
    public List<Book> showBookList(){
        return memoryBookService.getBooks();
    }


    @RequestMapping("/showBooks/{bookId}")
    public Book showBookById(@PathVariable String bookId){
        try{
            long id = Long.parseLong(bookId);
            return memoryBookService.getBookById(id);
        } catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @PostMapping("/addBook")
    public void addBook(@RequestParam Book book){
        memoryBookService.addBook(book);

        //ogarnac ID
    }

    @PutMapping("/editBook")
    public void editBook(@RequestParam Book book){
        memoryBookService.editBook(book);
    }
}
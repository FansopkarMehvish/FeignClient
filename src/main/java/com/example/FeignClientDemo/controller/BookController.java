package com.example.FeignClientDemo.controller;

import com.example.FeignClientDemo.model.Book;
import com.example.FeignClientDemo.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping("/allBooks")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/update")
    public String updateBook(@RequestParam int id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam int id){
        return bookService.deleteBook(id);
    }
}

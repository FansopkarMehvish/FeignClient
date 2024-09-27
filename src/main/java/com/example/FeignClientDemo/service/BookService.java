package com.example.FeignClientDemo.service;

import com.example.FeignClientDemo.interfaces.BookClient;
import com.example.FeignClientDemo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BookClient bookClient;

    public BookService(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    public List<Book> getBooks(){
        List<Book> books = bookClient.getAllBooks();
        if(Objects.nonNull(books)){
            return books;
        }
        throw  new RuntimeException("Books not found");
    }

    public String addBook(Book book) {
        return bookClient.addBook(book);
    }

    public String updateBook(int id, Book book) {
        return bookClient.updateBook(id, book);
    }

    public String deleteBook(int id) {
        return bookClient.deleteBook(id);
    }
}

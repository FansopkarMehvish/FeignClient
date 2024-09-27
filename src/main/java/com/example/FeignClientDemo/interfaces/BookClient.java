package com.example.FeignClientDemo.interfaces;

import com.example.FeignClientDemo.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "bookClient", url = "${feign.url}")
public interface BookClient {

    @GetMapping("/getAllBooks")
    List<Book> getAllBooks();

    @PostMapping("/addBook")
    String addBook(@RequestBody Book book);

    @PutMapping("/updateBook")
    String updateBook(@RequestParam("id") int id, @RequestBody Book book);

    @DeleteMapping("/deleteBook")
    String deleteBook(@RequestParam("id") int id);

}

package com.UST.EmployeeExample.controller;

import com.UST.EmployeeExample.entity.Book;
import com.UST.EmployeeExample.entity.User;
import com.UST.EmployeeExample.exception.IdNotFoundException;
import com.UST.EmployeeExample.repository.BookRepo;
import com.UST.EmployeeExample.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class LibraryController {
    @Autowired
    private BookRepo bookrepo;

    @Autowired
    private UserRepo userrepo;

    @PostMapping("/book")
    public ResponseEntity<Book> boook(@RequestBody Book book1) {
        bookrepo.save(book1);
        return ResponseEntity.ok().body(book1);
    }

    @PostMapping("/user")
    public ResponseEntity<User> userr(@RequestBody User user1) {
        userrepo.save(user1);
        return ResponseEntity.ok().body(user1);
    }
    @GetMapping("/book1")
    public ResponseEntity<List<Book>> getBook(){
        return ResponseEntity.ok().body(bookrepo.findAll());
    }
    @GetMapping("/user1")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok().body(userrepo.findAll());
    }

    @GetMapping("/book2/{id}")
    public ResponseEntity<Book> getBuk(@PathVariable Long id) throws IdNotFoundException    {
        Optional<Book> buk = bookrepo.findById(id);
        if(buk.isPresent()){
            return ResponseEntity.ok().body(bookrepo.findById(id).orElse(null));
        }
        else{
//            return ResponseEntity.noContent().build();
            throw new IdNotFoundException("no id");
        }
    }
    @GetMapping("/user2/{id}")
    public ResponseEntity<User> getusr(@PathVariable Long id){
        return ResponseEntity.ok().body(userrepo.findById(id).orElse(null));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updatebuk(@RequestBody Book book, @PathVariable Long id) throws IdNotFoundException{
        Optional<Book> bbkk= bookrepo.findById(id);
        if(bbkk.isPresent()) {


            Book bukk = null;
            Optional<Book> bkk = bookrepo.findById(id);
            bukk = bkk.get();
            bukk.setId(id);
            bukk.setName(book.getName());
            return ResponseEntity.ok().body(bookrepo.save(bukk));
        }
        else{
            throw new IdNotFoundException("no id");
        }
    }
    @PutMapping("/update1/{id}")
    public ResponseEntity<User> updateusr(@RequestBody User user,@PathVariable Long id){
        User usrr=null;
        Optional<User> urr=userrepo.findById(id);
        usrr=urr.get();
        usrr.setId(id);
        usrr.setName(user.getName());
        return ResponseEntity.ok().body(userrepo.save(usrr));
    }

    @DeleteMapping("/bukdel/{id}")
    public ResponseEntity<String> deletebuk(@PathVariable Long id){
        bookrepo.deleteById(id);
        return ResponseEntity.ok().body("deleted..");
    }
    @DeleteMapping("/usrdel/{id}")
    public ResponseEntity<String> deleteusr(@PathVariable Long id){
        Optional<User> uss=userrepo.findById(id);
        if(uss.isPresent()){
            userrepo.deleteById(id);
            return ResponseEntity.ok().body("deleted..");
    }
        else{
//            return ResponseEntity.noContent().build();
            throw new IdNotFoundException("no id");
        }

        }



}

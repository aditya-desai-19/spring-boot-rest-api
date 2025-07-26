package com.aditya.journal.controller;

import com.aditya.journal.entity.JournalEntitiy;
import com.aditya.journal.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

//Best practice in Java Spring boot
//        controller --> service --> repository

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @GetMapping
    public List<JournalEntitiy> getAll() {
      return journalService.getAll();
    }

    @PostMapping
    public String addEntry(@RequestBody JournalEntitiy data) {
        data.setDate(LocalDateTime.now());
        journalService.saveEntry(data);
       return "Successfully added";
    }

    @GetMapping("/{id}")
    public JournalEntitiy getById(@PathVariable String id) {
        return journalService.findById(id);
    }

    @PutMapping("/{id}")
    public JournalEntitiy updateEntry(@PathVariable String id, @RequestBody JournalEntitiy data) {
        return journalService.updateEntry(id, data);
    }

    @DeleteMapping("/{id}")
    public String deleteEntry(@PathVariable String id) {
        journalService.deleteById(id);
        return "Successfully deleted";
    }
}

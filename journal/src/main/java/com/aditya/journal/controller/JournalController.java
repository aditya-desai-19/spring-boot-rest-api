package com.aditya.journal.controller;

import com.aditya.journal.entity.JournalEntitiy;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalController {
    private Map<Long, JournalEntitiy> map = new HashMap<>();

    @GetMapping
    public List<JournalEntitiy> getAll() {
        return new ArrayList<>(map.values());
    }

    @PostMapping
    public String addEntry(@RequestBody JournalEntitiy data) {
        map.put(data.getId(), data);
        return "Successfully created";
    }

    @GetMapping("/{id}")
    public JournalEntitiy getById(@PathVariable long id) {
        return map.get(id);
    }

    @PutMapping("/{id}")
    public JournalEntitiy updateEntry(@PathVariable long id, @RequestBody JournalEntitiy data) {
        map.put(id, data);
        return map.get(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEntry(@PathVariable long id) {
        map.remove(id);
        return "Successfully deleted";
    }
}

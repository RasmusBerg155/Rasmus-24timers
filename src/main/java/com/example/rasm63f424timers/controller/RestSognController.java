package com.example.rasm63f424timers.controller;

import com.example.rasm63f424timers.model.Kommune;
import com.example.rasm63f424timers.model.Sogn;
import com.example.rasm63f424timers.repository.KommuneRepo;
import com.example.rasm63f424timers.repository.SognRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestSognController {

    @Autowired
    SognRepo sognRepo;

    @Autowired
    KommuneRepo kommuneRepo;

    @GetMapping("/sogn")
    public ResponseEntity<Iterable<Sogn>> findALL(){
        return ResponseEntity.status(HttpStatus.OK).body(sognRepo.findAll());
    }

    @GetMapping("/kommune")
    public ResponseEntity<Iterable<Kommune>> findALLKommune(){
        return ResponseEntity.status(HttpStatus.OK).body(kommuneRepo.findAll());
    }


    @GetMapping("/sogn/{id}")
    public ResponseEntity<Optional<Sogn>> findById(@PathVariable Long id)
    {
        Optional<Sogn> optionalSogn = sognRepo.findById(id);
        if (optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(optionalSogn);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(optionalSogn);
        }
    }

    @CrossOrigin(origins = "*", exposedHeaders = "Location")
    @PostMapping(value = "/sogn", consumes = "application/json")
    public ResponseEntity<String> create(@RequestBody Sogn s){
        Sogn sogn = new Sogn(s.getNavn(), s.getSmitteniveau(), s.getNedlukningStart());

        sognRepo.save(sogn);

        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/sogn/" + s.getId()).body("{'msg': 'Post created'}");
    }

    @PutMapping("/sogn/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody Sogn s) {
        Optional<Sogn> optionalSogn = sognRepo.findById(id);
        if (!optionalSogn.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{'msg' : 'sogn " + id + " not found'");
        }
        sognRepo.save(s);
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : 'updated' }");
    }

    @DeleteMapping("/sogn/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Optional<Sogn> optionalSogn = sognRepo.findById(id);
        if (!optionalSogn.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{ 'msg' : 'sogn " + id + " not found'}");
        } else if (optionalSogn.isPresent()){
            sognRepo.deleteById(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body("{ 'msg' : " + id + " 'deleted'}");
    }
}

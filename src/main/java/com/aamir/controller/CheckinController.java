package com.aamir.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.aamir.model.Checkin;
import com.aamir.services.CheckinService;

@RestController
@RequestMapping(value = "/checkin")
public class CheckinController {
 
    @Autowired
    private CheckinService service;
 
    @GetMapping(value = "/list")
    public ResponseEntity<List<Checkin>> getAllCheckin() {
        return new ResponseEntity<List<Checkin>>(service.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Checkin> getCheckin(@PathVariable Integer id) {
        return new ResponseEntity<Checkin>(service.findById(id), HttpStatus.OK);
    }
 
    
    @PostMapping(value = "/save")
    public ResponseEntity<Integer> newCheckin(@RequestBody Checkin checkin) {
        System.out.println("controller ::"+checkin);
        return new ResponseEntity<Integer>(service.save(checkin), HttpStatus.OK);
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<Integer> updateCheckin(@RequestBody Checkin checkin) {
        return new ResponseEntity<Integer>(service.update(checkin), HttpStatus.OK);
    }
 
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Integer> deleteCheckin(@RequestBody Checkin checkin) {
        return new ResponseEntity<Integer>(service.deleteById(checkin.getCheckinId()), HttpStatus.OK);
    }
 
 
}
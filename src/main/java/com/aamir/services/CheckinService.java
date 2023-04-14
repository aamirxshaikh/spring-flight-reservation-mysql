package com.aamir.services;

import java.util.List;

import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.aamir.repository.CheckinRepository;

import com.aamir.model.Checkin;

@Service
public class CheckinService {
 
    @Autowired
    private CheckinRepository repo;
 
    public List<Checkin> findAll() {
        return repo.findAll();
    }
 
    public Checkin findById(int id) {
        Optional<Checkin> checkin = repo.findById(id);
 
        if (checkin.isPresent()) {
            System.out.println(checkin);
            return checkin.get();
        } else {
            return new Checkin(); 
        }
    }
 
    public int save(Checkin checkin) {
        Optional<Checkin> existsCheckin = repo.findById(checkin.getCheckinId());
        int id = 0;
        if (existsCheckin.isPresent()) {
            id = -1;
        } else {
        	Checkin checkin2 = repo.saveAndFlush(checkin);
            id = checkin2.getCheckinId();
        }
        return id;
    }

    public int update(Checkin checkin) {
        Optional<Checkin> existsCheckin = repo.findById(checkin.getCheckinId());
        int id = 0;
        
		if (existsCheckin.isPresent()) {
            repo.saveAndFlush(checkin);
            id = 1;
        } else {
            id = -1;
        }
        return id;
    }
 
    public int deleteById(Integer id) {
        Optional<Checkin> existsCheckin = repo.findById(id);
        int i = 0;
        if (existsCheckin.isPresent()) {
            repo.deleteById(id);
            i = 1;
        } else {
            i = -1;
        }
        return i;
    }
}

package com.example.demo.service;

import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public void test(){
        List<Team> list = new ArrayList<>();
        teamRepository.saveAll(list);
    }
}

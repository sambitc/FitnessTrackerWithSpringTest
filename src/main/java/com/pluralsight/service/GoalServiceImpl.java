/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.service;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sambitc
 */
@Service("goalService")
public class GoalServiceImpl implements GoalService {
    
    @Autowired
    private GoalRepository goalRepository;
    
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> findAllGoals() {
        return goalRepository.loadAll();
    }
}

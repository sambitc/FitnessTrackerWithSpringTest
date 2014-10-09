/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.service;

import com.pluralsight.model.Goal;
import java.util.List;

/**
 *
 * @author sambitc
 */
public interface GoalService {
    Goal save(Goal goal);

    public List<Goal> findAllGoals();
}

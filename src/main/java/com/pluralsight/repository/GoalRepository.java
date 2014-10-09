/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import java.util.List;

/**
 *
 * @author sambitc
 */
public interface GoalRepository {

    Goal save(Goal goal);

    public List<Goal> loadAll();
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.repository;

import com.pluralsight.model.Goal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sambitc
 */
@Repository("goalRepository")
public class GoalRepositoryImpl implements GoalRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Goal save(Goal goal) {
        em.persist(goal);
        em.flush();
        return goal;
    }

    public List<Goal> loadAll() {
        Query query = em.createQuery("select g from Goal g");
        List goals = query.getResultList();
        return goals;
    }
}

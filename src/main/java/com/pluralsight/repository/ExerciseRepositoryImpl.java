/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.repository;

import com.pluralsight.model.Exercise;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sambitc
 */
@Repository
public class ExerciseRepositoryImpl implements ExerciseRepository {

    @PersistenceContext
    private EntityManager em;

    public Exercise save(Exercise exercise) {
        em.persist(exercise);
        em.flush();

        return exercise;
    }
}

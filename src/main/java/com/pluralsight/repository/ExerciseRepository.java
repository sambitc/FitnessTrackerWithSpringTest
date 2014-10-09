/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.repository;

import com.pluralsight.model.Exercise;

/**
 *
 * @author sambitc
 */
public interface ExerciseRepository {
    Exercise save(Exercise exercise);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.repository.EntityCourseDao;
import fr.utbm.lo54.projet.entity.Course;

/**
 *
 * @author Remi
 */
public class CourseService {
    
    public void registerCourse(Course c) {
        EntityCourseDao ecd = new EntityCourseDao();
        ecd.save(c);
    }
}

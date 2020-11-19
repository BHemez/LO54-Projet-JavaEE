/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.repository.EntityCourseDao;
import fr.utbm.lo54.projet.entity.Course;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Remi
 */
public class CourseService {
    
    public void registerCourse(Course c) {
        EntityCourseDao ecd = new EntityCourseDao();
        ecd.save(c);
    }
    
    public List<Course> listCourse(){
        EntityCourseDao ecd = new EntityCourseDao();
        return ecd.findAll();
    }
    
    public Optional<Course> findClientById(Integer id) {
        EntityCourseDao ecd = new EntityCourseDao();
        return ecd.findById(id);
    }

    public void deleteCourse(Course course) {
        EntityCourseDao ecd = new EntityCourseDao();
        ecd.deleteById(course.getCode());
    }
}

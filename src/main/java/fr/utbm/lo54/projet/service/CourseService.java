/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.lo54.projet.service;

import fr.utbm.lo54.projet.repository.EntityCourseDao;
import fr.utbm.lo54.projet.entity.Course;
import java.util.List;

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
    
    public Course findCourseById(Integer id) {
        EntityCourseDao ecd = new EntityCourseDao();
        return ecd.findById(id);
    }

    public Course findCourseByTitle(String title) {
        EntityCourseDao ecd = new EntityCourseDao();
        return ecd.findByTitle(title);
    }
    
    public void deleteCourse(Course course) {
        EntityCourseDao ecd = new EntityCourseDao();
        ecd.deleteById(course.getCode());
    }
}

package com.springrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
	private CourseDao courseDao;
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}
	


    //get Single Book by id using  jpa database
	@Override
    public Optional<Course> getCourse(long courseId){
       Optional<Course> course = null;
       try{
      course = this.courseDao.findById(courseId);
       }catch(Exception e){
           e.printStackTrace();
       }
       return course;
    }

/*
	@Override
	public Course getCourse(long courseId) {
	
		return courseDao.getOne(courseId);
	}
*/
	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
	Course entity = courseDao.getOne(parseLong);
	courseDao.delete(entity);
		
	}

}
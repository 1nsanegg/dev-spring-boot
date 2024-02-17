package com.nsanegg.cruddemo.dao;

import com.nsanegg.cruddemo.entity.Instructor;
import com.nsanegg.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}

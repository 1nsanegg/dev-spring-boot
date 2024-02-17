package com.nsanegg.cruddemo.dao;

import com.nsanegg.cruddemo.entity.Instructor;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}

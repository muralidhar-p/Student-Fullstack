package com.example.SpringPractice.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringPractice.Model.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

	ArrayList<Student> findByFname(String fname);
	

}

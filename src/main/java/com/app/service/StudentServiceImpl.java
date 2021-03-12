package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.jdbc.model.Student;
import com.app.model.StudentModel;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Long createStudent(StudentModel studentModel) {
		
		Student studentToSave = new Student();
		studentToSave.setSname(studentModel.getSname());
		
		studentRepository.save(studentToSave);
		
		return 1L;
	}

	@Override
	public void updateStudent(StudentModel studentModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteStudent(Long sno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentModel> getAllStudents() {
		List<Student> studentsFromDB = studentRepository.findAll();
		
		List<StudentModel> studentModels = new ArrayList<>();
		for(Student stud:studentsFromDB) {
			StudentModel studentModel = new StudentModel();
			studentModel.setSno(stud.getSno());
			studentModel.setSname(stud.getSname());
			
			studentModels.add(studentModel);
			
		}
		
		return studentModels;
	}

	@Override
	public StudentModel getStudent(Long sno) {
		// TODO Auto-generated method stub
		return null;
	}

}

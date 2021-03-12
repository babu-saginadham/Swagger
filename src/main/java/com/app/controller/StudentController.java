package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.StudentModel;
import com.app.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="student")
@Api(value="Student Management System", description="Operations pertaining to Student Management System")
public class StudentController {
	
	static Logger logger = Logger.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="/all")
	@ApiOperation(value = "View a list of available student", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<Object> getAll() {
		return ResponseEntity.ok(HttpStatus.OK).ok(studentService.getAllStudents());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
		return null;
	}
	
	@ApiOperation(value = "View a list of available student v2", response = List.class)
	@GetMapping(value="/v2/{id}")
	public ResponseEntity<List<StudentModel>> getStudent2(@ApiParam(name = "studentId") @PathVariable("id") Integer id, 
			@PathVariable("startsWith") String nameStartsWith) {
		return null;
	}
	
	
	@ApiOperation(value = "Create student", response = List.class)
	@PostMapping(value="/student")
	public ResponseEntity<Long> post(@ApiParam(name = "studentModel") @RequestBody StudentModel student) {
		Long sno = studentService.createStudent(student);
		return ResponseEntity.ok(HttpStatus.OK).ok(sno);
	}
	
	@PutMapping(value="/student/{id}")
	public ResponseEntity<String> put(@PathVariable("id") Integer id, @RequestBody StudentModel student) {
		return null;
	}

	
	@DeleteMapping(value="/delete")
	public ResponseEntity<String> delete(@RequestBody StudentModel student) {
		return null;
	}
	
	

}

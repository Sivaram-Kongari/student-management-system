package com.springboot.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.web.dto.StudentDTO;
import com.springboot.web.model.Student;
import com.springboot.web.service.StudentService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public Student addStudent(@RequestBody @Valid StudentDTO studentDTO) {

		Student insert = studentService.insertStudent(studentDTO);
		return insert;
	}
	@PutMapping("/update/{id}")
	public Student modifyStudent(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) {

		Student modifyStud = studentService.updateStudent(id, studentDTO);
		return modifyStud;
	}
	@DeleteMapping("/deleteById/{id}")
	public void deleteStudent(@PathVariable Long id) {

		studentService.removeStuden(id);
	}
	@GetMapping("/getStudentById/{id}")
	public Student fetchById(@PathVariable Long id) {

		Student byId = studentService.getById(id);
		return byId;
	}
	@GetMapping("/getAllStudents")
	public List<Student> fetchAllStudents() {

		List<Student> all = studentService.getAllStudents();
		return all;
	}
	@GetMapping("/getStudentName/{name}")
	public Student fetchByName(@PathVariable String name) {

		Student byName = studentService.getByName(name);
		return byName;
	}
	@GetMapping("/getStudentByBranch/{branch}")
	public List<Student> fetchByBranch(@PathVariable String branch) {

		List<Student> byBranch = studentService.getByBranch(branch);
		return byBranch;
	}
	@GetMapping("/getStudentByPercentageGreaterThan/{percentage}")
	public List<Student> fetchByPercentageGreaterThan(@PathVariable double percentage) {

		List<Student> byPercentageGreaterThan = studentService.getByPercentageGreaterThan(percentage);
		return byPercentageGreaterThan;
	}

	//Pagination & Sorting
	@GetMapping("/allStudents")
	public Page<Student> fetchStudents(
			@RequestParam int page,
			@RequestParam int size,
			@RequestParam String sortBy,
			@RequestParam String direction) {

		Page<Student> students = studentService.getStudents(page, size, sortBy, direction);
		return students;
	}	
}
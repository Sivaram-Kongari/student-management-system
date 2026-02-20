package com.springboot.web.service;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import com.springboot.web.dto.StudentDTO;
import com.springboot.web.exception.StudentNotFoundException;
import com.springboot.web.model.Student;
import com.springboot.web.repo.StudentRepo;

@Component
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ModelMapper modelMapper;

	public Student insertStudent(StudentDTO studentDTO) {

		Student insert = modelMapper.map(studentDTO, Student.class);
		Student save = studentRepo.save(insert);
		return save;
	}
	public Student updateStudent(Long id, StudentDTO studentDTO) {

		Student existingStudent = studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with the given id : "+id));

		modelMapper.map(studentDTO, existingStudent);
		Student update = studentRepo.save(existingStudent);
		return update;
	}
	public void removeStuden(Long id) {

		Student student = studentRepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with the given id : "+id));

		studentRepo.delete(student);	
	}
	public Student getById(Long id) {


		//		Optional<Student> optionalStudent = studentRepo.findById(id);
		//
		//		Student byId;
		//		if (optionalStudent.isPresent()) {
		//			byId = optionalStudent.get();
		//		} else {
		//			throw new RuntimeException("Student not found");
		//		}
		//
		//		return byId;

		Student byId = studentRepo.findById(id).orElseThrow(() -> 
		new StudentNotFoundException("Student not found with id : "+id));

		return byId;
	}
	public List<Student> getAllStudents() {

		List<Student> allStudents = studentRepo.findAll();
		return allStudents;
	}
	public Student getByName(String name) {

		Student byName = studentRepo.findByName(name);
		return byName;
	}
	public List<Student> getByBranch(String branch) {

		List<Student> byBranch = studentRepo.findByBranch(branch);
		return byBranch;
	}
	public List<Student> getByPercentageGreaterThan(double percentage) {

		List<Student> byPercentageGreaterThan = studentRepo.findByPercentageGreaterThan(percentage);
		return byPercentageGreaterThan;
	}

	// Pagination & Sorting
	public Page<Student> getStudents(int page, int size, String sortBy, String direction) {

		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return studentRepo.findAll(pageable);
	}
}
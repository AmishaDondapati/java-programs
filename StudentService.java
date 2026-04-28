package com.StudentMarks.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.StudentMarks.Entity.StudentMarks;

public interface StudentService 
{
	StudentMarks save(StudentMarks studentmarks);
	
	Iterable<StudentMarks> saveAll(Iterable<StudentMarks> studentmarks);

	String deleteById(long id);

	Iterable<StudentMarks> findAll();

	String deleteAll();

	Optional<StudentMarks> findById(long id);

	boolean existsById(long id);

	List<StudentMarks> findByNameAndTotal(String name, double total);

	List<StudentMarks> findByNameOrId(String name, long id);

	List<StudentMarks> findByIdBetween(int start, int end);

	List<StudentMarks> findByIdGreaterThan(int num);

	List<StudentMarks> findByIdLessThan(long id);

	List<StudentMarks> findByNameLike(String name);

	List<StudentMarks> sort(String field);

	Page<StudentMarks> paginate(int page, int size);

	List<StudentMarks> findByNameNative(String name);
}

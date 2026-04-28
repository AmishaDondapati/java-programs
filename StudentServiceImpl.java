package com.StudentMarks.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.StudentMarks.Entity.StudentMarks;
import com.StudentMarks.Repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository repo;
	
	@Override
	public StudentMarks save(StudentMarks studentmarks) 
	{

		return repo.save(studentmarks);
	}

	@Override
	public Iterable<StudentMarks> saveAll(Iterable<StudentMarks> studentmarks) 
	{
		return repo.saveAll(studentmarks);
	}
	
	public String deleteById(long id) 
	{
		repo.deleteById(id);
		return " deleted Successfully";
	}

	@Override
	public String deleteAll() 
	{
		repo.deleteAll();
		return "all the data deleted successfully";
	}
	
	@Override
	public Iterable<StudentMarks> findAll() 
	{
		return repo.findAll();
	}


	@Override
	public Optional<StudentMarks> findById(long id) 
	{
		return repo.findById(id);
	}

	@Override
	public boolean existsById(long id) 
	{
		return repo.existsById(id);
	}

	@Override
	public List<StudentMarks> findByNameAndTotal(String name, double total) 
	{
		return repo.findByNameAndTotal(name, total);
	}

	@Override
	public List<StudentMarks> findByNameOrId(String name, long id) 
	{
		return repo.findByNameOrId(name, id);
	}

	@Override
	public List<StudentMarks> findByIdBetween(int start, int end) 
	{
		return repo.findByIdBetween(start, end);
	}

	@Override
	public List<StudentMarks> findByIdGreaterThan(int num) 
	{
		return repo.findByIdGreaterThan(num);
	}

	@Override
	public List<StudentMarks> findByIdLessThan(long id) 
	{
		return repo.findByIdLessThan(id);
	}

	@Override
	public List<StudentMarks> findByNameLike(String name) 
	{
		return repo.findByNameLike(name);
	}

	@Override
	public List<StudentMarks> sort(String field) 
	{
		return repo.findAll(Sort.by(field));
	}

	@Override
	public Page<StudentMarks> paginate(int page, int size) 
	{
		PageRequest pageable=PageRequest.of(page, size);
		return repo.findAll(pageable);
	}

	@Override
	public List<StudentMarks> findByNameNative(String name) 
	{
		return repo.findByNameNative(name);
	}
	
}

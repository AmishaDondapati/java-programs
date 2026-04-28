package com.StudentMarks.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentMarks.Entity.StudentMarks;
import com.StudentMarks.Service.StudentService;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	//1. insert a row into table.
	@PostMapping("/save")
	public StudentMarks save(@RequestBody StudentMarks studentmarks)
	{
		return service.save(studentmarks);
	}
	
	// 2. insert multiple records
	@PostMapping("/insertAll")
	public Iterable<StudentMarks> saveAll(@RequestBody List<StudentMarks> studentmarks)
	{
		return service.saveAll(studentmarks);
	}
	
	// 3.delete a row by using id.
	@DeleteMapping("deleteid/{id}")
	public String deleteById(@PathVariable long id)
	{
		return service.deleteById(id);
	}
	
	// 4. delete all the data in the table.
	@DeleteMapping("/delete")
	public String deleteAll()
	{
		return service.deleteAll();
	}
	
	// 5.get all data from the table.
	@GetMapping("/findall")
	public Iterable<StudentMarks> findAll()
	{
		return service.findAll();
	}
	
	// 6.get the data present in the row by using id.
	@GetMapping("/findid/{id}")
	public Optional<StudentMarks> findById(@PathVariable long id)
	{
		return service.findById(id);
	}
	// 7. check if student exists or not.
	@GetMapping("/exists/{id}")
	public boolean existsById(@PathVariable long id)
	{
		return service.existsById(id);
	}
	
	//8. get the data using name and total // AND operator
	@GetMapping("/and/{name}/{total}")
	public List<StudentMarks> findByNameAndTotal(@PathVariable String name, @PathVariable double total)
	{
		return service.findByNameAndTotal(name, total);
	}
	
	//9. OR Operator
	@GetMapping("/or/{name}/{id}")
	public List<StudentMarks> findByNameOrId(@PathVariable String name, @PathVariable long id)
	{
		return  service.findByNameOrId(name, id);
	}
	
	//10. between
	@GetMapping("/between/{start}/{end}")
	public List<StudentMarks> findByIdBetween(@PathVariable int start, @PathVariable int end)
	{
		return service.findByIdBetween(start,end);
	}
	
	// 11. greater than
	@GetMapping("/greater/{num}")
	public List<StudentMarks> findByIdGreaterThan(@PathVariable int num)
	{
		return service.findByIdGreaterThan(num);
	}
	
	//12. less than
	@GetMapping("/lessthan/{id}")
	public List<StudentMarks> findByIdLessThan(@PathVariable long id)
	{
		return service.findByIdLessThan(id);
	}
	
	//13.like
	@GetMapping("/like/{name}")
	public List<StudentMarks> findByNameLike(@RequestParam String name)
	{
		return service.findByNameLike(name);
	}
	
	//14. using sort
	@GetMapping("/sort")
	public List<StudentMarks> sort(@RequestParam String field)
	{
		return service.sort(field);
	}
	
	//15. pagination
	@GetMapping("/page")
	public Page<StudentMarks> paginate(@RequestParam int page, int size)
	{
		return service.paginate(page, size);
	}
	
	//16. custom query
	@GetMapping("/custom")
	public List<StudentMarks> findByNameNative(@RequestParam String name)
	{
		return service.findByNameNative(name);
	}
}














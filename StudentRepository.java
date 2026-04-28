package com.StudentMarks.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentMarks.Entity.StudentMarks;
import java.util.List;


public interface StudentRepository extends JpaRepository<StudentMarks, Long> 
{
	List<StudentMarks> findByNameAndTotal(String name, double total);
	
	List<StudentMarks> findByNameOrId(String name, long id);
	
	List<StudentMarks> findByIdBetween(int start, int end);
	
	List<StudentMarks> findByIdGreaterThan(int num);
	
	List<StudentMarks> findByIdLessThan(long id);
	
	List<StudentMarks> findByNameLike(String name);
	
	@Query(value="SELECT * FROM StudentMarks where name=?1",nativeQuery=true)
	List<StudentMarks> findByNameNative(String name);
}

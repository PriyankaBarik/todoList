package com.pb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.pb.model.ToDo;

public interface ToDoRepo extends JpaRepository<ToDo, Long> {

//	@Query( value="SELECT t FROM TODOTABLE t  WHERE t.complete=false")
//	List<ToDo> findBynotDone();

}

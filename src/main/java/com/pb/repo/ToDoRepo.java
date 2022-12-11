package com.pb.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pb.model.ToDo;

public interface ToDoRepo extends JpaRepository<ToDo, Long> {

	List<ToDo> findByComplete(boolean complete);

}

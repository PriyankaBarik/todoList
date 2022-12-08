package com.pb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pb.model.ToDo;
import com.pb.repo.ToDoRepo;


@Service
public class ToDoService {

	@Autowired
	ToDoRepo toDoRepo;

	public void createtoDo(ToDo toDoModel) {
		toDoRepo.save(toDoModel);

	}

	public void updateToDo(Long id, ToDo updatedModel) {
		ToDo todo = toDoRepo.findById(id).get();

		todo.setDescription(updatedModel.getDescription());
		todo.setDueDate(updatedModel.getDueDate());
		todo.setCreatedDate(updatedModel.getCreatedDate());
		todo.setModifiedDate(updatedModel.getModifiedDate());

		toDoRepo.save(todo);
	}

	public List<ToDo> getAllToDOList() {
		return (List<ToDo>) toDoRepo.findAll();
	}

	public void setTaskCompleted(Long id) {
		ToDo todo = toDoRepo.findById(id).get();
		if(id==null) {
		System.out.println("id is not presennt");
		}
		todo.setComplete(true);
		toDoRepo.save(todo);
	}

	public void setTaskNotCompleted(Long id) {
		ToDo todo = toDoRepo.findById(id).get();
		if(id==null) {
		System.out.println("id is not presennt");
		}
		todo.setComplete(false);
		toDoRepo.save(todo);
	}

//	public List<ToDo> getAllNotDoneList() {
//		
//		return toDoRepo.findBynotDone();
//	}

}

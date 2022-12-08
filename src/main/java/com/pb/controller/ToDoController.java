package com.pb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pb.common.ApiResponce;

import com.pb.model.ToDo;
import com.pb.service.ToDoService;

@Controller
public class ToDoController {
	@Autowired
	ToDoService toDoService;

	@PostMapping("/createtodo")
	public ResponseEntity<ApiResponce> createToDoList(@RequestBody ToDo toDoModel) {

		toDoService.createtoDo(toDoModel);
		return new ResponseEntity<>(new ApiResponce(true, "Created"), HttpStatus.OK);

	}

	@PostMapping("/edittodo/{id}")
	public ResponseEntity<ApiResponce> updateToDo(@RequestBody ToDo toDoModel, @PathVariable Long id, Model model) {

		toDoService.updateToDo(id, toDoModel);
		return new ResponseEntity<>(new ApiResponce(true, "updated"), HttpStatus.OK);
	}

	@GetMapping("/listoftodo")
	public ResponseEntity<List<ToDo>> getToDoList() {

		List<ToDo> todoItem = toDoService.getAllToDOList();
		return new ResponseEntity<>(todoItem, HttpStatus.OK);
	}

	@GetMapping("/getByid/{id}")
	public ResponseEntity<Optional<ToDo>> getById(@PathVariable Long id) {

		Optional<ToDo> todoItem = toDoService.getById(id);
		return new ResponseEntity<>(todoItem, HttpStatus.OK);
	}

	@GetMapping("/markDone/{id}")
	public ResponseEntity<ApiResponce> setTaskCompleted(@PathVariable Long id) {
		toDoService.setTaskCompleted(id);
		return new ResponseEntity<>(new ApiResponce(true, "mark as done"), HttpStatus.OK);
	}

	@GetMapping("/markNotDone/{id}")
	public ResponseEntity<ApiResponce> setTaskNotCompleted(@PathVariable Long id) {
		toDoService.setTaskNotCompleted(id);
		return new ResponseEntity<>(new ApiResponce(true, "mark as done"), HttpStatus.OK);
	}

//	 @GetMapping("/notdonelist")
//	 public ResponseEntity<List<ToDo>> getNotdoneList(){
//			
//			List<ToDo> todoItem=toDoService.getAllNotDoneList();
//			return new ResponseEntity<>(todoItem,HttpStatus.OK);
//		}
}

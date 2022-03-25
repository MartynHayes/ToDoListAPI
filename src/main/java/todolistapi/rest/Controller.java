package todolistapi.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import todolistapi.domain.ToDoList;

@RestController
public class Controller {

	private Service service;

	public Controller(Service service) {
		super();
		this.service = service;
	}

	// create - Post
	@PostMapping("/create")
	public ResponseEntity<ToDoList> createMap(@RequestBody ToDoList newtdl) {
		return new ResponseEntity<ToDoList>(this.service.create(newtdl), HttpStatus.CREATED);
	}

	// readAll - Get
	@GetMapping("/get")
	public ResponseEntity<List<ToDoList>> readAllMap() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	// readOne - Get
	@GetMapping("/getby/{id}")
	public ResponseEntity<ToDoList> readByIdMap(@PathVariable("id") long id) {
		return new ResponseEntity<>(this.service.readById(id), HttpStatus.OK);
	}

	// update - Put
	@PutMapping("/update/{id}")
	public ResponseEntity<ToDoList> updateMap(@PathVariable("id") long id, @RequestBody ToDoList tdl) {
		return new ResponseEntity<>(this.service.update(tdl, id), HttpStatus.OK);
	}

	// delete - Delete
	@DeleteMapping("/delete/{id}")
	public void deleteMap(@PathVariable("id") long id) {
		this.service.delete(id);
	}
}

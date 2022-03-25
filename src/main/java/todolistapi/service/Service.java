package todolistapi.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import todolistapi.domain.ToDoList;
import todolistapi.repo.Repo;

@org.springframework.stereotype.Service
public class Service {

	private Repo repo;

	public Service(Repo repo) {
		super();
		this.repo = repo;
	}

	// create - logic
	public ToDoList create(ToDoList newtodolist) {
		return this.repo.save(newtodolist);
	}

	// readAll - get logic
	public List<ToDoList> readAll() {
		return this.repo.findAll();
	}

	// readOne - getOne logic
	public ToDoList readById(@PathVariable("id") long id) {
		return this.repo.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	// Update
	public ToDoList update(@RequestBody ToDoList newtodolist, @PathVariable("id") long id) {
		ToDoList updatedTDL = repo.getById(id);
		updatedTDL.setTaskName(newtodolist.getTaskName());
		updatedTDL.setTaskDescription(newtodolist.getTaskDescription());
		updatedTDL.setTaskPriority(newtodolist.getTaskPriority());
		updatedTDL.setIsComplete(newtodolist.getIsComplete());
		return repo.save(updatedTDL);
	}

	// Delete
	public void delete(long id) {
		this.repo.deleteById(id);
	}
}

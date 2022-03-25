package todolistapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todolistapi.domain.ToDoList;

@Repository
public interface Repo extends JpaRepository<ToDoList, Long> {

}

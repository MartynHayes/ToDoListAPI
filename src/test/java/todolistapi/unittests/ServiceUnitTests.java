package todolistapi.unittests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import todolistapi.domain.ToDoList;
import todolistapi.repo.Repo;
import todolistapi.service.Service;

@SpringBootTest
class ToDoListServiceTests {

	@Autowired
	private Service service;

	@MockBean
	private Repo repo;

	@Test
	public void testCreate() {
		ToDoList testTDL = new ToDoList("Homework", "Maths", "High", false);
		ToDoList createdTDL = new ToDoList(1L, "Homework", "Maths & CS", "High", false);

		Mockito.when(this.repo.save(testTDL)).thenReturn(createdTDL);

		assertThat(this.repo.save(testTDL)).isEqualTo(createdTDL);
		Mockito.verify(this.repo, Mockito.times(1)).save(testTDL);
	}

	@Test
	public void testReadAll() {
		Mockito.when(repo.findAll())
				.thenReturn(Stream
						.of(new ToDoList("Food shop", "List on fridge", "High", false),
								new ToDoList("Doc appointment", "4pm 3/06", "High", false))
						.collect(Collectors.toList()));
		assertThat(2).isEqualTo(repo.findAll().size());
		verify(repo, times(1)).findAll();
	}

	@Test
	public void testreadById() {
		Optional<ToDoList> testTDL = Optional.of(new ToDoList(1L, "Shop", "Eggs, bread.", "Medium", false));
		Mockito.when(repo.findById(1L)).thenReturn(testTDL);
		assertThat(testTDL).isEqualTo(repo.findById(1L));
		verify(repo, times(1)).findById(1L);
	}

	@Test
	public void testUpdate() {
		final ToDoList tdl = new ToDoList(1L, "Shop", "Buy eggs", "Medium", false);
		final ToDoList updatedTDL = new ToDoList(1L, "Shop", "Buy eggs", "Medium", true);

		Mockito.when(repo.save(tdl)).thenReturn(updatedTDL);

		assertThat(repo.save(tdl)).isEqualTo(updatedTDL);
		verify(repo, times(1)).save(tdl);
	}

	@Test
	public void updateTest() {
		ToDoList newtdl = new ToDoList(1L, "Shop", "Buy eggs", "Medium", false);
		ToDoList updatedTDL = new ToDoList(1L, "Shop", "Buy eggs", "Medium", true);

		Mockito.when(repo.getById(1L)).thenReturn(newtdl);
		newtdl.setTaskName(updatedTDL.getTaskName());
		newtdl.setTaskDescription(updatedTDL.getTaskDescription());
		newtdl.setTaskPriority(updatedTDL.getTaskPriority());
		newtdl.setIsComplete(updatedTDL.getIsComplete());

		assertThat(repo.getById(1L)).isEqualTo(updatedTDL);
		verify(repo, times(1)).getById(1L);
	}

	@Test
	public void updateT() {
		ToDoList newtdl = new ToDoList(1L, "Shop", "Buy eggs", "Medium", false);
		ToDoList updatedTDL = new ToDoList(1L, "Shop", "Buy eggs", "Medium", true);

		Mockito.when(repo.getById(1L)).thenReturn(updatedTDL);

		assertThat(repo.getById(1L)).isEqualTo(updatedTDL);
		verify(repo, times(1)).getById(1L);
	}

	@Test
	public void testDelete() {
		ToDoList tdl = new ToDoList(1L, "Shop", "Buy eggs", "Medium", false);
		Mockito.when(repo.getById(1L)).thenReturn(tdl);

		repo.deleteById(1L);

		boolean notExistAfterDelete = repo.findById(1L).isPresent();

		assertThat(notExistAfterDelete).isFalse();
		verify(repo, times(1)).deleteById(1L);
	}
}
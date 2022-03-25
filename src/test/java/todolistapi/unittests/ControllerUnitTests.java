package todolistapi.unittests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import todolistapi.domain.ToDoList;
import todolistapi.rest.Controller;
import todolistapi.service.Service;

@SpringBootTest
public class ControllerUnitTests {

	@MockBean
	private Service service;

	@Autowired
	private Controller controller;

	@Test
	public void testCreate() {
		ToDoList testTDL = new ToDoList("Homework", "Maths & CS", "High", false);
		ToDoList createdTDL = new ToDoList(1L, "Homework", "Maths & CS", "High", false);

		Mockito.when(service.create(testTDL)).thenReturn(createdTDL);

		assertThat(createdTDL).isEqualTo(service.create(testTDL));

		verify(service, times(1)).create(testTDL);
	}

	@Test
	public void testReadAll() {
		Mockito.when(service.readAll())
				.thenReturn(Stream
						.of(new ToDoList("Food shop", "List on fridge", "High", false),
								new ToDoList("Doc appointment", "4pm 3/06", "High", false))
						.collect(Collectors.toList()));
		assertThat(2).isEqualTo(service.readAll().size());
		verify(service, times(1)).readAll();
	}

	@Test
	public void testreadById() {
		ToDoList testTDL = new ToDoList(1L, "Shop", "Eggs, bread.", "Medium", false);
		Mockito.when(service.readById(1)).thenReturn(testTDL);
		assertThat(testTDL).isEqualTo(service.readById(1L));
		verify(service, times(1)).readById(1L);
	}

	@Test
	public void testUpdate() {
		final ToDoList tdl = new ToDoList(1L, "Shop", "Buy eggs", "Medium", false);
		final ToDoList updatedTDL = new ToDoList(1L, "Shop", "Buy eggs", "Medium", true);

		Mockito.when(service.update(tdl, 1)).thenReturn(updatedTDL);

		assertThat(service.update(tdl, 1L)).isEqualTo(updatedTDL);
		verify(service, times(1)).update(tdl, 1L);
	}

	@Test
	public void testDelete() {
		ToDoList tdl = new ToDoList(1L, "Clean car", "Wash ferrari", "Low", false);
		service.delete(1L);
		verify(service, times(1)).delete(1L);
	}
}

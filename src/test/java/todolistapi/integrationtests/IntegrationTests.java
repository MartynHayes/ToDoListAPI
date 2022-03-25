package todolistapi.integrationtests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import todolistapi.domain.ToDoList;
import todolistapi.repo.Repo;
import todolistapi.service.Service;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private Service service;

	@Autowired
	private Repo repo;

	private final ToDoList testTDL = new ToDoList(2L, "Tickets", "Book 3 festival tickets", "High", false);

	@Test
	public void integrationTestCreate() throws JsonProcessingException, Exception {
		String resultString = this.mockMvc
				.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(testTDL)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		ToDoList result = this.objectMapper.readValue(resultString, ToDoList.class);
		assertThat(result).isEqualTo(testTDL);
	}

	@Test
	public void integrationTestReadAll() throws Exception {
		List<ToDoList> listTDL = new ArrayList<>();
		listTDL.add(new ToDoList(1L, "Wash up", "Do all the dishes", "Low", false));
		listTDL.add(new ToDoList(2L, "Wash car", "Clean car on the driveway", "Low", false));
		listTDL.add(new ToDoList(3L, "Hoover", "Hoover whole house", "Medium", false));

		Mockito.when(service.readAll()).thenReturn(listTDL);
		String url = "/get";

		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);

		String expectedJsonResponse = objectMapper.writeValueAsString(listTDL);

		assertThat(actualJsonResponse).isEqualToNormalizingWhitespace(expectedJsonResponse);
	}

	@Test
	public void integrationTestReadById() throws Exception {

		Mockito.when(service.readById(2)).thenReturn(testTDL);
		String url = "/getby/2";

		MvcResult mvcResult = mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();

		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		System.out.println(actualJsonResponse);

		String expectedJsonResponse = objectMapper.writeValueAsString(testTDL);

		assertThat(actualJsonResponse).isEqualToNormalizingWhitespace(expectedJsonResponse);
	}

	@Test
	public void integrationTestUpdate() throws Exception {
		final ToDoList newTDL = new ToDoList(1L, "Wash car", "Clean car on the driveway", "Low", false);
		String resultString = this.mockMvc
				.perform(put("/update/2").contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsString(testTDL)))
				.andExpect(status().isOk()).andReturn().getRequest().getContentAsString();

		ToDoList result = this.objectMapper.readValue(resultString, ToDoList.class);
		assertThat(result).isEqualTo(testTDL);
	}

	@Test
	public void integrationTestDelete() throws Exception {
		Long id = (long) 1;

		Mockito.doNothing().when(service).delete(id);
		String url = "/delete/" + id;

		mockMvc.perform(delete(url)).andExpect(status().isOk());
		Mockito.verify(service, times(1)).delete(id);
	}
}
package todolistapi.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class ToDoList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String taskName;
	private String taskDescription;
	private String taskPriority;
	private Boolean isComplete;

	public ToDoList() {
		super();
	}

	public ToDoList(Long id, String taskName, String taskDescription, String taskPriority, Boolean isComplete) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.isComplete = isComplete;
	}

	public ToDoList(String taskName, String taskDescription, String taskPriority, Boolean isComplete) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.isComplete = isComplete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(Boolean isComplete) {
		this.isComplete = isComplete;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, isComplete, taskDescription, taskName, taskPriority);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoList other = (ToDoList) obj;
		return Objects.equals(id, other.id) && Objects.equals(isComplete, other.isComplete)
				&& Objects.equals(taskDescription, other.taskDescription) && Objects.equals(taskName, other.taskName)
				&& Objects.equals(taskPriority, other.taskPriority);
	}

	@Override
	public String toString() {
		return "ToDoListDomain [id=" + id + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskPriority=" + taskPriority + ", isComplete=" + isComplete + "]";
	}
}

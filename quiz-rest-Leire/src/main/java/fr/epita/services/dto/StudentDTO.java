package fr.epita.services.dto;

import fr.epita.datamodel.Student;

public class StudentDTO {

	// ATTRIBUTES

	private int id;
	private String name;

	// GETTERS

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// SETTERS

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// FUNCTIONS

	public Student toDataModel() {
		Student stu = new Student();
		stu.setId(this.id);
		stu.setName(this.name);
		return stu;
	}

	public StudentDTO fromDataModel(Student student) {
		this.name = student.getName();
		this.id = student.getStudentId();
		return this;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + "]";
	}

}

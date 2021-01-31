package fr.epita.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
public class Student {

	// ATTRIBUTES

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SID")
	private Integer studentId;

	@Column(name = "STUDENT_NAME")
	private String name;
	
	@Column(name = "STUDENT_EMAIL")
	private String email;
	
	@Column(name = "SCORE")
	private Integer score;

	// CONSTRUCTORS

	public Student() {

	}

	public Student(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// GETTERS

	public Integer getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Integer getScore() {
		return score;
	}

	// SETTERS

	public void setId(Integer studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}

	// FUNCTIONS
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", score=\" + score]";
	}

}

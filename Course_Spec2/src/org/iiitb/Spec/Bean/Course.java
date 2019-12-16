package org.iiitb.Spec.Bean;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;
@Entity

public class Course {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int course_id;
    @NotNull @Column(unique=true)
    private String course_code;
	private String course_name;
    private int credits;
    private int course_num_students;
    @JsonIgnore
    @ManyToMany(mappedBy="spec_course",fetch = FetchType.LAZY,cascade=CascadeType.REMOVE)
    
    private Collection<Specilisation> spec=new ArrayList<Specilisation>();
    public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public int getCourse_num_students() {
		return course_num_students;
	}
	public void setCourse_num_students(int course_num_students) {
		this.course_num_students = course_num_students;
	}
	public Collection<Specilisation> getSpec() {
		return spec;
	}
	public void setSpec(Collection<Specilisation> spec) {
		this.spec = spec;
	}





}
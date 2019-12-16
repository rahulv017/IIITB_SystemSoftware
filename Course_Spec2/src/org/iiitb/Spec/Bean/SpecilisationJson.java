package org.iiitb.Spec.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class SpecilisationJson {

   
    private int spec_id;
    private String spec_name;
    private  String spec_target_dept;
    private  int spec_min_credit;
    
   private List<String> spec_course=new ArrayList<String>();
	public List<String> getSpec_course() {
		return spec_course;
	}
	public void setSpec_course(List<String> spec_course) {
		this.spec_course = spec_course;
	}
	public int getSpec_id() {
		return spec_id;
	}
	public void setSpec_id(int spec_id) {
		this.spec_id = spec_id;
	}
	public String getSpec_name() {
		return spec_name;
	}
	public void setSpec_name(String spec_name) {
		this.spec_name = spec_name;
	}
	public String getSpec_target_dept() {
		return spec_target_dept;
	}
	public void setSpec_target_dept(String spec_target_dept) {
		this.spec_target_dept = spec_target_dept;
	}
	public int getSpec_min_credit() {
		return spec_min_credit;
	}
	public void setSpec_min_credit(int spec_min_credit) {
		this.spec_min_credit = spec_min_credit;
	}
	
}

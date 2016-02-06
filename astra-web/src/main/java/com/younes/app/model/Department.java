package com.younes.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.DateTime;

import com.younes.app.model.adaptor.DateTimeAdapter;




@XmlRootElement
public class Department implements Serializable{
	
    private String name;
    private DateTime date;
    
    private List<Employee> employees = new ArrayList<Employee>();
 
    public Department() {
        // TODO Auto-generated constructor stub
    }
    @XmlAttribute
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    @XmlElement(name="employee")
    public List<Employee> getEmployees() {
        return employees;
    }
 
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    //@XmlElement(name = "timestamp", required = true) 
    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    public DateTime getDate() {
		return date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	@Override
    public String toString() {
        return "Department [name=" + name + ", employees=" + employees + "]";
    }
 
}
 

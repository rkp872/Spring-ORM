package com.SpringORM.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.SpringORM.entities.Student;

public class StudentDao	 
{
	private HibernateTemplate templtae;
	
	public HibernateTemplate getTempltae() {
		return templtae;
	}

	public void setTempltae(HibernateTemplate templtae) {
		this.templtae = templtae;
	}
	
	
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer)this.templtae.save(student);
		return i;
	}
	//get the single object
	public Student getStudent(int id)
	{
		Student student = this.templtae.get(Student.class, id);
		return student;
	}
	//get All students
	public List<Student> getAllStudents()
	{
		List<Student> students=this.templtae.loadAll(Student.class);
		return students;
	}
	//delete data
	@Transactional
	public void delete(int id)
	{
		Student student = this.templtae.get(Student.class, id);
		this.templtae.delete(student);
	}
	//updating data
	@Transactional
	public void updateStudent(Student student)
	{
		this.templtae.update(student);
	}
}

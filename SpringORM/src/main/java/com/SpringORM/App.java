package com.SpringORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.SpringORM.dao.StudentDao;
import com.SpringORM.entities.Student;


public class App 
{
	public static void main(String[] args)
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao dao = context.getBean("dao", StudentDao.class);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean go=true;
		while(go)
		{
			System.out.println("PRESS 1 : Add new Student");
			System.out.println("PRESS 2 : Display all Students");
			System.out.println("PRESS 3 : Display single Student");
			System.out.println("PRESS 4 : Delete Student");
			System.out.println("PRESS 5 : Update Student");
			System.out.println("PRESS 6 : Exit ");
			try 
			{
				int ch=Integer.parseInt(br.readLine());
				switch(ch)
				{
					case 1  : //add a student
						System.out.print("Enter User Id : ");
						int uid=Integer.parseInt(br.readLine());
						System.out.print("Enter User Name  :");
						String uName=br.readLine();
						System.out.print("Enter User city : ");
						String uCity=br.readLine();
						Student student=new Student(uid, uName, uCity);
						int r=dao.insert(student);
						System.out.println("Student with id "+r+"  added..");
						System.out.println("*****************************");
						System.out.println();
						break;
					case 2  : //Display all students
						System.out.println("****************************");
						List<Student> allStudents=dao.getAllStudents();
						for(Student std : allStudents)
						{
							System.out.println("Id : "+std.getId());
							System.out.println("Name : "+std.getName());
							System.out.println("City : "+std.getCity());
							System.out.println("_____________________________________");
						}
						System.out.println("*****************************");
						break;
					case 3  : //Display single student
						System.out.print("Enter User Id : ");
						int userid=Integer.parseInt(br.readLine());
						Student student2 = dao.getStudent(userid);
						System.out.println("Id : "+student2 .getId());
						System.out.println("Name : "+student2 .getName());
						System.out.println("City : "+student2 .getCity());
						System.out.println("_____________________________________");
						break;
					case 4: // Delete student
						System.out.print("Enter User Id : ");
						int id=Integer.parseInt(br.readLine());
						dao.delete(id);
						System.out.println("Student Deleted");
						break;
					case 5 ://update student
						System.out.print("Enter your User Id : ");
						int userId=Integer.parseInt(br.readLine());
						System.out.print("Enter User Name  :");
						String userName=br.readLine();
						System.out.print("Enter User city : ");
						String userCity=br.readLine();
						Student student3=new Student(userId, userName, userCity);
						dao.updateStudent(student3);
						System.out.println("Updated successfully");
						break;
					case 6 : //exit
						go=false;
						break;
				}
			} 
			catch (Exception e) {
				System.out.println("Invalid Input : Try with another one\n\n");
				e.getMessage();
			}
		}
		System.out.println("Thank You for Using My Application!!");
		
	}
}

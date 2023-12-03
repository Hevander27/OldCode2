package hgdaco;

import java.util.*;
public class grades {
	public static void main(String args [])
	{

	Scanner scan = new Scanner(System.in);

	Student s1 = new Student();

	System.out.print(" Enter student's name: ");
	String n1 = scan.next();
	s1.setName(n1);

	s1.inputGrades();
	System.out.println(s1.toString());
	
	
	
	Student s2 = new Student("Leo");
	s2.inputGrades();
	System.out.println(s2.toString());
	
	/*
	 * 
	System.out.print("Test score1: ");
	int score1 = scan.nextInt();
	System.out.print("Test score2: ");
	int score2 = scan.nextInt();
	*/

	

	}
}

class Student {
	Scanner scan = new Scanner(System.in);
	private String name;
	private int score1, score2;

	Student(String namePassed)
	{
		name = namePassed;
	}

	Student()
	{

	}

String getName()
{
	return name;
}
void setName(String nameUpdate)
{
	name = nameUpdate;
}

void inputGrades()
{
	System.out.print("Enter " + name +"'s"+ " score of test1: " );
	score1 = scan.nextInt();

	System.out.print("Enter " + name +"'s"+ " score of test2: " );
	score2 = scan.nextInt();
}

 int getAverage()
{
	int average = (score1 + score2)/2;
	return average;
}

 public String toString()
{
	return "Name: " + name + " Test1 " + score1 + " Test2 " + score2
			+ " The average score for "+ name +" "+ getAverage();
	
	

}

}


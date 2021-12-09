/*static members of a class can be accessed with class name directly
 * static keyword can be used to make a variable as the global varible
 * can use a static keyword for a method as that can be accessed with the class name
*/
package com.balaji.miscellaneous;


class Student{
	static int count= 0;
	String name;
	int marks;
	char section;
	static long all_student_marks=0;
	
	Student(String name, int marks, char section){
		this.name= name;
		this.marks= marks;
		this.section= section;
		count++;
		all_student_marks+= marks;
	}
}


class CountStudents{
	public static Student createStudent() {
		return new Student("Akhilesh", 59, 'C');
	}
	private void print(Object message) {
		System.out.println(message);
	}
	public void toCount(){
		Student st1= new Student("Rajesh", 35, 'A');
		Student st2= new Student("Mahesh", 78, 'B');
		System.out.println("Number of students after st1, st2: "+ Student.count);
		Student st3= new Student("Suresh", 65, 'A');
		System.out.println("Number of students after st3: "+Student.count);
		Student st4= createStudent();
		System.out.println("Number of students after st4 "+Student.count);
		Student st5= CountStudents.createStudent();
		System.out.println("Number of students after st5 "+Student.count);
		System.out.println("Print Marks: "+ st1.marks + " "+ st2.marks+ " "+ 
		st3.marks+ " "+ st4.marks + " " + st5.marks);
		print("Total Students: "+Student.count);
		System.out.println("All Students marks: "+ Student.all_student_marks);
	}
}

class StaticKeyword {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountStudents count= new CountStudents();
		count.toCount();
	}
}
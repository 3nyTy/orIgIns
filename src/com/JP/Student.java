package com.JP;

public class Student implements Comparable<Student> {
	
	private  int rank;
	private  String name;
	private  int marks;
	private  int percentage;
   public Student(int rank,String name,int marks,int percentage){
	   this.rank = rank;
	   this.name=name;
	   this.marks=marks;
	   this.percentage= percentage;
   }
public  int getRank() {
	return rank;
}
public  void setRank(int rank) {
	this.rank = rank;
}
public  String getName() {
	return name;
}

public  void setName(String name) {
	this.name = name;
}
public  int getMarks() {
	return marks;
}
public  void setMarks(int marks) {
	this.marks = marks;
}
public  int getPercentage() {
	return percentage;
}
public  void setPercentage(int percentage) {
	this.percentage = percentage;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + marks;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + percentage;
	result = prime * result + rank;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	if (marks != other.marks)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (percentage != other.percentage)
		return false;
	if (rank != other.rank)
		return false;
	return true;
}

@Override
public String toString() {
	return "Student [getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", Rank=" + this.rank + ", Name = " + this.name +" ,marks = "+this.marks + ", percentage = "+this.percentage +"]";
}
@Override
public int compareTo(Student o) {
	if(this.rank > o.getRank()) return 1;
	else if (this.rank < o.getRank()) return -1;
	return 0;
}

}

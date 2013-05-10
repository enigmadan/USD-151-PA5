/**
* File: Student.java
* @author Mingyu Chen
* @author Daniel Myers
* @version 5/9/13
* Description: Class to create and display a "Student" with a
* 5 to 15 char name and a gpa double.
* We found that we were able to get results between 
* O(n*log(n)/log(2)) and O(n*log(n))
*  
*/



import java.text.DecimalFormat;
import java.util.Random;


public class Student implements Comparable<Student> {
	
	private String name="";
	private double gpa;
	
	public Student(){
		//initiate randomness
		Random rand = new Random();
		//make a double of appealing roundness
		double gpaRand = rand.nextInt(4)+rand.nextDouble();
		DecimalFormat decim = new DecimalFormat("#.##");
		gpa = Double.parseDouble(decim.format(gpaRand));
		
		//number 5-16 not including 16
		int l = rand.nextInt(11)+5;
		
		
		
		for(int j = 0; j<l;j++){
			
			//random alphabetical char generator
			name+=(char)(rand.nextInt(26)+'a');
		}
		
		
		
		}
	/**
	 * Create an array of Student
	 *@param int number of Students wanted to fill array
	 * @return Student[]
	 */
	public static Student[] StudentAr(int num){
		Student[] stu = new Student[num];
		for(int i =0;i<num;i++){
			stu[i]= new Student();
		}
		return stu;
	}
	/**
	 * Compare two students to find the alphabetically/gpa-ically superior and inferior
	 *@param Student student with which to compare calling Student
	 * @return int 1 if > 0 if == and -1 if <
	 */
	public int compareTo(Student s) {
		int x = this.name.compareTo(s.name);
		if(x == 0){
			if(this.gpa>s.gpa){
				x = 1;
			}else if(this.gpa<s.gpa){
				x = -1;
			}else{
				x = 0;
			}
		}
		return x;
	}
	/**
	 * Writes a Student to a String for easy printing
	 * @return String
	 */
	public String toString(){
		return name+";"+gpa;
	}

	/**
	 * Main method creates Student Arrays, sorts them, and returns comparisons made.
	 */
public static void main(String[] args){
	Student[]   stud100 = StudentAr(100);
	Student[]   stud1000 = StudentAr(1000);
	Student[]   stud10000 = StudentAr(10000);
	Student[]   stud100000 = StudentAr(100000);
	
	System.out.println(Sort.quicksort(stud100));
	//Test sorting
	/*for(int i = 0;i<stud100.length;i++){
		System.out.print(stud100[i]+", ");
	}*/
	System.out.println(Sort.quicksort(stud1000));
	System.out.println(Sort.quicksort(stud10000));
	System.out.println(Sort.quicksort(stud100000));
	
	
	
}



	
}

import java.text.DecimalFormat;
import java.util.Random;


public class Student implements Comparable<Student> {
	
	private String name="";
	private double gpa;
	
	public Student(){
		Random rand = new Random();
		double gpaRand = rand.nextInt(4)+rand.nextDouble();
		DecimalFormat decim = new DecimalFormat("#.##");
		gpa = Double.parseDouble(decim.format(gpaRand));
		
		
		int l = rand.nextInt(11)+5;
		
		
		
		for(int j = 0; j<l;j++){
			
			
			name+=(char)(rand.nextInt(26)+'a');
		}
		
		
		
		}
	
	public static Student[] StudentAr(int num){
		Student[] stu = new Student[num];
		for(int i =0;i<num;i++){
			stu[i]= new Student();
		}
		return stu;
	}
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


public static void main(String[] args){
	Student[]   stud100 = StudentAr(100);
	Student[]   stud1000 = StudentAr(1000);
	Student[]   stud10000 = StudentAr(10000);
	Student[]   stud100000 = StudentAr(100000);
	
	System.out.println(Sort.quicksort(stud100));
	System.out.println(Sort.quicksort(stud1000));
	System.out.println(Sort.quicksort(stud10000));
	System.out.println(Sort.quicksort(stud100000));
	
	
	
}



	
}

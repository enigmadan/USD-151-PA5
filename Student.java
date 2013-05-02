import java.util.Random;


public class Student {
  String name = "";
	double gpa;
	private final double DOUBLE_MIN_NON_EXP = .000000000000001; //15 digits?

	public static void main(String[] args){
		System.out.println(new Student());
		Student[] studAr = StudentArray(10);
		for(int i = 0;i<studAr.length;i++){
			System.out.println(studAr[i]);
		}
	}
	public Student(){
		Random rand = new Random();
		name = "";

		gpa = rand.nextDouble()*(4+DOUBLE_MIN_NON_EXP);
		int nameLength = (rand.nextInt(11)+5);
		for(int i=0;i<nameLength;i++){
			name += (char)(rand.nextInt(26)+'a');
		}
	}
	public static Student[] StudentArray(int number){
		Student[] studAr = new Student[number];
		for(int i = 0; i<number;i++){
			studAr[i] = new Student();
		}
		return studAr;
	}
	public String toString(){
		return name+":"+gpa;
	}

}

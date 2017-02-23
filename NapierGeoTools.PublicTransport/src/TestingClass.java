import java.util.ArrayList;

public class TestingClass{
	
	static double a;
	
	public static void main(String args[]){
		TestingClass testingClass=new TestingClass();
		System.out.println(testingClass.getA());
		if(a == 0)
			System.out.println("gleich 0");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);
	}
	
	
	public double getA(){
		return a;
	}

}
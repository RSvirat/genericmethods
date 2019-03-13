package array;

import java.util.ArrayList;

public class genericsample {
	public static void main(String args[]) {
		GenericClass<Comparable> gc = new GenericClass<Comparable>();
		String name = "sudhakar";
		long num = 8608323839L;
		ArrayList<GenericClass> arl = new ArrayList<GenericClass>();
		gc.setName(name);
		gc.setNum(num);
		arl.add(gc):
		System.out.println("Name="+gc.getName());
		System.out.println("Number="+gc.getNum());
		System.out.println("arraysize="+arl.size());
	}
}

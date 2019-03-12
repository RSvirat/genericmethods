package array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class generic {
	public static void main(String...doYourBest ) {
		List<String> firstResult = generic.<String>get(new ArrayList<>(),new String("2"));
		List<Object> secondResult = generic.get("Home", Double.valueOf("4"));
		Stream<Object> stream = Stream.concat(firstResult.stream(), secondResult.stream());
		stream.forEach(System.out::println);
	}
	public static <T> List<T> get(List<T> list, T t) {
		list.add(t);
		return list;
		
	}
	public static<T,R extends T> List<T> get(T type1, R type2){
		List<T> list = new ArrayList<>();
		list.add(type1);
		list.add(type2);
		return list;
		
	}
}

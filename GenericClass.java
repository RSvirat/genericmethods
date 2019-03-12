package array;

public class GenericClass<T> {
	private T name;
	private T num;
	private T password;
	
	public void setName(T name) {
		this.name = name;
	}
	public T getName() {
		return name;
	}
	public void setNum(T num) {
		this.num = num;
	}
	public T getNum() {
		return num;
	}
	public void setPassword(T password) {
		this.password = password;
	}
	public T getPassword() {
		return password;
	}
}

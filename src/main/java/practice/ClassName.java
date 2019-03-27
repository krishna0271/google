package practice;

public class ClassName {

	public void methodName() {
		System.out.println(this.getClass().getSimpleName());
		System.out.println(this.getClass().getName());
	}

	public static void main(String[] args) {
		ClassName c = new ClassName();
		c.methodName();
	}
}

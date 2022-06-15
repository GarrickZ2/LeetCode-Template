import java.util.*;
import util.Utility;

public class Main {
	final static int a;
	static {
		a = 20;
	}

	public static void main(String[] args) {
		String a = "2333";
		String b = "2333";

		String c = new String("2333");
		String d = new String("2333");

		System.out.println(a + b + c+ d);
	}
}

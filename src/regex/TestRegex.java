package regex;

public class TestRegex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "WZB210_0.8.0";
		str = str.substring(str.lastIndexOf("_")+1);
		System.out.println(str);
	}

}

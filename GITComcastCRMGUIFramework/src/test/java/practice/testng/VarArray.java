package practice.testng;

import java.util.Arrays;

public class VarArray {
public int[] createArr(int...eles)
{
	return eles;
}
public static void main(String[] args) {
	VarArray va = new VarArray();
	int[] createArr = va.createArr(1);
	System.out.println(Arrays.toString(createArr));
	createArr =va.createArr(2);
	createArr =va.createArr(2);
	createArr =va.createArr(2);
	createArr =va.createArr(2);
}
}
 
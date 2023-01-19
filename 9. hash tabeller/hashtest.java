import java.io.BufferedReader;
import java.io.FileReader;

public class hashtest
{
	public static void main(String args[])
	{
		/*String fil = "postnummer.csv";
		//Zip z = new Zip(fil);
		//ZipInt z = new ZipInt(fil);
		//ZipInt2 z = new ZipInt2(fil);
		//ZipInt3 z = new ZipInt3(fil);
		ZipInt4 z = new ZipInt4(fil);

		//String code1 = "111 15";
		//String code2 = "994 99";

		Integer code1 = 11115;
		Integer code2 = 99499;

		Integer code3 = 98499;
		//String code3 = "984 99";


		boolean tf = z.linearLookup(code1);
		System.out.println(tf? "Exsist" : "Doesnt exsist");

		tf = z.linearLookup(code2);
		System.out.println(tf? "Exsist" : "Doesnt exsist");

		tf = z.linearLookup(code3);

		System.out.println(tf? "Exsist" : "Doesnt exsist");

		/*System.out.println("Binary");
		tf = z.binaryLookup(code1);

		System.out.println(tf? "Exsist" : "Doesnt exsist");

		tf = z.binaryLookup(code2);

		System.out.println(tf? "Exsist" : "Doesnt exsist");
*/
			/*z.collisions(10000);
			z.collisions(20000);
			z.collisions(30000);
			z.collisions(12345);
			z.collisions(56789);
			z.collisions(60000);*/

		String fil = "postnummer.csv";
		//Zip z = new Zip(fil);
		//ZipInt z = new ZipInt(fil);
		//ZipInt2 z = new ZipInt2(fil);
		//ZipInt3 z = new ZipInt3(fil);
		ZipInt4 z = new ZipInt4(fil);

		//String code1 = "111 15";
		//String code2 = "994 99";

		Integer code1 = 18642;
		//Integer code2 = 99499;
		Integer code2 = 97242;

		int max = 1000000;

		long t01 = 0;
		double t_total1 = 0;

		long t02 = 0;
		double t_total2 = 0;

		int tf = 0;
		tf = z.linearLookup(code1);
		//System.out.println(tf? "Exsist" : "Doesnt exsist");
		System.out.println(code1 + ": " + tf);

		tf = z.linearLookup(code2);
		//System.out.println(tf? "Exsist" : "Doesnt exsist");
		System.out.println(code2 + ": " + tf);

		for(int i = 0; i < max; i++)
		{
			t01 = System.nanoTime();
			tf = z.linearLookup(code1);
			//z.binaryLookup(code1);
			t_total1 += System.nanoTime() - t01;


			t02 = System.nanoTime();
			tf = z.linearLookup(code2);
			//z.binaryLookup(code1);
			t_total2 += System.nanoTime() - t02;

		}
		System.out.println("code1: " + t_total1/max + " ns" + "\tcode2: " + t_total2/max + " ns" );

	}
}
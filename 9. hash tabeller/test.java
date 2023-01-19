public class test
{
	public static void main(String args[])
	{
		String[] data = {"1", "2", "3", "12", "14", "15", "19", "25", "179", "345", "1111"};

		String code1 = "179";

		boolean tf = binaryLookup(data, code1);

		System.out.println(tf? "Exsist" : "Doesnt exsist");

		System.out.println("new");

		String code2 = "4";

		boolean tf2 = binaryLookup(data, code2);

		System.out.println(tf2? "Exsist" : "Doesnt exsist");
	}

	public static boolean binaryLookup(String[] data, String entry )
	{
		int mid = data.length / 2;
		int first = 0;
		int last = data.length - 1;

		while(true)
		{

			mid = (first + last) / 2;
			if(Integer.parseInt(data[mid]) < Integer.parseInt(entry))
			{
				System.out.println("first: " + first + "\tmid: " + mid + "\tlast. " + last);
				first = mid;
				mid = (first + last + 1) / 2;

			}
			else if(Integer.parseInt(data[mid]) > Integer.parseInt(entry))
			{
				System.out.println("first: " + first + "\tmid: " + mid + "\tlast. " + last);
				last = mid;
				mid = (first + last - 1) / 2;
			}
			else if(entry.equals(data[mid]))
				return true;
		}
		//return false;
	}

	public static void Print(String[] data, int start, int back)
	{
		System.out.print( "[ ");
		for(int i = start; i < back - 1; i++)
			System.out.print(data[i] + ", ");
		System.out.println(data[back - 1] + " ]");
	}
}
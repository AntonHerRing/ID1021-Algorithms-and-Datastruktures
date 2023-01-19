import java.io.BufferedReader;
import java.io.FileReader;

public class Zip
{
	Node[] data;
	int max;

	public class Node
	{
		String code;
		String name;

		Integer pop;

		Node next;

		public Node()
		{
			this.code = "";
			this.name = "";
			this.pop = null;
		}

		public Node(String row0, String row1, Integer value)
		{
			this.code = row0;
			this.name = row1;
			this.pop = value;
		}
	}

	public Zip(String file)
	{
		data = new Node[10000];

		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null)
			{
				String[] row = line.split(",");
				data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
			}
			max = i-1;
		} catch (Exception e){
			System.out.println(" file " + file + " not found");
		}
	}

	public boolean linearLookup( String entry )
	{
		for(int i = 0; i < data.length; i++)
			if(data[i] != null && entry.equals(data[i].code))
				return true;
		return false;
	}

	public boolean binaryLookup(String entry )
	{
		int mid = data.length / 2;
		int first = 0;
		int last = max;

		while(data[mid] != null)
		{
			if(data[mid].code.compareTo(entry) < 0)
			{
				first = mid;
				mid = (first + last + 1) / 2;
			}
			else if(data[mid].code.compareTo(entry) > 0)
			{
				last = mid;
				mid = (first + last - 1) / 2;
			}
			else if(data[mid] != null && entry.equals(data[mid].code))
				return true;
			else
				return false;
		}
		return false;
	}

}



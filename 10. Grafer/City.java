import java.io.BufferedReader;
import java.io.FileReader;

public class City
{
	public class Connection
	{
		City node;
		int distMin;

		public Connection(City n, int weight)
		{
			this.node = n;
			this.distMin = weight;
		}
	}

	String name;
	Connection[] neighbors;

	int i;

	public City(String n)
	{
		this.name = n;
		this.neighbors = new Connection[4];

		this.i = 0;
	}

	public void add(City dest, int dist)
	{
		Connection connected = new Connection(dest, dist);
		if(i >= neighbors.length)
		{
			Connection[] temp = new Connection[neighbors.length * 2];
			for(int j = 0; j < neighbors.length; j++)
				temp[j] = neighbors[j];
		}
		neighbors[i++] = connected;
	}

	public void lookup()
	{

	}
}
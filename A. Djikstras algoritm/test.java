public class test
{
	public static void main( String args[] )
	{
		String fil = "trains.csv";
		Map map = new Map(fil);

		int count = 1;
		for(int i = 0; i < map.cities.length; i++)
			if(map.cities[i] != null)
				for(int k = 0; k < map.cities[i].neighbors.length; k++)
					if(map.cities[i].neighbors[k] != null)
						System.out.println(count++ + ": " + "main: " + map.cities[i].name + "\t\tconnection: " + map.cities[i].neighbors[k].node.name + "\t\tdist: " + map.cities[i].neighbors[k].distMin);
	}
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Map
{
	public City[] cities;
	private final int mod = 541;

	public int min;

	int count;

	public Map(String file)
	{
		cities = new City[mod];
		City city1 = null;
		City city2 = null;
		count = 1;
		min = 0;

		try (FileInputStream fis = new FileInputStream(file);
       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
       BufferedReader br = new BufferedReader(isr))

		{
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] row = line.split(",");

				if(lookup(row[0]).name.equals("no"))
				{
					city1 = handling(row[0]);
					city1.number = count++;
				}
				else
					city1 = lookup(row[0]);

				if(lookup(row[1]).name.equals("no"))
				{
					city2 = handling(row[1]);
					city2.number = count++;
				}
				else
					city2 = lookup(row[1]);

				city1.add(city2, Integer.valueOf(row[2]));
				city2.add(city1, Integer.valueOf(row[2]));
			}
		} catch (Exception e)
		{
			System.out.println(" file " + file + " not found or corrupt");
		}
	}

	//unknown city
	public City handling(String city)
	{
		Integer index = hash(city);

		while(cities[index] != null)
			index++;
		cities[index] = new City(city);

		return cities[index];
	}

	private Integer hash(String name)
	{
		int hash = 7;
		for (int i = 0; i < name.length(); i++)
			hash = (hash*31 % mod) + name.charAt(i);
		return hash % mod;
	}

	public City lookup( String name)
	{
		Integer index = hash(name);
		while(index < cities.length)
		{
			if(cities[index] != null && cities[index].name.equals(name))
				return cities[index];
			else
				index++;
		}
		return new City("no");
	}

	public Integer shortest(City from, City to, Integer max)
	{
		min = max;
		shortest(from, to, max, max);
		return min;
	}

	public Integer shortest(City from, City to, Integer max, Integer limit)
	{
		if (max < 0)
			return null;
		if (from == to){
			//if((limit - max) < min)
			//	min = (limit - max);
			return 0;
		}
		int minimum = max;
		City stad = null;

		Integer shrt = null;

		for (int i = 0; i < from.neighbors.length; i++)
		{
			if (from.neighbors[i] != null)
			{
				City.Connection conn = from.neighbors[i];
				stad = conn.node;
				//shrt = conn.distMin;

				//if((max - shrt) >= 0)
				//	shrt = shortest(stad, to, max - shrt, limit);

				if(minimum > conn.distMin)
					minimum = conn.distMin;

			}
		}
		if(limit > max)
			shrt = shortest(stad, to, max - minimum, limit);

		return limit - max;
	}
}

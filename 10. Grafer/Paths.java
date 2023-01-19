public class Paths
{
	public City[] path;
	int sp;

	Integer min;

	public Paths()
	{
		min = 0;
		path = new City[54];
		sp = 0;
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
			if((limit - max) < min)
				min = (limit - max);
			//System.out.println("arrived: " + (limit - max) + " min");
			return 0;
		}

		Integer shrt = null;

		for (int i = 0; i < from.neighbors.length; i++)
		{
			if (from.neighbors[i] != null)
			{
				for (int j = 0; j < sp; j++)
				{
					if (path[j] == from)
					{
						//System.out.println("");
						return null;
					}
				}
				if(sp < path.length -1)
					path[sp++] = from;

				City.Connection conn = from.neighbors[i];
				City stad = conn.node;
				shrt = conn.distMin;

				//System.out.println("now: " + stad.name + "\t\tcurr: " + (limit - max) + "\t\tgoal: " + to.name);

				if((max - shrt) >= 0)
					shrt = shortest(stad, to, (max - shrt), limit);

				if(sp > 0)
					path[sp--] = null;
			}
		}
		//System.out.println(sp);
		return shrt;
	}

	public Integer Fshortest(City from, City to)
	{
		min = null;
		Fshortest(from, to, 0);
		return min;
	}

	public Integer Fshortest(City from, City to, Integer max)
	{
		if (max < 0)
			return null;
		if (from == to)
		{
			if(min == null || max < min)
				min =  max;
			return 0;
		}

		Integer shrt = null;

		for (int i = 0; i < from.neighbors.length; i++)
		{
			if (from.neighbors[i] != null)
			{
				for (int j = 0; j < sp; j++)
					if (path[j] == from)
						return null;
				if(sp < path.length -1)
					path[sp++] = from;

				City.Connection conn = from.neighbors[i];
				City stad = conn.node;
				shrt = conn.distMin;

				//System.out.println("now: " + stad.name + "\t\tcurr: " + (max + shrt) + "\t\tshrt: " + shrt + "\t\tlim: " + min+ "\t\tgoal: " + to.name);

				if(min == null)
					shrt = Fshortest(stad, to, (max + shrt));
				else if(min != null && (max + shrt) < min)
					shrt = Fshortest(stad, to, (max + shrt));

				if(sp > 0)
					path[sp--] = null;
			}
		}
		return shrt;
	}
}
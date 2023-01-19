public class Naive
{
	public static void main(String[] args)
	{
		Map map = new Map("trains.csv");

		Paths path = new Paths();

		//System.out.println("begin");

		String from = "Malmö";
		String to = "Göteborg";
		Integer max = 500;

		//System.out.println(map.lookup(from).name);


		long t0 = System.nanoTime();
		Integer dist = map.shortest(map.lookup(from), map.lookup(to), max, max);
		//Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
		//Integer dist = path.Fshortest(map.lookup(from), map.lookup(to));
		long time = (System.nanoTime() - t0)/1_000;

		System.out.println("shortest: " + dist + " min (" + time/1000 + " ms)");
		System.out.println("shortest: " + dist+ " min (" + time + " us)");

		System.out.print("[ ");
		for(int i = 0; i < path.path.length - 1; i++)
			if(path.path[i] != null)
				System.out.print(path.path[i].name + " - ");
		if(path.path[path.path.length - 1] != null)
			System.out.println(path.path[path.path.length - 1].name + " - ");
	}

	/*private static Integer shortest(City from, City to, Integer max)
	{
		if (max < 0)
			return null;
		if (from == to){
			System.out.println("arrived: " + max + " min");

			System.out.println("");
			return 0;
		}


		Integer shrt = null;

		for (int i = 0; i < from.neighbors.length; i++)
		{

			if (from.neighbors[i] != null)
			{
				City.Connection conn = from.neighbors[i];
				City stad = conn.node;
				shrt = conn.distMin;
				//System.out.println("now: " + stad.name + "\t\tcurr: " + shrt + "\t\tgoal: " + to.name);
				//if((max - shrt) >= 0)
					//shrt = max - shrt;

				shrt = shortest(stad, to, max);
			}
		}
		return shrt;
	}*/
}
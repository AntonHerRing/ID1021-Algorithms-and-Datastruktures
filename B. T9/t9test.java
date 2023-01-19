public class t9test
{
	public static void main( String args[] )
	{
		String fil = "kelly.txt";
		//t9 text = new t9(fil);
		//t93 text = new t93(fil);
		//t9final text = new t9final(fil);
		t9finaltest text = new t9finaltest(fil);

		/*System.out.println(text.toCode("s", 0));
		System.out.println(text.toCode("p", 0));
		System.out.println(text.toChar(0));
		System.out.println(text.toIndex("6", 0));*/

		//text.add("andra");

		//t93.Node nxt = text.root;
		//System.out.println("root: " + nxt);

		//nxt = nxt.next[16].next[24];
		//System.out.println("a: " + nxt.next[17].count + " " + nxt.next[17].next[25].count + " " + nxt.next[17].next[25].next[10].count  + " " + nxt.next[17].next[25].next[10].next[4].count);
		//System.out.println("15: " + nxt.next[15].count);
		//nxt = nxt.next[25];

		//if(nxt == null)
		//	System.out.println("bruh");


		//System.out.println(nxt.word);
		//text.lookup("");

		//String[] s = text.lookup("15261");
		//String[] s = text.lookup("6942632766543734");
		//String[] s = text.lookup("356342653536726");
		//String s = text.lookup("1");

		for(int i = 0; i < text.data.length; i++)
		{
			String[] s = text.lookup(text.data[i]);
			System.out.println(s[0]);
		}

		System.out.println(text.toKey("inrikesminister"));

		String nstr = "";
		System.out.println("final word: ");

		/*for(int i = 0; i < s.length; i++)
		{
			if(s[i] != null)
				System.out.println(s[i]);
		}*/
	}
}
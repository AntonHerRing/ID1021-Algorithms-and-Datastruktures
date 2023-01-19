import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class t93
{
	public class Node
	{
		public Node[] next;
		public boolean word;
		public int test;

		public int count;

		public Node()
		{
			next = new Node[27];
			word = false;
			test = -1;
			count = 0;
		}
	}

	String[] data;
	int max;

	int counting;

	Node root;

	String[] saved;
	int index = 0;


	//String[] s;
	public t93(String file)
	{
		data = new String[8262];
		saved = new String[10];
		root = new Node();
		counting = 0;
		System.out.println("root making: "+root.test);
		//s = "";

		try (FileInputStream fis = new FileInputStream(file);
       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
       BufferedReader br = new BufferedReader(isr))
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null)
			{
				add(line);
				//System.out.println(line);
			}
			max = i-1;
		} catch (Exception e){
			System.out.println(" file " + file + " not found");
		}
		System.out.println("root test: "+root.next[0].test);
	}

	public void add( String s)
	{
		int index = 0;

		Node nxt = root;
		for(int i = 0; i < s.length(); i++)
		{
			index =  toCode(s, i);
			//System.out.println(toChar(index));

			if(nxt.next[index] == null){
				counting++;
				nxt.next[index] = new Node();
				nxt.next[index].test = index;
				nxt.next[index].count = counting;
				//System.out.println(index + " : " +toChar(index));
			}
			nxt = nxt.next[index];
		}
		nxt.word = true;
		//System.out.println(index + " : " + nxt.word);
	}

	public String[] lookup(String key)
	{
		return lookup(key, 0, "", root, root);
	}

	public String[] lookup(String key, int i, String save, Node temp, Node pre)
	{
		int index = 0;
		Node nxt = temp;
		Node prev = pre;
		String s = save;

		if(s.length() == key.length() && nxt.word == true )
				saved[0] = s;

		System.out.println("i: "+i );
		System.out.println("start: "+nxt.count );
		System.out.println("root: "+root.test );

		System.out.println(i + "<" + key.length());
		System.out.println(s);
		System.out.println("does word exist: " + nxt.word);

		if( i < key.length() )
		{
			index = toIndex(key, i);

			System.out.println("Before");

			//if(i <= 0)
			//	nxt = root;

			System.out.println("index: " + (index * 3) + "\t"+index);
			System.out.println("innan: " + nxt.test + " " +  nxt.count);
			System.out.println(nxt.next[index * 3]);
			if(nxt.next[index * 3] != null )
			{
				System.out.println("index: " + index * 3);
				prev = nxt;
				nxt = nxt.next[index * 3];
				System.out.println("i: " + i);


 				s += toChar(index*3);
 				System.out.println(s);
 				System.out.println("i: " + i);
 				System.out.println("bef1: "+nxt.test + " " +  nxt.count);
 				//i++;
 				++i;
				lookup(key, i, s, nxt, prev);
				nxt = prev;

				System.out.println("aft1: " + nxt.test + " " +  nxt.count);
				System.out.println("i: " + i);

				if(i < key.length() && i > 0){
					--i;
					index = toIndex(key, i);
				}
				System.out.println(s);

				s = s.substring(0, s.length() - 1);
				System.out.println(s);
			}
			System.out.println("mellan1");
			System.out.println(index * 3 + 1);
			System.out.println("i: " + i);
			//if( i - 1 <= 0)
			//nxt = root;

			System.out.println("innan1: " + nxt.test + " " +  nxt.count);
			if(nxt.next[index * 3 + 1] != null) //kan ej skriva ut n
			{
				System.out.println("index + 1: " + (index * 3 + 1));
				prev = nxt;
				nxt = nxt.next[index * 3 + 1];
				System.out.println("i: " + i);

				s += toChar(index*3 + 1);
				System.out.println(s);
				System.out.println("bef2: "+nxt.test + " " +  nxt.count);
				//i++;
				++i;

				lookup(key, i, s, nxt, prev);
				nxt = prev;

				System.out.println("aft2: " + nxt.test + " " +  nxt.count);
				System.out.println("i: " + i );

				if(i < key.length() && i > 0)
				{
					--i;
					index = toIndex(key, i);
				}
				System.out.println("newindex: " + index);


				s = s.substring(0, s.length() - 1);
				System.out.println(s);
			}
			//if(i <= 0)
			//	nxt = root;
			System.out.println(s);
			System.out.println("mellan2");
			System.out.println(index * 3 + 2);
			System.out.println(nxt.next[index * 3 + 2] );


			System.out.println("innan2: " + nxt.test + " " +  nxt.count);
			if(nxt.next[index * 3 + 2] != null)
			{
				System.out.println("index + 2: " + (index * 3 + 2));
				prev = nxt;
				nxt = nxt.next[index * 3 + 2];
				System.out.println("i: " + i);


				System.out.println("bef3: "+nxt.test + " " +  nxt.count);
				//i++;
				++i;
				s += toChar(index*3 + 2);
				System.out.println(s);
				lookup(key, i, s, nxt, prev);
				nxt = prev;

				System.out.println("aft3: " + nxt.test + " " +  nxt.count);
				System.out.println("i: " + i );

				if(nxt != null)
				{
					System.out.println("does word exist: " + nxt.word);
					System.out.println("word: " + s);
				}

				System.out.println(s);
				s = s.substring(0, s.length() - 1);
			}
			//if(i <= 0)
			//	nxt = root;
			System.out.println("slut");

		}
		return saved;
	}

	//Transform character to code, 1-26
	public int toCode( String cha , int i)
	{
		char ch = cha.charAt(i);
		if(ch == 'q' || ch == 'w')
			return 0;
		int deci = (int)ch - 96;

		if(deci == 133)
			return 25 - 1;
		else if(deci == 132)
			return 26 - 1;
		else if(deci == 150)
			return 27 - 1;

		if(deci >= 17)
			deci--;
		if(deci >= 23)
			deci--;

		return deci - 1;
	}

	//Transform code to character, a-ö
	public String toChar( int code )
	{
		code += 1;
		if(code == 25)
			code = 229 - 96;
		else if(code == 26)
			code = 228 - 96;
		else if(code == 27)
			code = 246 - 96;
		else if(code >= 17)
		{
			code++;
			if(code >= 23)
				code++;
		}

		char ch = (char)(code + 96);

		return Character.toString(ch);
	}

	//transform text "1" or "2" tp index 0 or 1. up to 9.
	public int toIndex( String key ,int i)
	{
		char ch = key.charAt(i);
		String s = Character.toString(ch);
		return Integer.parseInt(s) - 1;
	}

	//transform letter into representing key.
	public String toKey( String word )
	{

		return "";
	}
}
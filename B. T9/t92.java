import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class t92
{
	public class Node
	{
		public Node[] next;
		public boolean word;
		public int test;

		public Node()
		{
			next = new Node[27];
			word = false;
			test = -1;
		}
	}

	String[] data;
	int max;

	Node root;

	String[] saved;
	int index = 0;


	//String[] s;
	public t92(String file)
	{
		data = new String[8262];
		saved = new String[10];
		root = new Node();
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
				nxt.next[index] = new Node();
				nxt.next[index].test = index;
				//System.out.println(index + " : " +toChar(index));
			}
			nxt = nxt.next[index];
		}
		nxt.word = true;
		//System.out.println(index + " : " + nxt.word);
	}

	public String[] lookup(String key)
	{
		return lookup(key, 0, "", root);
	}

	public String[] lookup(String key, int i, String save, Node temp)
	{
		int index = 0;
		Node nxt = temp;
		String s = save;

		System.out.println("start: "+nxt.test );
		System.out.println("root: "+root.test );

		System.out.println(i + "<" + key.length());
		System.out.println(s);
		System.out.println("does word exist: " + nxt.word);

		if( i < key.length() )
		{
			index = toIndex(key, i);

			System.out.println("Before");

			System.out.println("index: " + (index * 3) + "\t"+index);
			if(nxt.next[index * 3] != null )
			{
				System.out.println("index: " + index * 3);
				nxt = nxt.next[index * 3];
				System.out.println("i: " + i);

 				System.out.println(s);
 				s += toChar(index*3);
 				System.out.println("i: " + i);
 				System.out.println("bef1: "+nxt.test );
 				//i++;
 				++i;
				lookup(key, i, s, nxt);

				System.out.println("aft1: " + nxt.test );
				System.out.println("i: " + i);

				if(i < key.length() && i > 0){
					//--i;
					index = toIndex(key, i);
				}
				System.out.println(s);


				if(s.length() == key.length() && nxt.word == true )
					saved[0] = s;
				//s = s.substring(0, s.length() - 1);
				System.out.println(s);
			}
			System.out.println("mellan1");
			System.out.println(index * 3 + 1);
			System.out.println("i: " + i);

			if(nxt.next[index * 3 + 1] != null) //kan ej skriva ut n
			{
				System.out.println("index + 1: " + (index * 3 + 1));
				nxt = nxt.next[index * 3 + 1];
				System.out.println("i: " + i);

				System.out.println(s);
				s += toChar(index*3 + 1);
				System.out.println("bef2: "+nxt.test );
				//i++;
				++i;
				lookup(key, i, s, nxt);

				System.out.println("aft2: " + nxt.test );
				System.out.println("i: " + i );

				if(i < key.length() && i > 0)
				{
					//--i;
					index = toIndex(key, i);
				}
				System.out.println("newindex: " + index);

				if(nxt != null)
				{
					System.out.println("does word exist: " + nxt.word);
					System.out.println("word: " + s);
				}

				if(s.length() == key.length() && nxt.word == true)
					saved[0] = s;
				//s = s.substring(0, s.length() - 1);
				System.out.println(s);
			}
			System.out.println(s);
			System.out.println("mellan2");
			System.out.println(index * 3 + 2);
			System.out.println(nxt.next[index * 3 + 2] );



			if(nxt.next[index * 3 + 2] != null)
			{
				System.out.println("index + 2: " + (index * 3 + 2));
				nxt = nxt.next[index * 3 + 2];
				System.out.println("i: " + i);

				System.out.println(s);

				System.out.println("bef3: "+nxt.test );
				//i++;
				++i;
				s += toChar(index*3 + 2);
				lookup(key, i, s, nxt);

				System.out.println("aft3: " + nxt.test );
				System.out.println("i: " + i );

				if(nxt != null)
				{
					System.out.println("does word exist: " + nxt.word);
					System.out.println("word: " + s);
				}

				if(nxt != null && s.length() == key.length() && nxt.word == true)
					saved[0] = s;
				System.out.println(s);
			}
			System.out.println("slut");

				if(nxt != null)
				{
					System.out.println("does word exist: " + nxt.word);
					System.out.println("word: " + s);
				}
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
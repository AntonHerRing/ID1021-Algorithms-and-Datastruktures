import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class t9final
{
	public class Node
	{
		public Node[] next;
		public boolean word;

		public Node()
		{
			next = new Node[27];
			word = false;
		}
	}

	String[] data;
	int max;

	Node root;

	String[] saved;
	int index = 0;

	public t9final(String file)
	{
		data = new String[8262];
		saved = new String[10];
		root = new Node();

		try (FileInputStream fis = new FileInputStream(file);
       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
       BufferedReader br = new BufferedReader(isr))
		{
			String line;
			int i = 0;
			while ((line = br.readLine()) != null)
			{
				add(line);
				data[i++] = toKey(line);
			}
			max = i-1;
		} catch (Exception e){
			System.out.println(" file " + file + " not found");
		}
	}

	public void add( String s)
	{
		int index = 0;

		Node nxt = root;
		for(int i = 0; i < s.length(); i++)
		{
			index =  toCode(s, i);

			if(nxt.next[index] == null){
				nxt.next[index] = new Node();
			}
			nxt = nxt.next[index];
		}
		nxt.word = true;
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
				saved[index++] = s;

		if( i < key.length() )
		{
			index = toIndex(key, i);

			if(nxt.next[index * 3] != null )
			{
				prev = nxt;
				nxt = nxt.next[index * 3];
 				s += toChar(index*3);

				lookup(key, i + 1, s, nxt, prev);
				nxt = prev;

				s = s.substring(0, s.length() - 1);
			}

			if(nxt.next[index * 3 + 1] != null)
			{
				prev = nxt;
				nxt = nxt.next[index * 3 + 1];
				s += toChar(index*3 + 1);

				lookup(key, i + 1, s, nxt, prev);
				nxt = prev;

				s = s.substring(0, s.length() - 1);
			}

			if(nxt.next[index * 3 + 2] != null)
			{
				prev = nxt;
				nxt = nxt.next[index * 3 + 2];
				s += toChar(index*3 + 2);

				lookup(key, i + 1, s, nxt, prev);
				nxt = prev;

				s = s.substring(0, s.length() - 1);
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
		String key = "";
		for(int i = 0; i < word.length(); i++)
		{
			int code = toCode(word, i) /3;
			key += (code + 1);
		}

		return key;
	}
}
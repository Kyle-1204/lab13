package lab13;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;


public class enriquez_lab13 {
	
	public ArrayList <Integer> list = new ArrayList<>();
	
	public void readData (String filename) {
		try {
				BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
				String inn = "";
				while ( (inn = input.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(inn, "/n");
					while (st.hasMoreTokens())
					{
						list.add(Integer.valueOf(st.nextToken()));
					}
				}
				input.close();
		}
		catch(Exception e)
		{
			//null
		}
	}
	public long getTotalCount()
	{
		return list.stream().count();
	}
	
	public long getOddCount()
	{
		return list.stream().filter(x -> x % 2 == 1).count();
	}
	
	public long getEvenCount()
	{
		return list.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		return list.stream().distinct().filter(x -> x > 5).count();
	}
	
	public Integer[] getResult1()
	{
		return list.stream().filter(x -> x % 2 == 0 && x > 5 && x < 50).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		return list.stream().limit(50).map(x -> (x*x)*3).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		return list.stream().filter(x -> x % 2 == 1).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
	
	

}

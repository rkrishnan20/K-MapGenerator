import java.io.*;
import java.util.*;

public class tester {

	public static void main(String[] args) 
	{
		Scanner kbReader = new Scanner(System.in);
		System.out.println("Enter your boolean function in the following format: \nVar1,Var2,Var3..."
				+ "\nMin1,Min2,Min3...");
		String vars[] = kbReader.nextLine().split(","), terms[] = kbReader.nextLine().split(",");
		int iTerms[] = new int[(int)Math.pow(terms.length, 2)];
		
		for(int j = 0; j < vars.length; j++)
		{
			iTerms[j] = Integer.parseInt(terms[j]);  
		}
		
		boolean kMap[][] = new boolean[(int) Math.ceil((double)vars.length / 2)]
				[(int) Math.pow((int) Math.ceil((double)vars.length / 2),  2)];
		
		for(int l = 0; l < iTerms.length; l++)
		{
			if(iTerms[l] > kMap[0].length)
			{
				kMap[iTerms[l] / 2][iTerms[l] % 2] = true;
			}
			else
			{
				kMap[0][iTerms[l]] = true;
			}
		}
		
		print_map(kMap);
		kbReader.close();
	}
	
	public static void print_map(boolean [][] map)
	{
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < map.length; i++)
		{
			sb.append("[");
			for(int j = 0; j < map[0].length; j++)
			{
				sb.append(map[i][j] + ",");
			}
			sb.delete(sb.length() - 1, sb.length());
			sb.append("]\n");
		}
		
		System.out.println(sb.toString());
	}
}

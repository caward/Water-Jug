//By Corey Ward

import java.util.Scanner;


public class WaterJug {

	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(System.in);
		System.out.println("Please enter the 3 capacity and water amount pairs. Example: 8 8 5 0 3 0");
		int c1 = stdin.nextInt();
		int amt1 = stdin.nextInt();
		int c2 = stdin.nextInt();
		int amt2 = stdin.nextInt();
		int c3 = stdin.nextInt();
		int amt3 = stdin.nextInt();
		System.out.println("Please enter the target amount");
		int target = stdin.nextInt();
		Graph graph = new Graph(amt1,amt2,amt3,c1,c2,c3,target);
		
		//Quick Test
//		Graph graph = new Graph(8,0,0,8,5,3,4);
	}

}

//By Corey Ward

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Graph
{
	Vertex v=null;
	int target;
	int c1, c2, c3;
	HashMap<String, Vertex> visited;
	
	public Graph(int i, int j, int k, int c1, int c2, int c3, int target)
	{
		v = new Vertex(i,j,k);
		this.target = target;
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		visited = new HashMap<String, Vertex>();
		bfs();
	}
	
	void bfs()
	{
		System.out.println("Capacity\tTarget");
		System.out.println("["+c1+", "+c2+", "+c3+"]\t  "+target);
		System.out.println("------------------------\n");
		System.out.println("Amount Permutations");
		System.out.println("------------------------\n");
		if(isTarget(v))
		{
			System.out.println("Already solved");
			return;
		}
		System.out.println(v);
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(v);
		visited.put(v.toString(), v);
		while(!q.isEmpty())
		{
			Vertex tmp;
			tmp = q.poll();
			createEdges(tmp);
			for(Edge e:tmp.getEdges())
			{
				Vertex vtex = e.getV2();
				q.add(vtex);
				visited.put(vtex.toString(),vtex);
				if(isTarget(vtex))
				{
					System.out.println("\nCorrect Path to Target: "+target+" From: ["+c1+", "+c2+", "+c3+"]");
					System.out.println("------------------------\n");
					printEvent(vtex);
					return;
				}
			}
		}
		System.out.println("Impossible");
		return;
	}
	private void printEvent(Vertex vtex)
	{
		Edge parent = vtex.getParent();
		if(parent==null)
		{
			return;
		}
		Vertex current = parent.getV1();
		printEvent(current);
		System.out.println("("+parent.getV1()+") "+parent.getEvent()+" ("+parent.getV2()+")");
	}
	
	private boolean isTarget(Vertex vtex)
	{
		return target == vtex.getI() || target== vtex.getJ()|| target==vtex.getK();
	} 
	
	private void createEdges(Vertex vertex)
	{
		int i = vertex.getI();
		int j = vertex.getJ();
		int k = vertex.getK();
		String event;
		if(i!=0)//add i to j
		{
			event="Jug1 to Jug2";
			if (j!=c2)
			{
				if(i+j<=c2)
				{j+=i; i-=i;}
				else{i=j+i-c2;j=c2; }
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
			
			i = vertex.getI();
			j = vertex.getJ();
			k = vertex.getK();
			event="Jug1 to Jug3";
			if (k!=c3)
			{
				if(i+k<=c3){k+=i; i=0;}
				else{i=k+i-c3;k=c3; }
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
		}
		i = vertex.getI();
		j = vertex.getJ();
		k = vertex.getK();
		//Adding j to  
		if(j!=0)//add i to j
		{
			event="Jug2 to Jug1";
			if (i!=c1)
			{
				if(i+j<=c1){i+=j;j=0;}
				else{j=j+i-c1;i=c1; }
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
			
			i = vertex.getI();
			j = vertex.getJ();
			k = vertex.getK();
			event="Jug2 to Jug3";
			if (k!=c3)
			{
				if(j+k<=c3){k+=j; j=0;}
				else{j=k+j-c3;k=c3; }
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
		}
		i = vertex.getI();
		j = vertex.getJ();
		k = vertex.getK();
		//Adding k to  
		if(k!=0)//add i to j
		{
			event="Jug3 to Jug1";
			if (i!=c1)
			{
				if(i+k<=c1){i+=k;k=0;}
				else{k=k+i-c1;i=c1; }
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
			i = vertex.getI();
			j = vertex.getJ();
			k = vertex.getK();
			event="Jug3 to Jug2";
			if (j!=c2)
			{
				if(k+j<=c2){j+=k; k=0;}
				else{k=k+j-c2; j=c2;}
			}
			if(!isExplored(i,j,k))
			{
				Vertex vertex2 = new Vertex(i,j,k);
				Edge e = new Edge(vertex, vertex2, event);
				vertex.addEdge(e); //sets children/successor
				vertex2.setParent(e); //sets parent/predecessor
				System.out.println(vertex2);
			}
		}
	}
	
	private boolean isExplored(int i, int j, int k)
	{
		return visited.containsKey(i+", "+j+", "+k);
	}
	
}

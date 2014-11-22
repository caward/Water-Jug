//By Corey Ward

import java.util.ArrayList;


public class Vertex
{
	int i;
	int j;
	int k;
	boolean visited = false;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	Edge parent=null;
	
	public Edge getParent() {
		return parent;
	}

	public void setParent(Edge parent) {
		this.parent = parent;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	
	public Vertex(int i, int j, int k)
	{
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	public void markVisited()
	{
		visited = true;
	}
	
	public String toString()
	{
		return i+", "+j+", "+k;
	}
	
	public void addEdge(Edge e)
	{
		edges.add(e);
	}
	
	public ArrayList<Edge> getEdges()
	{
		return edges;
	}
}

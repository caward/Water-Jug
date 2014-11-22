//By Corey Ward
public class Edge
{
	Vertex v1;
	Vertex v2;
	String event;
	
	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}
	
	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public Edge(Vertex v1, Vertex v2, String event)
	{
		this.v1 = v1;
		this.v2 = v2;
		this.event = event;
	}
}

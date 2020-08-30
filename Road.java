import java.util.Collection;
import java.util.HashSet;

/**
 * Road represents ... a road ... in our graph, which is some metadata and a
 * collection of Segments. We have lots of information about Roads, but don't
 * use much of it.
 * 
 * @author tony
 */
public class Road {
	public final int roadID;
	public final int type;
	public final String name, city;
	public final Collection<Segment> components;
	public final int oneway;
	public final int speed;
	public final int roadclass;
	public final int notforcar;
	public final int notforpede;
	public final int notforbicy;

	public Road(int roadID, int type, String label, String city, int oneway,
			int speed, int roadclass, int notforcar, int notforpede,
			int notforbicy) {
		this.roadID = roadID;
		this.type = type;
		this.city = city;
		this.name = label;
		this.components = new HashSet<Segment>();
		this.oneway = oneway;
		this.speed = speed;
		this.roadclass = roadclass;
		this.notforcar = notforcar;
		this.notforpede = notforpede;
		this.notforbicy = notforbicy;
	}


	public void addSegment(Segment seg) {components.add(seg);}
	}



// code for COMP261 assignments
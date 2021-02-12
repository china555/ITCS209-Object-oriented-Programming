import java.util.Map;

// Name:Nattawipa Saetae
// Student ID:6188089
// Section:1

public class Rating {
	public Movie m;
	public User u;
	public double rating;	//rating can be [0, 5]
	public long timestamp;	//timestamp tells you the time this rating was recorded
	
	
	public Rating(User _u, Movie _m, double _rating, long _timestamp) {
		
		// YOUR CODE GOES HERE
		u = _u;                    //set value for each attributes
		m = _m;
		rating = _rating;
		timestamp = _timestamp;
	}
	
	
	public String toString() {
		return "[uid: " + u.getID() +" mid: "+m.getID() +" rating: "+rating+"/5 timestamp: "+timestamp+"]";
	}
}

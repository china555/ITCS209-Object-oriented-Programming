// Name:Piyakorn Suwannakarn
// Student ID:6188110	
// Section:2

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {
	private int mid;
	private String title;
	private int year;
	private Set<String> tags;
	private Map<Integer, Rating> ratings;	//mapping userID -> rating
	private Double avgRating;
	//additional
	
	public Movie(int _mid, String _title, int _year){
		this.mid = _mid;
		this.title = _title;
		this.year = _year;
		tags = new HashSet<String>();
		ratings = new HashMap<Integer, Rating>();
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE
		return this.mid;
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE
		return this.title;
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE
		return this.tags;
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE
		tags.add(tag);
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE
		return this.year;
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		double x=0,y=0;
		for(Integer z:ratings.keySet()) {
			x+=ratings.get(z).rating;
			y+=1.0;
		}
		this.avgRating = x/y;
		return this.avgRating;
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE
		return this.avgRating;
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		// YOUR CODE GOES HERE
		ratings.put(user.uid,new Rating(user,movie,rating,timestamp));
		
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE
		
		return this.ratings;
	}
	
}

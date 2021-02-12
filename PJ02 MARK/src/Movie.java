// Name:sarun junbang
// Student ID: 6188080
// Section: 2

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
		// YOUR CODE GOES HERE
		this.mid=_mid;
		this.title=_title;								//conductor
		this.year= _year;
		avgRating = 0.0;
		tags= new HashSet<String>();   					// Hash is initial value 
		ratings = new HashMap<Integer, Rating>();
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE                //getID return mid
		return mid;
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE               //getTitle return title
		return title;
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE				//getTags return tags
		return tags;
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE         //set use add  && map use put;
		tags.add(tag);
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE			// getYear return year
		return year;
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		double all =0; 									// keyset because map run for key index  (Map)
		for(int i: ratings.keySet()) {
			 all = all + ratings.get(i).rating;         //get is use it this
		}
		avgRating = all/ratings.size(); 				// size is size of ratings
		return avgRating ;
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE							//getMeanRating return Avg
		
		return avgRating;
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		// YOUR CODE GOES HERE
		Rating x = new Rating(user, movie, rating, timestamp); //create new object because can't add another type except rating type
		ratings.put(user.uid,x);
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE						//Map<Integer, Rating> return ratings
		
		return ratings;
	}
	
}

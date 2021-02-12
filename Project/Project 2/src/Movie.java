// Name: Kittikorn 
// Student ID: 6188086
// Section: 1

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
	
	public Movie(int _mid, String _title, int _year) {
		// YOUR CODE GOES HERE
		this.mid = _mid;
		this.title = _title;						//set attribute to have same value of parameter
		this.year = _year;
		tags = new HashSet<String>();             	// initial Set variable
		ratings = new HashMap<Integer, Rating>();	// initial Map variable
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE 
		return this.mid; // get value mid
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE
		return this.title; //get value title
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE
		return this.tags;	//get value tag
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE
		tags.add(tag); //to add data into Set variable
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE
		return this.year; //get value 
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		avgRating = 0.0;
		double sumRating = 0;
		for(Integer key: ratings.keySet()) {
			sumRating += ratings.get(key).rating; // calculate mean of rating for each movie
		}
		avgRating = sumRating/ratings.size();
		return avgRating;
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE
		return this.avgRating; //get value avgRating
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		// YOUR CODE GOES HERE
		Rating data = new Rating(user, movie, rating, timestamp); 
		ratings.put(user.getID(), data); // add data to variable of Map
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE
		return ratings;  ////get value ratings that have the same datatype to this method
	}
	
}

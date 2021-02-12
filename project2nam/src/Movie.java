// Name:Nattawipa Saetae
// Student ID:6188089
// Section:1

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
		mid = _mid ;               //set value for each attributes
		title = _title ;   
		year = _year;
		tags = new HashSet<String>() ;      //initial value for Set variable
		ratings = new HashMap<Integer, Rating>() ;       //initial value for Map variable
		avgRating = 0.0 ;      //initial value for avgRating 
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE
		return mid ;     //return id
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE
		return title ;    //return title
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE
		return tags ;           //return tags 
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE
		tags.add(tag);         //add tag in tags Set
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE
		return year ;      //return year
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		double sum = 0 ;     //initial value for sum
		int count = 0 ;      //initial value for count
		for (Integer i : ratings.keySet())
		{
			sum = sum + ratings.get(i).rating;      //calculated sum and count for each times
			count++;
		}
		avgRating = sum/count;     //calculated avgRating
		return avgRating ;         //return avgRating
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE
		return avgRating ;    //get value of avgRating and return avgRating
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		// YOUR CODE GOES HERE
		Rating x = new Rating(user, movie, rating, timestamp) ;
		ratings.put(user.getID(), x);        //add new object in ratings Map
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE
		
		return this.ratings;    //return ratings
	}
	
}

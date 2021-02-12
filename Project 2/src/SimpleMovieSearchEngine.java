// Name:Kittikorn	
// Student ID:6188086
// Section: 1

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.acl.Group;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleMovieSearchEngine implements BaseMovieSearchEngine {
	public Map<Integer, Movie> movies ;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		
		// YOUR CODE GOES HERE
	   	String pattern = "([0-9]+),\"?(.*)\\s\\(([0-9]+)\\)\"?,(.+)"; //regex or regular expression for movies
		movies = new HashMap<Integer, Movie>(); //Initialization variable of Map
		BufferedReader read = null; 
		try {
			read = new BufferedReader(new FileReader(movieFilename)); // to read this file that have directory of movies.csv
			Pattern pat = Pattern.compile(pattern); // compile with regex to use this regex to check in each line
			String line = read.readLine(); // read first line
			while(line != null) {
				line = read.readLine();
				if(line != null) {
				Matcher match = pat.matcher(line); // match between line and pattern
				if(match.find()) { // if find pattern in each line continue in if
					Movie movie = new Movie(Integer.parseInt(match.group(1)), match.group(2),Integer.parseInt(match.group(3)));// object of Movie
					//Integer.parseInt(match.group(1,2,3,4)) change type of String to Integer 
					for(String tag : match.group(4).split("\\|")) { // will split to array and add it into tag of each movie
						movie.addTag(tag);
					}
					this.movies.put(Integer.parseInt(match.group(1)),movie); //this will use put to add data into movies because it Map variable
				}
				}	
			}
		} 
		  catch (FileNotFoundException e) { // catch error and then continue the program
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(read != null) {
					read.close();
				}
			}
		  catch (IOException e) {
			e.printStackTrace();
		}
		}
		return movies;
	}

	@Override
	public void loadRating(String ratingFilename) {

		// YOUR CODE GOES HERE
		String pattern = "^([0-9]+),([0-9]+),([0-9.]+),([0-9]+)"; // regex for rating
		try {
			BufferedReader read = new BufferedReader(new FileReader(ratingFilename)); // read file
			String line = read.readLine(); //read first line
			Pattern pat = Pattern.compile(pattern); //use this regex for pattern
			while((line = read.readLine()) != null) { //if null it gona stop loop
				Matcher match = pat.matcher(line); // match between line and pat
					if(match.find()) {
						User id = new User(Integer.parseInt(match.group(1)));
						if(movies.get(Integer.parseInt(match.group(2))) != null) {//if not the same with pattern don't add it 
						movies.get(Integer.parseInt(match.group(2))).addRating(id,movies.get(Integer.parseInt(match.group(2))),Double.parseDouble(match.group(3)),Long.parseLong(match.group(4)));//we have movie already and we will add rating for each movie use mid for key to search movie
						movies.get((Integer.parseInt(match.group(2)))).calMeanRating();//call method in class Movie to cal mean
						}
					}
				}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		  catch (IOException e) {
			e.printStackTrace();  
		}
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) { // pass by moogle tester in line 24
	
		// YOUR CODE GOES HERE
		loadMovies(movieFilename); //pass to method loadMovies
		loadRating(ratingFilename);//pass to method loadRating
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {

		// YOUR CODE GOES HERE
		if(movies.size() == 0) {
			return null;
		}
		return movies;    // get value of all movies
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {
		
		// YOUR CODE GOES HERE
		List<Movie> result = new ArrayList<Movie>();
		if(exactMatch == false) {
			for(Integer key: movies.keySet()) {
				String titleLowerCase = movies.get(key).getTitle().toLowerCase();
					if(titleLowerCase.contains(title)) { // contains it use to check some of text have or not
					result.add(movies.get(key));
				}
			}
		}
		else {
			for(Integer key: movies.keySet()) {
				String titleLowerCase = movies.get(key).getTitle().toLowerCase();
					if(titleLowerCase.equals(title)) { // equals it must be same
					result.add(movies.get(key));
				}
			}
			
		}
		return result;
	}

	@Override
	public List<Movie> searchByTag(String tag) {

		// YOUR CODE GOES HERE
		List<Movie> s_tag = new ArrayList<Movie>();
		for(Integer i : movies.keySet()) {
			if(movies.get(i).getTags().contains(tag)) { //check tag have or not
				s_tag.add(movies.get(i));
			}
		}
		return s_tag;
	}

	@Override
	public List<Movie>searchByYear(int year) {

		// YOUR CODE GOES HERE
		List<Movie> s_year = new ArrayList<Movie>();//check year are same as year in parameter or not
		for(Integer i : movies.keySet()) {
			if(movies.get(i).getYear() == year) {
				s_year.add(movies.get(i));
			}
		}
		return s_year;
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) { //to check out 4 case

		// YOUR CODE GOES HERE
		List<Movie> result = new ArrayList<Movie>();
		for(Integer key: movies.keySet()) {
			if(title == null) {
				Set<String> listTags = movies.get(key).getTags(); // check between tags and year.
				for(String list : listTags) {					//if it have all then add it into result
					if(list.contains(tag)) {
						if(movies.get(key).getYear()==year) {
							result.add(movies.get(key));
						}
					}
				}
			}else if(tag == null) {
				String titleLowerCase = movies.get(key).getTitle().toLowerCase();// check between title and year.
				if(titleLowerCase.contains(title)) {	//if it have all then add it into result
					if(movies.get(key).getYear()==year) {
						result.add(movies.get(key));
					}
				}
			}else if(year == -1) {
				Set<String> listTags = movies.get(key).getTags();// check between title and tag.
				String titleLowerCase = movies.get(key).getTitle().toLowerCase();//if it have all then add it into result
				for(String list : listTags) {
					if(titleLowerCase.contains(title)) {
						if(list.contains(tag)) {
							result.add(movies.get(key));
						}
					}
				}
			}else {
				Set<String> listTags = movies.get(key).getTags(); //check all case tag , year and title
				String titleLowerCase = movies.get(key).getTitle().toLowerCase();// and add movies into result
				for(String list : listTags) {
					if(titleLowerCase.contains(title)) {
						if(list.contains(tag)) {
							if(movies.get(key).getYear() == year)
								result.add(movies.get(key));
						}
					}
				}
			}
		}
		return result;
	}

	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		if(asc == true) {//if true a-z
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle));//sort title
			return unsortedMovies;
		}else if(asc == false) {//if false z-a
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());//sort title
			return unsortedMovies;
		}
		return null;
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		
		if(asc) {
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating));//sort meanrating
		}else if(asc == false) {
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating).reversed());//sort meanrating
		}
		return unsortedMovies;
	}

}

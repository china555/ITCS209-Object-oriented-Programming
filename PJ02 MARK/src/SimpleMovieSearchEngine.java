// Name:sarun junbang
// Student ID:6188080
// Section: 2

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	public Map<Integer, Movie> movies;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		
		// YOUR CODE GOES HERE 		
		String work = "([0-9]+),(.+)\\W\\((\\d+)\\)\"?,(.+)";	    // 
		movies = new HashMap<Integer, Movie>();
		File name = new File(movieFilename);						//BufferedReader 
		BufferedReader read = null;
		try {
			FileReader namey = new FileReader(name);				//
			BufferedReader name1 = new BufferedReader(namey);
			Pattern work1 = Pattern.compile(work);					//
			String rule = name1.readLine();							//
			while(rule != null) {
				rule = name1.readLine();
				if(rule != null) {
				Matcher match = work1.matcher(rule);
					if(match.find()) {
					Movie movie = new Movie(Integer.parseInt(match.group(1)),match.group(2),
							Integer.parseInt(match.group(3)));
					for (String i : match.group(4).split("\\|")) {
						movie.addTag(i);
					}
					movies.put(Integer.parseInt(match.group(1)), movie);
				}
				}	
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void loadRating(String ratingFilename) {

		// YOUR CODE GOES HERE
		String work = "([0-9]+),([0-9]+),(([0-9]+).([0-9]+)),([0-9]+)";	    //
		File name = new File(ratingFilename);						//
		BufferedReader read = null;
		//FileReader reader;
		try {
			FileReader namey = new FileReader(name);				//
			BufferedReader name1 = new BufferedReader(namey);
			Pattern work1 = Pattern.compile(work);					//
			String rule = name1.readLine();							//
			while(rule != null) {
				rule = name1.readLine();
				if(rule != null) {
				Matcher match = work1.matcher(rule);
					if(match.find()) {
						User id = new User(Integer.parseInt(match.group(1)));
						if(movies.get(Integer.parseInt(match.group(2))) != null) {
						movies.get(Integer.parseInt(match.group(2))).addRating(id,movies.get(Integer.parseInt(match.group(2))),Double.parseDouble(match.group(3)),Long.parseLong(match.group(4)));
						movies.get((Integer.parseInt(match.group(2)))).calMeanRating();
						}
				}	
			}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) {
		// YOUR CODE GOES HERE                                                  // send value to loadMovies 
		 loadMovies(movieFilename);												// send value to loadRating
		 loadRating(ratingFilename);
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {

		// YOUR CODE GOES HERE							//Map<Integer, Movie> is in movies
		
		return movies;
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {  // search name movie for find movie

		// YOUR CODE GOES HERE
		List<Movie> searchmovie  = new ArrayList<Movie>();					//
		for(int i: movies.keySet()) {
			if(exactMatch==true) {
				if(movies.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) {   //toLowercase for change big font to small
				searchmovie.add(movies.get(i));													//equals is font=font
			}
		}		
			else {
				if (movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {		//contains  
					searchmovie.add(movies.get(i));
				}
			}
		}
		return searchmovie;
	}

	@Override
	public List<Movie> searchByTag(String tag) {			//search movie by tag

		// YOUR CODE GOES HERE
		List<Movie> searchtag =new ArrayList<Movie>();		
		for(int i : movies.keySet()) {
			if(movies.get(i).getTags().contains(tag)) {		// contains
				searchtag.add(movies.get(i));
			}
		}
		return searchtag;
	}

	@Override
	public List<Movie>searchByYear(int year) {				//search movie by year

		// YOUR CODE GOES HERE
		List<Movie> searchyear = new ArrayList<Movie>();
		for(int i : movies.keySet()) {
			if(movies.get(i).getYear()==year) {
				searchyear.add(movies.get(i));
			}
		}
		return searchyear;
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {

		// YOUR CODE GOES HERE
		List<Movie> searchadvance = new ArrayList<Movie>();
		for(int i: movies.keySet()) {
			if(title==null) {											//if title is null 
				if(movies.get(i).getTags().contains(tag)){				//check tag and year
					if(movies.get(i).getYear()==year) {
						searchadvance.add(movies.get(i));
					}
				}
			}
			else if(tag==null) { 																		//if tag is null
					if (movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {		//check title and year
						if(movies.get(i).getYear()==year) {
							searchadvance.add(movies.get(i));
						}
				}
			}
			else if (year == -1) {  							
				if(movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) { 				//if year is -1  check title and tag
						if(movies.get(i).getTags().contains(tag)) {		
							searchadvance.add(movies.get(i));
						}
				}
			}
			else {
				if(movies.get(i).getTitle().toLowerCase().equals(title.toLowerCase())) { 				//if no one is null
					if (movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {			// check all				
						if(movies.get(i).getTags().equals(tag)) {		
							if(movies.get(i).getYear()==year) {
								searchadvance.add(movies.get(i));
							}
						}
					}
				}
			}
		}
				
		return searchadvance;
	}

	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {			//sort movie by title

		// YOUR CODE GOES HERE																// condition
		if(asc == true) {
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle));						//asc = true
			return unsortedMovies;
		}else if(asc == false) {															//asc = false
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());		
			return unsortedMovies;
		}
		return null;
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {			//sort movie by rating

		// YOUR CODE GOES HERE																// condition
		
		if(asc) {
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating));			
		}else if(asc == false) {											
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating).reversed());   // asc = false
		}
		return unsortedMovies;
	}

}

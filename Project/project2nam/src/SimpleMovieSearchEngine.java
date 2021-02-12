// Name:Nattawipa Saetae
// Student ID:6188089
// Section:1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
	public static BufferedWriter write;
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		
		// YOUR CODE GOES HERE
		movies = new HashMap<Integer, Movie>();  //create new map object
		try 
		{
			BufferedReader read = new BufferedReader(new FileReader(movieFilename));   //read file by use bufferreader
			String pattern =  "([\\d]+),(.+)\\s\\(([\\d]+)\\)\\\"?,(.+)";    //pattern for data in this file 
			Pattern pat = Pattern.compile(pattern);
			String line = read.readLine();   //read first line
			for(int i = 0 ;line != null; i++) 
			{
				line = read.readLine();      //read line if it not empty
				if(line!= null)
				{
					Matcher match = pat.matcher(line);       //match pattern for each line if it find
					if(match.find()) 
					{
						int mid = Integer.parseInt(match.group(1));    //set id for group 1 of data
						String title = match.group(2);    //set title for group 2 of data
						int year = Integer.parseInt(match.group(3));    //set year for group 3 of data
						String tags = match.group(4);     //set tags for group 4 of data
						Movie movie = new Movie(mid, title, year);
						for(String tag : tags.split("\\|"))       //split word by | and add it to array 
						{
							movie.addTag(tag);   //add tag into each movie 
						}
						movies.put(mid,movie);   //put into movies
					}
				}
			}
		} 
		catch (FileNotFoundException e)  
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public void loadRating(String ratingFilename) {

		// YOUR CODE GOES HERE

			BufferedReader read;
			try 
			{
				read = new BufferedReader(new FileReader(ratingFilename));     //read file by using bufferreader
				String pattern =  "([\\d]+),([\\d]+),([\\d].[\\d]),(.+)";      //pattern for data in this file 
				Pattern pat = Pattern.compile(pattern);     
				String line = read.readLine();    //read first line
				while(line != null)
				{
					line = read.readLine();       //read line if it not empty
					if(line != null)
					{
						Matcher match = pat.matcher(line);       //match pattern for each line if it find
						if(match.find())
						{
							User u = new User(Integer.parseInt(match.group(1)));    //create new User object
							int mid = Integer.parseInt(match.group(2));      //set id for group 2 of data
							double rating = Double.parseDouble(match.group(3));      //set rating for group 3 of data
							long timestamp = Long.parseLong(match.group(4));     //set timestamp for group 4 of data
							if(movies.get(mid)!=null)
							{
								movies.get(mid).addRating(u,movies.get(mid), rating, timestamp);     //add rating
								movies.get(mid).calMeanRating();        //calculate mean rating
							}
						}
					}
				}
				print(movies);
			}
			catch (FileNotFoundException e)    //try catch use to find the error and print warning massage at the end but the program still run until the end
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e)     
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) {
	
		// YOUR CODE GOES HERE
		loadMovies(movieFilename) ;      //pass directory of movieFilename and ratingFilename to use in another method
		loadRating(ratingFilename);     
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {

		// YOUR CODE GOES HERE
		if(movies.size()!=0)
		{
			return movies;    //return all movies
		}
		else
		{
			return null;     //if size is empty return null
		}
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {

		// YOUR CODE GOES HERE
		List<Movie> w = new ArrayList<Movie>();     //create new arraylist object
		if( exactMatch == true )    //if exact match is true mean all of the alphabet is same
		{
			for(Integer i : movies.keySet())  
			{
				if(movies.get(i).getTitle().toLowerCase().equals(title.toLowerCase()))     //if title is same with movie title in list 
				{
					w.add(movies.get(i));     //add title into arraylist
				}
			}
		}
		else 
		{
			for(Integer i : movies.keySet())
			{
				if(movies.get(i).getTitle().toLowerCase().contains(title.toLowerCase()))      //if title is some word contains in the title 
				{
					w.add(movies.get(i));     //add title into arraylist
				}
			}
		}
		return w;    //return this arraylist
	}

	@Override
	public List<Movie> searchByTag(String tag) {

		// YOUR CODE GOES HERE
		List<Movie> x = new ArrayList<Movie>();      //create new arraylist object
		for(Integer i : movies.keySet())
		{
			if(movies.get(i).getTags().contains(tag))      //if movies contains the same tag
			{
				x.add(movies.get(i));     //add it into arraylist
			}
		}
		return x;   //return this arraylist
	}

	@Override
	public List<Movie>searchByYear(int year) {

		// YOUR CODE GOES HEE
		List<Movie> y = new ArrayList<Movie>();     //create new arraylist object
		for(Integer i : movies.keySet())
		{
			if(movies.get(i).getYear() == year)     //if movies contains the same year
			{
				y.add(movies.get(i));       //add it into arraylist
			}
		}
		return y;    //return this arraylist
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {

		// YOUR CODE GOES HERE
		List<Movie> z = new ArrayList<Movie>();      //create new arraylist object
		for(Integer i : movies.keySet())
		{
			if(title == null)        //if title is nothing
			{
				if(movies.get(i).getTags().contains(tag))      //check tag and year if all same
				{ 
					if(movies.get(i).getYear() == year)       
					{
						z.add(movies.get(i));     //add it into arraylist
					}
				}
			}
			else if(tag == null)      //if tag is nothing
			{
				if(movies.get(i).getTitle().contains(title))      //check title and year if all same
				{
					if(movies.get(i).getYear() == year)
					{
						z.add(movies.get(i));     //add it into arraylist
					}
				}
			}
			else if(year == -1)      //if year is -1
			{
				if(movies.get(i).getTitle().contains(title))       //check title and tag if all same
				{
					if(movies.get(i).getTags().contains(tag))
					{
						z.add(movies.get(i));     //add it into arraylist
					}
				}
			}
			else {
				if(movies.get(i).getTitle().contains(title))       
				{
					if(movies.get(i).getTags().contains(tag))
					{
						if(movies.get(i).getYear() == year)
						{
							z.add(movies.get(i));
						}
					}
				}
			}
		}
		return z;    //return this arraylist
	}

	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		if(asc == true)      //if ascending is true sort from a-z
		{
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle));     
		}
		else if(asc == false)    //if ascending is false sort reverse from z-a
		{
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
		}
		return unsortedMovies;    //return unsortedMovies
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		if(asc== true)     //if ascending is true sort from least to great number
		{
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating));
		}
		else if(asc == false)     //if ascending is false sort reverse from great to least number
		{
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating).reversed());
		}
		return unsortedMovies;     //return unsortedMovies
	}
	//EXTRA FEATURES
	public static void print(Map<Integer, Movie> movies) throws IOException
	{
		SimpleMovieSearchEngine s = new SimpleMovieSearchEngine();
		Map<Integer, Rating> ratings=null;
		int numRatings = 0;
		//File micro = new File("log-micro.txt");  
		File sample = new File("log-sample.txt");
		//FileWriter x = new FileWriter(micro);       //test case for micro
		FileWriter x = new FileWriter(sample);    //test case for sample
		write = new BufferedWriter(x);
		for(int i : movies.keySet()) 
		{
			ratings = movies.get(i).getRating();
			write.append(movies.get(i).toString());   //append in method toString of movies
			write.newLine();      //new line
			numRatings += ratings.size();
			for(int y: ratings.keySet()) 
			{
				write.append( "   " + ratings.get(y).toString());     //append in method toString of ratings
				write.newLine();     //new line
			}
		}
		write.append("**********************************");
		write.newLine();
		write.append("Total number of movies: " + movies.size());
		write.newLine();
		write.append("Total number of ratings: " + numRatings);
		write.newLine();
		write.close();
	}
}
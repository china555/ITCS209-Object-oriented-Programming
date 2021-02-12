
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
	boolean T = true;
	boolean F = false;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		
		// YOUR CODE GOES HERE
		this.movies = new HashMap<Integer,Movie>();
		String line=null;
		
		String p1 = "([0-9]+),(.*)\\s\\(([0-9]+)\\)\"?,(.+)";
		Pattern pat = Pattern.compile(p1);
		
		Matcher m;
		
		try
		{   
			BufferedReader br = new BufferedReader(new FileReader(movieFilename));
			line = br.readLine();
			while((line = br.readLine()) != null)
			{
				m = pat.matcher(line);
				if(m.matches())
				{
					Movie hd = new Movie(Integer.parseInt(m.group(1)),m.group(2),Integer.parseInt(m.group(3)));//import//
						this.movies.put(Integer.parseInt(m.group(1)), hd);
						for(String tag : m.group(4).split("\\|"))
						{
						hd.addTag(tag);	
						}
					movies.put(Integer.parseInt(m.group(1)),hd);
			}
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return this.movies;
	}

	@Override
	public void loadRating(String ratingFilename) {

		// YOUR CODE GOES HERE
		String line2=null;
		String p2 = "([0-9]+),([0-9]+),([0-9].[0-9]+),(.*)";
		Pattern pat2 = Pattern.compile(p2);
		Matcher m2;
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(ratingFilename));
			line2 = br.readLine();
			while((line2 = br.readLine()) != null)
			{
				m2 = pat2.matcher(line2);
				if(m2.matches())
				{
					if(movies.get(Integer.parseInt(m2.group(2))) != null) {
					movies.get(Integer.parseInt(m2.group(2))).addRating(new User(Integer.parseInt(m2.group(1))), movies.get(Integer.parseInt(m2.group(2))), Double.parseDouble(m2.group(3)), Long.parseLong(m2.group(4)));
					movies.get(Integer.parseInt(m2.group(2))).calMeanRating();
					}
				}
			}
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) {
	
		// YOUR CODE GOES HERE
		
		loadMovies(movieFilename);
		loadRating(ratingFilename);
		
			
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {

		// YOUR CODE GOES HERE
		
		return movies;
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {

		// YOUR CODE GOES HERE
		List<Movie> movlist = new ArrayList<Movie>();
		for(Movie mov : movies.values())
		{
          if (mov.getTitle().toLowerCase().contains(title.toLowerCase()) ) {
        	  movlist.add(mov);
		}
		}
		return movlist;
	}
	

	@Override
	public List<Movie> searchByTag(String tag) {

		// YOUR CODE GOES HERE
		
		List<Movie> movlist = new ArrayList<Movie>();
		for(Movie mov : movies.values())
		{
          if (mov.getTags().contains(tag)) {
        	  movlist.add(mov);
		}
		}
		return movlist;
	}

	@Override
	public List<Movie>searchByYear(int year) {

		// YOUR CODE GOES HERE
		List<Movie> movlist = new ArrayList<Movie>();
		for(Movie mov : movies.values())
		{
          if (mov.getYear()==year ) {
        	  movlist.add(mov);
		}
		}
		return movlist;
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {

		// YOUR CODE GOES HERE
		List<Movie> movlist = new ArrayList<Movie>();
		if(tag==null) {
			for(Movie mov : movies.values()) 
			{
						if(mov.getTitle().contains(title) && mov.getYear()==year) {
							movlist.add(mov);
			}
		}
		}
		else if(title==null) {
			for(Movie Mov : movies.values()) 
			{
						if(Mov.getYear()==year && Mov.getTags().contains(tag)) {
							movlist.add(Mov);
			}
		}
		}
		else if(year==-1) {
			for(Movie mOv : movies.values()) 
			{
						if(mOv.getTitle().contains(title) && mOv.getTags().contains(tag)) {
							movlist.add(mOv);
			}
		}
		}
			else 
			{
				for(Movie moV : movies.values()) {
					if(moV.getTitle().contains(title) && moV.getTags().contains(tag) && moV.getYear()==year) {
						movlist.add(moV);
				}
			}
		
	}
		return movlist;
	}
	

	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		List<Movie> sortedMovies=new ArrayList<Movie>();
		Comparator<Movie> com = Comparator.comparing(Movie::getTitle); //Thanks to http://www.baeldung.com/java-8-comparator-comparing//
		Comparator<Movie> rcom = Comparator.comparing(Movie::getTitle).reversed();
		if(asc==true) {
			unsortedMovies.sort(com);
		}
		else {
			unsortedMovies.sort(rcom);
		}
		
		return unsortedMovies;
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		
		Comparator<Movie> com = Comparator.comparing(Movie::getMeanRating); //Thanks to http://www.baeldung.com/java-8-comparator-comparing// 
		Comparator<Movie> rcom = Comparator.comparing(Movie::getMeanRating).reversed();
		if(asc==true) {
			unsortedMovies.sort(com);
			return unsortedMovies;
		}
		else {
			unsortedMovies.sort(rcom);
			return unsortedMovies;
		}
		
	}

}

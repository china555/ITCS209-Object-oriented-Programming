import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		movies = new HashMap<Integer, Movie>();
		File file = new File(movieFilename);
		try 
		{
			List <String> lines = FileUtils.readLines(file,"UTF-8");
			String  pattern = "([0-9]+),(.{2,}),(.+(\\|.+)*)?";
			Pattern pat = Pattern.compile(pattern);
			for(String i:lines)
			{
				Matcher match = pat.matcher(i); 
				if(match.find())
				{
					Movie movie = new Movie(Integer.parseInt(match.group(1)), match.group(2));
					for(String tag : match.group(3).split("\\|"))
					{
						movie.tags.add(tag);
					}
					this.movies.put(Integer.parseInt(match.group(1)), movie);
				}
			}
			
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> x = new ArrayList<Movie>();
		for(int i: movies.keySet()) 
		{
			if(movies.containsValue(query))
			{
				x.add(movies.get(i));
			}
		}
		return x;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> y = new ArrayList<Movie>();
		for(int i: movies.keySet()) 
		{
			if(movies.get(i).tags.contains(tag))
			{
				y.add(movies.get(i));
			}
		}
		return y;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}

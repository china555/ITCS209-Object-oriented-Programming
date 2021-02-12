import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

public class din {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		movies = new HashMap<Integer, Movie>();
		File file = new File(movieFilename);
		try {
		List<String> read = FileUtils.readLines(file, "UTF-8");
	
		String pattern = "(\\d+),(.+),(.+)";
		Pattern pat = Pattern.compile(pattern);
		for(String line: read) {
			Matcher m = pat.matcher(line);
			if(line != null) {
				int mid = Integer.parseInt(m.group(1));
				String title = m.group(2);
				Movie mov = new Movie(mid,title);
				for(String tags : m.group(3).split("\\|")) {
					mov.tags.add(tags);
				}
				movies.put(mid, mov);
			}
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		//YOUR BONUS CODE GOES HERE
		
		
		return null;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		return null;
	}
	
	
	public static void main(String[] args)
	{
		din mdb = new din();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}

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
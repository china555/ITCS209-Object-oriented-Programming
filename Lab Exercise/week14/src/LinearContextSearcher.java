
public class LinearContextSearcher extends ContextSearcher {

	LinearContextSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String find(Word query, int window) {
		// TODO Auto-generated method stub
		for(Word i : sortedWords) {
			if(i.compareTo(query) == 0) {
				return getSnippet(i, window);
			}
		}
		return null;
	}

}

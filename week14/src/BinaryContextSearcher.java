public class BinaryContextSearcher extends ContextSearcher {

	BinaryContextSearcher(String filename) {
		super(filename);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String find(Word query, int window) {
		// TODO Auto-generated method stub
		Word foo =binarysearch(query,0,  sortedWords.size());
		return getSnippet(foo, window);
	}
	public Word binarysearch(Word a,int start, int end) {
		int mid = start + (end-start)/2;//(start+end+1)/2
		if(end < start) {
			return null;
		}
		if(sortedWords.get(mid).equals(a)) {
			Word result = sortedWords.get(mid);
			while(mid > start) {
				if(sortedWords.get(mid).equals(a)) {
					result = sortedWords.get(mid);
				}
				mid--;
			}
			return result;
		}
		else if(a.compareTo(sortedWords.get(mid))> 0) {
			start = mid+1;
			return binarysearch(a, start, end);
		}
		else {
			end = mid-1;
			return binarysearch(a, start, end);
		}
	}
	public Word binary(Word q ,int start ,int end) {
		while(start != end) {
			
		}
		return q;
	}
}

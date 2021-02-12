import java.util.ArrayList;

public class Member {
	public String email;
	public String password;
	public static ArrayList<Repository> repoList;
	Member(String email, String password){
		this.email = email;
		this.password = password;
		repoList = new ArrayList<Repository>();
	}
	public boolean addRepository(Repository repo) {
		if(repo == null) {
		return false;
		}
		else {
			repoList.add(repo);
			return true;
		}
	}
	public boolean removeRepository(Repository repo) {
		/*for(Repository x: repoList  ) {
			if(x.isEqual(repo)){
				System.out.println("successful message");
				repoList.remove(x);
				return true;
			}
		}
		return false;*/
		for(int i=0;i<repoList.size();i++) {
			if(repoList.get(i).isEqual(repo)){
				System.out.println(repoList.get(i).toString()+"is successfully removed.");
				repoList.remove(i);
				return true;
			}
		}
		return false;
}
	public void printMemberInfo() {
		System.out.println("Email"+this.email+"(pwd: "+this.password);
		System.out.println("List of repositories");
		for(Repository data : repoList) {
			System.out.println(data.toString());
		}
	}
}

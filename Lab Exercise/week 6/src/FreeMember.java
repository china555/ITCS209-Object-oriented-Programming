
public class FreeMember extends Member {
	public static int FREE_PRIVATE_REPOS;
	public static int numPrivateRepo;
	FreeMember(String email, String password) {
		super(email, password);
		FREE_PRIVATE_REPOS = 3;
		numPrivateRepo = 0;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean addRepository(Repository repo) {
			if(repo.isPrivate()) {
				if(numPrivateRepo<FREE_PRIVATE_REPOS) {
					repoList.add(repo);
					numPrivateRepo++;
					return true;
				}
				else  {
					System.out.println("Name"+repo.getName()+"cannot be added because the number of private repository is reaching the limit");
					return false;
				}		
			}else {
				repoList.add(repo);    
				return true;
			}
	}
	@Override
	public boolean removeRepository(Repository repo) {
		for(int i=0;i<repoList.size();i++) {
			if(repoList.get(i).isPrivate()&&repoList.get(i).isEqual(repo)) {
				System.out.println(repoList.get(i).toString()+"is successfully removed.");
				repoList.remove(i);
				numPrivateRepo--;
				return true;
			}
		}
		return false;
	}
	@Override
	public void printMemberInfo() {
		System.out.println("“---- FREE MEMBER ----\n"+"Email"+this.email+"(pwd: "+this.password+")");
		for(int i=0;i<repoList.size();i++) {
			System.out.println(repoList.get(i).toString());
		}
	}
	public int getNumPrivateRepo() {
		return numPrivateRepo;
	}
}

import java.util.ArrayList;

public class ProMember extends Member{
	
	public double fee;
	public static double  COLLABORATOR_FREE = 80.0;
	public ArrayList<String> collaborators;
	public ProMember(String email, String password, int fee) {
		super(email,password);
		this.fee = fee;
		this.collaborators = new ArrayList<String>();
	}

	public boolean addCollaborator(String username) {
		if(!username.isEmpty()) {
			System.out.println(username+"is added successfully");
			this.collaborators.add(username);
			return true;
		}
		return false;
	}
	
	public boolean removeCollaborator(String username) {
		for(int i = 0; i < this.collaborators.size();i++) {
			if(this.collaborators.get(i).equals(username)) {
				System.out.println(username+"is removed successfully.");
				this.collaborators.remove(i);
				return true;
			}
		}
		System.out.println(username+"cannot be removed");
		return false;
	}
	
	public double getMonthlyBill() {
		double sum = this.fee + (COLLABORATOR_FREE* this.collaborators.size());
		return sum;
	}
	public void printMemberInfo() {
		System.out.println("--- PRO MEMBER ---");
		System.out.println("Member fee : " + fee);
		System.out.println("Email" + this.email + "(pwd: " + this.password + ")" );
		for(Repository repo: repoList) {
			if(repo.isPrivate()) {
				System.out.println("Name: " + repo.getName() + "(Private)");
			}else {
				System.out.println("Name: " + repo.getName() + "(Public)");
			}
			
		}
		
	}

}
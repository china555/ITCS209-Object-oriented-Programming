import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
	public String firstname;
	public String lastname;
	public MyDate birthday;
	Person(String aFirstname, String aLastname){
		this.firstname = aFirstname;
		this.lastname = aLastname;
	}
	Person(String aFirstname, String aLastname, int aYear, int aMonth, int aDay){
		this.firstname = aFirstname;
		this.lastname = aLastname;
		this.birthday = new MyDate(aYear, aMonth, aDay);
		
	}
	public int getAge(MyDate aDate) {
		//LocalDate now = LocalDate.now();
		//MyDate data = new MyDate(now.getYear() ,now.getMonthValue()   ,now.getDayOfMonth());
		MyDate data = new MyDate(aDate.year,  aDate.month, aDate.day);
		return aDate.yearDiff(birthday,data);
	}
	public boolean isEligible(MyDate elecDate) {
		if(elecDate.year - birthday.year>=18) {
			return true ;
		}
		else {
		return false ;
		}
	}
	public void printPersonInfo() {
		System.out.println("Person: "+this.firstname+"  "+this.lastname);
		System.out.println("Birthday: "+this.birthday.day+" "+this.birthday.strmonths[this.birthday.month-1]+" "+this.birthday.year);
	}
}

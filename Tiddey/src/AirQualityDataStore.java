import java.time.LocalDateTime;
import java.util.Locale;

public class AirQualityDataStore {
	
	public static void main(String[] args)
	{
		LocalDateTime today = LocalDateTime.now();
		AirQualityProfile x = new  AirQualityProfile(today,"Thonburi" ,112,40,  29, "Few clouds");
		x.printAirQualityInfo();
		//System.out.println(x.isUnhealthy());
		x.isUnhealthy();
		AirQualityProfile BKK = new AirQualityProfile(today, "Bangkok", 55, 11, 29, "Few Clouds");
		BKK.printAirQualityInfo();
		BKK.isUnhealthy();
		System.out.println(BKK.count);
		
			
	}

}

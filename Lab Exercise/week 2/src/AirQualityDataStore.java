import java.time.LocalDateTime;

public class AirQualityDataStore {
	public static void main(String[] args) {
			LocalDateTime today = LocalDateTime.now();
			AirQualityProfile2 Delhi = new AirQualityProfile2(today, "Delhi",420,380,29,"Few cloud");
			AirQualityProfile2 Shanghai = new AirQualityProfile2(today, "Shanghai", 184, 119,9,"Sunny");
			AirQualityProfile2 data1 = new AirQualityProfile2(today,"Thon Buri",112,40,29,"Few clouds");
			data1.printAirQualityInfo();
			Delhi.printAirQualityInfo();
			Shanghai.printAirQualityInfo();
	}
}

//public static void main(String[] args) {
//AirQualityProfile Delhi = new AirQualityProfile("2019-01-20 09:30", "Delhi",420,380,29,"Few cloud");
//AirQualityProfile Shanghai = new AirQualityProfile("2019-01-20", "Shanghai", 184, 119,9,"Sunny");
////AirQualityProfile.printAirQualityInfo(Delhi);
////AirQualityProfile.printAirQualityInfo(Shanghai);
//Delhi.printAirQualityInfo();
//Shanghai.printAirQualityInfo();
//
//}
import java.time.LocalDateTime;

public class AirQualityProfile {
	private LocalDateTime datetime; 
	private String location;
	private int aqi;
	private int pm25;
	private int temp;
	private String weather;
	public static int count=0;
	
	
	public AirQualityProfile(LocalDateTime datetime,String location,int aqi ,int pm25,int temp,String weather)
	{		
		this.datetime=datetime;
		this.location=location;
		this.aqi=aqi;
		this.pm25=pm25;
		this.temp=temp;
		this.weather=weather;
		count++;
		
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public void printAirQualityInfo()
	{
		System.out.println(location +" at " + datetime  );
		System.out.println("AQI: "+ aqi + " PM2.5: " + pm25 + " microgram/m3"  );
		System.out.println(temp + " celsius" + "( " + weather +  ")");
		
		
		
	}
	/* public String isUnhealthy()
	 {
		 if (aqi>100 )
		 {
			 return "true";
			 
		 }
		 else
			 return "false";
	 }
			 */
	public void isUnhealthy()
	{
		if(aqi>100)
			System.out.println("True");
		else
			System.out.println("False");
		
	}
	
	
	

}

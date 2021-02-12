import java.time.LocalDateTime;

public class AirQualityProfile2 {
	private static LocalDateTime datetime;
	private String location; 
	private int aqi;
	private int pm25;
	private int temp;
	private String weather;
	public static int count =0;
	public AirQualityProfile2(LocalDateTime datatime,String location,int aqi,int pm25,int temp,String weather) {
		this.datetime=datatime;
		this.location=location;
		this.aqi=aqi;
		this.pm25=pm25;
		this.temp=temp;
		this.weather=weather;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime2) {
		this.datetime = datetime2;// = "2019-01-18 18:00";
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location; //="ThonBuri";
	}
	public int getAqi() {
		return aqi;
	}
	public void setAqi(int aqi) {
		this.aqi = aqi;//=112;
	}
	public int getPm25() {
		return pm25;
	}
	public void setPm25(int pm25) {
		this.pm25 = pm25;//=40;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;//=29;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;//="Few clouds";
	}
//	public static void printAirQualityInfo(AirQualityProfile2 data) {
//		System.out.println(data.location+" at "+AirQualityProfile2.datetime+"\n"+"AQI: "+data.aqi+", PM2.5:"+data.pm25+"microgram/m3\n"+data.temp+"celsius "+"("+data.weather+")");
//		System.out.println(isUnhealty(data));
//		System.out.println(bad(data));
//		count++;
//		System.out.println(count);
//	}
	public void printAirQualityInfo() {
		System.out.println(getlocation()+" at "+getDatetime()+"\n"+"AQI: "+getAqi()+", PM2.5:"+getPm25()+"microgram/m3\n"+getTemp()+"celsius "+"("+getWeather()+")");
		System.out.println(isUnhealty());
		System.out.println(bad());
		count++;
		System.out.println(count);
	}
	public  String isUnhealty() {
		if(getAqi()>100) {
			return "True";
		}
		return "False";
	}
	public String bad() {
		if(getPm25()>100) {
			return "Your body are in danger";
		}
		return "Safe";
	}
}



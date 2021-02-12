
public class AirQualityProfile {
	private String datetime;
	private String location;
	private int aqi;
	private int pm25;
	private int temp;
	private String weather;
	public AirQualityProfile(String datetime,String location,int aqi,int pm25,int temp,String weather) {
		this.datetime = datetime;
		this.location = location;
		this.aqi =aqi;
		this.pm25 = pm25;
		this.temp = temp;
		this.weather = weather;
	}
	public AirQualityProfile() {
		// TODO Auto-generated constructor stub
		this.location = "thai";
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;// = "2019-01-18 18:00";
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
	public static void  main(String[] args) {
		AirQualityProfile data1 = new AirQualityProfile("2019-01-18 18:00","Thon Buri",112,40,29,"Few clouds");
		//printAirQualityInfo(data1);
		data1.printAirQualityInfo();
	}
//1	public static void printAirQualityInfo(AirQualityProfile data) {
//		System.out.println(data.location+" at "+data.datetime+"\n"+"AQI: "+data.aqi+", PM2.5:"+data.pm25+"microgram/m3\n"+data.temp+"celsius "+"("+data.weather+")");
//	}
	public void printAirQualityInfo() {
		System.out.println(getlocation()+" at "+getDatetime()+"\n"+"AQI: "+getAqi()+", PM2.5:"+getPm25()+"microgram/m3\n"+getTemp()+"celsius "+"("+getWeather()+")");
	}
}


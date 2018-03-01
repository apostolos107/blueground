//This class holds the information of the search you want to do

public class SearchInfo {

    String apiKey;
    String city;
    String day;

    SearchInfo(String apiKey, String city , String day){
        this.apiKey = apiKey;
        this.city = city;
        this.day = day;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getCity() {
        return city;
    }

    public String getDay() {
        return day;
    }

}

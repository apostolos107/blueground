
public class Main{
    public static void main (String [] args){
        SearchInfo info = new SearchInfo("1acb4f567efb21d8","New_York","20171030");
        DailyResults summary = new DailyResults();
        summary.Calculate(info);
        summary.writeFile();
    }

}
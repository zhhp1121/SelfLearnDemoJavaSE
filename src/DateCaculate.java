import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateCaculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		millisToTime(1543460880000L);
	}
	
//	1542181500000
	
	public static int[] millisToTime(long nowMillis) {
	    int[] splitDate = new int[6];
	    Calendar now = Calendar.getInstance();
	    now.setTimeInMillis(nowMillis);

	    DateFormat formatter1 = new SimpleDateFormat("yyyy");
	    splitDate[0] = Integer.valueOf(formatter1.format(now.getTime()));

	    DateFormat formatter2 = new SimpleDateFormat("MM");
	    splitDate[1] = Integer.valueOf(formatter2.format(now.getTime()));

	    DateFormat formatter3 = new SimpleDateFormat("dd");
	    splitDate[2] = Integer.valueOf(formatter3.format(now.getTime()));

	    DateFormat formatter4 = new SimpleDateFormat("HH");
	    splitDate[3] = Integer.valueOf(formatter4.format(now.getTime()));

	    DateFormat formatter5 = new SimpleDateFormat("mm");
	    splitDate[4] = Integer.valueOf(formatter5.format(now.getTime()));

	    DateFormat formatter6 = new SimpleDateFormat("ss");
	    splitDate[5] = Integer.valueOf(formatter6.format(now.getTime()));
	    System.out.println(splitDate[0]+":"+splitDate[1]+":"+splitDate[2]+":"+splitDate[3]+":"+splitDate[4]+":"+splitDate[5]);
	    return splitDate;
	}

}



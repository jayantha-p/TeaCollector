
package TeaCollector;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

public class DateAndTime {
    String date;
    String time;
    void showDate(){
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        date = s.format(d);
    }
    public void showTime(){
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                java.util.Date d = new java.util.Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                time = s.format(d);
            }
        }).start();
    }
}

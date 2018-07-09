package com.mydavidjerome.android.musicalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.deezer.sdk.model.Album;
import com.deezer.sdk.model.Permissions;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.connect.event.DialogListener;
import com.deezer.sdk.network.request.DeezerRequest;
import com.deezer.sdk.network.request.DeezerRequestFactory;
import com.deezer.sdk.network.request.event.JsonRequestListener;
import com.deezer.sdk.network.request.event.RequestListener;
import com.mydavidjerome.android.musicalarm.AlarmReceiver;
import com.mydavidjerome.android.musicalarm.R;

import java.util.Calendar;
import java.util.List;

//imports Deezer may need
/*import com.deezer.sdk.model
import com.deezer.sdk.network.connect
import com.deezer.sdk.network.connect.event
        com.deezer.sdk.network.request
        com.deezer.sdk.network.request.event
        com.deezer.sdk.player
        com.deezer.sdk.player.event
        com.deezer.sdk.player.exception
        com.deezer.sdk.player.networkcheck*/

public class MainActivity extends AppCompatActivity {
    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    Activity testAct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker = findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        // replace with your own Application ID
        //Deezer set id


        // The listener for authentication events

    };

        // Launches the authentication process


        // the request listener





    public void OnToggleClicked(View view)
    {

        long time;
        if (((ToggleButton) view).isChecked())
        {
            //startActivity(Intent)
            Toast.makeText(MainActivity.this, "ALARM ON", Toast.LENGTH_SHORT).show();
            Calendar calendar=Calendar.getInstance();

            int currentApiVersion = android.os.Build.VERSION.SDK_INT;
            if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1)
            {
                calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());
            }
            else {
                calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getCurrentHour());
                calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
            }

            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time)
            {
                if (Calendar.AM_PM == 0)
                    time = time + (1000*60*60*12);
                else
                    time = time + (1000*60*60*24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);
        }
        else
        {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
        }
        //public class DeezerConnect.Builder();
    }

}
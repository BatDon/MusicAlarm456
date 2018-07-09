package com.mydavidjerome.android.musicalarm;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.deezer.sdk.model.Permissions;
import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.network.connect.event.DialogListener;
import com.deezer.sdk.player.AlbumPlayer;
import com.deezer.sdk.player.networkcheck.NetworkStateCheckerFactory;
import com.deezer.sdk.player.networkcheck.WifiAndMobileNetworkStateChecker;
import com.deezer.sdk.player.networkcheck.WifiOnlyNetworkStateChecker;

import static com.deezer.sdk.network.connect.DeezerConnect.forApp;
//new DeezerConnect.Builder();
public class AlarmReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        String application = "30595446";
        Toast.makeText(context, "Wake up!", Toast.LENGTH_LONG).show();
        // create the player
        String applicationID = "280982";
        //Permission doesn't work yet
        // The set of Deezer Permissions needed by the app
        String[] permissions = new String[]{
                Permissions.BASIC_ACCESS,
                Permissions.MANAGE_LIBRARY,
                Permissions.LISTENING_HISTORY};
        DialogListener listener = new DialogListener() {

            public void onComplete(Bundle values) {
            }

            public void onCancel() {
            }

            public void onException(Exception e) {
            }
        };



        //Activity was in MainActivity under alarm Manager in onCreate
        Activity activity = new AppCompatActivity();
        Intent intentToConnect = new Intent(context,ConnectToMusic.class);
        activity.startActivity(intentToConnect);
        DeezerConnect deezerConnect = new DeezerConnect.Builder().withContext(context,"30595446");

        deezerConnect.authorize(activity, permissions, listener);
        AlbumPlayer albumPlayer = new AlbumPlayer("30595446", deezerConnect, new WifiOnlyNetworkStateChecker());

        // start playing music
        //7777long albumId = 89142;
        //7777albumPlayer.playAlbum(albumId);

        // ...

        // to make sure the player is stopped (for instance when the activity is closed)
        //7777 albumPlayer.stop();
        //7777 albumPlayer.release();
        /* Before Deezer to play music
        MediaPlayer ring= MediaPlayer.create(context,R.raw.dubs);
        String songString = android.net.Uri.parse("file://" + R.raw.dubs).getPath();
        Uri alarmUri=Uri.parse(songString);
        //Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALL);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();*/

        //MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
        //ring.start();
    }
    //{
        /*Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALL);
        if (alarmUri == null)
        {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        //MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.ring);
        //ring.start();*/
   // }
}

package com.mydavidjerome.android.musicalarm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.deezer.sdk.network.connect.DeezerConnect;
import com.deezer.sdk.player.AlbumPlayer;
import com.deezer.sdk.player.networkcheck.WifiOnlyNetworkStateChecker;
import com.deezer.sdk.network.connect.DeezerConnect.Builder;

public class ConnectToMusic extends AppCompatActivity {


    DeezerConnect deezerConnect = new DeezerConnect.Builder().withContext(this,"30595446");

        deezerConnect.authorize(activity, permissions, listener);
    AlbumPlayer albumPlayer = new AlbumPlayer("30595446", deezerConnect, new WifiOnlyNetworkStateChecker());
    long albumId = 89142;
        albumPlayer.playAlbum(albumId);
    albumPlayer.stop();
        albumPlayer.release();
}

package com.example.leguern_boy_33.myapplication;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.NotificationCompat.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.button1:
                Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_LONG).show();
                break;

            case R.id.button2:
                NotificationCompat.Builder mBuilder = (Builder) new Builder(this)
                        .setContentTitle("Avez vous une petite soif ?")
                        .setContentText("Voici notre selection")
                        .setSmallIcon(android.R.drawable.alert_dark_frame);
                Intent resultIntent = new Intent(this, FirstActivity.class);
                PendingIntent resultPendingIndent = PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(resultPendingIndent);

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0, mBuilder.build());
                break;


            case R.id.button3:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.choix)
                        .setTitle(R.string.title);
                AlertDialog dialog = builder.create(); //la boite de dialogue est créée
                dialog.show(); //Sans cette ligne, pas de pop-up
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Toast
        Button btton = (Button)findViewById(R.id.button1);
        btton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.toast),Toast.LENGTH_LONG).show();
            }
        });

    }



}
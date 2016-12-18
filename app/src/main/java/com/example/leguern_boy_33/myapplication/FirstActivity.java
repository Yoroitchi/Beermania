package com.example.leguern_boy_33.myapplication;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FirstActivity extends AppCompatActivity implements CheckDownload{

    public static String BIERS_UPDATE = "com.octip.cours.inf4042_11.BIERS_UPDATE";
    BiersAdapter biersAdapter;
    public JSONArray getBiersFromFile(){
        try{
            InputStream is = new FileInputStream(getCacheDir()+ "/" + "bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer, "UTF-8")); //Construction du tableau
        } catch (IOException e){
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        GetBiersServices.startActionBiers(this);

        IntentFilter filter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(this),filter);

        //Button Toast :
        // [edit] mis en commentaire lors de la suppression de son existence dans le XML, autrement l'appli crashait
      /*  Button yo = (Button)findViewById(R.id.button1);
        yo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),getString(R.string.title),Toast.LENGTH_LONG).show();
            }
        });*/

        //Binding du Recycler
        RecyclerView rv_oui = (RecyclerView) findViewById(R.id.rv_biere);
        rv_oui.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Ajout de l'Adapter
        biersAdapter = new BiersAdapter(getBiersFromFile());

        //Affichage du JSON array téléchargé
        rv_oui.setAdapter(biersAdapter);
    }

    @Override
    public void DlFinished() {
        biersAdapter.setNewBiere(getBiersFromFile());
    }
}

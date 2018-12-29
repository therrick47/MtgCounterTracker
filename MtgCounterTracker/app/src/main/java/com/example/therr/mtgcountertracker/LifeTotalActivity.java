package com.example.therr.mtgcountertracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class LifeTotalActivity extends AppCompatActivity {

    ListView listView;
    private static LifeViewCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(GameData.playerList == null) {
            GameData.SetupPlayerList(2);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_total);

        listView = (ListView) findViewById(R.id.LifeListView);
        adapter = new LifeViewCustomAdapter(GameData.playerList,getApplicationContext());
        listView.setAdapter(adapter);
    }
}

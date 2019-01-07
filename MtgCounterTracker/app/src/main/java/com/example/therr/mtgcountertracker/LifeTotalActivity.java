package com.example.therr.mtgcountertracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;

public class LifeTotalActivity extends AppCompatActivity {

    ListView listView;
    private static LifeViewCustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_total);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(GameData.playerList == null) {
            GameData.SetupPlayerList(2);
        }

        listView = (ListView) findViewById(R.id.LifeListView);
        adapter = new LifeViewCustomAdapter(GameData.playerList,getApplicationContext());
        listView.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    public void AddPlayerClicked(MenuItem menuItem){
        GameData.AddPlayer();
        adapter.UpdatePlayerList();
    }
    public void RemovePlayerClicked(MenuItem menuItem){
        if(GameData.playerList.size()>1) {
            GameData.RemoveLastPlayer();
            adapter.UpdatePlayerList();
        }
    }
}

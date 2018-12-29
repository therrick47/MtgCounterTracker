package com.example.therr.mtgcountertracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LifeViewCustomAdapter extends ArrayAdapter<Player> implements View.OnClickListener {
    private Context context;
    private ArrayList<Player> players;

    public LifeViewCustomAdapter(ArrayList<Player> playerArrayList, Context newContext) {
        super(newContext, R.layout.life_total_list_item, playerArrayList);
        context = newContext;
        players = playerArrayList;
    }

    private static class ViewHolder {
        TextView playerLife;
        TextView playerName;
        Button btnDec;
        Button btnInc;
    }

    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        Player player = (Player) object;
        switch (view.getId()) {
            case R.id.btnIncrease:
                player.IncrementLife();
                this.notifyDataSetChanged();
                break;
            case R.id.btnDecrease:
                player.DecrementLife();
                this.notifyDataSetChanged();
                break;
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.life_total_list_item, parent, false);
            holder.playerLife = convertView.findViewById(R.id.txtLife);
            holder.playerName = convertView.findViewById(R.id.txtName);
            holder.btnDec = convertView.findViewById(R.id.btnDecrease);
            holder.btnInc = convertView.findViewById(R.id.btnIncrease);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.playerLife.setText("Life: "+player.GetLifeAsString());
        holder.playerName.setText(player.GetName());
        holder.btnInc.setOnClickListener(this);
        holder.btnDec.setOnClickListener(this);
        holder.btnInc.setTag(position);
        holder.btnDec.setTag(position);
        return convertView;
    }
}

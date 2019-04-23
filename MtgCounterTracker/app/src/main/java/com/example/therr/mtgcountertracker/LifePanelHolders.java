package com.example.therr.mtgcountertracker;

import android.widget.Button;
import android.widget.TextView;


public class LifePanelHolders {
    public static class LifePanelViewHolder {
        TextView playerLife;
        TextView playerName;
        Button btnDec;
        Button btnInc;
    }
    private static class CmdrDmgHolder{
        Button btnDecDmg;
        Button btnIncDmg;
        TextView txtDmg;
        TextView playerName;
    }
}

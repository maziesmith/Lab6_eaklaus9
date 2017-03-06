package com.cs60333.eaklaus.lab1_eklaus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eakla on 2/10/2017.
 */

public class ScheduleAdapter extends ArrayAdapter<Team> {
    public ScheduleAdapter (Context context, ArrayList<String[]> schedule) {
        super(context, R.layout.schedule_item, schedule);

    }
    public View getView (int position, View convertView, ViewGroup parent) {
        LayoutInflater scheduleInflater = LayoutInflater.from(getContext());
        View scheduleView = scheduleInflater.inflate(R.layout.schedule_item, parent, false);

        String[] matchItem = getItem(position);
        TextView teamName = (TextView) scheduleView.findViewById(R.id.team_name);
        teamName.setText(matchItem[1]);

        // Set the date
        TextView date = (TextView) scheduleView.findViewById(R.id.date);
        date.setText(matchItem[2]);

        // Set the team image
        ImageView teamLogo = (ImageView) scheduleView.findViewById(R.id.teamlogo);
        String mDrawableName = matchItem[0];
        int resID = getContext().getResources().getIdentifier(mDrawableName , "drawable", getContext().getPackageName());
        teamLogo.setImageResource(resID );
        return scheduleView;
    }
}
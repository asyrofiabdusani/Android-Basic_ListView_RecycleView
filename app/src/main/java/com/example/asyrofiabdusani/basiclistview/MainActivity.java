package com.example.asyrofiabdusani.basiclistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private listAdapter mAdapter;
    private ListView listView;
    private ArrayList <simpleList> list = new ArrayList<simpleList>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        mAdapter = new listAdapter(this, list);

        list.add(new simpleList("VR", "Valentino Rossi", "Italy"));
        list.add(new simpleList("MM", "Marc Marquez", "Spain"));
        list.add(new simpleList("DP", "Dani Pedrosa","Spain"));
        list.add(new simpleList("JL","Jorge Lorenzo", "Spain"));
        list.add(new simpleList("AD","Andrea Dovisiozo","Italy"));
        list.add(new simpleList("AI","Andrea Ianone","Italy"));
        list.add(new simpleList("CC","Call Crutchlow", "England"));
        list.add(new simpleList("FM", "Franco Morbidelli","Italy"));
        list.add(new simpleList("JZ","Johan Zarco","France"));
        list.add(new simpleList("HS","Hafiz Syahrin","Malaysia"));
        list.add(new simpleList("PE","Pol Espargaro", "Spain"));
        list.add(new simpleList("AE", "Alex Espargaro", "Spain"));
        list.add(new simpleList("AR","Alex Rins","Spain"));

        listView.setAdapter(mAdapter);

    }
}

class simpleList{
    private String uTitle;
    private String uText1;
    private String uText2;

    public simpleList (String defTitle, String defText1, String defText2){
        uTitle = defTitle;
        uText1 = defText1;
        uText2 = defText2;
    }

    public String getuTitle(){
        return uTitle;
    }

    public String getuText1(){
        return uText1;
    }

    public String getuText2(){
        return uText2;
    }
}

class listAdapter extends ArrayAdapter<simpleList>{

    public listAdapter(@NonNull Context context, ArrayList<simpleList> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_layout, parent, false);
        }

        simpleList listSimple = (simpleList) getItem(position);

        TextView txtTitle = (TextView) listItem.findViewById(R.id.title_text);
        txtTitle.setText(listSimple.getuTitle());

        TextView txt1 = (TextView) listItem.findViewById(R.id.text1);
        txt1.setText(listSimple.getuText1());

        TextView txt2 = (TextView) listItem.findViewById(R.id.text2);
        txt2.setText(listSimple.getuText2());

        return listItem;
    }
}

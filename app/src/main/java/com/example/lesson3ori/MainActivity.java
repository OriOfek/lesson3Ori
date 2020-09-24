package com.example.lesson3ori;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener{
    ListView ls;
    Spinner sn;
    TextView capitel;
    TextView languge;
    TextView poplation;
    TextView nationalSong;
    String[] lands;
    int row;
    String[][] countries;
    String[][][] info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row = 0;
        sn = (Spinner)findViewById(R.id.spinner);
        ls = (ListView) findViewById(R.id.ls);
        capitel = (TextView) findViewById(R.id.cap);
        languge = (TextView) findViewById(R.id.lang);
        poplation = (TextView) findViewById(R.id.pop);
        nationalSong = (TextView) findViewById(R.id.song);
        lands = new String[]{"Africa","Europe","Asia","America"};
        countries = new String[][]{{"Nigeria","Ethiopia","Egypt","South Africa","Kenya","Uganda","Algeria"},
                {"Russia","Germany","United Kingdom","France","Italy","Spain","Ukraine"},
                {"China","India","Indonesia","Pakistan","Bangladesh","Japan","Philippines"}
        ,{"United States","Brazil","Mexico","Colombia","Argentina","Canada","Peru"}};
        info = new String[][][] {     { {"English","195.9M","Arise, O Compatriots","Abuja"},{ } }
        ,{   {}},   }; //contains{   { country1{languge,poplation,song,capitel} country2{things}  }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
                ,R.layout.support_simple_spinner_dropdown_item,lands);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sn.setAdapter(adapter);
        sn.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this
                ,R.layout.support_simple_spinner_dropdown_item,countries[pos]);
        row = pos;
        ls.setAdapter(adp);
        ls.setOnItemClickListener(this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        capitel.setText(info[row][i][3]);
        poplation.setText(info[row][i][1]);
        nationalSong.setText(info[row][i][2]);
        languge.setText(info[row][i][0]);


    }
}
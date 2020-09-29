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
    TextView capital;
    TextView language;
    TextView population;
    TextView nationalSong;
    String[] lands;
    int row;
    ArrayAdapter<String> adp;
    String[][] countries;
    String[][][] info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        row = 0;
        sn = (Spinner)findViewById(R.id.spinner);
        ls = (ListView) findViewById(R.id.ls);
        capital = (TextView) findViewById(R.id.cap);
        language = (TextView) findViewById(R.id.lang);
        population = (TextView) findViewById(R.id.pop);
        nationalSong = (TextView) findViewById(R.id.song);
        lands = new String[]{"","Africa","Europe","Asia","America"};
        countries = new String[][]{{"Nigeria","Ethiopia","Egypt","South Africa","Kenya","Uganda","Algeria"},
                {"Russia","Germany","United Kingdom","France","Italy","Spain","Ukraine"},
                {"China","India","Indonesia","Pakistan","Bangladesh","Japan","Philippines"}
        ,{"United States","Brazil","Mexico","Colombia","Argentina","Canada","Peru"}};
        info = new String[][][] {     { {"English","195.9M","Arise, O Compatriots","Abuja"}, //Niferia
                {"Amharic","109.2M","Ethiopia, Be happy","Addis Ababa" },//Ethiopia
                {"Masri","98.42M","Bilady, Bilady, Bilady","Cairo" },
                {"Afrikaans","57.78M","National anthem of South Africa","Pretoria" },
                {"Swahili","47.564M","Ee Mungu Nguvu Yetu","Nairobi" },
                {"English and Swahili","42.729M","Oh Uganda, Land of Beauty","Kampala" },
                {"Arabic and Berber","43.6M","Kassaman","Algiers" }},
           { {"Russian","146.748M","Государственный гимн Российской Федерации","Moscow"},
                {"German","83.166M","Deutschlandlied","Berlin" },
                   {"English","67.886M","God Save the Queen","London" },
                {"French","67.081M","La Marseillaise","Paris" },
                {"Italian","60.3174M","The Song of the Italians","Rome" },
                {"Spanish","47.431M","Marcha Real","Madrid" },
                {"Ukrainian","41.660M","Derzhavnyi Himn Ukrayiny","Kyiv" }} ,
                { {"Standard Chinese","1,400,050,000","义勇军进行曲","Beijing"},
                        {"Hindi and English","1,352,642,280","Jana Gana Mana","New Delhi" },
                        {"Indonesian","267.670M","Indonesia Raya","Jakarta" },
                        {"English and Urdu","212,228M","Qaumī Tarānah","Islamabad" },
                        {"Bengali","161.376M","Amar Sonar Bangla","Dhaka" },
                        {"Japanese","125.960M","Kimigayo","Tokyo" },
                        {"Filipino and English","109.048M","Lupang Hinirang","Manila" }},
                { {"English","328.239M","The Star-Spangled Banner","Washington, D.C."},
                {"Portuguese","210.147M","Hino Nacional Brasileiro","Brasília" },
                {"Spanish","128.649M","Himno Nacional Mexicano","Mexico City" },
                {"English and Spanish","50.372M","Himno Nacional de la República de Colombia","Bogotá" },
                {"None(there are many languages)","44.938M","Himno Nacional Argentino","Buenos Aires" },
                {"English and French","37.971M","O Canada","Ottawa" },
                {"Spanish","32.824M","Himno Nacional del Perú","Lima" }}}; //contains{   { country1{languge,poplation,song,capitel} country2{things}  }

        adp = new ArrayAdapter<String>(this
                ,R.layout.support_simple_spinner_dropdown_item,lands);
        sn.setAdapter(adp);
        sn.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        if (pos != 0) {
            ls.setVisibility(View.VISIBLE);

            adp = new ArrayAdapter<String>(this
                    , R.layout.support_simple_spinner_dropdown_item, countries[pos - 1]);
            row = pos;
            ls.setAdapter(adp);
            ls.setOnItemClickListener(this);
        }
        else
        {
            ls.setVisibility(View.INVISIBLE);
            capital.setText("");
            population.setText("");
            nationalSong.setText("");
            language.setText("");
        }

        row = pos-1;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        capital.setText("capital = " + info[row][i][3]);
        population.setText("population = " + info[row][i][1]);
        nationalSong.setText("anthem = " + info[row][i][2]);
        language.setText("language  = " + info[row][i][0]);
    }
}
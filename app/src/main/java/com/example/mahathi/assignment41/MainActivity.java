package com.example.mahathi.assignment41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.Button;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView list;
    Button mAscButton,mDescButton;
    ArrayAdapter<String> adapter,adapter1,adapter2;

    String[] months= new String[]{"Jan","Feb","March", "April", "May", "June", "July"};
    List<String> sortedMonthsList = Arrays.asList(months);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAscButton = (Button) findViewById(R.id.asc_button);
        mDescButton = (Button) findViewById(R.id.desc_button);
        list =  (ListView)findViewById(R.id.list);
        //Seting the list items to Arrayadapter
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
        list.setAdapter(adapter);

        mAscButton.setOnClickListener(this);
        mDescButton.setOnClickListener(this);
    }

    // Comparator for Ascending Order
    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName1.compareToIgnoreCase(stringName2);
        }
    };
    //Comparator for Descending Order

    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;

            return stringName2.compareToIgnoreCase(stringName1);
        }
    };
    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.asc_button :
                Collections.sort(sortedMonthsList,StringAscComparator);
                ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sortedMonthsList);
                list.setAdapter(adapter1);
                adapter1.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
                break;
            case R.id.desc_button :
                Collections.sort(sortedMonthsList,StringDescComparator);
                ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,sortedMonthsList);
                list.setAdapter(adapter2);
                adapter2.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
                break;
        }

    }
}

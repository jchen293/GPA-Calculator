package io.github.httpsjchen293.simplegpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 8/9/17.
 */
public class homeScreen extends AppCompatActivity {
    Button college, hs;
    Spinner more;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        college = (Button) findViewById(R.id.button2s);
        hs = (Button) findViewById(R.id.button);
        more = (Spinner) findViewById(R.id.spinner11);

        hs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, HsGpa.class);

                startActivity(intent);

            }
        });
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(homeScreen.this, MainActivity.class);

                startActivity(intent);

            }
        });


        List<String> items = new ArrayList<String>();
        items.add("More");
        items.add("Contact");
        items.add("About");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        more.setAdapter(dataAdapter1);


        more.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) more.getSelectedItem().toString();

                if(str.equals("More")){

                }else if (str.equals("Contact")){
                 Intent intent = new Intent(homeScreen.this, contact.class);

                startActivity(intent);

                }else{
                    Intent intent = new Intent(homeScreen.this, about.class);

                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }
}

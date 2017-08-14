package io.github.httpsjchen293.simplegpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText edt1, edt2, credit1, credit2, credit3, credit4, credit5, credit6, credit7, credit8, credit9, credit10;
    Spinner spinner, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10;
    Button cal, clear, back;
    TextView gpa, semGpa;
    double grade11, grade22,grade33,grade44,grade55,grade66,grade77,grade88,grade99,grade00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        credit1 = (EditText) findViewById(R.id.credit1);
        credit2 = (EditText) findViewById(R.id.credit2);
        credit3 = (EditText) findViewById(R.id.credit3);
        credit4 = (EditText) findViewById(R.id.credit4);
        credit5 = (EditText) findViewById(R.id.credit5);
        credit6 = (EditText) findViewById(R.id.credit6);
        credit7 = (EditText) findViewById(R.id.credit7);
        credit8 = (EditText) findViewById(R.id.credit8);
        credit9 = (EditText) findViewById(R.id.credit9);
        credit10 = (EditText) findViewById(R.id.credit10);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);
        spinner9 = (Spinner) findViewById(R.id.spinner9);
        spinner10 = (Spinner) findViewById(R.id.spinner10);

        cal = (Button) findViewById(R.id.cal);
        clear = (Button) findViewById(R.id.clear);
        back = (Button) findViewById(R.id.back);

        gpa = (TextView) findViewById(R.id.gpa);
        semGpa = (TextView) findViewById(R.id.semGpa);

        // Spinner click listener

        List<String> categories = new ArrayList<String>();
        categories.add("");
        categories.add("A");
        categories.add("A-");
        categories.add("B+");
        categories.add("B");
        categories.add("B-");
        categories.add("C+");
        categories.add("C");
        categories.add("C-");
        categories.add("D+");
        categories.add("D");
        categories.add("F");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);
        spinner6.setAdapter(dataAdapter);
        spinner7.setAdapter(dataAdapter);
        spinner8.setAdapter(dataAdapter);
        spinner9.setAdapter(dataAdapter);
        spinner10.setAdapter(dataAdapter);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float GPA = Float.parseFloat(edt1.getText().toString());
                float credits = Float.parseFloat(edt2.getText().toString());
                float credits1 = Float.parseFloat(credit1.getText().toString());
                float credits2 = Float.parseFloat(credit2.getText().toString());
                float credits3 = Float.parseFloat(credit3.getText().toString());
                float credits4 = Float.parseFloat(credit4.getText().toString());
                float credits5 = Float.parseFloat(credit5.getText().toString());
                float credits6 = Float.parseFloat(credit6.getText().toString());
                float credits7 = Float.parseFloat(credit7.getText().toString());
                float credits8 = Float.parseFloat(credit8.getText().toString());
                float credits9 = Float.parseFloat(credit9.getText().toString());
                float credits10 = Float.parseFloat(credit10.getText().toString());

                double gpa1 = grade11*credits1;
                double gpa2 = grade22*credits2;
                double gpa3 = grade33*credits3;
                double gpa4 = grade44*credits4;
                double gpa5 = grade55*credits5;
                double gpa6 = grade66*credits6;
                double gpa7 = grade77*credits7;
                double gpa8 = grade88*credits8;
                double gpa9 = grade99*credits9;
                double gpa10 = grade00*credits10;

                double cGpa = GPA * credits;


                double totalCredits = credits + credits1 + credits2 + credits3 + credits4 + credits5 + credits6 + credits7 + credits8 + credits9 + credits10;
                double semTotalCredits = credits1 + credits2 + credits3 + credits4 + credits5 + credits6 + credits7 + credits8 + credits9 + credits10;

                double totalGpa = roundThreeDecimals(((cGpa) + (gpa1) + (gpa2) + (gpa3) + (gpa4) + (gpa5) + (gpa6) + (gpa7) + (gpa8) + (gpa9) + (gpa10)) / ((totalCredits)));
                double semGPA = roundThreeDecimals(((gpa1) + (gpa2) + (gpa3) + (gpa4) + (gpa5) + (gpa6) + (gpa7) + (gpa8) + (gpa9) + (gpa10)) / (semTotalCredits));

                gpa.setText("Overall GPA: " + totalGpa);
                semGpa.setText("Term GPA: " + semGPA);

                if(totalGpa>=3.0){
                    showToast2(v);
                }else if(totalGpa>=2.0){
                    showToast3(v);
                }else if(totalGpa <2.0){
                    showToast4(v);
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edt1.setText("0");
                edt2.setText("0");
                credit1.setText("0");
                credit2.setText("0");
                credit3.setText("0");
                credit4.setText("0");
                credit5.setText("0");
                credit6.setText("0");

                reset();

                showToast(v);
                gpa.setText("Overall GPA: ");
                semGpa.setText("Term GPA: ");

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, homeScreen.class);

                startActivity(intent);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit1.setText("0");
                    grade11 = 0.0;
                } else if (str.equals("A")) {
                    grade11 = 4.0;
                } else if (str.equals("A-")) {
                    grade11 = 3.667;
                } else if (str.equals("B+")) {
                    grade11 = 3.334;
                } else if (str.equals("B")) {
                    grade11 = 3.0;
                } else if (str.equals("B-")) {
                    grade11 = 2.667;
                } else if (str.equals("C+")) {
                    grade11 = 2.334;
                } else if (str.equals("C")) {
                    grade11 = 2.0;
                } else if (str.equals("C-")) {
                    grade11 = 1.667;
                } else if (str.equals("D+")) {
                    grade11 = 1.334;
                } else if (str.equals("D")) {
                    grade11 = 1.0;
                } else {
                    grade11 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner2.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit2.setText("0");
                    grade22 = 0.0;
                } else if (str.equals("A")) {
                    grade22 = 4.0;
                } else if (str.equals("A-")) {
                    grade22 = 3.667;
                } else if (str.equals("B+")) {
                    grade22 = 3.334;
                } else if (str.equals("B")) {
                    grade22 = 3.0;
                } else if (str.equals("B-")) {
                    grade22 = 2.667;
                } else if (str.equals("C+")) {
                    grade22 = 2.334;
                } else if (str.equals("C")) {
                    grade22 = 2.0;
                } else if (str.equals("C-")) {
                    grade22 = 1.667;
                } else if (str.equals("D+")) {
                    grade22 = 1.334;
                } else if (str.equals("D")) {
                    grade22 = 1.0;
                } else {
                    grade22 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner3.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit3.setText("0");
                    grade33 = 0.0;
                } else if (str.equals("A")) {
                    grade33 = 4.0;
                } else if (str.equals("A-")) {
                    grade33 = 3.667;
                } else if (str.equals("B+")) {
                    grade33 = 3.334;
                } else if (str.equals("B")) {
                    grade33 = 3.0;
                } else if (str.equals("B-")) {
                    grade33 = 2.667;
                } else if (str.equals("C+")) {
                    grade33 = 2.334;
                } else if (str.equals("C")) {
                    grade33 = 2.0;
                } else if (str.equals("C-")) {
                    grade33 = 1.667;
                } else if (str.equals("D+")) {
                    grade33 = 1.334;
                } else if (str.equals("D")) {
                    grade33 = 1.0;
                } else {
                    grade33 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner4.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit4.setText("0");
                    grade44 = 0.0;
                } else if (str.equals("A")) {
                    grade44 = 4.0;
                } else if (str.equals("A-")) {
                    grade44 = 3.667;
                } else if (str.equals("B+")) {
                    grade44 = 3.334;
                } else if (str.equals("B")) {
                    grade44 = 3.0;
                } else if (str.equals("B-")) {
                    grade44 = 2.667;
                } else if (str.equals("C+")) {
                    grade44 = 2.334;
                } else if (str.equals("C")) {
                    grade44 = 2.0;
                } else if (str.equals("C-")) {
                    grade44 = 1.667;
                } else if (str.equals("D+")) {
                    grade44 = 1.334;
                } else if (str.equals("D")) {
                    grade44 = 1.0;
                } else {
                    grade44 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner5.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit5.setText("0");
                    grade55 = 0.0;
                } else if (str.equals("A")) {
                    grade55 = 4.0;
                } else if (str.equals("A-")) {
                    grade55 = 3.667;
                } else if (str.equals("B+")) {
                    grade55 = 3.334;
                } else if (str.equals("B")) {
                    grade55 = 3.0;
                } else if (str.equals("B-")) {
                    grade55 = 2.667;
                } else if (str.equals("C+")) {
                    grade55 = 2.334;
                } else if (str.equals("C")) {
                    grade55 = 2.0;
                } else if (str.equals("C-")) {
                    grade55 = 1.667;
                } else if (str.equals("D+")) {
                    grade55 = 1.334;
                } else if (str.equals("D")) {
                    grade55 = 1.0;
                } else {
                    grade55 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner6.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit6.setText("0");
                    grade66 = 0.0;
                } else if (str.equals("A")) {
                    grade66 = 4.0;
                } else if (str.equals("A-")) {
                    grade66 = 3.667;
                } else if (str.equals("B+")) {
                    grade66 = 3.334;
                } else if (str.equals("B")) {
                    grade66 = 3.0;
                } else if (str.equals("B-")) {
                    grade66 = 2.667;
                } else if (str.equals("C+")) {
                    grade66 = 2.334;
                } else if (str.equals("C")) {
                    grade66 = 2.0;
                } else if (str.equals("C-")) {
                    grade66 = 1.667;
                } else if (str.equals("D+")) {
                    grade66 = 1.334;
                } else if (str.equals("D")) {
                    grade66 = 1.0;
                } else {
                    grade66 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner7.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit7.setText("0");
                    grade77 = 0.0;
                } else if (str.equals("A")) {
                    grade77 = 4.0;
                } else if (str.equals("A-")) {
                    grade77 = 3.667;
                } else if (str.equals("B+")) {
                    grade77 = 3.334;
                } else if (str.equals("B")) {
                    grade77 = 3.0;
                } else if (str.equals("B-")) {
                    grade77 = 2.667;
                } else if (str.equals("C+")) {
                    grade77 = 2.334;
                } else if (str.equals("C")) {
                    grade77 = 2.0;
                } else if (str.equals("C-")) {
                    grade77 = 1.667;
                } else if (str.equals("D+")) {
                    grade77 = 1.334;
                } else if (str.equals("D")) {
                    grade77 = 1.0;
                } else {
                    grade77 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner8.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit8.setText("0");
                    grade88 = 0.0;
                } else if (str.equals("A")) {
                    grade88 = 4.0;
                } else if (str.equals("A-")) {
                    grade88 = 3.667;
                } else if (str.equals("B+")) {
                    grade88 = 3.334;
                } else if (str.equals("B")) {
                    grade88 = 3.0;
                } else if (str.equals("B-")) {
                    grade88 = 2.667;
                } else if (str.equals("C+")) {
                    grade88 = 2.334;
                } else if (str.equals("C")) {
                    grade88 = 2.0;
                } else if (str.equals("C-")) {
                    grade88 = 1.667;
                } else if (str.equals("D+")) {
                    grade88 = 1.334;
                } else if (str.equals("D")) {
                    grade88 = 1.0;
                } else {
                    grade88 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner9.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit9.setText("0");
                    grade99 = 0.0;
                } else if (str.equals("A")) {
                    grade99 = 4.0;
                } else if (str.equals("A-")) {
                    grade99 = 3.667;
                } else if (str.equals("B+")) {
                    grade99 = 3.334;
                } else if (str.equals("B")) {
                    grade99 = 3.0;
                } else if (str.equals("B-")) {
                    grade99 = 2.667;
                } else if (str.equals("C+")) {
                    grade99 = 2.334;
                } else if (str.equals("C")) {
                    grade99 = 2.0;
                } else if (str.equals("C-")) {
                    grade99 = 1.667;
                } else if (str.equals("D+")) {
                    grade99 = 1.334;
                } else if (str.equals("D")) {
                    grade99 = 1.0;
                } else {
                    grade99 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner10.getSelectedItem().toString();

                if (str.equals("")) {
                    semGpa.setText("Term GPA: ");
                    gpa.setText("Overall GPA:");
                    credit10.setText("0");
                    grade00 = 0.0;
                } else if (str.equals("A")) {
                    grade00 = 4.0;
                } else if (str.equals("A-")) {
                    grade00 = 3.667;
                } else if (str.equals("B+")) {
                    grade00 = 3.334;
                } else if (str.equals("B")) {
                    grade00 = 3.0;
                } else if (str.equals("B-")) {
                    grade00 = 2.667;
                } else if (str.equals("C+")) {
                    grade00 = 2.334;
                } else if (str.equals("C")) {
                    grade00 = 2.0;
                } else if (str.equals("C-")) {
                    grade00 = 1.667;
                } else if (str.equals("D+")) {
                    grade00 = 1.334;
                } else if (str.equals("D")) {
                    grade00 = 1.0;
                } else {
                    grade00 = 0.0;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void reset() {
        List<String> categories = new ArrayList<String>();
        categories.add("");
        categories.add("A");
        categories.add("A-");
        categories.add("B+");
        categories.add("B");
        categories.add("B-");
        categories.add("C+");
        categories.add("C");
        categories.add("C-");
        categories.add("D+");
        categories.add("D");
        categories.add("F");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter);
        spinner3.setAdapter(dataAdapter);
        spinner4.setAdapter(dataAdapter);
        spinner5.setAdapter(dataAdapter);
        spinner6.setAdapter(dataAdapter);
        spinner7.setAdapter(dataAdapter);
        spinner8.setAdapter(dataAdapter);
        spinner9.setAdapter(dataAdapter);
        spinner10.setAdapter(dataAdapter);
    }

    public double roundThreeDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.###");
        return Double.valueOf(twoDForm.format(d));
    }
    public void showToast(View v) {

        Toast.makeText(this, "Data has been cleared", Toast.LENGTH_SHORT).show();
    }
    public void showToast2(View v) {

        Toast.makeText(this, "Good work. Your hard work has truly paid off.", Toast.LENGTH_SHORT).show();
    }
    public void showToast3(View v) {

        Toast.makeText(this, "Not bad, keep up the good work.", Toast.LENGTH_SHORT).show();
    }
    public void showToast4(View v) {

        Toast.makeText(this, "Fail! Work harder next time, good luck!.", Toast.LENGTH_SHORT).show();
    }
}


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

/**
 * Created by Jack on 8/1/17.
 */

public class HsGpa extends AppCompatActivity {

    TextView semGpa, cumGpa;
    EditText edt1, edt2, preGpa, totalClass;
    Spinner grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9, grade10;
    Spinner spinner, spinner2, spinner3, spinner4, spinner5, spinner6, spinner7, spinner8, spinner9, spinner10;
    Button cal, clear, back;

    double grade11, type11, grade22, type22,grade33, type33, grade44, type44,grade55, type55, grade66, type66,grade77, type77, grade88, type88,grade99, type99, grade00, type00;
    int c1, c2,c3,c4,c5,c6,c7,c8,c9,c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hsgpa);

        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        preGpa = (EditText) findViewById(R.id.edt1);
        totalClass = (EditText) findViewById(R.id.edt2);

        semGpa = (TextView) findViewById(R.id.gpa);
        cumGpa = (TextView) findViewById(R.id.semGpa);


        grade1 = (Spinner) findViewById(R.id.spinner);
        grade2 = (Spinner) findViewById(R.id.spinner2);
        grade3 = (Spinner) findViewById(R.id.spinner3);
        grade4 = (Spinner) findViewById(R.id.spinner4);
        grade5 = (Spinner) findViewById(R.id.spinner5);
        grade6 = (Spinner) findViewById(R.id.spinner6);
        grade7 = (Spinner) findViewById(R.id.spinner7);
        grade8 = (Spinner) findViewById(R.id.spinner8);
        grade9 = (Spinner) findViewById(R.id.spinner9);
        grade10 = (Spinner) findViewById(R.id.spinner10);

        spinner = (Spinner) findViewById(R.id.type);
        spinner2 = (Spinner) findViewById(R.id.type2);
        spinner3 = (Spinner) findViewById(R.id.type3);
        spinner4 = (Spinner) findViewById(R.id.type4);
        spinner5 = (Spinner) findViewById(R.id.type5);
        spinner6 = (Spinner) findViewById(R.id.type6);
        spinner7 = (Spinner) findViewById(R.id.type7);
        spinner8 = (Spinner) findViewById(R.id.type8);
        spinner9 = (Spinner) findViewById(R.id.type9);
        spinner10 = (Spinner) findViewById(R.id.type10);

        cal = (Button) findViewById(R.id.cal);
        clear = (Button) findViewById(R.id.clear);
        back = (Button) findViewById(R.id.back);


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

        grade1.setAdapter(dataAdapter);
        grade2.setAdapter(dataAdapter);
        grade3.setAdapter(dataAdapter);
        grade4.setAdapter(dataAdapter);
        grade5.setAdapter(dataAdapter);
        grade6.setAdapter(dataAdapter);
        grade7.setAdapter(dataAdapter);
        grade8.setAdapter(dataAdapter);
        grade9.setAdapter(dataAdapter);
        grade10.setAdapter(dataAdapter);

        List<String> typeOfClass = new ArrayList<String>();
        typeOfClass.add("");
        typeOfClass.add("Regular");
        typeOfClass.add("Honors");
        typeOfClass.add("AP");

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float GPA = Float.parseFloat(edt1.getText().toString());
                float classes = Float.parseFloat(edt2.getText().toString());

                double semesterGpa1 = grade11 +type11;
                double semesterGpa2 = grade22 +type22;
                double semesterGpa3 = grade33 +type33;
                double semesterGpa4 = grade44 +type44;
                double semesterGpa5 = grade55 +type55;
                double semesterGpa6 = grade66 +type66;
                double semesterGpa7 = grade77 +type77;
                double semesterGpa8 = grade88 +type88;
                double semesterGpa9 = grade99 +type99;
                double semesterGpa10 = grade00 +type00;
                double overall = GPA*classes;


                double overallGpa = roundThreeDecimals((overall+semesterGpa1+semesterGpa2+semesterGpa3+semesterGpa4+semesterGpa5+semesterGpa6+semesterGpa7+semesterGpa8+semesterGpa9+semesterGpa10)/(classes+c1+c2+c3+c4+c5+c6+c7+c8+c9+c10));
                double gpa = roundThreeDecimals((semesterGpa1+semesterGpa2+semesterGpa3+semesterGpa4+semesterGpa5+semesterGpa6+semesterGpa7+semesterGpa8+semesterGpa9+semesterGpa10)/(c1+c2+c3+c4+c5+c6+c7+c8+c9+c10));
                semGpa.setText("Overall GPA: " +overallGpa);
                cumGpa.setText("Term GPA: " + gpa);

                if(overallGpa>=3.0){
                    showToast2(view);
                }else if(overallGpa>=2.0){
                    showToast3(view);
                }else if(overallGpa <2.0){
                    showToast4(view);
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preGpa.setText("0");
                totalClass.setText("0");
                cumGpa.setText("Term GPA:");
                semGpa.setText("Overall GPA:");
           reset();
           showToast(v);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HsGpa.this, homeScreen.class);

                startActivity(intent);
            }
        });



        // Creating adapter for spinner
        ArrayAdapter<String> types = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, typeOfClass);

        // Drop down layout style - list view with radio button
        types.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(types);
        spinner2.setAdapter(types);
        spinner3.setAdapter(types);
        spinner4.setAdapter(types);
        spinner5.setAdapter(types);
        spinner6.setAdapter(types);
        spinner7.setAdapter(types);
        spinner8.setAdapter(types);
        spinner9.setAdapter(types);
        spinner10.setAdapter(types);

        grade1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade1.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade11=0.0;
                    type11 = 0.0;
                    c1 =0;
                }else if (str.equals("A")){
                    grade11=4.0;
                    c1 =1;
                }else if(str.equals("A-")){
                    grade11 = 3.667;
                    c1 =1;
                }else if(str.equals("B+")){
                    grade11 = 3.334;
                    c1 =1;
                }else if(str.equals("B")){
                    grade11 = 3.0;
                    c1 =1;
                }else if (str.equals("B-")){
                    grade11 = 2.667;
                    c1 =1;
                }else if (str.equals("C+")){
                    grade11 = 2.334;
                    c1 =1;
                }else if (str.equals("C")){
                    grade11 = 2.0;
                    c1 =1;
                }else if (str.equals("C-")){
                    grade11 = 1.667;
                    c1 =1;
                }else if (str.equals("D+")){
                    grade11 = 1.334;
                    c1 =1;
                }else if (str.equals("D")){
                    grade11 = 1.0;
                    c1 =1;
                }else {
                    grade11 = 0.0;
                    c1 =1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) spinner.getSelectedItem().toString();

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type11=0.0;
                } else if(str.equals("Honors")){
                    type11 =0.5;
                }else {
                    type11 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        grade2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade2.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade22=0.0;
                    type22=0.0;
                    c2=0;
                }else if (str.equals("A")){
                    grade22=4.0;
                    c2=1;
                }else if(str.equals("A-")){
                    grade22 = 3.667;
                    c2=1;
                }else if(str.equals("B+")){
                    grade22 = 3.334;
                    c2=1;
                }else if(str.equals("B")){
                    grade22 = 3.0;
                    c2=1;
                }else if (str.equals("B-")){
                    grade22 = 2.667;
                    c2=1;
                }else if (str.equals("C+")){
                    grade22 = 2.334;
                    c2=1;
                }else if (str.equals("C")){
                    grade22 = 2.0;
                    c2=1;
                }else if (str.equals("C-")){
                    grade22 = 1.667;
                    c2=1;
                }else if (str.equals("D+")){
                    grade22 = 1.334;
                    c2=1;
                }else if (str.equals("D")){
                    grade22 = 1.0;
                    c2=1;
                }else {
                    grade22 = 0.0;
                    c2=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type22=0.0;
                } else if(str.equals("Honors")){
                    type22 =0.5;
                }else {
                    type22 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

        grade3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade3.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade33=0.0;
                    type33 = 0.0;
                    c3 =0;
                }else if (str.equals("A")){
                    grade33=4.0;
                    c3=1;
                }else if(str.equals("A-")){
                    grade33 = 3.667;
                    c3=1;
                }else if(str.equals("B+")){
                    grade33 = 3.334;
                    c3=1;
                }else if(str.equals("B")){
                    grade33 = 3.0;
                    c3=1;
                }else if (str.equals("B-")){
                    grade33 = 2.667;
                    c3=1;
                }else if (str.equals("C+")){
                    grade33 = 2.334;
                    c3=1;
                }else if (str.equals("C")){
                    grade33 = 2.0;
                    c3=1;
                }else if (str.equals("C-")){
                    grade33 = 1.667;
                    c3=1;
                }else if (str.equals("D+")){
                    grade33 = 1.334;
                    c3=1;
                }else if (str.equals("D")){
                    grade33 = 1.0;
                    c3=1;
                }else {
                    grade33 = 0.0;
                    c3=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type33=0.0;
                } else if(str.equals("Honors")){
                    type33 =0.5;
                }else {
                    type33 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade4.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade44=0.0;
                    type44 = 0.0;
                    c4 =0;
                }else if (str.equals("A")){
                    grade44=4.0;
                    c4=1;
                }else if(str.equals("A-")){
                    grade44 = 3.667;
                    c4=1;
                }else if(str.equals("B+")){
                    grade44 = 3.334;
                    c4=1;
                }else if(str.equals("B")){
                    grade44 = 3.0;
                    c4=1;
                }else if (str.equals("B-")){
                    grade44 = 2.667;
                    c4=1;
                }else if (str.equals("C+")){
                    grade44 = 2.334;
                    c4=1;
                }else if (str.equals("C")){
                    grade44 = 2.0;
                    c4=1;
                }else if (str.equals("C-")){
                    grade44 = 1.667;
                    c4=1;
                }else if (str.equals("D+")){
                    grade44 = 1.334;
                    c4=1;
                }else if (str.equals("D")){
                    grade44 = 1.0;
                    c4=1;
                }else {
                    grade44 = 0.0;
                    c4=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type44=0.0;
                } else if(str.equals("Honors")){
                    type44 =0.5;
                }else {
                    type44 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade5.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade55=0.0;
                    type55 = 0.0;
                    c5 =0;
                }else if (str.equals("A")){
                    grade55=4.0;
                    c5=1;
                }else if(str.equals("A-")){
                    grade55 = 3.667;
                    c5=1;
                }else if(str.equals("B+")){
                    grade55 = 3.334;
                    c5=1;
                }else if(str.equals("B")){
                    grade55 = 3.0;
                    c5=1;
                }else if (str.equals("B-")){
                    grade55 = 2.667;
                    c5=1;
                }else if (str.equals("C+")){
                    grade55 = 2.334;
                    c5=1;
                }else if (str.equals("C")){
                    grade55 = 2.0;
                    c5=1;
                }else if (str.equals("C-")){
                    grade55 = 1.667;
                    c5=1;
                }else if (str.equals("D+")){
                    grade55 = 1.334;
                    c5=1;
                }else if (str.equals("D")){
                    grade55 = 1.0;
                    c5=1;
                }else {
                    grade55 = 0.0;
                    c5=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type55=0.0;
                } else if(str.equals("Honors")){
                    type55 =0.5;
                }else {
                    type55 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade6.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade66=0.0;
                    type66 = 0.0;
                    c6 =0;
                }else if (str.equals("A")){
                    grade66=4.0;
                    c6=1;
                }else if(str.equals("A-")){
                    grade66 = 3.667;
                    c6=1;
                }else if(str.equals("B+")){
                    grade66 = 3.334;
                    c6=1;
                }else if(str.equals("B")){
                    grade66 = 3.0;
                    c6=1;
                }else if (str.equals("B-")){
                    grade66 = 2.667;
                    c6=1;
                }else if (str.equals("C+")){
                    grade66 = 2.334;
                    c6=1;
                }else if (str.equals("C")){
                    grade66 = 2.0;
                    c6=1;
                }else if (str.equals("C-")){
                    grade66 = 1.667;
                    c6=1;
                }else if (str.equals("D+")){
                    grade66 = 1.334;
                    c6=1;
                }else if (str.equals("D")){
                    grade66 = 1.0;
                    c6=1;
                }else {
                    grade66 = 0.0;
                    c6=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type66=0.0;
                } else if(str.equals("Honors")){
                    type66 =0.5;
                }else {
                    type66 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade7.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade77=0.0;
                    type77 = 0.0;
                    c7 =0;
                }else if (str.equals("A")){
                    grade77=4.0;
                    c7=1;
                }else if(str.equals("A-")){
                    grade77 = 3.667;
                    c7=1;
                }else if(str.equals("B+")){
                    grade77 = 3.334;
                    c7=1;
                }else if(str.equals("B")){
                    grade77 = 3.0;
                    c7=1;
                }else if (str.equals("B-")){
                    grade77 = 2.667;
                    c7=1;
                }else if (str.equals("C+")){
                    grade77 = 2.334;
                    c7=1;
                }else if (str.equals("C")){
                    grade77 = 2.0;
                    c7=1;
                }else if (str.equals("C-")){
                    grade77 = 1.667;
                    c7=1;
                }else if (str.equals("D+")){
                    grade77 = 1.334;
                    c7=1;
                }else if (str.equals("D")){
                    grade77 = 1.0;
                    c7=1;
                }else {
                    grade77 = 0.0;
                    c7=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type77=0.0;
                } else if(str.equals("Honors")){
                    type77 =0.5;
                }else {
                    type77 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade8.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade88=0.0;
                    type88 = 0.0;
                    c8 =0;
                }else if (str.equals("A")){
                    grade88=4.0;
                    c8=1;
                }else if(str.equals("A-")){
                    grade88 = 3.667;
                    c8=1;
                }else if(str.equals("B+")){
                    grade88 = 3.334;
                    c8=1;
                }else if(str.equals("B")){
                    grade88 = 3.0;
                    c8=1;
                }else if (str.equals("B-")){
                    grade88 = 2.667;
                    c8=1;
                }else if (str.equals("C+")){
                    grade88 = 2.334;
                    c8=1;
                }else if (str.equals("C")){
                    grade88 = 2.0;
                    c8=1;
                }else if (str.equals("C-")){
                    grade88 = 1.667;
                    c8=1;
                }else if (str.equals("D+")){
                    grade88 = 1.334;
                    c8=1;
                }else if (str.equals("D")){
                    grade88 = 1.0;
                    c8=1;
                }else {
                    grade88 = 0.0;
                    c8=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type88=0.0;
                } else if(str.equals("Honors")){
                    type88 =0.5;
                }else {
                    type88 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade9.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade99=0.0;
                    type99 = 0.0;
                    c9 =0;
                }else if (str.equals("A")){
                    grade99=4.0;
                    c9=1;
                }else if(str.equals("A-")){
                    grade99 = 3.667;
                    c9=1;
                }else if(str.equals("B+")){
                    grade99 = 3.334;
                    c9=1;
                }else if(str.equals("B")){
                    grade99 = 3.0;
                    c9=1;
                }else if (str.equals("B-")){
                    grade99 = 2.667;
                    c9=1;
                }else if (str.equals("C+")){
                    grade99 = 2.334;
                    c9=1;
                }else if (str.equals("C")){
                    grade99 = 2.0;
                    c9=1;
                }else if (str.equals("C-")){
                    grade99 = 1.667;
                    c9=1;
                }else if (str.equals("D+")){
                    grade99 = 1.334;
                    c9=1;
                }else if (str.equals("D")){
                    grade99 = 1.0;
                    c9=1;
                }else {
                    grade99 = 0.0;
                    c9=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type99=0.0;
                } else if(str.equals("Honors")){
                    type99 =0.5;
                }else {
                    type99 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
        grade10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String str = (String) grade10.getSelectedItem().toString();

                if(str.equals("")){
                    cumGpa.setText("Term GPA:");
                    semGpa.setText("Overall GPA:");
                    grade00=0.0;
                    type00 = 0.0;
                    c10 =0;
                }else if (str.equals("A")){
                    grade00=4.0;
                    c10=1;
                }else if(str.equals("A-")){
                    grade00 = 3.667;
                    c10=1;
                }else if(str.equals("B+")){
                    grade00 = 3.334;
                    c10=1;
                }else if(str.equals("B")){
                    grade00 = 3.0;
                    c10=1;
                }else if (str.equals("B-")){
                    grade00 = 2.667;
                    c10=1;
                }else if (str.equals("C+")){
                    grade00 = 2.334;
                    c10=1;
                }else if (str.equals("C")){
                    grade00 = 2.0;
                    c10=1;
                }else if (str.equals("C-")){
                    grade00 = 1.667;
                    c10=1;
                }else if (str.equals("D+")){
                    grade00 = 1.334;
                    c10=1;
                }else if (str.equals("D")){
                    grade00 = 1.0;
                    c10=1;
                }else {
                    grade00 = 0.0;
                    c10=1;
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

                if(str.equals("")){

                }else if (str.equals("Regular")){
                    type00=0.0;
                } else if(str.equals("Honors")){
                    type00 =0.5;
                }else {
                    type00 =1.0;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }
    public void reset(){
        List<String> categoriess = new ArrayList<String>();
        categoriess.add("");
        categoriess.add("A");
        categoriess.add("A-");
        categoriess.add("B+");
        categoriess.add("B");
        categoriess.add("B-");
        categoriess.add("C+");
        categoriess.add("C");
        categoriess.add("C-");
        categoriess.add("D+");
        categoriess.add("D");
        categoriess.add("F");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapters = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categoriess);

        // Drop down layout style - list view with radio button
        dataAdapters.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        grade1.setAdapter(dataAdapters);
        grade2.setAdapter(dataAdapters);
        grade3.setAdapter(dataAdapters);
        grade4.setAdapter(dataAdapters);
        grade5.setAdapter(dataAdapters);
        grade6.setAdapter(dataAdapters);
        grade7.setAdapter(dataAdapters);
        grade8.setAdapter(dataAdapters);
        grade9.setAdapter(dataAdapters);
        grade10.setAdapter(dataAdapters);
    }

    public double roundThreeDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.###");
        return Double.valueOf(twoDForm.format(d));
    }
    public void showToast(View v){

        Toast.makeText(this,"Data has been cleared", Toast.LENGTH_SHORT).show();
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


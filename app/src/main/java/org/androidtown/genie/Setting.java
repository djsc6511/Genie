package org.androidtown.genie;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Setting extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        //분류
        final Spinner spinner_class = (Spinner)findViewById(R.id.spinner_classification);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(
                this,R.array.classification,android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_class.setAdapter(adapter1);
        spinner_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_class.getSelectedItemPosition() > 0) {
                    String classification = ((TextView) spinner_class.getSelectedView()).getText().toString();
                    Log.d("class", classification);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //장소
        final Spinner spinner_location = (Spinner)findViewById(R.id.spinner_location);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(
                this,R.array.location,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_location.setAdapter(adapter2);
        spinner_location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_location.getSelectedItemPosition() > 0) {
                    String location = ((TextView) spinner_location.getSelectedView()).getText().toString();
                    Log.d("loc", location);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //시간
        final Spinner spinner_time = (Spinner)findViewById(R.id.spinner_time);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(
                this,R.array.time,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_time.setAdapter(adapter3);
        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_time.getSelectedItemPosition() > 0) {
                    String time = ((TextView) spinner_time.getSelectedView()).getText().toString();
                    Log.d("time", time);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}

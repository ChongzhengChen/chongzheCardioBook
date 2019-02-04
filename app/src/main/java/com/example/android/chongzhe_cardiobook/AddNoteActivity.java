package com.example.android.chongzhe_cardiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    public static final String EXTRA_PRIOTITY =
            "package com.example.android.chongzhe_cardiobook.EXTRA_PRIOTITY";

    public static final String EXTRA_DATE =
            "package com.example.android.chongzhe_cardiobook.EXTRA_DATE";
    public static final String EXTRA_TIME =
            "package com.example.android.chongzhe_cardiobook.EXTRA_TIME";
    public static final String EXTRA_SYSTOLIC =
            "package com.example.android.chongzhe_cardiobook.EXTRA_SYSTOLIC";
    public static final String EXTRA_DIASTOLIC =
            "package com.example.android.chongzhe_cardiobook.EXTRA_DIASTOLIC";
    public static final String EXTRA_HEARTRATE =
            "package com.example.android.chongzhe_cardiobook.EXTRA_HEARTRATE";
    public static final String EXTRA_COMMENTS =
            "package com.example.android.chongzhe_cardiobook.EXTRA_COMMENTS";


    private EditText editTextPriotity;
    private EditText editTextDate;
    private EditText editTextTime;
    private EditText editTextSystolicPressure;
    private EditText editTextDiastolicPressure;
    private EditText editTextHeartRate;
    private EditText editTextComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextPriotity = findViewById(R.id.edit_priority);
        editTextDate = findViewById(R.id.edit_date);
        editTextTime = findViewById(R.id.edit_time);
        editTextSystolicPressure = findViewById(R.id.edit_systolic_pressure);
        editTextDiastolicPressure = findViewById(R.id.edit_diastolic_pressure);
        editTextHeartRate = findViewById(R.id.edit_heart_rate);
        editTextComments = findViewById(R.id.edit_comments);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");
    }

    public void saveNote() {
        int priority = Integer.parseInt(editTextPriotity.getText().toString());
        String date = editTextDate.getText().toString();
        String time = editTextTime.getText().toString();
        String sys_text = editTextSystolicPressure.getText().toString();
        String dias_text = editTextDiastolicPressure.getText().toString();
        String HR_text = editTextHeartRate.getText().toString();
        int systolic = Integer.parseInt(editTextSystolicPressure.getText().toString());
        int diastolic = Integer.parseInt(editTextDiastolicPressure.getText().toString());
        int heartRate = Integer.parseInt(editTextHeartRate.getText().toString());
        String comments = editTextComments.getText().toString();

        //check if any necessary information is left empty

        if (date.trim().isEmpty() || time.trim().isEmpty() || sys_text.trim().isEmpty() || dias_text.trim().isEmpty() || HR_text.trim().isEmpty()){
            Toast.makeText(this, "please fill out the first five category", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_PRIOTITY,priority);
        data.putExtra(EXTRA_DATE,date);
        data.putExtra(EXTRA_TIME,time);
        data.putExtra(EXTRA_SYSTOLIC,systolic);
        data.putExtra(EXTRA_DIASTOLIC,diastolic);
        data.putExtra(EXTRA_HEARTRATE,heartRate);
        data.putExtra(EXTRA_COMMENTS,comments);

        setResult(RESULT_OK,data);
        finish();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

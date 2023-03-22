package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.todolist.ui.Schedule;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TodoListSaveForm extends AppCompatActivity {

    private TextView startTimeTextView;
    private TextView endTimeTextView;
    private TextView addScheduleEdieText;
    private Button btnSave;
    private DatabaseReference mDatabase;


    // ArrayList로 일정 목록을 관리합니다.
    private ArrayList<Schedule> scheduleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_save_form);

        // Firebase Realtime Database 초기화
        mDatabase = FirebaseDatabase.getInstance().getReference();

        startTimeTextView = findViewById(R.id.start_time_textview);
        endTimeTextView = findViewById(R.id.end_time_textview);
        addScheduleEdieText = findViewById(R.id.addSchedule_editText);

        // 현재 시간을 가져옵니다.
        Calendar currentTime = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String startTime = timeFormat.format(currentTime.getTime());

        // 2시간 후의 시간을 가져옵니다.
        Calendar laterTime = Calendar.getInstance();
        laterTime.add(Calendar.HOUR_OF_DAY, 2);
        String endTime = timeFormat.format(laterTime.getTime());
        startTimeTextView.setText(startTime);
        endTimeTextView.setText(endTime);

        btnSave = findViewById(R.id.btn_addSchedule);
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String schedule = addScheduleEdieText.getText().toString();
                String startTime = startTimeTextView.getText().toString();
                String endTime = endTimeTextView.getText().toString();
                Date saveTime = currentTime.getTime();
                // 새로운 일정을 ArrayList에 추가합니다.
                Schedule newSchedule = new Schedule(schedule, startTime, endTime, saveTime );
                scheduleList.add(newSchedule);

                // Firebase Realtime Database에 일정 목록을 추가합니다.
                String key = mDatabase.child("schedules").push().getKey();
                mDatabase.child("schedules").child(key).setValue(newSchedule);

                // 저장 완료 후 액티비티 종료

                finish();

            }
        });


    }
}
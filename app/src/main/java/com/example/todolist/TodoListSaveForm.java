package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TodoListSaveForm extends AppCompatActivity {

    private TextView startTimeTextView;
    private TextView endTimeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list_save_form);

        startTimeTextView = findViewById(R.id.start_time_textview);
        endTimeTextView = findViewById(R.id.end_time_textview);

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


    }
}
package com.example.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.ui.Schedule;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.ScheduleViewHolder> {

    private List<Schedule> todoLists;

    public TodoListAdapter(List<Schedule> todoLists) {

        this.todoLists = todoLists;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schdule_item, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        Schedule currentSchedule = todoLists.get(position);
        holder.startTimeTextView.setText(currentSchedule.getStartTime());
        holder.endTimeTextView.setText(currentSchedule.getEndTime());
        holder.scheduleTextView.setText(currentSchedule.getSchedule());
    }

    @Override
    public int getItemCount() {
        return todoLists.size();
    }


    // onCreateViewHolder()와 onBindViewHolder() 메소드 구현 생략

    public static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView startTimeTextView;
        TextView endTimeTextView;
        TextView scheduleTextView;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);

            startTimeTextView = itemView.findViewById(R.id.start_time_text_view);
            endTimeTextView = itemView.findViewById(R.id.end_time_text_view);
            scheduleTextView = itemView.findViewById(R.id.schedule_text_view);
        }
    }
}

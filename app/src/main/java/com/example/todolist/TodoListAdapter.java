package com.example.todolist;

import android.annotation.SuppressLint;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder,  int position) {
        Schedule currentSchedule = todoLists.get(position);
        holder.startTimeTextView.setText(currentSchedule.getStartTime());
        holder.endTimeTextView.setText(currentSchedule.getEndTime());
        holder.scheduleTextView.setText(currentSchedule.getSchedule());

    }

    @Override
    public int getItemCount() {
        return todoLists.size();
    }


    public static class ScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView startTimeTextView;
        TextView endTimeTextView;
        TextView scheduleTextView;
        ImageView deleteIcon;
        ClickListener listener;

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(v, getAdapterPosition());
            }
        }

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            startTimeTextView = itemView.findViewById(R.id.start_time_text_view);
            endTimeTextView = itemView.findViewById(R.id.end_time_text_view);
            scheduleTextView = itemView.findViewById(R.id.schedule_text_view);
            deleteIcon = itemView.findViewById(R.id.delete_icon);

            // 텍스트 색상 설정
            startTimeTextView.setTextColor(itemView.getResources().getColor(R.color.black));
            startTimeTextView.setGravity(Gravity.CENTER); // 중앙 정렬 추가
            endTimeTextView.setTextColor(itemView.getResources().getColor(R.color.black));
            endTimeTextView.setGravity(Gravity.CENTER); // 중앙 정렬 추가
            scheduleTextView.setTextColor(itemView.getResources().getColor(R.color.black));
            scheduleTextView.setGravity(Gravity.CENTER); // 중앙 정렬 추가

            // 삭제 아이콘 클릭 이벤트 처리
            deleteIcon.setOnClickListener(this);


        }


    }

    public interface ClickListener {
        void onClick(View view, int position);
    }
}

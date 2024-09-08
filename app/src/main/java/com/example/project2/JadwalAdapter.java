package com.example.project2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.JadwalViewHolder> {

    private List<ItemJadwal> classScheduleList;

    public JadwalAdapter(List<ItemJadwal> classScheduleList) {
        this.classScheduleList = classScheduleList;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_schedule, parent, false);
        return new JadwalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        ItemJadwal item = classScheduleList.get(position);
        holder.className.setText(item.getClassName());
        holder.classTime.setText(item.getClassTime());
        holder.classLocation.setText(item.getClassLocation());
    }

    @Override
    public int getItemCount() {
        return classScheduleList.size();
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {
        TextView className, classTime, classLocation;

        public JadwalViewHolder(@NonNull View itemView) {
            super(itemView);
            className = itemView.findViewById(R.id.className);
            classTime = itemView.findViewById(R.id.classTime);
            classLocation = itemView.findViewById(R.id.classLocation);
        }
    }
}

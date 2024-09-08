package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> daysList = Arrays.asList("Senin", "Selasa", "Rabu", "Kamis", "Jumat");

        DaysAdapter adapter = new DaysAdapter(daysList);
        recyclerView.setAdapter(adapter);
    }

    // Adapter sebagai inner class
    class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> {

        private List<String> daysList;

        public DaysAdapter(List<String> daysList) {
            this.daysList = daysList;
        }

        @Override
        public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_day, parent, false);
            return new DayViewHolder(view);
        }

        @Override
        public void onBindViewHolder(DayViewHolder holder, int position) {
            String day = daysList.get(position);
            holder.dayNameTextView.setText(day);

            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, JadwalActivity.class);
                intent.putExtra("day_name", day);
                startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return daysList.size();
        }

        class DayViewHolder extends RecyclerView.ViewHolder {
            TextView dayNameTextView;

            public DayViewHolder(View itemView) {
                super(itemView);
                dayNameTextView = itemView.findViewById(R.id.day_name);
            }
        }
    }
}


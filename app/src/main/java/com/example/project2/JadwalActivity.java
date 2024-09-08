package com.example.project2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JadwalActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private JadwalAdapter jadwalAdapter;
    private List<ItemJadwal> classScheduleItemList;

    // Simulasi data jadwal untuk setiap hari
    private static final Map<String, List<ItemJadwal>> SCHEDULE_MAP = new HashMap<>();

    static {
        List<ItemJadwal> seninJadwal = new ArrayList<>();
        seninJadwal.add(new ItemJadwal("REKAYASA PERANGKAT LUNAK", "12:50 - 15:20", "Room E4"));
        SCHEDULE_MAP.put("Senin", seninJadwal);

        List<ItemJadwal> selasaJadwal = new ArrayList<>();
        selasaJadwal.add(new ItemJadwal("INOVASI DIGITAL", "09:30 - 11:10", "Room E5"));
        selasaJadwal.add(new ItemJadwal("MKP. PLATFORM KEUANGAN DIGITAL", "12:50 - 15:20", "Room E5"));
        SCHEDULE_MAP.put("Selasa", selasaJadwal);

        List<ItemJadwal> rabuJadwal = new ArrayList<>();
        rabuJadwal.add(new ItemJadwal("SISTEM ENTERPRISE", "08:40 - 11:10", "Room E5"));
        rabuJadwal.add(new ItemJadwal("MANAJEMEN INVESTASI TEKNOLOGI INFORMASI", "12:50 - 15:20", "Room E5"));
        SCHEDULE_MAP.put("Rabu", rabuJadwal);

        List<ItemJadwal> kamisJadwal = new ArrayList<>();
        kamisJadwal.add(new ItemJadwal("PERENCANAAN KEBERLANGSUNGAN BISNIS IT", "08:40 - 11:20", "Room E5"));
        kamisJadwal.add(new ItemJadwal("DESAIN ANTARMUKA PENGGUNA", "12:50 - 15:20", "Room E5"));
        SCHEDULE_MAP.put("Kamis", kamisJadwal);

        List<ItemJadwal> jumatJadwal = new ArrayList<>();
        jumatJadwal.add(new ItemJadwal("ANALISIS DAN VISUALISASI DATA", "12:50 - 15:20", "Room E5"));
        SCHEDULE_MAP.put("Jumat", jumatJadwal);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        // Set up the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Jadwal");

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ambil hari dari Intent
        String hari = getIntent().getStringExtra("day_name");

        // Ambil jadwal berdasarkan hari
        classScheduleItemList = SCHEDULE_MAP.getOrDefault(hari, new ArrayList<>());

        // Set up the adapter
        jadwalAdapter = new JadwalAdapter(classScheduleItemList);
        recyclerView.setAdapter(jadwalAdapter);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

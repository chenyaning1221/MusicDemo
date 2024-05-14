package com.example.mymusicplayer;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicplayer.music.Music;
import com.example.mymusicplayer.music.MusicAdapter;

import java.util.ArrayList;
import java.util.List;

public class ZhPlaylistActivity extends AppCompatActivity {

    private List<Music> musicList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zh_playlist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_zh_playlist);
        }

        initMusic();//取音乐数据放入List中
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.zh_music_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(musicList);
        recyclerView.setAdapter(musicAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initMusic(){
        Music m1 = new Music("爱人错过","告五人",R.drawable.ic_dashboard_black_24dp,false);
        musicList.add(m1);

        Music m2 = new Music("有一种悲伤","黄丽玲",R.drawable.ic_dashboard_black_24dp,false);
        musicList.add(m2);

        Music m3 = new Music("绅士","薛之谦",R.drawable.ic_dashboard_black_24dp,false);
        musicList.add(m3);

        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);

        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);

        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);
        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);
        musicList.add(m1);
        musicList.add(m2);
        musicList.add(m3);

    }
}
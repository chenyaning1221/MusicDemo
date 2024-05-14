package com.example.mymusicplayer.ui.home;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicplayer.EnPlaylistActivity;
import com.example.mymusicplayer.music.Music;
import com.example.mymusicplayer.music.MusicAdapter;
import com.example.mymusicplayer.ui.PlayerActivity;
import com.example.mymusicplayer.R;
import com.example.mymusicplayer.ZhPlaylistActivity;
import com.example.mymusicplayer.databinding.FragmentHomeBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private List<Music> musicList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        Button toplay = binding.toplay;
        toplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout toZhList = binding.playlistZh;
        toZhList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZhPlaylistActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout toEnList = binding.playlistEn;
        toEnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EnPlaylistActivity.class);
                startActivity(intent);
            }
        });

        initMusic();//取音乐数据放入List中
        RecyclerView recyclerView = binding.musicList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(musicList);
        recyclerView.setAdapter(musicAdapter);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initMusic() {

//        Music music = extractMusicInfo(filePath);
//        musicList.add(music);
        Music m1 = new Music("爱人错过", "告五人", R.drawable.picture_test2, false);
        musicList.add(m1);

        Music m2 = new Music("有一种悲伤", "黄丽玲", R.drawable.picture_test, false);
        musicList.add(m2);

        Music m3 = new Music("绅士", "薛之谦", R.drawable.picture_test3, false);
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

    public static Music extractMusicInfo(String filePath) {

        Log.d("HomeFragment","In retriver");
        Music music = new Music();
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();

        try {
            // 设置数据源为指定的文件路径
            retriever.setDataSource(filePath);
            Log.d("HomeFragment","In try");

            // 获取音乐标题
            String title = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
            Log.d("HomeFragment","After title");
            // 获取艺术家
            String artist = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
            Log.d("HomeFragment","After artist");
            // 获取作者
            String author = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_AUTHOR);
            Log.d("HomeFragment","After author");
            // 获取持续时间（毫秒）
            String duration = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
            Log.d("HomeFragment","After duration");

            // 打印获取到的信息
            Log.d("HomeFragment", "Title: " + title);
            Log.d("HomeFragment", "Artist: " + artist);
            Log.d("HomeFragment", "Author: " + author);
            Log.d("HomeFragment", "Duration: " + duration + " ms");

            music.setMusic_name(title);
            music.setSinger(artist);
            assert duration != null;
            music.setDuration(Long.parseLong(duration));
            music.setCollected(false);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 确保释放资源
            try {
                retriever.release();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return music;
    }
}
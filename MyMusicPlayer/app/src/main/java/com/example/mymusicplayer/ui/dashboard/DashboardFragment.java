package com.example.mymusicplayer.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mymusicplayer.CollectPlaylistActivity;
import com.example.mymusicplayer.LocalPlaylistActivity;
import com.example.mymusicplayer.RecentPlaylistActivity;
import com.example.mymusicplayer.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout toCollectList = binding.collectPlaylist;
        toCollectList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectPlaylistActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout toRecentList = binding.recentPlaylist;
        toRecentList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RecentPlaylistActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout toLocalList = binding.localPlaylist;
        toLocalList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LocalPlaylistActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
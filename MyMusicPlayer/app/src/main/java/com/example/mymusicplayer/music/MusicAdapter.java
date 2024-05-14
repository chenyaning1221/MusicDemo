package com.example.mymusicplayer.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusicplayer.R;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {

    private List<Music> mMusicList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View musicView;
        TextView musicName;
        TextView singer;

        ImageView picture;

        ImageView collect;

        public ViewHolder(View view){
            super(view);
            musicView = view;
            musicName = (TextView) view.findViewById(R.id.music_name);
            singer = (TextView) view.findViewById(R.id.singer);
            picture = (ImageView) view.findViewById(R.id.music_picture);
            collect = (ImageView) view.findViewById(R.id.music_collect);
        }
    }

    public MusicAdapter(List<Music> musicList){
        mMusicList = musicList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.music,parent,false);
        final MusicAdapter.ViewHolder holder = new MusicAdapter.ViewHolder(view);
        holder.musicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                Music music = mMusicList.get(position);
                //开始播放点击的音乐
                Toast.makeText(v.getContext(),music.getMusic_name(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getBindingAdapterPosition();
                Music music = mMusicList.get(position);
                //更换音乐收藏状态
                music.setCollected(!music.getCollected());
                int pictureId;
                if (music.getCollected()) pictureId = R.drawable.collect;
                else pictureId = R.drawable.favorite;
                holder.collect.setImageResource(pictureId);
                Toast.makeText(v.getContext(),music.getMusic_name()+"collected state is "
                        + String.valueOf(music.getCollected()),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Music music = mMusicList.get(position);
        holder.picture.setImageResource(music.getPicture());
        holder.picture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.musicName.setText(music.getMusic_name());
        holder.singer.setText(music.getSinger());
        int pictureId;
        if (music.getCollected()) pictureId = R.drawable.collect;
        else pictureId = R.drawable.favorite;
        holder.collect.setImageResource(pictureId);
    }

    @Override
    public int getItemCount() {
        return mMusicList.size();
    }
}

package com.example.mymusicplayer.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mymusicplayer.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_player);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        //播放页隐藏顶部栏
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setTitle("歌曲");
//
//        }

        ImageView picture = (ImageView) findViewById(R.id.playing_pic);
        picture.setImageResource(R.drawable.picture_test);
        picture.setScaleType(ImageView.ScaleType.CENTER);

        View player_view = (View) findViewById(R.id.player_view);
        player_view.setBackgroundResource(R.drawable.picture_test);

        ImageView backIv = (ImageView) findViewById(R.id.backIv);
        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回按钮，暂时写为finish,之后是变成小组件
                finish();
            }
        });
    }

}
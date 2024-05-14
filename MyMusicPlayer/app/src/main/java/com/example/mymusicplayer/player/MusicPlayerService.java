package com.example.mymusicplayer.player;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import com.example.mymusicplayer.utils.LogUtil;

public class MusicPlayerService extends Service {

    private static final String TAG = "MusicPlayerService";

    private MusicPlayBinder mBinder = new MusicPlayBinder();
    public MusicPlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return mBinder;
    }

    public class MusicPlayBinder extends Binder{

        //开始播放
        public void startPlay(){

            LogUtil.d(TAG,"startPlay");
            //1. 如果有当前在播的音乐，继续播放
            //2. 无正在播放音乐，播放当前点击的音乐
            //3. 有正在播放音乐，替换为当前点击的音乐

        }
        //暂停播放
        public void pausePlay(){
            LogUtil.d(TAG,"pausePlay");
            //有歌曲正在播放 进行的动作
            //1. 停止播放
            //2. 停止进度条移动
            //3. 保存
        }
        //切下一首
        public void nextSong(){

            LogUtil.d(TAG,"change to next song");

        }
        //切上一首
        public void prevSong(){
            LogUtil.d(TAG,"change to previous song");

        }

    }



}
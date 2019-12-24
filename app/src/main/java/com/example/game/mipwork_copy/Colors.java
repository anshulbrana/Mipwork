package com.example.game.mipwork_copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletitionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Black","kululli", R.drawable.color_black,R.raw.color_black));
        items.add(new Item("Brown","ṭakaakki", R.drawable.color_brown,R.raw.color_brown));
        items.add(new Item("Dusty Yellow","ṭopiisә", R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        items.add(new Item("Gray","ṭopoppi", R.drawable.color_gray,R.raw.color_gray));
        items.add(new Item("Green","chokokki", R.drawable.color_green,R.raw.color_green));
        items.add(new Item("Mustard Yellow","chiwiiṭә", R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        items.add(new Item("Red","weṭeṭṭi", R.drawable.color_red,R.raw.color_red));
        items.add(new Item("White","kelelli", R.drawable.color_white,R.raw.color_white));

        ListView listView = (ListView) findViewById(R.id.color_list);
        ListViewAdapter adapter = new ListViewAdapter(items, Colors.this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id) {
                Item item = items.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(Colors.this,item.getMaudioresourceID());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletitionListener);
            }
        });
    }
    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }
}

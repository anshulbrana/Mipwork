package com.example.game.mipwork_copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_member extends AppCompatActivity {
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
        setContentView(R.layout.activity_family_member);
        final ArrayList<Item> items=new ArrayList<>();
        items.add(new Item("Father","әpә",R.drawable.family_father,R.raw.family_father));
        items.add(new Item("Mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        items.add(new Item("Son","angsi",R.drawable.family_son,R.raw.family_son));
        items.add(new Item("Daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        items.add(new Item("Older Brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        items.add(new Item("Younger Brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        items.add(new Item("Older Sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        items.add(new Item("Younger Sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        items.add(new Item("Grandfather","ama",R.drawable.family_grandfather,R.raw.family_grandfather));
        items.add(new Item("Grandmother","paapa",R.drawable.family_grandmother,R.raw.family_grandmother));

        ListView listView = (ListView)findViewById(R.id.family_list);
        ListViewAdapter adapter=new ListViewAdapter(items,Family_member.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id) {
                Item item = items.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(Family_member.this,item.getMaudioresourceID());
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


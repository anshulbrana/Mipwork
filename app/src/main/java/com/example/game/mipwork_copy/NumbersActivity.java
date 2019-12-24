package com.example.game.mipwork_copy;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private MediaPlayer.OnCompletionListener mCompletitionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("One","utti",R.drawable.number_one,R.raw.number_one));
        items.add(new Item("Two","otiiko",R.drawable.number_two,R.raw.number_two));
        items.add(new Item("Three","tolookosu",R.drawable.number_three,R.raw.number_three));
        items.add(new Item("Four","oyyisa",R.drawable.number_four,R.raw.number_four));
        items.add(new Item("Five","massokka",R.drawable.number_five,R.raw.number_five));
        items.add(new Item("Six","temmokka",R.drawable.number_six,R.raw.number_six));
        items.add(new Item("Seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        items.add(new Item("Eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        items.add(new Item("Nine","wo’e",R.drawable.number_nine,R.raw.number_nine));
        items.add(new Item("Ten","na’aacha",R.drawable.number_ten,R.raw.number_ten));
        //use of Adaptor
        ListView listView = (ListView) findViewById(R.id.number_list);
        ListViewAdapter adapter=new ListViewAdapter(items,NumbersActivity.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position,long id) {
                Item item=items.get(position);
                releaseMediaPlayer();
                mMediaPlayer=MediaPlayer.create(NumbersActivity.this,item.getMaudioresourceID());
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

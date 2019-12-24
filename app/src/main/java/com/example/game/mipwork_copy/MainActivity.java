package com.example.game.mipwork_copy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.id_number);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(intent);
            }
        }); 
     }
    public void openNumbersClick(View view){
        Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
        startActivity(intent);
    }
    public void openFamily_member(View view){
        Intent intent = new Intent(MainActivity.this,Family_member.class);
        startActivity(intent);
    }
    public void openColor(View view){
        Intent intent = new Intent(MainActivity.this,Colors.class);
        startActivity(intent);
    }
    public void openPhrase(View view){
        Intent intent = new Intent(MainActivity.this,Phrases.class);
        startActivity(intent);
    }
    public void openAudio(View view){
        Intent intent=new Intent(MainActivity.this,activity_audio.class);
        startActivity(intent);

    }

}
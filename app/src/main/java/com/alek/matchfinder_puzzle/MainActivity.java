package com.alek.matchfinder_puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView curView = null;
    private int countPair = 0;
    final int [] drawble = new int[] {R.drawable.sample_0,R.drawable.sample_1,
            R.drawable.sample_2,R.drawable.sample_3,R.drawable.sample_4,
            R.drawable.sample_5,R.drawable.sample_6,R.drawable.sample_7};

    int [] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int curretPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (curretPos <0){
                    curretPos = position;
                    curView = (ImageView) view;
                    ((ImageView)view).setImageResource(drawble[pos[position]]);
                }

                else {
                    if (curretPos == position){

                        ((ImageView)view).setImageResource(R.drawable.hidden);
                    }
                    else if (pos[curretPos] !=pos[position]){
                        curView.setImageResource(R.drawable.hidden);
                        Toast.makeText(getApplicationContext(),"Not match", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        ((ImageView)view).setImageResource(drawble[pos[position]]);
                        countPair++;

                        if ((countPair==0)){
                            Toast.makeText(getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
                        }
                    }
                    curretPos = -1;
                }
            }
        });
    }
}
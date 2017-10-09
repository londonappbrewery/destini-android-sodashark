package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static com.londonappbrewery.destini.R.string.T1_Story;
import static com.londonappbrewery.destini.R.string.T3_Story;
import static com.londonappbrewery.destini.R.string.app_name;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    Button mButtonClose;
    TextView mStoryTextView;
    String mTitle;
    int mStoryIndex=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);
        mButtonClose = (Button) findViewById(R.id.buttonClose);
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);

        mButtonClose.setVisibility(View.GONE);

        mTitle = getString(R.string.app_name);

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Welcome to your " + mTitle);
        alert.setCancelable(false);
        alert.setMessage("Your choices will determine your fate");
        alert.setPositiveButton("Start Interactive Story", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alert.show();


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex==1){
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex=3;
                } else if (mStoryIndex==2){
                    mStoryTextView.setText(R.string.T3_Story);
                    mButtonTop.setText(R.string.T3_Ans1);
                    mButtonBottom.setText(R.string.T3_Ans2);
                    mStoryIndex=3;
                } else {
                    mStoryTextView.setText(R.string.T6_End);
                    updateButtons();
                }
            }
        });

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex==1){
                    mStoryTextView.setText(R.string.T2_Story);
                    mButtonTop.setText(R.string.T2_Ans1);
                    mButtonBottom.setText(R.string.T2_Ans2);
                    mStoryIndex=2;
                } else if (mStoryIndex==2){
                    mStoryTextView.setText(R.string.T4_End);
                    updateButtons();
                } else {
                    mStoryTextView.setText(R.string.T5_End);
                    updateButtons();
                }
            }
        });

        mButtonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void updateButtons() {
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
        mButtonClose.setVisibility(View.VISIBLE);

    }
}
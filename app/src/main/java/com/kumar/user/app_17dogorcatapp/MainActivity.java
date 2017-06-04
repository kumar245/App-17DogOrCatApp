package com.kumar.user.app_17dogorcatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup canineRadioGroup;
    private RadioButton canineRadioButton;
    private SeekBar seekBar;
    private TextView seekBarTextView;
    private CheckBox cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot;
    private RadioGroup droolRadioGroup;
    private RadioButton droolRadioButton;
    private Button showResultButton;
    private int dogCounter;
    private int catCounter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
         seekBar = (SeekBar) findViewById(R.id.seekBar3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarTextView.setText(" Comfortableness : " + progress + "/" +
                                        seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Let's Play", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void setUp(){
        dogCounter=0;
        catCounter=0;

         canineRadioGroup = (RadioGroup) findViewById(R.id.radioGroupCanine);
         droolRadioGroup = (RadioGroup) findViewById(R.id.radioGroupDrool);
        seekBarTextView= (TextView) findViewById(R.id.comfort);
        //check boxes
         cutestCheckBoxDog = (CheckBox) findViewById(R.id.checkboxCutestDog);
         cutestCheckBoxCat = (CheckBox) findViewById(R.id.checkboxCutestCat);
         cutestCheckBoxParrot = (CheckBox) findViewById(R.id.checkboxCutestParrot);
        //call methods
        processCutest(cutestCheckBoxDog, cutestCheckBoxCat, cutestCheckBoxParrot);
        processDrool(droolRadioGroup);
        processCanines(canineRadioGroup);
         showResultButton = (Button) findViewById(R.id.showResults);
        showResultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra("dogCounter",dogCounter);
                intent.putExtra("catCounter",catCounter);
                startActivity(intent);
            }
        });
    }

    void processCutest(CheckBox dog,CheckBox cat,CheckBox parrot){

        if (dog.isChecked() && !cat.isChecked() && !parrot.isChecked()){
            dogCounter+=5;
        }
        else if (cat.isChecked() && !dog.isChecked() && !parrot.isChecked()){
            catCounter+=5;
        }
        else {
            //nobody get points
        }

    }
    public void processDrool(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    int radioId=radioGroup.getCheckedRadioButtonId();
                droolRadioButton= (RadioButton) findViewById(radioId);
                if (droolRadioButton.getText().equals("YES")){
                    dogCounter+=5;
                }

            }
        });
    }
    public void processCanines(final RadioGroup radioGroup){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int radioGroupID=radioGroup.getCheckedRadioButtonId();
                canineRadioButton= (RadioButton) findViewById(radioGroupID);
                if (canineRadioButton.getText().equals("YES")){
                    dogCounter+=5;
                }
            }
        });
    }

}

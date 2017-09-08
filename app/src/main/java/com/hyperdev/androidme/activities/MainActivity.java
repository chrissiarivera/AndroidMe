package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.fragment.BodyPartFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BodyPartFragment mHeadPart;
    private BodyPartFragment mBodyPart;
    private BodyPartFragment mLegPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            mHeadPart = new BodyPartFragment();
            mHeadPart.setPartList(AndroidImageAssets.getHeads());
            int headPosition = getIntent().getIntExtra("headPosition", 0);
            mHeadPart.setListPosition(headPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.head_container, mHeadPart)
                    .commit();

            mBodyPart = new BodyPartFragment();
            mBodyPart.setPartList(AndroidImageAssets.getBodies());
            int bodyPosition = getIntent().getIntExtra("bodyPosition", 0);
            mBodyPart.setListPosition(bodyPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.body_container, mBodyPart)
                    .commit();

            mLegPart = new BodyPartFragment();
            mLegPart.setPartList(AndroidImageAssets.getLegs());
            int legPosition = getIntent().getIntExtra("legPosition", 0);
            mLegPart.setListPosition(legPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.leg_container, mLegPart)
                    .commit();
        }
    }
}

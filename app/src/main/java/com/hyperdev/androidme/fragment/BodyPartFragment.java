package com.hyperdev.androidme.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment {

    private static final String PART_LIST = "partList";
    private static final String PART_NUMBER = "partNumber";
    private List<Integer> mPartNumber;
    private int mListPosition;
    private ImageView mImgView;

    public BodyPartFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       if(savedInstanceState !=  null){
           mPartNumber = savedInstanceState.getIntegerArrayList(PART_LIST);
           mListPosition = savedInstanceState.getInt(PART_NUMBER);
       }

       View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        mImgView = (ImageView) view.findViewById(R.id.bodyPartImg);
        if(mPartNumber != null){
            mImgView.setImageResource(mPartNumber.get(mListPosition));

            mImgView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(mListPosition < mPartNumber.size()-1){
                        mListPosition++;
                    }else {
                        mListPosition = 0;
                    }
                    mImgView.setImageResource(mPartNumber.get(mListPosition));
                }
            });
        }
        return view;
    }

    public void setPartList(List<Integer> partList){
        this.mPartNumber = partList;
    }

    public void setListPosition(int listPosition){
        this.mListPosition = listPosition;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PART_LIST,(ArrayList<Integer>)mPartNumber);
        outState.putInt(PART_NUMBER,mListPosition);
    }

}

package com.sifatsdroid.android_me.ui;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sifatsdroid.android_me.R;
import com.sifatsdroid.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;
/**
 * Created by Sifat on 8/4/2017.
 */
public class BodyPartFragment extends Fragment {
    private List<Integer> mImageIDs;
    private int mListItem;
    public  static final String IMAGE_ID_LIST = "image_ids";
    public  static final String LIST_ITEM_INDEX = "list_index";



    public void setmImageIDs(List<Integer> mImageIDs) {
        this.mImageIDs = mImageIDs;
    }

    public void setmListItem(int mListItem) {
        this.mListItem = mListItem;
    }

    public BodyPartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {

       if (savedInstanceState!=null){
           mImageIDs=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
           mListItem=savedInstanceState.getInt(LIST_ITEM_INDEX);
       }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView=(ImageView) rootView.findViewById(R.id.fragment_body_part_image_view);

        if (mImageIDs!=null){
        imageView.setImageResource(mImageIDs.get(mListItem));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (mListItem<mImageIDs.size()-1) mListItem+=1;
                    else mListItem=0;

                    imageView.setImageResource(mImageIDs.get(mListItem));

                }
            });


        }
        else {

        }
        return rootView;

    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {

        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIDs);
        currentState.putInt(LIST_ITEM_INDEX , mListItem);


    }
}

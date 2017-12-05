package com.st00.afir.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.st00.afir.android_me.R;
import com.st00.afir.android_me.data.AndroidImageAssets;

/**
 * Created by zakaria_afir on 04/12/2017.
 */

public class MasterListFragment extends Fragment {

    private OnImageClickListener mCallback;

    public MasterListFragment() {

    }

    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context) {
        try{
            mCallback = (OnImageClickListener) context;
        } catch (ClassCastException c){
            throw new ClassCastException(context.toString());
        }
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        MasterListAdapter masterListAdapter = new MasterListAdapter(this.getContext(), AndroidImageAssets.getAll());

        final GridView gridView = (GridView) rootView.findViewById(R.id.images_grid_view);

        gridView.setAdapter(masterListAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onImageSelected(position);
            }
        });

        return rootView;

    }

}

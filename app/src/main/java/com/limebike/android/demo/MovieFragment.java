package com.limebike.android.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.limebike.android.demo.com.limebike.android.demo.ui.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Don on 8/29/2019.
 */

public class MovieFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;
    private MovieAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclview_layout, container, false);
        mRecyclerView = view.findViewById (R.id.id_recyclerview);
        initData();
        mAdapter = new MovieAdapter(getActivity (), mDatas);
        mRecyclerView.setLayoutManager (new LinearLayoutManager (getActivity (), LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setItemAnimator (new DefaultItemAnimator());
        mRecyclerView.setAdapter (mAdapter);
        mRecyclerView.addItemDecoration (new DividerItemDecoration(getActivity (),DividerItemDecoration.VERTICAL));
        return view;
    }


    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }
}

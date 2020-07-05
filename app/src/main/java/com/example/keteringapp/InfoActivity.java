package com.example.keteringapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class InfoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Catering> mCateringData;
    private CateringAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(
                this, gridColumnCount));

        mCateringData = new ArrayList<>();

        mAdapter = new CateringAdapter(this, mCateringData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
}

    private void initializeData() {
        String[] CateringList = getResources()
                .getStringArray(R.array.Catering_titles);
        String[] CateringInfo = getResources()
                .getStringArray(R.array.Catering_Info);
        TypedArray CateringImageResourcea =
                getResources().obtainTypedArray(R.array.Catering_Images);
        mCateringData.clear();

        for (int i = 0; i < CateringList.length; i++) {
            mCateringData.add(new Catering(CateringList[i], CateringInfo[i],
                    CateringImageResourcea.getResourceId(i, 0)));

        }
        CateringImageResourcea.recycle();

        mAdapter.notifyDataSetChanged();
    }
}

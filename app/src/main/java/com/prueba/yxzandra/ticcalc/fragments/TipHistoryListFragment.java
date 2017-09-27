package com.prueba.yxzandra.ticcalc.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prueba.yxzandra.ticcalc.R;
import com.prueba.yxzandra.ticcalc.activities.TipDetailActivity;
import com.prueba.yxzandra.ticcalc.adapters.OnItemClickListener;
import com.prueba.yxzandra.ticcalc.adapters.TipAdapter;
import com.prueba.yxzandra.ticcalc.models.TipRecord;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipHistoryListFragment extends android.support.v4.app.Fragment implements TipHistoryFragmentListener, OnItemClickListener {
    @BindView(R.id.recyclerView)
    android.support.v7.widget.RecyclerView recyclerView;

    private TipAdapter adapter;

    public TipHistoryListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tip_history_list, container, false);
        ButterKnife.bind(this, view);
        initAdapter();
        initRecyclerView();
        return view;
    }


    private void initAdapter() {
        if (adapter == null) {
            adapter = new TipAdapter(getActivity().getApplicationContext(), this);
        }
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addToList(TipRecord record) {
        adapter.add(record);
    }

    @Override
    public void clearList() {
        adapter.clear();
    }

    @Override
    public void onItemClick(TipRecord tipRecord) {
        Intent intent = new Intent(getActivity(), TipDetailActivity.class);
        intent.putExtra(TipDetailActivity.TIP_KEY,tipRecord.getTip());
        intent.putExtra(TipDetailActivity.BILL_TOTAL_KEY,tipRecord.getBill());
        intent.putExtra(TipDetailActivity.DATE_KEY,tipRecord.getDateFormatted());

        startActivity(intent);
    }
}

package com.prueba.yxzandra.ticcalc.fragments;

import com.prueba.yxzandra.ticcalc.models.TipRecord;

/**
 * Created by Yxzandra Cordero on 17/7/2016.
 */
public interface TipHistoryFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}

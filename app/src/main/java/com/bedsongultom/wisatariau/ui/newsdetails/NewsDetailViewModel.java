package com.bedsongultom.wisatariau.ui.newsdetails;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsDetailViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public NewsDetailViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
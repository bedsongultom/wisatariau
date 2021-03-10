package com.bedsongultom.wisatariau.ui.newsupdate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsUpdateViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public NewsUpdateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
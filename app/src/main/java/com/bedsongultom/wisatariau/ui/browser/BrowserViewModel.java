package com.bedsongultom.wisatariau.ui.browser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BrowserViewModel extends ViewModel {
    private MutableLiveData<String> mText;
    public BrowserViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Browser fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
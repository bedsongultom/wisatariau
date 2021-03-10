package com.bedsongultom.wisatariau.ui.exit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExitViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ExitViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Are you want to exit ?");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
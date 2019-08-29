package com.limebike.android.demo.ui.presenter;

/**
 * Created by Don on 8/29/2019.
 */

public interface IPresenter {

    void execute();
    void onResume();
    void onStart();
    void onStop();
    void onPause();
    void onDestroy();
}

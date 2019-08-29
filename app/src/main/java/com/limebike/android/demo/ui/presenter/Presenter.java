package com.limebike.android.demo.ui.presenter;

import com.limebike.android.demo.ui.contract.ILoadDataView;

/**
 * Created by Don on 8/29/2019.
 */

public abstract class Presenter<T> implements IPresenter {

    ILoadDataView<T>  view = null;

    public Presenter(ILoadDataView<T> view) {
        this.view = view;
    }

    @Override
    public void execute() {

    }

    public abstract void getMoreData();

    public abstract void refresh();



    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

        view = null;

    }
}

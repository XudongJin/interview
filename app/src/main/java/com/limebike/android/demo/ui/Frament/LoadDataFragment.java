package com.limebike.android.demo.ui.Frament;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;

import com.limebike.android.demo.R;
import com.limebike.android.demo.ui.contract.ILoadDataView;
import com.limebike.android.demo.ui.presenter.IPresenter;
import com.limebike.android.demo.ui.presenter.Presenter;

/**
 * Created by Don on 8/29/2019.
 */

public abstract class LoadDataFragment<T> extends Fragment implements ILoadDataView<T>, View.OnClickListener {

    private IPresenter presenter = null;

    protected FrameLayout frameLayout;


    View mainView;
    View retryView;
    View loadingView;

    protected abstract IPresenter createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.presenter == null)
            this.presenter = this.createPresenter();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View viewContainer = inflater.inflate(R.layout.state_layout, container, false);
        frameLayout = viewContainer.findViewById(R.id.frame_view);
        ViewStub stub = viewContainer.findViewById(R.id.mainView);
        stub.setLayoutResource(this.getLayout());
        mainView = stub.inflate();
        retryView = (Button)viewContainer.findViewById(R.id.retryBtn);
        loadingView = viewContainer.findViewById(R.id.loadingView);
        retryView.setOnClickListener(this);
        showLoading();
        return  viewContainer;

    }

    public abstract int getLayout();

    @Override
    public void showResult() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setData(Object data) {

    }

    @Override
    public Context getViewContext() {
        return getContext();
    }

    @Override
    public void onClick(View view) {
        showLoading();
        presenter.execute();

    }
}

package com.limebike.android.demo.ui.contract;

import android.content.Context;

/**
 * Created by Don on 8/29/2019.
 */

public interface ILoadDataView<T> {

    void showResult();
    void showError(String msg);
    void showLoading();
    void setData(T data);
    Context getViewContext();
}

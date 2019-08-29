package com.limebike.android.demo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(savedInstanceState == null);
    }


    private void initView(Boolean isResume){

        Button btn = (Button) findViewById(R.id.bt_switch);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // fragment template
                FragmentManager fm = getFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();

                // 创建 Fragment 并为其添加一个参数，用来指定应显示的文章
                MovieFragment newFragment = new MovieFragment();
                Bundle args = new Bundle();
                args.putString("Data", "DATA FROM ACTIVITY");
                newFragment.setArguments(args);

                transaction.add(R.id.fragment_container, newFragment,"MovieFragment");
                // OR
                //  内容替换为此 Fragment，
                // 然后将该事务添加到返回堆栈，以便用户可以向后导航
                // transaction.replace(R.id.fragment_container, newFragment);
                //transaction.addToBackStack(null);

                transaction.commit();
            }

        });


        return;
    }
}

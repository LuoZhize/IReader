package com.example.root.ireader.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.root.ireader.R;
import com.example.root.ireader.adapter.addAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 17-6-28.
 */

public class AddActivity extends Activity {
    private List list = new ArrayList();
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        listView.setAdapter(new addAdapter(list));

    }
}

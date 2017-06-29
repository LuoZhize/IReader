package com.example.root.ireader;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.root.ireader.activity.AddActivity;
import com.example.root.ireader.activity.SerchActivity;
import com.example.root.ireader.fragment.BookShelfFragment;
import com.example.root.ireader.fragment.NetFragment;
import com.example.root.ireader.fragment.PublishFragment;
import com.example.root.ireader.fragment.WelfareFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private ActivityMainBinding binding;
    private ViewPager viewPager;
    private TextView bookshelf, net, publis, welfare, addBook, serchBook;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initFragment();
        initView();
        SWFragment();

    }

    private void initView() {
        serchBook = (TextView) findViewById(R.id.activity_serch);
        addBook = (TextView) findViewById(R.id.activity_add);
        bookshelf = (TextView) findViewById(R.id.activity_bookshelf);
        net = (TextView) findViewById(R.id.activity_net);
        publis = (TextView) findViewById(R.id.activity_publish);
        welfare = (TextView) findViewById(R.id.activity_welfare);
        bookshelf.setOnClickListener(this);
        net.setOnClickListener(this);
        publis.setOnClickListener(this);
        welfare.setOnClickListener(this);
        serchBook.setOnClickListener(this);
        addBook.setOnClickListener(this);
    }

    private void initFragment() {
        fragmentList.add(new BookShelfFragment());
        fragmentList.add(new NetFragment());
        fragmentList.add(new PublishFragment());
        fragmentList.add(new WelfareFragment());
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pager, new BookShelfFragment());
        fragmentTransaction.commit();
    }

    private void SWFragment() {
        viewPager = (ViewPager) binding.pager.findViewById(R.id.pager);
        //让viewpager缓存两个页面
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new BookShelfFragment();
                    case 1:
                        return new NetFragment();
                    case 2:
                        return new PublishFragment();
                    case 3:
                        return new WelfareFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_bookshelf:
                viewPager.setCurrentItem(0);
                break;
            case R.id.activity_net:
                viewPager.setCurrentItem(1);
                break;
            case R.id.activity_publish:
                viewPager.setCurrentItem(2);
                break;
            case R.id.activity_welfare:
                viewPager.setCurrentItem(3);
                break;
            case R.id.activity_add:
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                break;
            case R.id.activity_serch:
                startActivity(new Intent(MainActivity.this, SerchActivity.class));
                break;
        }
    }
}

package com.example.sp.shahezaddemo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sp.shahezaddemo.adapter.ViewPagerAdapter;
import com.example.sp.shahezaddemo.bean.Book;
import com.example.sp.shahezaddemo.fragment.ContentFragment;
import com.example.sp.shahezaddemo.fragment.HistoryFragment;
import com.example.sp.shahezaddemo.fragment.LoginFragment;
import com.example.sp.shahezaddemo.util.UtilLog;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String message = intent.getStringExtra("key");
        int number = bundle.getInt("Integer", 0);
        int fakeNumber = bundle.getInt("fake", 0);
        Book book = (Book) bundle.getSerializable("book");

        UtilLog.logD("ViewPagerActivity, value is: ",message);

        //empty string "" + number, converts number to string
        UtilLog.logD("ViewPagerActivity, number is: ","" +number);

        UtilLog.logD("ViewPagerActivity, fake number is: ", String.valueOf(fakeNumber));

        //use to get author for the book
        UtilLog.logD("ViewPagerActivity, book author is: ", book.getAuthor());
        initial();
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    private void initial()
    {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //initalized as a field
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("message", "ViewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();
    }
}

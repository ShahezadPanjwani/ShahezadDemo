package com.example.sp.shahezaddemo;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sp.shahezaddemo.adapter.ListViewAdapter;
import com.example.sp.shahezaddemo.adapter.ViewPagerAdapter;
import com.example.sp.shahezaddemo.fragment.ContentFragment;
import com.example.sp.shahezaddemo.fragment.HistoryFragment;
import com.example.sp.shahezaddemo.fragment.LoginFragment;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayList<String> listResult;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult =  new ArrayList<String>();
        createFakeResult();
        initialView();

    }

    private void createFakeResult() {
        listResult.add("AAAAAAAAAAAAAAA");
        listResult.add("BBBBBBBBBBBB");
        listResult.add("CCCCCC");
        listResult.add("DD");
        listResult.add("EEEEEEEEEE");
        listResult.add("F");
        listResult.add("GGGGGGGGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");

    }

    private void initialView() {


        listView = (ListView)findViewById(R.id.list_view);

        //points to header file to refer to
        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);
        LinearLayout listViewHeader = (LinearLayout)view.findViewById(R.id.list_view_header);

        viewPager = (ViewPager) view.findViewById(R.id.list_view_pager);
        //initalized as a field
        fragmentList.add(new LoginFragment());
        fragmentList.add(new ContentFragment());
        fragmentList.add(new HistoryFragment());
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);

        viewPager.setAdapter(viewPagerAdapter);



        ListViewAdapter listViewAdapter = new ListViewAdapter(this,listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"listView was clicked at position: " +position,Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",String.valueOf(position));

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("message", "ViewPager");
        setResult(RESULT_OK, intent);
        super.onBackPressed();

    }

}

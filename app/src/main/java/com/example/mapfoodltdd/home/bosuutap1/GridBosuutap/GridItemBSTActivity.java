package com.example.mapfoodltdd.home.bosuutap1.GridBosuutap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.Adapter.SectionPagerAdapterHome;
import com.example.mapfoodltdd.home.HomeFragment;
import com.example.mapfoodltdd.home.TabHome.BanChay.BanChayFragment;
import com.example.mapfoodltdd.home.TabHome.GanToi.GanToiFragment;
import com.example.mapfoodltdd.home.listprovince.ListProvince;
import com.google.android.material.tabs.TabLayout;

public class GridItemBSTActivity extends AppCompatActivity {

    TextView idnamebst,tenchitietbst;
    ImageView imageViewbst;
    ViewPager viewPagerhome;
    TabLayout tabLayouthome;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item_bst);

        back=(ImageView) findViewById(R.id.idbackgridbst);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openGridItemActivity();
            }
        });

        tenchitietbst=findViewById(R.id.tenchitietbst);
        idnamebst = findViewById(R.id.idnamechinh);
        imageViewbst = findViewById(R.id.imageViewbst);
        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        int receivedImage = intent.getIntExtra("image",0);
        idnamebst.setText(receivedName);
        imageViewbst.setImageResource(receivedImage);
        tenchitietbst.setText(receivedName);

        viewPagerhome = findViewById(R.id.viewPagerbst);
        tabLayouthome = findViewById(R.id.tabLayoutbst);
        setUpViewPagerHome(viewPagerhome);
        tabLayouthome.setupWithViewPager(viewPagerhome);
        tabLayouthome.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    private void setUpViewPagerHome(ViewPager viewPager) {
        SectionPagerAdapterHome adapter = new SectionPagerAdapterHome(getSupportFragmentManager());

        adapter.addFragment(new BanChayFragment(), "Gợi ý");
        adapter.addFragment(new GanToiFragment(), "Gần tôi");
        adapter.addFragment(new BanChayFragment(), "Đặt nhiều");
        adapter.addFragment(new GanToiFragment(), "Giảm nhiều");
        viewPagerhome.setAdapter(adapter);
    }
    public void openGridItemActivity(){
        Intent intent=new Intent(GridItemBSTActivity.this, XemThemBSTActivity.class);
        startActivity(intent);
        finish();
    }
}
package com.example.mapfoodltdd.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mapfoodltdd.R;
import com.example.mapfoodltdd.home.Adapter.SectionPagerAdapterHome;
import com.example.mapfoodltdd.home.IconMenu.IconMenuAdapter;
import com.example.mapfoodltdd.home.IconMenu.ListIcon;
import com.example.mapfoodltdd.home.IconMenu.chitieticonmenu.ChiTietIconMenuActivity;
import com.example.mapfoodltdd.home.Map.MapActivity;
import com.example.mapfoodltdd.home.TabHome.BanChay.BanChayFragment;
import com.example.mapfoodltdd.home.TabHome.DanhGia.DanhGiaFragment;
import com.example.mapfoodltdd.home.TabHome.GanToi.GanToiFragment;
import com.example.mapfoodltdd.home.TabHome.GiaoNhanh.GiaoNhanhFragment;
import com.example.mapfoodltdd.home.bosuutap1.Bosuutap1Adapter;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.GridItemBSTActivity;
import com.example.mapfoodltdd.home.bosuutap1.GridBosuutap.XemThemBSTActivity;
import com.example.mapfoodltdd.home.bosuutap1.ListBoSuuTap1;
import com.example.mapfoodltdd.home.listprovince.ListProvince;
import com.example.mapfoodltdd.home.tonghopicon.TongHopIconAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private TextView txtProvince, txtmap,txtxemthembst;
    RecyclerView recyclerViewbosuutap;
    private View root;
    public EditText txtlocation;
    Context context;
    RecyclerView mList1,mList2,mListbst1,mListthicon;
    List<ListIcon> appList1,appList2,appListthicon;
    List<ListBoSuuTap1> appListbst1;
    ViewPager viewPagerhome;
    TabLayout tabLayouthome;
    private MapActivity mMapActivity;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }

    interface FragmentCallback {
        void onClickButton(HomeFragment fragment);
    }
    private FragmentCallback mCallback;
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        context=getActivity();
        root = inflater.inflate(R.layout.fragment_home, container, false);

        //Xem thêm bộ sưu tập
        txtxemthembst=root.findViewById(R.id.xemthembst);
        txtxemthembst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThemBoSuuTap();
            }
        });
        
        //Chuyển map ->Home Fragment
//        txtlocation= root.findViewById(R.id.txt_destination);
//        txtlocation.setText(mMapActivity.getMlocation());

        //Icon menu


        // List Icon
        mList1 = root.findViewById(R.id.listicon1);
        mListbst1=root.findViewById(R.id.listbst1);
        appList1 = new ArrayList<>();
        appListbst1= new ArrayList<>();

        appList1.add(new ListIcon(R.drawable.trasua,"Trà sữa"));
        appList1.add(new ListIcon(R.drawable.tigersugar,"Tiger Sugar"));
        appList1.add(new ListIcon(R.drawable.rice,"Cơm"));
        appList1.add(new ListIcon(R.drawable.freeship,"Freeship XTra"));
        appList1.add(new ListIcon(R.drawable.snack,"Ăn vặt"));
        appList1.add(new ListIcon(R.drawable.nowship,"Now ship"));
        appList1.add(new ListIcon(R.drawable.quanmoi,"Quán mới"));
        appList1.add(new ListIcon(R.drawable.airpay,"Airpay"));
        appList1.add(new ListIcon(R.drawable.nowtable,"NowTable"));
        appList1.add(new ListIcon(R.drawable.nowfresh,"NowFresh"));
        appList1.add(new ListIcon(R.drawable.doitac,"Đối tác"));
        appList1.add(new ListIcon(R.drawable.hoa,"Hoa"));
        appList1.add(new ListIcon(R.drawable.pet,"Thú cưng"));
        appList1.add(new ListIcon(R.drawable.sieuthi,"Siêu thị"));
        appList1.add(new ListIcon(R.drawable.giatui,"Giặt ủi"));
        appList1.add(new ListIcon(R.drawable.thuoc,"Thuốc"));
        appList1.add(new ListIcon(R.drawable.lamdep,"Làm đẹp"));
        appList1.add(new ListIcon(R.drawable.bia,"Bia"));
        appList1.add(new ListIcon(R.drawable.sale,"Sale"));
        appList1.add(new ListIcon(R.drawable.giupviec,"Giúp việc"));

        GridLayoutManager manager1 = new GridLayoutManager(HomeFragment.this.getActivity(),2);
        manager1.setOrientation(GridLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

        IconMenuAdapter adaptor1 = new IconMenuAdapter(HomeFragment.this.getActivity(),appList1);
        mList1.setAdapter(adaptor1);



        // List Bộ siêu tập1
        appListbst1.add(new ListBoSuuTap1(1,R.drawable.bst1,"Combo x3 với thẻ Visa"));
        appListbst1.add(new ListBoSuuTap1(2,R.drawable.bst2,"Bữa tiệc đa dạng"));
        appListbst1.add(new ListBoSuuTap1(3,R.drawable.bst3,"Combo lẩu tươi"));
        appListbst1.add(new ListBoSuuTap1(4,R.drawable.bst4,"Combo cơm Lào"));
        appListbst1.add(new ListBoSuuTap1(5,R.drawable.bst5,"Deal đỉnh mỗi ngày"));

        LinearLayoutManager manager3 = new LinearLayoutManager(HomeFragment.this.getActivity());
        manager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListbst1.setLayoutManager(manager3);

        Bosuutap1Adapter adaptor3 = new Bosuutap1Adapter(HomeFragment.this.getActivity(),appListbst1);
        mListbst1.setAdapter(adaptor3);

        // List tổng hợp icon
        mListthicon=root.findViewById(R.id.listthonghop);
        appListthicon= new ArrayList<>();

        appListthicon.add(new ListIcon(R.drawable.tatca,"Tất cả"));
        appListthicon.add(new ListIcon(R.drawable.food,"Đồ ăn"));
        appListthicon.add(new ListIcon(R.drawable.douong,"Đồ uống"));
        appListthicon.add(new ListIcon(R.drawable.monchay,"Đồ chay"));
        appListthicon.add(new ListIcon(R.drawable.banhkem,"Bánh kem"));
        appListthicon.add(new ListIcon(R.drawable.trangmieng,"Tráng miệng"));
        appListthicon.add(new ListIcon(R.drawable.homemade,"Homemade"));
        appListthicon.add(new ListIcon(R.drawable.viahe,"Vỉa hè"));
        appListthicon.add(new ListIcon(R.drawable.burger,"Pizza/Burger"));
        appListthicon.add(new ListIcon(R.drawable.monga,"Món gà"));
        appListthicon.add(new ListIcon(R.drawable.lau,"Món lẩu"));
        appListthicon.add(new ListIcon(R.drawable.sushi,"Sushi"));
        appListthicon.add(new ListIcon(R.drawable.noodle,"Mì phở"));
        appListthicon.add(new ListIcon(R.drawable.com,"Cơm hộp"));

        LinearLayoutManager manager4 = new LinearLayoutManager(HomeFragment.this.getActivity());
        manager4.setOrientation(LinearLayoutManager.HORIZONTAL);
        mListthicon.setLayoutManager(manager4);

        TongHopIconAdapter adaptor4 = new TongHopIconAdapter(HomeFragment.this.getActivity(),appListthicon);
        mListthicon.setAdapter(adaptor4);

        //ImageSlider
        viewPagerhome = root.findViewById(R.id.viewPagerhome);
        tabLayouthome = root.findViewById(R.id.tabLayouthome);

        txtlocation=root.findViewById(R.id.textlocation);

        ImageSlider imageSlider = (ImageSlider) root.findViewById ( R.id.slide );
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add ( new SlideModel (R.drawable.pn1) );
        slideModels.add ( new SlideModel (R.drawable.pn2) );
        slideModels.add ( new SlideModel (R.drawable.pn3) );
        slideModels.add ( new SlideModel (R.drawable.pn4) );
        slideModels.add ( new SlideModel (R.drawable.pn5) );
        imageSlider.setImageList ( slideModels,true );

        txtProvince = root.findViewById(R.id.listprovince);
        txtProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openListprovince();
            }
        });
        txtmap = root.findViewById(R.id.textlocation);
        txtmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });
//        initUI();

        return root;
    }

//    private void initUI() {
//
//        txtlocation=root.findViewById(R.id.txt_destination);
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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
        SectionPagerAdapterHome adapter = new SectionPagerAdapterHome(getChildFragmentManager());

        adapter.addFragment(new BanChayFragment(), "Bán chạy");
        adapter.addFragment(new GanToiFragment(), "Gần tôi");
        adapter.addFragment(new BanChayFragment(), "Đánh giá");
        adapter.addFragment(new GanToiFragment(), "Giao nhanh");
        viewPagerhome.setAdapter(adapter);
    }

// Intent
    public void openListprovince(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), ListProvince.class);
        startActivity(intent);
    }
    public void openMap(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), MapActivity.class);
        startActivity(intent);
    }
    public void openXemThemBoSuuTap(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), XemThemBSTActivity.class);
        startActivity(intent);
    }
    public void openChiTietIconMenu(){
        Intent intent=new Intent(HomeFragment.this.getActivity(), ChiTietIconMenuActivity.class);
        startActivity(intent);
    }

}
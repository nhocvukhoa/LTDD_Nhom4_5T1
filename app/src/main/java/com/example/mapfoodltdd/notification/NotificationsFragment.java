package com.example.mapfoodltdd.notification;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.mapfoodltdd.R;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private ListView listView, listView2;
    Context context;
    private ConstraintLayout rela, rela2;
    private ArrayList<ThongBaoModel> thongbaoData;
    private CustomAdapter customAdapter;
    private ThongBaoModel thongbaoModel;

    private ArrayList<TinhTrangModel> tinhtrangData;
    private CustomAdapter2 customAdapter2;
    private TinhTrangModel tinhtrangModel;

    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        listView = root.findViewById(R.id.listView);
        rela = root.findViewById(R.id.rela);
        thongbaoData = new ArrayList<>();

        listView2 = root.findViewById(R.id.listView2);
        rela2 = root.findViewById(R.id.rela2);
        tinhtrangData = new ArrayList<>();

        //add Countries Data
        listthongbaoData();
        listtinhtrang();
        customAdapter = new CustomAdapter(context, thongbaoData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, thongbaoData.get(position).getTieude(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(),name[position], Toast.LENGTH_LONG).show();
//                 Intent intent = new Intent(getApplicationContext(), OpenThongBao.class);
//                intent.putExtra("image", image[position]);
//                intent.putExtra("name", name[position]);
//                startActivity(intent);
            }
        });
        customAdapter2 = new CustomAdapter2(context, tinhtrangData);
        listView2.setAdapter(customAdapter2);
        registerForContextMenu(listView2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, tinhtrangData.get(position).getTieude2(), Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    private void listthongbaoData() {

        thongbaoModel=new ThongBaoModel();
        thongbaoModel.setId(1);
        thongbaoModel.setAvata(R.drawable.sale);
        thongbaoModel.setTieude("Khuyến mãi");
        thongbaoModel.setNoidung("Chốt đơn combo Buger King CHỈ 35K");
        thongbaoModel.setDetail(R.drawable.detail);
        thongbaoData.add(thongbaoModel);

        thongbaoModel=new ThongBaoModel();
        thongbaoModel.setId(2);
        thongbaoModel.setAvata(R.drawable.loa);
        thongbaoModel.setTieude("Tin tức");
        thongbaoModel.setNoidung("Chưa có tin tức nào");
        thongbaoModel.setDetail(R.drawable.detail);
        thongbaoData.add(thongbaoModel);
    }
    private void listtinhtrang() {

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(1);
        tinhtrangModel.setAvata2(R.drawable.banhcanh);
        tinhtrangModel.setTieude2("Đã hoàn tất đơn");
        tinhtrangModel.setNoidung2("Đơn hàng của bạn tại Bánh Canh Đường Ray - Lê Độ đã được Phong Trần Hải giao thành công. Cảm ơn bạn đã sử dụng dịch vụ Now.");
        tinhtrangModel.setTime("24/10/2020 13:04");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(2);
        tinhtrangModel.setAvata2(R.drawable.chethai);
        tinhtrangModel.setTieude2("Đã hoàn tất đơn");
        tinhtrangModel.setNoidung2("Đơn hàng của bạn tại Chè Liên Đà Nẵng đã được Đức Ngô Mạnh giao thành công. Cảm ơn bạn đã sử dụng dịch vụ Now.");
        tinhtrangModel.setTime("22/10/2020 9:15");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(3);
        tinhtrangModel.setAvata2(R.drawable.caffemuoi);
        tinhtrangModel.setTieude2("Đã hoàn tất đơn");
        tinhtrangModel.setNoidung2("Đơn hàng của bạn tại Cà Phê Muối Samdi-Mike đã được Hiền Văn Lê giao thành công. Cảm ơn bạn đã sử dụng dịch vụ Now.");
        tinhtrangModel.setTime("17/10/2020 10:20");
        tinhtrangData.add(tinhtrangModel);

        tinhtrangModel=new TinhTrangModel();
        tinhtrangModel.setId(4);
        tinhtrangModel.setAvata2(R.drawable.comga);
        tinhtrangModel.setTieude2("Đã hoàn tất đơn");
        tinhtrangModel.setNoidung2("Đơn hàng của bạn tại Cơm gà Vân - Lê Đình Lý đã được Đức Văn Trần giao thành công. Cảm ơn bạn đã sử dụng dịch vụ Now.");
        tinhtrangModel.setTime("11/10/2020 18:20");
        tinhtrangData.add(tinhtrangModel);

    }
}

package com.example.mapfoodltdd.Order.Tab;

import android.os.Bundle;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mapfoodltdd.R;


public class DonNhapFragment extends Fragment {

    TextView popupdichvudn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_donnhap, container, false);
        popupdichvudn= root.findViewById(R.id.popupdichvudnhap);
        popupdichvudn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupdichvu(view);
            }
        });
        return root;
    }
    public void showPopupdichvu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menudichvulichsu_order, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.thuoc:
                        Toast.makeText(getActivity().getApplicationContext(),"Thuốc",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.thucung:
                        Toast.makeText(getActivity().getApplicationContext(),"Thú cưng",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giatui:
                        Toast.makeText(getActivity().getApplicationContext(),"Giặt ủi",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giaohang:
                        Toast.makeText(getActivity().getApplicationContext(),"Giao hàng",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.datban:
                        Toast.makeText(getActivity().getApplicationContext(),"Đặt bàn",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.salon:
                        Toast.makeText(getActivity().getApplicationContext(),"Salon",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.giupviec:
                        Toast.makeText(getActivity().getApplicationContext(),"Giúp việc",Toast.LENGTH_LONG).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
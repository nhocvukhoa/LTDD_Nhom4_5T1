package com.example.mapfoodltdd.collections;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mapfoodltdd.R;

import java.util.ArrayList;

public class CollectionsFragment extends Fragment {

    Spinner spinnerdanhsach;
    TextView xemthem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.fragment_collections, container, false);
        xemthem =root.findViewById (R.id.xemthem);
        xemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openXemThem();
            }

            private void openXemThem() {
                Intent intent=new Intent(CollectionsFragment.this.getActivity(), Xemthem.class);
                startActivity(intent);
            }
        });
        spinnerdanhsach = root.findViewById ( R.id.spinner );
        ArrayList<String> arrayListdanhsach = new ArrayList<String> ();
        arrayListdanhsach.add("Dịch vụ");
        arrayListdanhsach.add("Món ăn");
        arrayListdanhsach.add("Đồ uống");
        arrayListdanhsach.add("Thực phẩm");
        arrayListdanhsach.add("Sản phẩm");
        arrayListdanhsach.add("Thú cưng");
        arrayListdanhsach.add("Khác");

        ArrayAdapter arrayAdapter = new ArrayAdapter (CollectionsFragment.this.getActivity(), android.R.layout.simple_spinner_item,arrayListdanhsach );
        arrayAdapter.setDropDownViewResource ( android.R.layout.simple_spinner_dropdown_item );
        spinnerdanhsach.setAdapter ( arrayAdapter );

        //Bắt sự kiện cho Spinner, khi chọn phần tử nào thì hiển thị lên Toast
        spinnerdanhsach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //đối số postion là vị trí phần tử trong list Data
                Toast.makeText(CollectionsFragment.this.getActivity(),arrayListdanhsach.get ( position ), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Toast.makeText(CollectionsFragment.this.getActivity(), "onNothingSelected", Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }
}
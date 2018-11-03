package com.adamk.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RequestFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private ListView listView;

    public static RequestFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RequestFragment fragment = new RequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        listView = (ListView) getView().findViewById(R.id.lv_feed);
        List<Item> items = makeData();
        Log.d("hej", items.size()+"");
        ItemsAdapter adapter = new ItemsAdapter(this.getContext(), makeData() );
        listView.setAdapter(adapter);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);


        return view;
    }

    private List<Item> makeData() {
        List itemList = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            itemList.add(new Item("Hammare ", "Detta är hammre nummer ", R.drawable.hammer, "2 km"));
        }

        return itemList;
    }
}

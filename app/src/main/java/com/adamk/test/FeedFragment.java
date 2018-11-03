package com.adamk.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// In this case, the fragment displays simple text based on the page
public class FeedFragment extends Fragment {

    private ListView listView;

    public FeedFragment() {}

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static FeedFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        Log.d("hej", "Page:" + page);
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

        View rootView = inflater.inflate(R.layout.fragment_page, container, false);

        return rootView;
    }

    private List<Item> makeData() {
        List itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            itemList.add(new Item("Hammare ", "Detta är hammre nummer ", R.drawable.hammer, "2 km"));
        }

        return itemList;
    }

    public void onClick(int adapterPosition) {
        //Item item = itemList.get(adapterPosition);
        //Intent intent = new Intent(MainActivity.this, ItemDetail.class);
        //intent.putExtra("Item", item);
        //startActivity(intent);
    }

}

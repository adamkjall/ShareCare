package com.adamk.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// In this case, the fragment displays simple text based on the page
public class FeedFragment extends Fragment {

    private ListView listView;

    public FeedFragment() {
    }

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
        final List<Item> items = feedData();
        ItemsAdapter adapter = new ItemsAdapter(this.getContext(), items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position);
                Intent intent = new Intent(getContext(), ItemDetail.class);
                intent.putExtra("Item", item);
                startActivity(intent);
            }
        });
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_page, container, false);

        return rootView;
    }

    private List<Item> feedData() {
        List itemList = new ArrayList<>();

        itemList.add(new Item("Long handled cultivator", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.long_handled_cultivator, "2.5 km", 5));
        itemList.add(new Item("Scythe", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.scythe, "0.5 km", 4));
        itemList.add(new Item("Seeder", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.seeder, "5 km", 3));
        itemList.add(new Item("Wheelbarrow", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.wheelbarrow, "3 km", 0));
        itemList.add(new Item("Automatic seeder ", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.automatic_seeder, "2 km", 5));
        itemList.add(new Item("Microseeder", "Some text about wonderful tools that you can borrow from a friendly local citizen ", R.drawable.microseeder, "8 km", 5));
        itemList.add(new Item("Portable pressure pump", "Some text about wonderful tools that you can borrow from a friendly local citizen", R.drawable.portable_pressure_pump, "12 km", 1));
        itemList.add(new Item("Hammare 1", "Detta är en hammare", R.drawable.hammer, "1.4 km", 0));
        itemList.add(new Item("Hammare 2", "Detta är hammare", R.drawable.hammer, "0.7 km", 2));
        itemList.add(new Item("Hammare 3", "Detta är hummer", R.drawable.hammer, "10 km", 2));
        itemList.add(new Item("Hammare 4", "Detta är hammare", R.drawable.hammer, "2 km", 4));

        return itemList;
    }


}

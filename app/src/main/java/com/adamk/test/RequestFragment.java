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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RequestFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private ListView listView;
    private List<Item> items;

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
        items = makeData();

        ItemsAdapter adapter = new ItemsAdapter(this.getContext(), makeData() );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = items.get(position);
                Intent intent = new Intent(getContext(), ItemDetail2.class);
                intent.putExtra("Item", item);
                startActivity(intent);
            }
        });
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

        itemList.add(new Item("Weeding tool needed", "I have problem with weeds in my garden. I need a tool to remove this kind of weeds easily.", R.drawable.weeding_tool, "2.5 km", 5));
        itemList.add(new Item("Sulfate tool", "I have some bugs on this small plantation and I need to sulfate to get rid of them but I have to tools for doing so.", R.drawable.sulfate_tool, "0.5 km", 4));
        itemList.add(new Item("Wheat harvest tool", "My small wheat plantation is ready for harvesting. it is my first time and I have no appropriate tool. I would like both the tool and the advice.", R.drawable.wheat_harvest, "5 km", 3));
        itemList.add(new Item("Tool for moving hay", "I have some hay from the last season. I want to move it, and I need a specific tool for it.", R.drawable.moving_hay, "3 km", 0));
        itemList.add(new Item("I need to seed my spot", "I want to seed my spot for the next season. Therefore I need a manual seeder.", R.drawable.seed_my_spot, "2 km", 5));

        return itemList;
    }
}

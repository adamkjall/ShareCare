package com.adamk.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;

public class ItemsAdapter extends ArrayAdapter<Item> {

    private List<Item> itemList;

    public ItemsAdapter(@NonNull Context context, List<Item> items) {

        super(context, R.layout.card_view, items);
    }

    /*public ItemsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public ItemsAdapter(@NonNull Context context, int resource, @NonNull Item[] objects, List<Item> itemList) {
        super(context, resource, objects);
        this.itemList = itemList;
    }*/

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_view, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Item item = getItem(position);

        holder.iv_image.setImageResource(item.getImage());
        holder.tv_title.setText(item.getTitle());
        holder.tv_distance.setText(item.getDistance());

        return convertView;
    }

    public void setData(List<Item> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }


    // The view holder design pattern
    static class ViewHolder  {

        private ImageView iv_image;
        private TextView tv_title;
        private TextView tv_description;
        private TextView tv_distance;

        public ViewHolder(@NonNull View itemView) {

            iv_image = itemView.findViewById(R.id.iv_main_image);

            iv_image = itemView.findViewById(R.id.iv_main_image);
            tv_title = itemView.findViewById(R.id.tv_main_title);
            tv_distance = itemView.findViewById(R.id.tv_main_distance);
        }

    }

}

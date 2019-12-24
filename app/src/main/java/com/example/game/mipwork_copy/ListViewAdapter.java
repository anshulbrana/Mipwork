package com.example.game.mipwork_copy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by game on 23/02/18.
 */

public class ListViewAdapter extends ArrayAdapter<Item> {
    ArrayList<Item> items=new ArrayList<>();
    Context context;
    public ListViewAdapter(ArrayList<Item> items,Context context){
        super(context,R.layout.list_item,items);
        this.context=context;
        this.items=items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item currentItem = getItem(position);

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
            TextView textView = (TextView) listItemView.findViewById(R.id.textView);
            TextView textView1=(TextView) listItemView.findViewById(R.id.cTextView);
            ImageView imageView = (ImageView) listItemView.findViewById(R.id.imageView);

            textView.setText(currentItem.getNumber());
            textView1.setText(currentItem.getCNumber());
            imageView.setImageResource(currentItem.getImage());

        return listItemView;
    }
}

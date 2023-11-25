package com.example.contact_contracting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContracterAdapter extends ArrayAdapter<Contracter> {
    private int mcolorResourceId;
    public String cname;
    public String caddress;
    public ContracterAdapter(Activity context, ArrayList<Contracter> contracters, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, contracters);
        mcolorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Contracter currentContracter = getItem(position);

        TextView contractersName = listItemView.findViewById(R.id.contracters_name);
        contractersName.setText(currentContracter.getmContarcterNmae());
     cname=contractersName.toString();
        TextView contractersAddress = listItemView.findViewById(R.id.contracters_address);
        contractersAddress.setText(currentContracter.getmContracterAddress());
      caddress=contractersAddress.toString();
        ImageView defaultImage = listItemView.findViewById(R.id.image_resource_view);
        defaultImage.setImageResource(currentContracter.getmImageResourceId());
        defaultImage.setVisibility(View.VISIBLE);



        return listItemView;

    }




}
package io.volcain.android.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import io.volcain.android.tourguide.R;
import io.volcain.android.tourguide.module.Place;

/*
* {@link PlaceAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link Place} objects.
*
* Created by volcain on 12/18/16.
*/
public class PlaceAdapter extends ArrayAdapter<Place> {
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor). The context
     * is used to inflate the layout file, and the list is the data we want to populate into the
     * lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param places  A List of {@link Place} objects to display in a list
     */
    public PlaceAdapter(Context context, ArrayList<Place> places, int resource) {
        super(context, -1, places);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Place} object located at this position in the list
        final Place currentPlace = getItem(position);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_image_view);
        // if Place object provides an image show it
        if (currentPlace.hasImage()) {
            // Get the image resource ID from the current Place object and set the image to iconView
            iconView.setImageResource(currentPlace.getImageResourceId());
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.item_container);

        // Find the TextView in the list_item.xml layout with the ID short_desc_text_view
        TextView shortDescTextView = (TextView) listItemView.findViewById(R.id.short_desc_text_view);
        // Get the short description from the current Place object and set this text on the name TextView
        shortDescTextView.setText(currentPlace.getShortDescription());

        // Find the TextView in the list_item.xml layout with the ID entry_price_text_view
        TextView entryPriceTextView = (TextView) listItemView.findViewById(R.id.entry_price_text_view);
        // Get the short description from the current Place object and set this text on the name TextView
        entryPriceTextView.setText(currentPlace.getEntryPrice());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in the ListView
        return listItemView;
    }
}

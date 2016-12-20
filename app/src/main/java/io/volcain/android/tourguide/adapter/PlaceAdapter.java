package io.volcain.android.tourguide.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
    public View getView(int position, final View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        // to reference the child views for later actions
        ViewHolder holder;
        // Get the {@link Place} object located at this position in the list
        final Place currentPlace = getItem(position);

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            // cache view fields into the holder
            holder = new ViewHolder();
            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
            holder.placeImage = (ImageView) listItemView.findViewById(R.id.list_item_image_view);
            if (currentPlace != null) {
                // if Place object provides an image show it
                if (currentPlace.hasImage()) {
                    // Get the image resource ID from the current Place object and set the image to iconView
                    holder.placeImage.setImageResource(currentPlace.getImageResourceId());
                    holder.placeImage.setVisibility(View.VISIBLE);
                } else {
                    holder.placeImage.setVisibility(View.GONE);
                }
            }
            // Find the TextView in the list_item.xml layout with the ID place_name_text_view
            holder.placeNameText = (TextView) listItemView.findViewById(R.id.place_name_text_view);
            // Get the place name from the current Place object and set this text on the name TextView
            holder.placeNameText.setText(currentPlace.getLocation().getName());

            // Find the TextView in the list_item.xml layout with the ID entry_price_text_view
            holder.entryPriceText = (TextView) listItemView.findViewById(R.id.entry_price_text_view);
            // Get the entry price from the current Place object and set this text on the name TextView
            holder.entryPriceText.setText(currentPlace.getEntryPrice());

            // Find the ImageView in the list_item.xml layout with the ID list_item_info_image_view
            holder.directionsIcon = (ImageView) listItemView.findViewById(R.id.list_item_info_image_view);
            // If there is a website provided we will display the ic_language icon else ic_directions
            if (currentPlace.hasWebsite()) {
                holder.directionsIcon.setImageResource(R.drawable.ic_language_black_36dp);
            } else {
                holder.directionsIcon.setImageResource(R.drawable.ic_directions_black_36dp);
            }
            // associate the holder with the view for later lookup
            listItemView.setTag(holder);
        } else {
            // view already exists, get the holder instance from the view
            holder = (ViewHolder) listItemView.getTag();
        }

        /*
        if (currentPlace != null) {
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

            // Find the TextView in the list_item.xml layout with the ID place_name_text_view
            TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name_text_view);
            // Get the place name from the current Place object and set this text on the name TextView
            placeNameTextView.setText(currentPlace.getLocation().getName());

            // Find the TextView in the list_item.xml layout with the ID entry_price_text_view
            TextView entryPriceTextView = (TextView) listItemView.findViewById(R.id.entry_price_text_view);
            // Get the entry price from the current Place object and set this text on the name TextView
            entryPriceTextView.setText(currentPlace.getEntryPrice());

            // Find the ImageView in the list_item.xml layout with the ID list_item_info_image_view
            ImageView directionsView = (ImageView) listItemView.findViewById(R.id.list_item_info_image_view);
            // If there is a website provided we will display the ic_language icon else ic_directions
            if (currentPlace.hasWebsite()) {
                directionsView.setImageResource(R.drawable.ic_language_black_36dp);
            } else {
                directionsView.setImageResource(R.drawable.ic_directions_black_36dp);
            }
        }*/

        // Return the whole list item layout (containing 2 TextViews and 2 ImageViews) so that it can be shown in the ListView
        return listItemView;
    }

    // create a class to hold your exact set of views
    static class ViewHolder {
        ImageView placeImage;
        TextView placeNameText;
        TextView entryPriceText;
        ImageView directionsIcon;
    }
}



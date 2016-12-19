package io.volcain.android.tourguide;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.volcain.android.tourguide.adapter.PlaceAdapter;
import io.volcain.android.tourguide.module.Location;
import io.volcain.android.tourguide.module.Place;

public class SpecialEventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set up the "Up" button to navigate to back to the main screen
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        // Christkindelsmarkt
        Location location = new Location(getString(R.string.event_christkindelsmarkt_name), getString(R.string.event_christkindelsmarkt_street), getString(R.string.event_christkindelsmarkt_zip_code));
        Place place = new Place(getString(R.string.event_christkindelsmarkt_entry_price), R.drawable.event_christkindelsmarkt, location);
        places.add(place);

        // The Blue Night
        location = new Location(getString(R.string.event_blue_night_name), null, null);
        place = new Place(getString(R.string.event_blue_night_entry_price), R.drawable.event_blue_night, location, getString(R.string.event_blue_night_website));
        places.add(place);

        // Create an ArrayAdapter, whose data source is a list of Place objects. The
        // adapter knows how to create layouts for each item in the list, using the
        // list_item.xml layout resource.
        // This list item layout contains two {@link TextView} views, which the adapter will set to
        // display text.
        PlaceAdapter itemsAdapter = new PlaceAdapter(this, places, -1);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);
        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each place in the list of places.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);
        // Set a click listener to open the map when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Place} object at the given position the user clicked on
                final Place place = places.get(position);

                String uriString;

                // if there is a website provided we will use that information else we will use the address
                if (place.hasWebsite()) {
                    uriString = place.getWebsite();
                } else {
                    // Build the intent
                    Location placeLocation = place.getLocation();
                    uriString = "geo:0,0?q=" + placeLocation.getName() + "," + placeLocation.getStreet() + "," + placeLocation.getZipCode() + "," + getString(placeLocation.getCityId()) + "," + getString(placeLocation.getCountryId());
                }

                Uri location = Uri.parse(uriString);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                // Verify it resolves
                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Start an activity if it's safe
                if (isIntentSafe) {
                    startActivity(mapIntent);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    // This activity is NOT part of this app's task, so create a new task
                    // when navigating up, with a synthesized back stack.
                    TaskStackBuilder.create(this)
                            // Add all of this activity's parents to the back stack
                            .addNextIntentWithParentStack(upIntent)
                            // Navigate up to the closest parent
                            .startActivities();
                } else {
                    // This activity is part of this app's task, so simply
                    // navigate up to the logical parent activity.
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

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

public class MuseumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set up the "Up" button to navigate to back to the main screen
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        // House of Albrecht Dürer
        Location location = new Location(getString(R.string.museum_albrecht_duerer_name), getString(R.string.museum_albrecht_duerer_street), getString(R.string.museum_albrecht_duerer_zip_code));
        Place place = new Place(getString(R.string.museum_albrecht_duerer_entry_price), R.drawable.museum_albrecht_duerer, location);
        places.add(place);

        // Germanisches Nationalmuseum
        location = new Location(getString(R.string.museum_german_nationalmuseum_name), getString(R.string.museum_german_nationalmuseum_street), getString(R.string.museum_german_nationalmuseum_zip_code));
        place = new Place(getString(R.string.museum_german_nationalmuseum_entry_price), R.drawable.museum_german_nationalmuseum, location);
        places.add(place);

        // Memorium Nuremberg Trials
        location = new Location(getString(R.string.museum_memorium_trials_name), getString(R.string.museum_memorium_trials_street), getString(R.string.museum_memorium_trials_zip_code));
        place = new Place(getString(R.string.museum_memorium_trials_entry_price), R.drawable.museum_memorium_trials, location);
        places.add(place);

        // Documentation Centre
        location = new Location(getString(R.string.museum_docu_center_name), getString(R.string.museum_docu_center_street), getString(R.string.museum_docu_center_zip_code));
        place = new Place(getString(R.string.museum_docu_center_entry_price), R.drawable.museum_docu_center, location);
        places.add(place);

        // New Museum - State Museum for Art and Design
        location = new Location(getString(R.string.museum_new_name), getString(R.string.museum_new_street), getString(R.string.museum_new_zip_code));
        place = new Place(getString(R.string.museum_new_entry_price), R.drawable.museum_new, location);
        places.add(place);

        // Toy Museum
        location = new Location(getString(R.string.museum_toy_name), getString(R.string.museum_toy_street), getString(R.string.museum_toy_zip_code));
        place = new Place(getString(R.string.museum_toy_entry_price), R.drawable.museum_toy, location);
        places.add(place);

        // DB Railway Museum
        location = new Location(getString(R.string.museum_db_railway_name), getString(R.string.museum_db_railway_street), getString(R.string.museum_db_railway_zip_code));
        place = new Place(getString(R.string.museum_db_railway_entry_price), R.drawable.museum_db_railway, location);
        places.add(place);

        // Tucher Mansion Museum and the Hirsvogel Hall
        location = new Location(getString(R.string.museum_tucher_mansion_name), getString(R.string.museum_tucher_mansion_street), getString(R.string.museum_tucher_mansion_zip_code));
        place = new Place(getString(R.string.museum_tucher_mansion_entry_price), R.drawable.museum_tucher_mansion, location);
        places.add(place);

        // Medieval Dungeons
        location = new Location(getString(R.string.museum_medieval_dungeons_name), getString(R.string.museum_medieval_dungeons_street), getString(R.string.museum_medieval_dungeons_zip_code));
        place = new Place(getString(R.string.museum_medieval_dungeons_entry_price), R.drawable.museum_medieval_dungeons, location);
        places.add(place);

        // City Museum Nuremberg
        location = new Location(getString(R.string.museum_city_name), getString(R.string.museum_city_street), getString(R.string.museum_city_zip_code));
        place = new Place(getString(R.string.museum_city_entry_price), R.drawable.museum_city, location);
        places.add(place);

        // Museum of Industrial Culture
        location = new Location(getString(R.string.museum_industrial_culture_name), getString(R.string.museum_industrial_culture_street), getString(R.string.museum_industrial_culture_zip_code));
        place = new Place(getString(R.string.museum_industrial_culture_entry_price), R.drawable.museum_industrial_culture, location);
        places.add(place);

        // Communications Museum
        location = new Location(getString(R.string.museum_communications_name), getString(R.string.museum_communications_street), getString(R.string.museum_communications_zip_code));
        place = new Place(getString(R.string.museum_communications_entry_price), R.drawable.museum_communications, location);
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

                // Build the intent
                Location placeLocation = place.getLocation();
                String uriString = "geo:0,0?q=" + placeLocation.getName() + "," + placeLocation.getStreet() + "," + placeLocation.getZipCode() + "," + getString(placeLocation.getCityId()) + "," + getString(placeLocation.getCountryId());
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

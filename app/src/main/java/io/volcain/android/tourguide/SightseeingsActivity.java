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

public class SightseeingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set up the "Up" button to navigate to back to the main screen
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        // Former Nazi Party Rally Grounds
        Location location = new Location(getString(R.string.sightseeing_former_party_ground_name), getString(R.string.sightseeing_former_party_ground_street), getString(R.string.sightseeing_former_party_ground_zip_code));
        Place place = new Place(getString(R.string.sightseeing_former_party_ground_short_desc), getString(R.string.sightseeing_former_party_ground_entry_price), R.drawable.sightseeing_former_party_ground, location);
        places.add(place);

        // Craftsmen's Courtyard
        location = new Location(getString(R.string.sightseeing_craftmens_courtyard_name), getString(R.string.sightseeing_craftmens_courtyard_street), getString(R.string.sightseeing_craftmens_courtyard_zip_code));
        place = new Place(getString(R.string.sightseeing_craftmens_courtyard_short_desc), getString(R.string.sightseeing_craftmens_courtyard_entry_price), R.drawable.sightseeing_craftmens_courtyard, location);
        places.add(place);

        // Imperial Castle
        location = new Location(getString(R.string.sightseeing_imperial_castle_name), getString(R.string.sightseeing_imperial_castle_street), getString(R.string.sightseeing_imperial_castle_zip_code));
        place = new Place(getString(R.string.sightseeing_imperial_castle_short_desc), getString(R.string.sightseeing_imperial_castle_entry_price), R.drawable.sightseeing_imperial_castle, location);
        places.add(place);

        // Beautiful Fountain
        location = new Location(getString(R.string.sightseeing_beautiful_fountain_name), getString(R.string.sightseeing_beautiful_fountain_street), getString(R.string.sightseeing_beautiful_fountain_zip_code));
        place = new Place(getString(R.string.sightseeing_beautiful_fountain_short_desc), getString(R.string.sightseeing_beautiful_fountain_entry_price), R.drawable.sightseeing_beautiful_fountain, location);
        places.add(place);

        // St. Lawrence Church
        location = new Location(getString(R.string.sightseeing_lawrence_church_name), getString(R.string.sightseeing_lawrence_church_street), getString(R.string.sightseeing_lawrence_church_zip_code));
        place = new Place(getString(R.string.sightseeing_lawrence_church_short_desc), getString(R.string.sightseeing_lawrence_church_entry_price), R.drawable.sightseeing_lawrence_church, location);
        places.add(place);

        // St. Sebald Church
        location = new Location(getString(R.string.sightseeing_sebald_church_name), getString(R.string.sightseeing_sebald_church_street), getString(R.string.sightseeing_sebald_church_zip_code));
        place = new Place(getString(R.string.sightseeing_sebald_church_short_desc), getString(R.string.sightseeing_sebald_church_entry_price), R.drawable.sightseeing_sebald_church, location);
        places.add(place);

        // Zoological Garden
        location = new Location(getString(R.string.sightseeing_zoo_garden_name), getString(R.string.sightseeing_zoo_garden_street), getString(R.string.sightseeing_zoo_garden_zip_code));
        place = new Place(getString(R.string.sightseeing_zoo_garden_short_desc), getString(R.string.sightseeing_zoo_garden_entry_price), R.drawable.sightseeing_zoo_garden, location);
        places.add(place);

        // The Way of Human Rights
        location = new Location(getString(R.string.sightseeing_way_human_rights_name), getString(R.string.sightseeing_way_human_rights_street), getString(R.string.sightseeing_way_human_rights_zip_code));
        place = new Place(getString(R.string.sightseeing_way_human_rights_short_desc), getString(R.string.sightseeing_way_human_rights_entry_price), R.drawable.sightseeing_way_human_rights, location);
        places.add(place);

        // Hospital of the Holy Spirit
        location = new Location(getString(R.string.sightseeing_hospital_holy_spirit_name), getString(R.string.sightseeing_hospital_holy_spirit_street), getString(R.string.sightseeing_hospital_holy_spirit_zip_code));
        place = new Place(getString(R.string.sightseeing_hospital_holy_spirit_short_desc), getString(R.string.sightseeing_hospital_holy_spirit_entry_price), R.drawable.sightseeing_hospital_holy_spirit, location);
        places.add(place);

        // Church of Our Lady
        location = new Location(getString(R.string.sightseeing_church_lady_name), getString(R.string.sightseeing_church_lady_street), getString(R.string.sightseeing_church_lady_zip_code));
        place = new Place(getString(R.string.sightseeing_church_lady_short_desc), getString(R.string.sightseeing_church_lady_entry_price), R.drawable.sightseeing_church_lady, location);
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

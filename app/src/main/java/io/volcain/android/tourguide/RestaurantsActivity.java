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

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // set up the "Up" button to navigate to back to the main screen
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create a list of places
        final ArrayList<Place> places = new ArrayList<>();

        // Albrecht-Dürer-Stube
        Location location = new Location(getString(R.string.restaurant_albrecht_duerer_name), getString(R.string.restaurant_albrecht_duerer_street), getString(R.string.restaurant_albrecht_duerer_zip_code));
        Place place = new Place(getString(R.string.restaurant_albrecht_duerer_entry_price), R.drawable.restaurant_albrecht_duerer, location);
        places.add(place);

        // Zur Baumwolle
        location = new Location(getString(R.string.restaurant_zur_baumwolle_name), getString(R.string.restaurant_zur_baumwolle_street), getString(R.string.restaurant_zur_baumwolle_zip_code));
        place = new Place(getString(R.string.restaurant_zur_baumwolle_entry_price), R.drawable.restaurant_zur_baumwolle, location);
        places.add(place);

        // Gasthof Weinländer
        location = new Location(getString(R.string.restaurant_gasthof_weinlaender_name), getString(R.string.restaurant_gasthof_weinlaender_street), getString(R.string.restaurant_gasthof_weinlaender_zip_code));
        place = new Place(getString(R.string.restaurant_gasthof_weinlaender_entry_price), R.drawable.restaurant_gasthof_weinlaender, location);
        places.add(place);

        // Reichelsdorfer Keller
        location = new Location(getString(R.string.restaurant_reichelsdorfer_keller_name), getString(R.string.restaurant_reichelsdorfer_keller_street), getString(R.string.restaurant_reichelsdorfer_keller_zip_code));
        place = new Place(getString(R.string.restaurant_reichelsdorfer_keller_entry_price), R.drawable.restaurant_reichelsdorfer_keller, location);
        places.add(place);

        // Landgasthof Gentner
        location = new Location(getString(R.string.restaurant_landgasthof_gentner_name), getString(R.string.restaurant_landgasthof_gentner_street), getString(R.string.restaurant_landgasthof_gentner_zip_code));
        place = new Place(getString(R.string.restaurant_landgasthof_gentner_entry_price), R.drawable.restaurant_landgasthof_gentner, location);
        places.add(place);

        // Burgwächter
        location = new Location(getString(R.string.restaurant_burgwaechter_name), getString(R.string.restaurant_burgwaechter_street), getString(R.string.restaurant_burgwaechter_zip_code));
        place = new Place(getString(R.string.restaurant_burgwaechter_entry_price), R.drawable.restaurant_burgwaechter, location);
        places.add(place);

        // Böhm\'s Herrenkeller
        location = new Location(getString(R.string.restaurant_boehms_herrenkeller_name), getString(R.string.restaurant_boehms_herrenkeller_street), getString(R.string.restaurant_boehms_herrenkeller_zip_code));
        place = new Place(getString(R.string.restaurant_boehms_herrenkeller_entry_price), R.drawable.restaurant_boehms_herrenkeller, location);
        places.add(place);

        // Schäufelewärtschaft
        location = new Location(getString(R.string.restaurant_schaeufelewaertschaft_name), getString(R.string.restaurant_schaeufelewaertschaft_street), getString(R.string.restaurant_schaeufelewaertschaft_zip_code));
        place = new Place(getString(R.string.restaurant_schaeufelewaertschaft_entry_price), R.drawable.restaurant_schaeufelewaertschaft, location);
        places.add(place);

        // Pillhofer
        location = new Location(getString(R.string.restaurant_pillhofer_name), getString(R.string.restaurant_pillhofer_street), getString(R.string.restaurant_pillhofer_zip_code));
        place = new Place(getString(R.string.restaurant_pillhofer_entry_price), R.drawable.restaurant_pillhofer, location);
        places.add(place);

        // Alte Küch\'n
        location = new Location(getString(R.string.restaurant_alte_kuechn_name), getString(R.string.restaurant_alte_kuechn_street), getString(R.string.restaurant_alte_kuechn_zip_code));
        place = new Place(getString(R.string.restaurant_alte_kuechn_entry_price), R.drawable.restaurant_alte_kuechn, location);
        places.add(place);

        // Gaststätte Petzengarten
        location = new Location(getString(R.string.restaurant_petzengarten_name), getString(R.string.restaurant_petzengarten_street), getString(R.string.restaurant_petzengarten_zip_code));
        place = new Place(getString(R.string.restaurant_petzengarten_entry_price), R.drawable.restaurant_petzengarten, location);
        places.add(place);

        // Weinrestaurant Steichele
        location = new Location(getString(R.string.restaurant_steichele_name), getString(R.string.restaurant_steichele_street), getString(R.string.restaurant_steichele_zip_code));
        place = new Place(getString(R.string.restaurant_steichele_entry_price), R.drawable.restaurant_steichele, location);
        places.add(place);

        // Fränkische Weinstube
        location = new Location(getString(R.string.restaurant_fraenkische_weinstube_name), getString(R.string.restaurant_fraenkische_weinstube_street), getString(R.string.restaurant_fraenkische_weinstube_zip_code));
        place = new Place(getString(R.string.restaurant_fraenkische_weinstube_entry_price), R.drawable.restaurant_fraenkische_weinstube, location);
        places.add(place);

        // Heilig-Geist-Spital
        location = new Location(getString(R.string.restaurant_heilig_geist_spital_name), getString(R.string.restaurant_heilig_geist_spital_street), getString(R.string.restaurant_heilig_geist_spital_zip_code));
        place = new Place(getString(R.string.restaurant_heilig_geist_spital_entry_price), R.drawable.restaurant_heilig_geist_spital, location);
        places.add(place);

        // Zum Spießgesellen
        location = new Location(getString(R.string.restaurant_zum_spiessgesellen_name), getString(R.string.restaurant_zum_spiessgesellen_street), getString(R.string.restaurant_zum_spiessgesellen_zip_code));
        place = new Place(getString(R.string.restaurant_zum_spiessgesellen_entry_price), R.drawable.restaurant_zum_spiessgesellen, location);
        places.add(place);

        // Barfüßer
        location = new Location(getString(R.string.restaurant_barfuesser_name), getString(R.string.restaurant_barfuesser_street), getString(R.string.restaurant_barfuesser_zip_code));
        place = new Place(getString(R.string.restaurant_barfuesser_entry_price), R.drawable.restaurant_barfuesser, location);
        places.add(place);

        // Raubritter
        location = new Location(getString(R.string.restaurant_raubritter_name), getString(R.string.restaurant_raubritter_street), getString(R.string.restaurant_raubritter_zip_code));
        place = new Place(getString(R.string.restaurant_raubritter_entry_price), R.drawable.restaurant_raubritter, location);
        places.add(place);

        // Gaststätte Augustiner - Zur Schranke
        location = new Location(getString(R.string.restaurant_zur_schranke_name), getString(R.string.restaurant_zur_schranke_street), getString(R.string.restaurant_zur_schranke_zip_code));
        place = new Place(getString(R.string.restaurant_zur_schranke_entry_price), R.drawable.restaurant_zur_schranke, location);
        places.add(place);

        // Hexenhäusle
        location = new Location(getString(R.string.restaurant_hexenhaeusle_name), getString(R.string.restaurant_hexenhaeusle_street), getString(R.string.restaurant_hexenhaeusle_zip_code));
        place = new Place(getString(R.string.restaurant_hexenhaeusle_entry_price), R.drawable.restaurant_hexenhaeusle, location);
        places.add(place);

        // Zum Karlsbrückla
        location = new Location(getString(R.string.restaurant_zum_karlsbrueckla_name), getString(R.string.restaurant_zum_karlsbrueckla_street), getString(R.string.restaurant_zum_karlsbrueckla_zip_code));
        place = new Place(getString(R.string.restaurant_zum_karlsbrueckla_entry_price), R.drawable.restaurant_zum_karlsbrueckla, location);
        places.add(place);

        // Goldenes Posthorn
        location = new Location(getString(R.string.restaurant_goldenes_posthorn_name), getString(R.string.restaurant_goldenes_posthorn_street), getString(R.string.restaurant_goldenes_posthorn_zip_code));
        place = new Place(getString(R.string.restaurant_goldenes_posthorn_entry_price), R.drawable.restaurant_goldenes_posthorn, location);
        places.add(place);

        // Bratwurst Röslein
        location = new Location(getString(R.string.restaurant_bratwurst_roeslein_name), getString(R.string.restaurant_bratwurst_roeslein_street), getString(R.string.restaurant_bratwurst_roeslein_zip_code));
        place = new Place(getString(R.string.restaurant_bratwurst_roeslein_entry_price), R.drawable.restaurant_bratwurst_roeslein, location);
        places.add(place);

        // Etzerdla
        location = new Location(getString(R.string.restaurant_etzerdla_name), getString(R.string.restaurant_etzerdla_street), getString(R.string.restaurant_etzerdla_zip_code));
        place = new Place(getString(R.string.restaurant_etzerdla_entry_price), R.drawable.restaurant_etzerdla, location);
        places.add(place);

        // Restaurant Oberkrainer
        location = new Location(getString(R.string.restaurant_oberkrainer_name), getString(R.string.restaurant_oberkrainer_street), getString(R.string.restaurant_oberkrainer_zip_code));
        place = new Place(getString(R.string.restaurant_oberkrainer_entry_price), R.drawable.restaurant_oberkrainer, location);
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

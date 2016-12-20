package io.volcain.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // start initializing on click listeners
        this.initOnClickListeners();
    }


    /**
     * Initialize the click listeners on each category (Sightseeing, Museums, Restaurants and Christkindelsmarkt)
     */
    private void initOnClickListeners() {
        // Set a click listener on that layout (Sigthseeings)
        RelativeLayout sightseeingsLayout = (RelativeLayout) findViewById(R.id.sightseeing_layout);
        sightseeingsLayout.setOnClickListener(new ClickListener());
        // Set a click listener on that layout (Museums)
        RelativeLayout museumsLayout = (RelativeLayout) findViewById(R.id.museum_layout);
        museumsLayout.setOnClickListener(new ClickListener());
        // Set a click listener on that layout (Restaurants)
        RelativeLayout restaurantsLayout = (RelativeLayout) findViewById(R.id.restaurant_layout);
        restaurantsLayout.setOnClickListener(new ClickListener());
        // Set a click listener on that layout (Special Events)
        RelativeLayout specialEventsLayout = (RelativeLayout) findViewById(R.id.specialevents_layout);
        specialEventsLayout.setOnClickListener(new ClickListener());
    }

    private class ClickListener implements View.OnClickListener {
        Class<?> aClass;

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.sightseeing_layout:
                    aClass = SightseeingsActivity.class;
                    break;
                case R.id.museum_layout:
                    aClass = MuseumsActivity.class;
                    break;
                case R.id.restaurant_layout:
                    aClass = RestaurantsActivity.class;
                    break;
                case R.id.specialevents_layout:
                    aClass = SpecialEventsActivity.class;
                    break;
            }

            Intent placeIntent = new Intent(MainActivity.this, aClass);
            startActivity(placeIntent);
        }
    }
}

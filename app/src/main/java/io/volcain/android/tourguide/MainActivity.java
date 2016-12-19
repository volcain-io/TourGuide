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
        sightseeingsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sightseeingsIntent = new Intent(MainActivity.this, SightseeingsActivity.class);
                startActivity(sightseeingsIntent);
            }
        });
        // Set a click listener on that layout (Museums)
        RelativeLayout museumsLayout = (RelativeLayout) findViewById(R.id.museum_layout);
        museumsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent museumsIntent = new Intent(MainActivity.this, MuseumsActivity.class);
                startActivity(museumsIntent);
            }
        });
        // Set a click listener on that layout (Restaurants)
        RelativeLayout restaurantsLayout = (RelativeLayout) findViewById(R.id.restaurant_layout);
        restaurantsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurantsIntent);
            }
        });
        // Set a click listener on that layout (Christkindelsmarkt)
        RelativeLayout christkindelsmarktLayout = (RelativeLayout) findViewById(R.id.christkindlesmarkt_layout);
        christkindelsmarktLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent christkindelsmarktIntent = new Intent(MainActivity.this, SpecialEventsActivity.class);
                startActivity(christkindelsmarktIntent);
            }
        });
    }
}

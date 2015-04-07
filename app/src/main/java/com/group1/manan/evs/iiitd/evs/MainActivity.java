package com.group1.manan.evs.iiitd.evs;

import android.app.FragmentManager;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.iconics.utils.Utils;


public class MainActivity extends ActionBarActivity {
    private ImageButton mImageButton;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handle toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Handle DrawerLayout
        DrawerLayout mdraDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        //Handle ActionBarDrawerToggle
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mdraDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        mdraDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        //Drawerlist
        LinearLayout mDrawerList = (LinearLayout) findViewById(R.id.drawerList);

        //Progress Bar
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        mDrawerList.findViewById(R.id.drawer_pollution).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle args = new Bundle();
                Fragment pollution = new PollutionFragment();
                pollution.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.frame, pollution).commit();


            }

        });
        ((ImageView) mDrawerList.findViewById(R.id.drawer_pollution_icon)).setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_sitemap).colorRes(R.color.secondary).actionBarSize());

        mImageButton = (ImageButton) findViewById(R.id.fab_button);
        mImageButton.setImageDrawable(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_refresh).color(Color.WHITE).actionBarSize());
        mImageButton.setOnClickListener(fabClickListener);
        com.group1.manan.evs.iiitd.evs.Utils.configureFab(mImageButton);

        //mImageButton
       /** mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.theme_accent));
        mSwipeRefreshLayout.setRefreshing(false);
      /**  mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                //mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            }
        });**/

        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    View.OnClickListener fabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
        }
    };


    public void animateActivity() {
    }

    private class Getdata extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //handle visibility
            mProgressBar.setVisibility(View.GONE);

            //set data for list
            mSwipeRefreshLayout.setRefreshing(false);

            super.onPostExecute(result);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

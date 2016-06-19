package com.example.darcel.sors_moi;

/**
 * Created by Darcel on 06/04/2016.
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity
        /*implements NavigationView.OnNavigationItemSelectedListener */{

    public static final String ID_REQUESTED = "IDTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailled_activity);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        final Intent intent = getIntent();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                //this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.setDrawerListener(toggle);
        //toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);*/

        TextView textTitleActivity = (TextView) findViewById(R.id.textTitleActivity);
        TextView textTitle2 = (TextView) findViewById(R.id.textTitle2);
        TextView texteDateActivity = (TextView) findViewById(R.id.texteDateActivity);
        TextView texteHourActivity = (TextView) findViewById(R.id.texteHourActivity);
        TextView planActivity = (TextView) findViewById(R.id.planActivity);

        textTitleActivity.setText(getIntent().getExtras().get("NomActivity").toString());



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.parties_, menu);
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

    /*@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.connect) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.calendar) {

        } else if (id == R.id.contact) {

        } else if (id == R.id.infoslegales) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
package com.example.darcel.sors_moi;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.darcel.sors_moi.Webservice.Models.Activite;
import com.example.darcel.sors_moi.Webservice.Models.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Parties_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button boutondetails;
    List<Activite> activit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent intent = getIntent();

        String Cat = intent.getStringExtra(MainActivity.BOUTON_CHOISI);

        TextView textTitle = (TextView) findViewById(R.id.textTitle2);
        if (Cat.equals("Soiree")) {
            textTitle.setText("Soirées");
        }
        if (Cat.equals("Bar")) {
            textTitle.setText("Bars");
        }
        if (Cat.equals("Resto")) {
            textTitle.setText(R.string.resto);
        }
        if (Cat.equals("Concert")) {
            textTitle.setText("Concerts");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listActivity();

    }



    public void listActivity() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://sors-moi.api.montpellier.epsi.fr/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            ApiService service = retrofit.create(ApiService.class);
            final Call<List<Activite>> activities = service.listActivity();
            activities.enqueue(new Callback<List<Activite>>() {
                @Override
                public void onResponse(Call<List<Activite>> call, Response<List<Activite>> response) {
                    Log.w("List Activité", "OK");
                    Log.w("Response", response.message());
                    if (response.isSuccessful()) {
                        activit = response.body();
                        /*for(int i = 1; i <= response.body().size(); i++) {
                            Log.w("Reponse envoyée : ",response.body().get(i).getNomActivite());
                        }*/
                    }
                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    MyAdapter adapt = new MyAdapter(getApplicationContext());
                    adapt.act = activit;
                    recyclerView.setAdapter(adapt);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }

                @Override
                public void onFailure(Call<List<Activite>> call, Throwable t) {
                    Log.w("List Activité", "KO");
                    Log.w("Erreur", t.getMessage());
                }
            });
        }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.connect) {
            Intent intent = new Intent(Parties_Activity.this, ConnectionActivity.class);
            startActivity(intent);

        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(Parties_Activity.this, EditUserActivity.class);
            startActivity(intent);

        //} else if (id == R.id.calendar) {

        } else if (id == R.id.contact) {
            Intent intent = new Intent(Parties_Activity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.infoslegales) {
            Intent intent = new Intent(Parties_Activity.this, MentionsLegalesActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

package com.example.darcel.sors_moi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Darcel on 20/04/2016.
 */
public class ContactActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlayout);

        final Intent intent = getIntent();


        Button mailerBerthet = (Button) findViewById(R.id.mailerBerthet);
        mailerBerthet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                Intent email = new Intent(android.content.Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.adressemailBerthet)});
                email.putExtra(Intent.EXTRA_SUBJECT, "À propos de Sors-moi !");
                email.putExtra(Intent.EXTRA_TEXT, "Soyez indulgent, c'est notre première appli...");
                //emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });

        Button mailerCornu = (Button) findViewById(R.id.mailerCornu);
        mailerCornu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                Intent email = new Intent(android.content.Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.adressemailCornu)});
                email.putExtra(Intent.EXTRA_SUBJECT, "À propos de Sors-moi !");
                email.putExtra(Intent.EXTRA_TEXT, "Soyez indulgent, c'est notre première appli...");
                //emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });

        Button mailerDangla = (Button) findViewById(R.id.mailerDangla);
        mailerDangla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                Intent email = new Intent(android.content.Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.adressemailDangla)});
                email.putExtra(Intent.EXTRA_SUBJECT, "À propos de Sors-moi !");
                email.putExtra(Intent.EXTRA_TEXT, "Soyez indulgent, c'est notre première appli...");
                //emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });

        Button mailerDarcel = (Button) findViewById(R.id.mailerDarcel);
        mailerDarcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                Intent email = new Intent(android.content.Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{getResources().getString(R.string.adressemailDarcel)});
                email.putExtra(Intent.EXTRA_SUBJECT, "À propos de Sors-moi !");
                email.putExtra(Intent.EXTRA_TEXT, "Soyez indulgent, c'est notre première appli...");
                //emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(email, "Send mail..."));
            }
        });


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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.connect) {

        } else if (id == R.id.settings) {

        } else if (id == R.id.calendar) {

        } else if (id == R.id.contact) {

        } else if (id == R.id.infoslegales) {
            Intent intent = new Intent(ContactActivity.this, MentionsLegalesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

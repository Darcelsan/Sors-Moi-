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
import android.widget.EditText;
import android.widget.TextView;

import com.example.darcel.sors_moi.Webservice.Models.ApiService;
import com.example.darcel.sors_moi.Webservice.Models.Utilisateur;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Darcel on 20/04/2016.
 */
public class ConnectionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button confirmInscription;
    String nomUtilisateur;
    String prenomUtilisateur;
    String mailUtilisateur;
    String villeUtilisateur;
    String codePostalUtilisateur;
    String motDePasse;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connectionlayout);

        final Intent intent = getIntent();

        EditText nomUtili = (EditText) findViewById(R.id.nomInscri);
            nomUtilisateur = nomUtili.getText().toString();
            EditText prenomUtili = (EditText) findViewById(R.id.prenomInscri);
            prenomUtilisateur = prenomUtili.getText().toString();
            EditText mailUtili = (EditText) findViewById(R.id.mailInscri);
            mailUtilisateur = mailUtili.getText().toString();
            EditText villeUtili = (EditText) findViewById(R.id.villeInscri);
            villeUtilisateur = villeUtili.getText().toString();
            EditText codePostalUtili = (EditText) findViewById(R.id.codePostalInscri);
            codePostalUtilisateur = codePostalUtili.getText().toString();
            EditText motDePasseUtili = (EditText) findViewById(R.id.motDePasseInscri);
            motDePasse = motDePasseUtili.getText().toString();

        Button confirmInscription = (Button) findViewById(R.id.confirmInscription);
        confirmInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                inscription();
            }
        });


    }

    public void inscription(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sors-moi.api.montpellier.epsi.fr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Utilisateur utilisat = new Utilisateur(nomUtilisateur, prenomUtilisateur, mailUtilisateur, villeUtilisateur, codePostalUtilisateur, motDePasse);
        Call<Utilisateur> call = service.createUser(utilisat);
        call.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                TextView confirm = (TextView) findViewById(R.id.validationInscri);
                confirm.setText("Utilisateur créé avec succès !");
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {

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
            Intent intent = new Intent(ConnectionActivity.this, MentionsLegalesActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

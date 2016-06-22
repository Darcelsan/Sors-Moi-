package com.example.darcel.sors_moi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
public class EditUserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Button recuperer;
    Button modifier;
    String idUtilisateur;
    String nomUtilisateur;
    String prenomUtilisateur;
    String mailUtilisateur;
    String villeUtilisateur;
    String codePostalUtilisateur;
    String motDePasse;
    Utilisateur user;
    EditText idutili;
    EditText nomUtili;
    EditText prenomUtili;
    EditText mailUtili;
    EditText villeUtili;
    EditText codePostalUtili;
    EditText motDePasseUtili;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edituserlayout);

        final Intent intent = getIntent();
        idutili = (EditText) findViewById(R.id.idInscri2);
        nomUtili = (EditText) findViewById(R.id.nomInscri2);
        prenomUtili = (EditText) findViewById(R.id.prenomInscri2);
        mailUtili = (EditText) findViewById(R.id.mailInscri2);
        villeUtili = (EditText) findViewById(R.id.villeInscri2);
        codePostalUtili = (EditText) findViewById(R.id.codePostalInscri2);
        motDePasseUtili = (EditText) findViewById(R.id.motDePasseInscri2);

        recuperer = (Button) findViewById(R.id.getuser);
        recuperer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                idUtilisateur = idutili.getText().toString();
                recuperID();
            }
        });

        modifier = (Button) findViewById(R.id.confirmInscription);
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context context;
                context = v.getContext();
                idUtilisateur = idutili.getText().toString();
                nomUtilisateur = nomUtili.getText().toString();
                prenomUtilisateur = prenomUtili.getText().toString();
                mailUtilisateur = mailUtili.getText().toString();
                villeUtilisateur = villeUtili.getText().toString();
                codePostalUtilisateur = codePostalUtili.getText().toString();
                motDePasse = motDePasseUtili.getText().toString();
                modification();
            }
        });


    }

    public void recuperID() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sors-moi.api.montpellier.epsi.fr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        final Call<Utilisateur> getUser = service.getUser(idUtilisateur);
        getUser.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                Log.w("Response", response.message());
                if (response.isSuccessful()) {
                    user = response.body();
                    nomUtili.setText(user.getNomUtilisateur());
                    prenomUtili.setText(user.getPrenomUtilisateur());
                    mailUtili.setText(user.getMailUtilisateur());
                    villeUtili.setText(user.getVilleUtilisateur());
                    codePostalUtili.setText(user.getCodePostalUtilisateur());
                    motDePasseUtili.setText(user.getMotDePasse());
                }
                else {
                    TextView confirm = (TextView) findViewById(R.id.validationInscri2);
                    confirm.setText("Utilisateur introuvable.");
                }
            }

            @Override
            public void onFailure(Call<Utilisateur> call, Throwable t) {
                Log.w("List Activité", "KO");
                Log.w("Erreur", t.getMessage());
            }
        });
    }

    public void modification(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sors-moi.api.montpellier.epsi.fr/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Utilisateur utilisat = new Utilisateur(idUtilisateur, nomUtilisateur, prenomUtilisateur, mailUtilisateur, villeUtilisateur, codePostalUtilisateur, motDePasse);
        Call<Utilisateur> call = service.deleteUser(Integer.parseInt(idUtilisateur));
        call.enqueue(new Callback<Utilisateur>() {
            @Override
            public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                Log.d("RETROFIT DELETE", response.message());
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://sors-moi.api.montpellier.epsi.fr/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService service = retrofit.create(ApiService.class);
                Utilisateur utilisat = new Utilisateur(idUtilisateur, nomUtilisateur, prenomUtilisateur, mailUtilisateur, villeUtilisateur, codePostalUtilisateur, motDePasse);
                Call<Utilisateur> call2 = service.createUtilisateur(utilisat);
                call2.enqueue(new Callback<Utilisateur>() {
                    @Override
                    public void onResponse(Call<Utilisateur> call2, Response<Utilisateur> response) {
                        Log.d("RETROFIT CREATE", response.message());
                        TextView confirm = (TextView) findViewById(R.id.validationInscri2);
                        confirm.setText("Utilisateur modifié avec succès !");
                    }

                    @Override
                    public void onFailure(Call<Utilisateur> call, Throwable t) {

                    }
                });
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
            Intent intent = new Intent(EditUserActivity.this, ConnectionActivity.class);
            startActivity(intent);

        } else if (id == R.id.action_settings) {


        } else if (id == R.id.calendar) {

        } else if (id == R.id.contact) {
            Intent intent = new Intent(EditUserActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (id == R.id.infoslegales) {
            Intent intent = new Intent(EditUserActivity.this, MentionsLegalesActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

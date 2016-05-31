package com.example.darcel.sors_moi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.darcel.sors_moi.Webservice.*;

import java.util.List;

/**
 * Created by Darcel on 15/05/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CellHolder>{
    private final Context _context;
    private String descEvent = "test";
    public List<Activites> act;

    public MyAdapter(Context c) {
        _context = c;
    }

    public void getListEvents (){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:52871/api/")//"https://api.github.com/"
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiservice service = retrofit.create(Apiservice.class);
        Call<List<Activites>> ActivitesListRequest = service.listActivites();

        ActivitesListRequest.enqueue(new Callback<List<Activites>>() {
            @Override
            public void onResponse(Call<List<Activites>> call, Response<List<Activites>> response) {

                if (response.isSuccessful()) {
                    act = response.body();
                    for (Activites activ : act) {
                        descEvent = activ.getNomActivite();
                    }
                }

                try {

                } catch (Exception e) {

                }


            }

            @Override
            public void onFailure(Call<List<Activites>> call, Throwable t) {
                Log.e("retrofit", t.getLocalizedMessage());
            }
        });
    }

    @Override
    public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        getListEvents();
        View cell = LayoutInflater.from(_context).inflate(R.layout.cell,viewGroup,false);
        return new CellHolder(cell);
    }

    @Override
    public void onBindViewHolder(CellHolder cellHolder, int i) {
        cellHolder.setData(descEvent);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class CellHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView _cellLabel;
        ImageView _image;
        private String _data;

        public CellHolder(View itemView) {
            super(itemView);
            _cellLabel = (TextView) itemView.findViewById(R.id.cell_text);
            _cellLabel.setOnClickListener(this);
            _image = (ImageView)itemView.findViewById(R.id.cell_image);
        }

        public void setData(String t){
            _cellLabel.setText(t);
            _data = t;
        }

        @Override
        public void onClick(View view) {
            Intent detailIntent = new Intent(_context,Details_Activity.class);
            detailIntent.putExtra(Details_Activity.ID_REQUESTED, _data);
            _context.startActivity(detailIntent);
        }
    }
}














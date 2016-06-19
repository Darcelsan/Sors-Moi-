package com.example.darcel.sors_moi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darcel.sors_moi.Webservice.Models.Activite;

import java.util.List;

/**
 * Created by Darcel on 15/05/15.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CellHolder>{
    private final Context _context;
    private String descEvent = "test";
    public List<Activite> act;

    public MyAdapter(Context c) {
        _context = c;
    }


    @Override
    public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View cell = LayoutInflater.from(_context).inflate(R.layout.cell,viewGroup,false);
        return new CellHolder(cell);
    }

    @Override
    public void onBindViewHolder(CellHolder cellHolder, int i) {
        cellHolder.setData(act.get(i).getNomActivite());
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
            int i = this.getAdapterPosition();
            Intent detailIntent = new Intent(_context,Details_Activity.class);
            detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            detailIntent.putExtra(Details_Activity.ID_REQUESTED, _data);
            detailIntent.putExtra("IDActivity",i);
            detailIntent.putExtra("CategorieActivity",act.get(i).getCategorieActivite());
            detailIntent.putExtra("LieuActivity",act.get(i).getLieuActivite());
            detailIntent.putExtra("NomActivity",act.get(i).getNomActivite());
            _context.startActivity(detailIntent);
        }
    }
}














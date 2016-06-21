package com.example.darcel.sors_moi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Darcel on 15/05/15.
 */
public class MyAdapterKitKat extends RecyclerView.Adapter<MyAdapterKitKat.CellHolder>{
    private final Context _context;
    private String descEvent = "test";

    public MyAdapterKitKat(Context c) {
        _context = c;
    }


    @Override
    public CellHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View cell = LayoutInflater.from(_context).inflate(R.layout.cell,viewGroup,false);
        return new CellHolder(cell);
    }

    @Override
    public void onBindViewHolder(CellHolder cellHolder, int i) {
        cellHolder.setData("Kit-Kat délicieux "+i);
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
            Intent detailIntent = new Intent(_context,Details_Activity_KitKat.class);
            detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            _context.startActivity(detailIntent);
        }
    }
}














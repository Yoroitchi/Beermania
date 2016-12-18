package com.example.leguern_boy_33.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by r1leg on 15/11/2016.
 */

class BiersAdapter extends RecyclerView.Adapter<BiersAdapter.BierHolder> {
    private JSONArray biers;

    public BiersAdapter(JSONArray json){
        this.biers = json;
    }

    @Override
    public BierHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View view = inflater.inflate(R.layout.rv_bier_element,null,false);

        BierHolder bierholder = new BierHolder(view);
        return bierholder;
    }

    @Override
    public void onBindViewHolder(BierHolder holder, int position) {
        JSONObject obj = null;
        try {
            obj = biers.getJSONObject(position);
            holder.name.setText(obj.getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return biers.length();
    }

    public void setNewBiere(JSONArray array){
        this.biers = array;
        notifyDataSetChanged();
    }

    public class BierHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public BierHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.rv_bier_element_name);
        }
    }
}

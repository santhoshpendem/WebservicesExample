package com.application.santhosh.storesdisplay.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.application.santhosh.storesdisplay.R;
import com.application.santhosh.storesdisplay.StoreActivity;
import com.application.santhosh.storesdisplay.models.Store;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Santhosh Pendem on 12/1/2017.
 */

public class StoresAdapter extends RecyclerView.Adapter<MyViewHolder>{
	
	
	private List<Store> storeList;
	private Context context;
	private MyItemClickListener myItemClickListener;
	
	public StoresAdapter(ArrayList<Store> storeList, Context context) {
		this.storeList = storeList;
		this.context = context;
	}

	public void setMyItemClickListener(MyItemClickListener myItemClickListener){
	    this.myItemClickListener = myItemClickListener;
    }
	
	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_card,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Store store = storeList.get(position);
        holder.storePhone.setText(store.getPhone());
        holder.storeAddress.setText(store.getAddress());

        Glide.with(context)
                .load(store.getStoreLogoURL())
                .into(holder.storeImage);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, StoreActivity.class);
                i.putExtra("store", store);
                context.startActivity(i);
            }
        });
    }
	
	@Override
	public int getItemCount() {
		return storeList.size();
	}

}

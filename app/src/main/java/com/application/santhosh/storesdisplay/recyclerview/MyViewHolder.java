package com.application.santhosh.storesdisplay.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.application.santhosh.storesdisplay.R;

/**
 * Created by Santhosh Pendem on 12/6/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
	
	TextView storePhone,storeAddress;
	ImageView storeImage;
	LinearLayout linearLayout;
	MyItemClickListener myItemClickListener;
	
	public MyViewHolder(View itemView) {
		super(itemView);
		storePhone = (TextView) itemView.findViewById(R.id.phone);
		storeAddress = (TextView) itemView.findViewById(R.id.address);
		storeImage = (ImageView) itemView.findViewById(R.id.storeImage);
		linearLayout = (LinearLayout) itemView.findViewById(R.id.storeEntry);
	}
	
	@Override
	public void onClick(View v) {
		this.myItemClickListener.onItemClick(v,getPosition());
	}
	
	public void setItemClickListener(MyItemClickListener ic){
		this.myItemClickListener = ic;
	}
	
}

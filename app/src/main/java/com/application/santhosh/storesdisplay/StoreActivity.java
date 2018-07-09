package com.application.santhosh.storesdisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.santhosh.storesdisplay.models.Store;
import com.bumptech.glide.Glide;

public class StoreActivity extends AppCompatActivity {

    private TextView storeName, storeId, phone, address, city, state, zipCode, latitude, logitude;
    ImageView storeImage;
    Store store;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store_info);

        initializeViews();
        getIncomingIntent();
        populateViews();

    }


    private void initializeViews() {
        storeName = (TextView) findViewById(R.id.name);
        storeId = (TextView) findViewById(R.id.storeId);
        phone = (TextView) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        city = (TextView) findViewById(R.id.city);
        state = (TextView) findViewById(R.id.state);
        zipCode = (TextView) findViewById(R.id.zipcode);
        latitude = (TextView) findViewById(R.id.latitude);
        logitude = (TextView) findViewById(R.id.longitude);
        storeImage = (ImageView) findViewById(R.id.storeImage);

    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("store")) {
            store = (Store) getIntent().getSerializableExtra("store");
        }
    }


    private void populateViews() {
        storeName.setText(store.getName());
        storeId.setText(store.getStoreID());
        phone.setText(store.getPhone());
        address.setText(store.getAddress());
        city.setText(store.getCity());
        state.setText(store.getState());
        zipCode.setText(store.getZipcode());
        latitude.setText(store.getLatitude());
        logitude.setText(store.getLongitude());
        Glide.with(this)
                .load(store.getStoreLogoURL())
                .into(storeImage);
    }
}

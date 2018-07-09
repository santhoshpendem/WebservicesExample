package com.application.santhosh.storesdisplay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.application.santhosh.storesdisplay.client.StoreClient;
import com.application.santhosh.storesdisplay.client.StoreInterface;
import com.application.santhosh.storesdisplay.models.RootObject;
import com.application.santhosh.storesdisplay.models.Store;
import com.application.santhosh.storesdisplay.recyclerview.MyItemClickListener;
import com.application.santhosh.storesdisplay.recyclerview.StoresAdapter;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements MyItemClickListener {

    private RecyclerView rv;
    private StoresAdapter storesAdapter;
    ArrayList<Store> storeList = new ArrayList<>();
    private Retrofit retrofit;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager((MainActivity.this));
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());


        if(!isNetworkAvailable())
            Toast.makeText(this, "No Network Availbale", Toast.LENGTH_LONG).show();
        else {
            retrofit = StoreClient.getClient();

            retrofit.create(StoreInterface.class).fetchStores()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResults, this::handleError);
        }

    }

    private void handleResults(RootObject rootObject){
        if(rootObject.getStores() != null){
            storesAdapter = new StoresAdapter(rootObject.getStores(), MainActivity.this);
            rv.setAdapter(storesAdapter);
        }else{
            Log.e("Stores: ","Cant retreive the Data");
        }
    }

    private void handleError(Throwable t){
        Log.e("Observer", ""+ t.toString());
        Toast.makeText(this, "ERROR IN GETTING STORES",
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onItemClick(View v, int position) {
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}

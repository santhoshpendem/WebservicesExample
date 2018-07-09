package com.application.santhosh.storesdisplay.client;

import com.application.santhosh.storesdisplay.models.RootObject;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Santhosh Pendem on 12/6/2017.
 */

public interface StoreInterface {
	@GET("BR_Android_CodingExam_2015_Server/stores.json")
	Observable<RootObject> fetchStores();
}




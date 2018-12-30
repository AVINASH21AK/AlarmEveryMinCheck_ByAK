package com.locationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActDashboard extends AppCompatActivity {

    //Api
    Call callApiMethod;
    //CustomProgressDialog customProgressDialog;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_dashboard);

        //dbHelper = new DatabaseHelper(ActDashboard.this);
        //dbHelper.dropAllTable();

        App.startAlarmServices(ActDashboard.this);
    }



    /*public void apiSync(){
        try{

            if(App.isInternetAvail(ActDashboard.this)){

                String strDeviceIdUniqu = "";
                String strAppVersion = "";
                String strAndroidDevice_Token = "";
                String strSyncTime = "";


                if(strDeviceIdUniqu != null && strDeviceIdUniqu.length() > 0 && strAppVersion != null && strAppVersion.length() > 0) {

                    callApiMethod = App.getRetrofitApiService().syncdata(
                            ApiFunction.OP_SYNCDATA,
                            strDeviceIdUniqu,
                            strAndroidDevice_Token,
                            App.App_platform,
                            App.App_mode,
                            strAppVersion,
                            strSyncTime

                    );




                    callApiMethod.enqueue(new Callback<SyncResponce>() {
                        @Override
                        public void onResponse(Call<SyncResponce> call, Response<SyncResponce> response) {
                            try {

                                SyncResponce responce = response.body();

                                if (responce == null) {

                                    App.showLog(TAG, "==Something wrong in service responce==");
                                    okhttp3.ResponseBody responseBody = response.errorBody();
                                    if (responseBody != null) {
                                        try {
                                            App.showLog(TAG + " error: ", "" + responseBody.string());

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }

                                } else {

                                    App.showLog(TAG, "===Response==" + response.body().toString());
                                    App.showLogResponce("OP_SYNCDATA: ", new Gson().toJson(response.body()));


                                    if (responce != null && responce.status != null) {

                                        if (responce.status.equalsIgnoreCase("1")) {

                                        }

                                    } else {

                                        App.showLog(TAG, "------------- API Fails -------------");

                                    }
                                }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<SyncResponce> call, Throwable t) {
                            App.showLog(TAG, "=======onFailure apiSync=========");
                            t.printStackTrace();
                        }

                    });

                }

            }else {

                App.showSnackBar(viewShowSnackBar, getResources().getString(R.string.errNoInternetConnection));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/


}

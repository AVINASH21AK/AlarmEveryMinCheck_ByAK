package com.locationtracker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class App extends Application {

    static Drawable eventDrawable;

    public static String TAG = "APP";
    public static String currentChatUserQbId = "";
    public static boolean isChatList = false;
    public static Context context;
    private static App mInstance;
    static Typeface tf_Regular, tf_Bold, tf_Light, tf_SemiBold;
    public static String strFolderName = "Wolfkeeper";
    public static String strDicFullPath = Environment.getExternalStorageDirectory() + File.separator + App.strFolderName;
    public static String PREF_NAME = "Wolfkeeper_PREFERENCE";
    public static GPSTracker gpsTracker;
    public static Double latitude=0d, longitude=0d;

    public static String App_mode = "1";  //1 for Production and 2 for Development
    public static String App_plateform = "2";  //1 for IOS and 2 for Android


    static public DatabaseHelper dbHelper;


    /*---- string ---*/
    public static Bitmap profilePhotoBitmap;   //set value and after upload set null value
    public static int strBase_RefreshTotal = 10;
    public static String dateTimeFormateYYYYMMDD = "yyyy-MM-dd";
    public static String dateTimeFormateYYYYMMDDTime = "yyyy-MM-dd HH:mm";
    public static String dateTimeFormateDDMMYYY = "dd/MM/yyyy";
    public static String dateTimeFormateShort = "dd/MM/yyyy HH:mm";
    public static String dateTimeFormateTimeOnly = "HH:mm";
    public static String dateTimeFormateShortDDMM = "dd MMM";
    public static String dateTimeFormateLong = "E MMM dd HH:mm:ss Z yyyy";
    public static ArrayList<String> arrBreed = new ArrayList<String>();





    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        mInstance = this;
        dbHelper = new DatabaseHelper(context);

    }



    public static void showLog(String ActivityName, String strMessage) {
        Log.d("From: ", ActivityName + " : " + strMessage);
    }





    /*------ Check Internet -------*/
    public static boolean isInternetAvail(Context context) {

        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity.getActiveNetworkInfo() != null && connectivity.getActiveNetworkInfo().isAvailable() && connectivity.getActiveNetworkInfo().isConnected()) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }

    /*--------- FOR STATUS BAR TRANSPARENT ----------*/
    public static void setStatusBarTranslucent(boolean makeTranslucent, Activity activity) {
        if (makeTranslucent) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /*------  Get GPS Location  ------*/
    public static void getGPSLocation(){
        try{
            gpsTracker = new GPSTracker(context);
            if(gpsTracker.canGetLocation()){
                latitude = gpsTracker.getLatitude();
                longitude = gpsTracker.getLongitude();

                if(latitude != null && longitude != null & latitude > 0 && longitude > 0)
                {
                    App.showLog(TAG, "-------------------------Got GPS Locatio-------------------------\nlatitude: "+latitude+"\nlongitude: "+longitude);

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void setFullScreen(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public static void setStatusBarColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.setStatusBarColor(ContextCompat.getColor(activity, color));
        }
    }


    public static void showSnackBar(View view, String strMessage) {
        // Toast.makeText(context, ""+strMessage, Toast.LENGTH_SHORT).show();

        try {
            Snackbar snackbar = Snackbar.make(view, strMessage, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(Color.BLACK);
            TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String stripHtmlRegex(String source) {
        // Replace all tag characters with an empty string.
        return source.replaceAll("<.*?>", "");
    }


    public static void hideSoftKeyboardMy(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }


    public static void myStartActivity(Activity activity, Intent intent) {
        activity.startActivity(intent);
    }

    public static void myStartActivityRefersh(Activity activity, Intent intent) {
        activity.finish();
        activity.startActivity(intent);
    }


    public static void myStartActivityClearTop(Activity activity, Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.finish();
        activity.startActivity(intent);
    }


    public static void myFinishActivityRefresh(Activity activity, Intent intent) {
        activity.finish();
        activity.startActivity(intent);
    }


    public static void myFinishActivity(Activity activity) {
        activity.finish();
    }




    public static String getddMMMyy(String convert_date_string) {
        String final_date = "";
        String date1 = "";
        if (convert_date_string != null) {

            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(App.dateTimeFormateYYYYMMDD);
                SimpleDateFormat outputFormat = new SimpleDateFormat(App.dateTimeFormateDDMMYYY);
                String inputDateStr = convert_date_string;
                Date date = null;
                date = inputFormat.parse(inputDateStr);
                //String outputDateStr = outputFormat.format(date);
                date1 = outputFormat.format(date);
                final_date = date1.toLowerCase();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return final_date;
    }


    /*------- For Calander ---------*/
    public static String getCurrentddMMMyyyyTime()
    {  //https://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android

        String currentDate = "";

        try {
            Calendar c = Calendar.getInstance();
            App.showLog(TAG, "current Time: "+c.getTime());

            SimpleDateFormat df = new SimpleDateFormat(App.dateTimeFormateShort);
            currentDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }



        return currentDate;
    }


    /*
    * for alarm manager broadcast receiver
    * */
    public static String getCurrentTime()
    {  //https://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android

        String currentDate = "";

        try {
            Calendar c = Calendar.getInstance();
            App.showLog(TAG, "current Time: "+c.getTime());

            SimpleDateFormat df = new SimpleDateFormat(App.dateTimeFormateTimeOnly);
            currentDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return currentDate;
    }

    /*
    * for alarm manager broadcast receiver
    * */
    public static String getTimeFromDate(String convert_date_string)
    {  //https://stackoverflow.com/questions/11097256/how-to-convert-mon-jun-18-000000-ist-2012-to-18-06-2012

        String final_date = "";
        String date1 = "";
        if (convert_date_string != null) {

            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(App.dateTimeFormateYYYYMMDDTime);
                SimpleDateFormat outputFormat = new SimpleDateFormat(App.dateTimeFormateTimeOnly);
                String inputDateStr = convert_date_string;
                Date date = null;
                date = inputFormat.parse(inputDateStr);
                date1 = outputFormat.format(date);
                final_date = date1.toLowerCase();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return final_date;
    }

    public static String getTimeFromLongDate(String convert_date_string)
    {  //https://stackoverflow.com/questions/11097256/how-to-convert-mon-jun-18-000000-ist-2012-to-18-06-2012

        String final_date = "";
        String date1 = "";
        if (convert_date_string != null) {

            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(App.dateTimeFormateLong);
                SimpleDateFormat outputFormat = new SimpleDateFormat(App.dateTimeFormateTimeOnly);
                String inputDateStr = convert_date_string;
                Date date = null;
                date = inputFormat.parse(inputDateStr);
                date1 = outputFormat.format(date);
                final_date = date1.toLowerCase();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return final_date;
    }


    /*
    * for alarm manager broadcast receiver
    * */
    public static String getCurrentDate()
    {  //https://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android

        String currentDate = "";

        try {
            Calendar c = Calendar.getInstance();
            App.showLog(TAG, "current Time: "+c.getTime());

            SimpleDateFormat df = new SimpleDateFormat(App.dateTimeFormateYYYYMMDDTime);
            currentDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }



        return currentDate;
    }

    public static String getCurrentTimeZone() {
        //return TimeZone.getDefault().getDisplayName();   //TimeZone: India Standard Time
        return TimeZone.getDefault().getID();   //TimeZone: Asia/Kolkata
    }

    public static String getDateTimeLongFormate(String convert_date_string)
    {  //https://stackoverflow.com/questions/11097256/how-to-convert-mon-jun-18-000000-ist-2012-to-18-06-2012

        String final_date = "";
        String date1 = "";
        if (convert_date_string != null) {

            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(App.dateTimeFormateShort);
                SimpleDateFormat outputFormat = new SimpleDateFormat(App.dateTimeFormateLong);
                String inputDateStr = convert_date_string;
                Date date = null;
                date = inputFormat.parse(inputDateStr);
                date1 = outputFormat.format(date);
                final_date = date1.toLowerCase();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return final_date;
    }


    public static String getddMMMyyyy(String convert_date_string)
    {  //https://stackoverflow.com/questions/11097256/how-to-convert-mon-jun-18-000000-ist-2012-to-18-06-2012

        String final_date = "";
        String date1 = "";
        if (convert_date_string != null) {

            try {
                SimpleDateFormat inputFormat = new SimpleDateFormat(App.dateTimeFormateLong);
                SimpleDateFormat outputFormat = new SimpleDateFormat(App.dateTimeFormateShort);
                String inputDateStr = convert_date_string;
                Date date = null;
                date = inputFormat.parse(inputDateStr);
                date1 = outputFormat.format(date);
                final_date = date1.toLowerCase();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return final_date;
    }


    /*
    * Check Alarm Start & End DateTime with Current DateTime
    * */
    public static boolean checkAlarmToStart(String strStartEvent, String strEndEvent){
        boolean isAlarmStart = false;
        try{

            Calendar c = Calendar.getInstance();
            SimpleDateFormat formatCurrentDate = new SimpleDateFormat(App.dateTimeFormateLong);
            String formatedate = formatCurrentDate.format(c.getTime());
            Date dateCurrent = formatCurrentDate.parse(formatedate);

            SimpleDateFormat formatStartDate = new SimpleDateFormat(App.dateTimeFormateYYYYMMDDTime);
            Date dateStartEvent = formatStartDate.parse(strStartEvent);

            SimpleDateFormat formatEndDate = new SimpleDateFormat(App.dateTimeFormateYYYYMMDDTime);
            Date dateEndEvent = formatEndDate.parse(strEndEvent);


            App.showLog(TAG, "enddate: " + dateEndEvent);
            App.showLog(TAG, "startDate: " + dateStartEvent);
            App.showLog(TAG, "currrentdate: " + dateCurrent);
            App.showLog(TAG, "Date Comparisoin after: " + (dateCurrent.after(dateEndEvent)));
            App.showLog(TAG, "Date Comparisoin before: " + (dateCurrent.before(dateStartEvent)));

            /*------ Check Is Alarm between start and end -----*/
            if (dateEndEvent.after(dateCurrent) && dateStartEvent.before(dateCurrent)) {
                isAlarmStart = true;
            }

            /*---- check if event is end than stop -----*/
            /*if(dateCurrent.after(dateEndEvent)){
                isAlarmStart = false;
            }*/

        }catch (Exception e){
            e.printStackTrace();
        }

        return isAlarmStart;
    }



    public static int pxToDp(int px, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int dpToPx(int dp, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static void create_DB_Folder() {
        FileOutputStream out = null;
        try {
            //String directoryPath = Environment.getExternalStorageDirectory() + File.separator + App.strFolderName;
            File appDir = new File(App.strDicFullPath);
            if (!appDir.exists() && !appDir.isDirectory()) {
                if (appDir.mkdirs()) {
                    App.showLog(TAG, "App Directory created");
                } else {
                    App.showLog(TAG, "Unable To Create App Directory!");
                }
            } else {
                App.showLog(TAG, "App Directory Already Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
   * collapse view with animation
   * */
    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }


    /*
    * expand view with animation
    * */
    public static void expand(final View v) {
        v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT); //WRAP_CONTENT
        //v.measure(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? WindowManager.LayoutParams.WRAP_CONTENT //WRAP_CONTENT
                        //? WindowManager.LayoutParams.MATCH_PARENT //WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void saveBitmapSdcard(String filename, Bitmap bitmap) {
        FileOutputStream out = null;
        try {

            String directoryPath = Environment.getExternalStorageDirectory() + File.separator + App.strFolderName;

            File appDir = new File(directoryPath);

            if (!appDir.exists() && !appDir.isDirectory()) {
                // create empty directory
                if (appDir.mkdirs()) {
                    App.showLog("===CreateDir===", "App dir created");
                } else {
                    App.showLog("===CreateDir===", "Unable to create app dir!");
                }
            } else {
                //App.showLog("===CreateDir===","App dir already exists");
            }


            out = new FileOutputStream(directoryPath + File.separator + filename);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out); // bmp is your Bitmap instance
            // PNG is a lossless format, the compression factor (100) is ignored
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }

        return Bitmap.createScaledBitmap(image, width, height, true);
    }


    /*-----start Retrofit-----*/

    public static OkHttpClient getClient() {
        //OkHttpClient client =

        return new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();
        //return client;
    }

    public static Retrofit getRetrofitBuilder() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();


        return new Retrofit.Builder()
                .baseUrl("strBaseUrl")
                .client(getClient()) // it's optional for adding client
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getRetrofitApiService() {
        return getRetrofitBuilder().create(ApiService.class);
    }

    /*-----end Retrofit-----*/



    public static String strPrevTime = "";
    public static AlarmManagerBroadcastReceiver alarm;
    public static void startAlarmServices(Context context)
    {
        if(alarm == null)
        {
            alarm = new AlarmManagerBroadcastReceiver();
        }
        if(alarm != null)
        {
            alarm.CancelAlarm(context);
            alarm.SetAlarm(context);
        }
        else
        {
            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
        }

    }

    public static void stopUpdateLocation(Context context)
    {
        if(alarm == null)
        {
            alarm = new AlarmManagerBroadcastReceiver();
        }
        if(alarm != null)
        {
            alarm.CancelAlarm(context);
        }
        else
        {
            Toast.makeText(context, "Alarm is null", Toast.LENGTH_SHORT).show();
        }
    }




}

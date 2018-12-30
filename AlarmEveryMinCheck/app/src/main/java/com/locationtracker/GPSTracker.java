package com.locationtracker;


import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;

public class GPSTracker extends Service implements LocationListener {
    String TAG = "GPSTracker";
    private final Context mContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;
    Location location;
    double latitude;
    double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10L;
    private static final long MIN_TIME_BW_UPDATES = 60000L;
    protected LocationManager locationManager;

    public GPSTracker(Context context) {
        this.mContext = context;
        this.getLocation();
    }

    public Location getLocation() {
        try {
            this.locationManager = (LocationManager)this.mContext.getSystemService("location");
            this.isGPSEnabled = this.locationManager.isProviderEnabled("gps");
            this.isNetworkEnabled = this.locationManager.isProviderEnabled("network");
            if (this.isGPSEnabled || this.isNetworkEnabled) {
                this.canGetLocation = true;
                if (this.isNetworkEnabled) {
                    this.locationManager.requestLocationUpdates("network", 60000L, 10.0F, this);
                    App.showLog(this.TAG, "Network");
                    if (this.locationManager != null) {
                        this.location = this.locationManager.getLastKnownLocation("network");
                        if (this.location != null) {
                            this.latitude = this.location.getLatitude();
                            this.longitude = this.location.getLongitude();
                        }
                    }
                }

                if (this.isGPSEnabled && this.location == null) {
                    this.locationManager.requestLocationUpdates("gps", 60000L, 10.0F, this);
                    App.showLog(this.TAG, "GPS Enabled");
                    if (this.locationManager != null) {
                        this.location = this.locationManager.getLastKnownLocation("gps");
                        if (this.location != null) {
                            this.latitude = this.location.getLatitude();
                            this.longitude = this.location.getLongitude();
                        }
                    }
                }
            }
        } catch (Exception var2) {
            var2.printStackTrace();
        }

        return this.location;
    }

    public double getLatitude() {
        if (this.location != null) {
            this.latitude = this.location.getLatitude();
        }

        return this.latitude;
    }

    public double getLongitude() {
        if (this.location != null) {
            this.longitude = this.location.getLongitude();
        }

        return this.longitude;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void onLocationChanged(Location location) {
    }

    public void onProviderDisabled(String provider) {
    }

    public void onProviderEnabled(String provider) {
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    public IBinder onBind(Intent arg0) {
        return null;
    }
}

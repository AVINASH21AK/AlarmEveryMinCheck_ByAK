package com.locationtracker;

import com.google.gson.annotations.SerializedName;

public class DoctorResponce extends CommonResponce{

   @SerializedName("data")
   public Data data;


   public class Data{
       @SerializedName("total_doctors")
       public String total_doctors;

       /*@SerializedName("doctors")
       public ArrayList<DoctorModel> arrDoctor;*/
   }

}

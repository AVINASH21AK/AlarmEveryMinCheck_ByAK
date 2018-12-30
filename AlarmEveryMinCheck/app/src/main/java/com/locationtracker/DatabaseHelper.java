package com.locationtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.reliancehospitals.api.model.AboutAppModel;
import com.reliancehospitals.api.model.AboutRelianceModel;
import com.reliancehospitals.api.model.DepartmentListModel;
import com.reliancehospitals.api.model.DoctorModel;
import com.reliancehospitals.api.model.EventsModel;
import com.reliancehospitals.api.model.HealthTipsModel;
import com.reliancehospitals.api.model.MedicineTrackerDaysModel;
import com.reliancehospitals.api.model.MedicineTrackerModel;
import com.reliancehospitals.api.model.MedicineTrackerTimeModel;
import com.reliancehospitals.api.model.NewsModel;
import com.reliancehospitals.api.model.NotificationModel;
import com.reliancehospitals.api.model.OverviewModel;
import com.reliancehospitals.api.model.PhoneDirModel;
import com.reliancehospitals.api.model.ServicesModel;
import com.reliancehospitals.api.model.SubDepartmentModel;
import com.reliancehospitals.api.model.TechnologyModel;
import com.reliancehospitals.api.model.VirtualTourModel;
import com.reliancehospitals.api.model.WaterTrackerChildModel;
import com.reliancehospitals.api.model.WaterTrackerParentModel;

import java.util.ArrayList;

/**
 * Created by avinash.kahar on 5/7/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    String TAG = "DatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    static Context context;
    SQLiteDatabase db;

    public static final String TABLE_DEPARTMENTS = "tbl_departments";
    public static final String TABLE_SUBDEPARTMENTS = "tbl_subdepartments";
    public static final String TABLE_HEALTHTIPS = "tbl_heathtips";
    public static final String TABLE_DOCTOR = "tbl_doctor";
    public static final String TABLE_DOCTOR_HOD = "tbl_doctor_hod";
    public static final String TABLE_DOCTOR_DEPRT = "tbl_doctor_deprt";
    public static final String TABLE_DOCTOR_SUBDEPRTID = "tbl_doctor_subdeprtid";
    public static final String TABLE_OVERVIEW = "tbl_overview";
    public static final String TABLE_SERVICES = "tbl_services";
    public static final String TABLE_TECHNOLOGY = "tbl_technology";
    public static final String TABLE_NEWS = "tbl_news";
    public static final String TABLE_EVENTS = "tbl_events";
    public static final String TABLE_ABOUTRELIANCE = "tbl_aboutreliance";
    public static final String TABLE_ABOUTRELIANCE_SUB = "tbl_aboutreliance_sub";
    public static final String TABLE_PHONEDIRECTORY = "tbl_phonedirectory";
    public static final String TABLE_ABOUTAPP = "tbl_aboutapp";
    public static final String TABLE_MEDICINETRACKER = "tbl_medicinetracker";
    public static final String TABLE_MEDICINETRACKERT_TIME = "tbl_medicinetracker_time";
    public static final String TABLE_MEDICINETRACKERT_DAY = "tbl_medicinetracker_day";
    public static final String TABLE_NOTIFICATION = "tbl_notification";
    public static final String TABLE_NAME_DRINK_LIST = "Drink_List";
    public static final String TABLE_VirtualTour = "tbl_virtualtour";
    public static final String TABLE_VirtualTourDetail = "tbl_virtualtour_detail";



    /*
    * Department Parameter
    * */
    public static class modelDepartmentTbl {
        public static final String ID = "departmentid";
        public static final String IMAGE = "image";
        public static final String ISACTIVE = "isactive";
        public static final String TITLE = "title";
        public static final String DESC = "description";
        public static final String OVERVIEW = "overview";
        public static final String SERVICES = "services";
        public static final String TECHNOLOGY = "technology";
        public static final String SPECIALISTS = "specialists";
        public static final String DATETIME = "datetime";
        public static final String UPDATED = "updated";
    }

   /*
    * SubDepartment Parameter
    * */
    public static class modelSubDepartmentTbl {
        public static final String DEPARTMENTID = "departmentid";
        public static final String SUBID = "subid";
        public static final String SUBTITLE = "subtitle";
        public static final String ISACTIVE = "isactive";
        public static final String DATETIME = "datetime";
        public static final String UPDATED = "updated";

    }

    /*
    * Overview Parameter
    * */
    public static class modelOverviewTbl {
        public static final String ID = "departmentid";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
    }

    /*
    * Services Parameter
    * */
    public static class modelServicesTbl {
        public static final String MAINID = "departmentid";
        public static final String ID = "service_subid";
        public static final String TITLE = "title";
        public static final String DESC = "description";
        public static final String ISACTIVE = "isactive";
    }

    /*
    * Technology Parameter
    * */
    public static class modelTechnologyTbl {
        public static final String ID = "departmentid";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
    }

    /*
    * HealthTips Parameter
    * */
    public static class modelHealthTipsTbl {
        public static final String ID = "healthtipid";
        public static final String IMAGE = "image";
        public static final String ISACTIVE = "isactive";
        public static final String TITLE = "title";
        public static final String DESC = "desciption";  //desc is considered as descending order
        public static final String DATETIME = "datetime";
        public static final String UPDATED = "updated";
    }

    /*
    * News Parameter
    * */
    public static class modelNewsTbl {
        public static final String ID = "newsid";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String DESC = "description"; //desc is considered as descending order
        public static final String DATETIME = "datetime";
        public static final String UPDATED = "updated";
    }

    /*
    * Events Parameter
    * */
    public static class modelEventsTbl {
        public static final String ID = "eventid";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
        public static final String START_DATE = "start_date";  //desc is considered as descending order
        public static final String END_DATE = "end_date";
        public static final String START_TIME = "start_time";
        public static final String END_TIME = "end_time";
    }


    /*
    * Doctor Parameter
    * */
    public static class modelDoctorTbl {
        public static final String EMAIL = "email";
        public static final String STATUS = "status";
        public static final String DOCID = "docid";
        public static final String TITLE = "title";
        public static final String FIRSTNAME = "firstname";
        public static final String LASTNAME = "lastname";
        public static final String PHOTO = "photo";
        public static final String GENDER = "gender";
        public static final String ADDRESS = "address";
        public static final String CITY = "city";
        public static final String STATE = "state";
        public static final String COUNTRY = "country";
        public static final String ZIPCODE = "zipcode";
        public static final String MOBILE1 = "mobile1";
        public static final String MOBILE2 = "mobile2";
        public static final String MOBILE3 = "mobile3";
        public static final String DOB = "dob";
        public static final String DESIGNATION = "designation";
        public static final String QUALIFICATIONS = "qualifications";
        public static final String LANGUAGES = "languages";
        public static final String SERVICE_OFFER = "service_offer";
        public static final String SPECIALTY_INTEREST = "specialty_interest";
        public static final String AREA_INTEREST = "area_interest";
        public static final String FELLOWSHIPS = "fellowships";
        public static final String EXPERIENCE = "experience";
        public static final String ACHIVEMENTS = "achivements";
        public static final String BREAKTHROUGH = "breakthrough";
        public static final String EDUCATION = "education";
        public static final String FAVORITE = "favorite";
        public static final String ISACTIVE = "isactive";
        public static final String AVAILABILITY = "availability";
        public static final String DATETIME = "datetime";
        public static final String UPDATED = "updated";
    }


    /*
    * Doctor Hode Patameter
    * */
    public static class modelDoctorHODTble {
        final public static String DOCID = "docid";
        final public static String DEPRTID = "deprtid";
    }

    /*
    * Doctor Deprt Patameter
    * */
    public static class modelDoctorDeprtTble {
        final public static String DOCID = "docid";
        final public static String DEPRTID = "deprtid";
    }

    /*
    * Doctor SubDeprt Patameter
    * */
    public static class modelDoctorSubDeprtTble {
        final public static String DOCID = "docid";
        final public static String SUBDEPRTID = "subdeprtid";
    }


    /*
   * About Reliance Parameter
   * */
    public static class modelAboutRelianceTbl {
        public static final String ID = "mainid";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String DESC = "description";  //desc is considered as descending order
        public static final String URL = "url";
    }


    /*
   * Sub-About Reliance Parameter
   * */
    public static class modelSubAboutRelianceTbl {
        public static final String MAINID = "mainid";
        public static final String SUBID = "subid";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String DESC = "description";  //desc is considered as descending order
        public static final String URL = "url";
    }


    /*
   * Phone Directory Parameter
   * */
    public static class modelPhoneDirTbl {
        public static final String ID = "id";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
    }

    /*
   * Medicine Tracker
   * */
    public static class modelMedicineTrackerTbl {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String IMAGE = "image";
        public static final String TYPE = "type";
        public static final String DOSSAGE = "dossage";
        public static final String ALARM = "alarm";
    }

    /*
   * Medicine Tracker time
   * */
    public static class modelMedicineTrackerTimeTbl {
        public static final String ID = "id";
        public static final String TIMETITLE_1 = "timetitle_1";
        public static final String TIME12HR_1 = "time12hr_1";
        public static final String TIME24HR_1 = "time24hr_1";

        public static final String TIMETITLE_2 = "timetitle_2";
        public static final String TIME12HR_2 = "time12hr_2";
        public static final String TIME24HR_2 = "time24hr_2";

        public static final String TIMETITLE_3 = "timetitle_3";
        public static final String TIME12HR_3 = "time12hr_3";
        public static final String TIME24HR_3 = "time24hr_3";
    }

    /*
   * Medicine Tracker day
   * */
    public static class modelMedicineTrackerDayTbl {
        public static final String ID = "id";
        public static final String SUNDAY_SELECTED = "sunday_selected";
        public static final String MONDAY_SELECTED = "monday_selected";
        public static final String TUESDAY_SELECTED = "tuesday_selected";
        public static final String WEDNESDAY_SELECTED = "wednesday_selected";
        public static final String THURDAY_SELECTED = "thurday_selected";
        public static final String FRIDAY_SELECTED = "friday_selected";
        public static final String SATURDAY_SELECTED = "saturday_selected";
    }


    /*
   * About App Parameter
   * */
    public static class modelAboutAppTbl {
        public static final String ID = "id";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
    }



    /*
   * About App Parameter
   * */
    public static class modelNotificationTbl {
        public static final String ID = "noti_id";
        public static final String TYPE = "type";
        public static final String TITLE = "title";
        public static final String NOTI_TITLE = "noti_title";
        public static final String IMAGE = "image";
        public static final String DESC = "description";
        public static final String DATETIME = "datetime";
        public static final String DATA_ID = "data_id";
        public static final String USER_ID = "user_id";
        public static final String IS_READ = "is_read";
    }



    /*
     * Virtual Tour Parameter
     * */
    public static class modelVitualTbl {
        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
    }

    /*
     * Virtual Tour Detail Parameter
     * */
    public static class modelVitualTblDetails {
        public static final String MAINID = "mainid";
        public static final String SUBID = "subid";
        public static final String TITLE = "title";
        public static final String IMAGE = "image";
        public static final String URL = "url";
    }



    public DatabaseHelper(Context context) {
        super(context, App.DATABASE_FOLDER_FULLPATH, null, DATABASE_VERSION);
        this.context = context;

        //App.showLog(TAG, "Database Path: " + App.APP_FOLDER_FULLPATH + File.separator + App.DB_NAME);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    @Override
    public synchronized void close() {
        if (db != null)
            db.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DEPARTMENTS + "(" +
                modelDepartmentTbl.ID + " TEXT," +
                modelDepartmentTbl.ISACTIVE + " TEXT," +
                modelDepartmentTbl.TITLE + " TEXT," +
                modelDepartmentTbl.DESC + " TEXT," +
                modelDepartmentTbl.IMAGE + " TEXT," +
                modelDepartmentTbl.OVERVIEW + " TEXT," +
                modelDepartmentTbl.SERVICES + " TEXT," +
                modelDepartmentTbl.SPECIALISTS + " TEXT," +
                modelDepartmentTbl.TECHNOLOGY + " TEXT," +
                modelDepartmentTbl.DATETIME + " TEXT," +
                modelDepartmentTbl.UPDATED + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SUBDEPARTMENTS + "(" +
                modelSubDepartmentTbl.DEPARTMENTID + " TEXT," +
                modelSubDepartmentTbl.SUBID + " TEXT," +
                modelSubDepartmentTbl.SUBTITLE + " TEXT," +
                modelSubDepartmentTbl.ISACTIVE + " TEXT," +
                modelSubDepartmentTbl.DATETIME + " TEXT," +
                modelSubDepartmentTbl.UPDATED + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_OVERVIEW + "(" +
                modelOverviewTbl.ID + " TEXT," +
                modelOverviewTbl.IMAGE + " TEXT," +
                modelOverviewTbl.DESC + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_SERVICES + "(" +
                modelServicesTbl.MAINID + " TEXT," +
                modelServicesTbl.ID + " TEXT," +
                modelServicesTbl.TITLE + " TEXT," +
                modelServicesTbl.DESC + " TEXT," +
                modelServicesTbl.ISACTIVE + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_TECHNOLOGY + "(" +
                modelTechnologyTbl.ID + " TEXT," +
                modelTechnologyTbl.IMAGE + " TEXT," +
                modelTechnologyTbl.DESC + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_HEALTHTIPS + "(" +
                modelHealthTipsTbl.ID + " TEXT," +
                modelHealthTipsTbl.ISACTIVE + " TEXT," +
                modelHealthTipsTbl.TITLE + " TEXT," +
                modelHealthTipsTbl.IMAGE + " TEXT," +
                modelHealthTipsTbl.DESC + " TEXT," +
                modelHealthTipsTbl.DATETIME + " TEXT," +
                modelHealthTipsTbl.UPDATED + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_EVENTS + "(" +
                modelEventsTbl.ID + " TEXT," +
                modelEventsTbl.TITLE + " TEXT," +
                modelEventsTbl.IMAGE + " TEXT," +
                modelEventsTbl.DESC + " TEXT," +
                modelEventsTbl.START_DATE + " TEXT," +
                modelEventsTbl.END_DATE + " TEXT," +
                modelEventsTbl.START_TIME + " TEXT," +
                modelEventsTbl.END_TIME + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NEWS + "(" +
                modelNewsTbl.ID + " TEXT," +
                modelNewsTbl.TITLE + " TEXT," +
                modelNewsTbl.IMAGE + " TEXT," +
                modelNewsTbl.DESC + " TEXT," +
                modelNewsTbl.DATETIME + " TEXT," +
                modelNewsTbl.UPDATED + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DOCTOR + "(" +
                modelDoctorTbl.DOCID + " TEXT," +
                modelDoctorTbl.FAVORITE + " TEXT," +
                modelDoctorTbl.ISACTIVE + " TEXT," +
                modelDoctorTbl.FIRSTNAME + " TEXT," +
                modelDoctorTbl.LASTNAME + " TEXT," +
                modelDoctorTbl.PHOTO + " TEXT," +
                modelDoctorTbl.EMAIL + " TEXT," +
                modelDoctorTbl.TITLE + " TEXT," +
                modelDoctorTbl.GENDER + " TEXT," +
                modelDoctorTbl.ADDRESS + " TEXT," +
                modelDoctorTbl.CITY + " TEXT," +
                modelDoctorTbl.STATE + " TEXT," +
                modelDoctorTbl.COUNTRY + " TEXT," +
                modelDoctorTbl.ZIPCODE + " TEXT," +
                modelDoctorTbl.MOBILE1 + " TEXT," +
                modelDoctorTbl.MOBILE2 + " TEXT," +
                modelDoctorTbl.MOBILE3 + " TEXT," +
                modelDoctorTbl.DOB + " TEXT," +
                modelDoctorTbl.DESIGNATION + " TEXT," +
                modelDoctorTbl.QUALIFICATIONS + " TEXT," +
                modelDoctorTbl.LANGUAGES + " TEXT," +
                modelDoctorTbl.SERVICE_OFFER + " TEXT," +
                modelDoctorTbl.SPECIALTY_INTEREST + " TEXT," +
                modelDoctorTbl.AREA_INTEREST + " TEXT," +
                modelDoctorTbl.FELLOWSHIPS + " TEXT," +
                modelDoctorTbl.EXPERIENCE + " TEXT," +
                modelDoctorTbl.ACHIVEMENTS + " TEXT," +
                modelDoctorTbl.BREAKTHROUGH + " TEXT," +
                modelDoctorTbl.EDUCATION + " TEXT," +
                modelDoctorTbl.STATUS + " TEXT," +
                modelDoctorTbl.AVAILABILITY + " TEXT," +
                modelDoctorTbl.DATETIME + " TEXT," +
                modelDoctorTbl.UPDATED + " TEXT" +

                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ABOUTRELIANCE + "(" +
                modelAboutRelianceTbl.ID + " TEXT," +
                modelAboutRelianceTbl.TITLE + " TEXT," +
                modelAboutRelianceTbl.IMAGE + " TEXT," +
                modelAboutRelianceTbl.DESC + " TEXT," +
                modelAboutRelianceTbl.URL + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ABOUTRELIANCE_SUB + "(" +
                modelSubAboutRelianceTbl.MAINID + " TEXT," +
                modelSubAboutRelianceTbl.SUBID + " TEXT," +
                modelSubAboutRelianceTbl.TITLE + " TEXT," +
                modelSubAboutRelianceTbl.IMAGE + " TEXT," +
                modelSubAboutRelianceTbl.DESC + " TEXT," +
                modelSubAboutRelianceTbl.URL + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DOCTOR_HOD + "(" +
                modelDoctorHODTble.DOCID + " TEXT," +
                modelDoctorHODTble.DEPRTID + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DOCTOR_DEPRT + "(" +
                modelDoctorDeprtTble.DOCID + " TEXT," +
                modelDoctorDeprtTble.DEPRTID + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_DOCTOR_SUBDEPRTID + "(" +
                modelDoctorSubDeprtTble.DOCID + " TEXT," +
                modelDoctorSubDeprtTble.SUBDEPRTID + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_PHONEDIRECTORY + "(" +
                modelPhoneDirTbl.ID + " TEXT," +
                modelPhoneDirTbl.IMAGE + " TEXT," +
                modelPhoneDirTbl.DESC + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_ABOUTAPP + "(" +
                modelPhoneDirTbl.ID + " TEXT," +
                modelPhoneDirTbl.IMAGE + " TEXT," +
                modelPhoneDirTbl.DESC + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MEDICINETRACKER + "(" +
                modelMedicineTrackerTbl.ID + " TEXT," +
                modelMedicineTrackerTbl.NAME + " TEXT," +
                modelMedicineTrackerTbl.IMAGE + " TEXT," +
                modelMedicineTrackerTbl.TYPE + " TEXT," +
                modelMedicineTrackerTbl.DOSSAGE + " TEXT," +
                modelMedicineTrackerTbl.ALARM + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MEDICINETRACKERT_TIME + "(" +
                modelMedicineTrackerTimeTbl.ID + " TEXT," +
                modelMedicineTrackerTimeTbl.TIMETITLE_1 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME12HR_1 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME24HR_1 + " TEXT," +

                modelMedicineTrackerTimeTbl.TIMETITLE_2 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME12HR_2 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME24HR_2 + " TEXT," +

                modelMedicineTrackerTimeTbl.TIMETITLE_3 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME12HR_3 + " TEXT," +
                modelMedicineTrackerTimeTbl.TIME24HR_3 + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MEDICINETRACKERT_DAY + "(" +
                modelMedicineTrackerDayTbl.ID + " TEXT," +
                modelMedicineTrackerDayTbl.SUNDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.MONDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.TUESDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.WEDNESDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.THURDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.FRIDAY_SELECTED + " TEXT," +
                modelMedicineTrackerDayTbl.SATURDAY_SELECTED + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NOTIFICATION + "(" +
                modelNotificationTbl.ID + " TEXT," +
                modelNotificationTbl.TYPE + " TEXT," +
                modelNotificationTbl.TITLE + " TEXT," +
                modelNotificationTbl.NOTI_TITLE + " TEXT," +
                modelNotificationTbl.IMAGE + " TEXT," +
                modelNotificationTbl.DESC + " TEXT," +
                modelNotificationTbl.DATETIME + " TEXT," +
                modelNotificationTbl.DATA_ID + " TEXT," +
                modelNotificationTbl.USER_ID + " TEXT," +
                modelNotificationTbl.IS_READ + " TEXT" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_VirtualTour + "(" +
                modelVitualTbl.ID + " INTEGER," +
                modelVitualTbl.TITLE + " TEXT," +
                modelVitualTbl.IMAGE + " TEXT" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_VirtualTourDetail + "(" +
                modelVitualTblDetails.MAINID + " INTEGER," +
                modelVitualTblDetails.SUBID + " INTEGER," +
                modelVitualTblDetails.TITLE + " TEXT," +
                modelVitualTblDetails.IMAGE + " TEXT," +
                modelVitualTblDetails.URL + " TEXT" +
                ");");


        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DRINK_LIST + "( w_id INTEGER PRIMARY KEY, w_DateTime TEXT, w_date TEXT, w_img TEXT, w_quantityML TEXT);"
        );

        App.showLog(TAG, "---===---DATABASE ALL TABLE CREATED.---===---");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DEPARTMENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_SUBDEPARTMENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_HEALTHTIPS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_HOD + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_DEPRT + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_SUBDEPRTID + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_OVERVIEW + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_SERVICES + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_TECHNOLOGY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NEWS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_EVENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTRELIANCE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTRELIANCE_SUB + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_PHONEDIRECTORY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTAPP + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKERT_TIME + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKERT_DAY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NOTIFICATION + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME_DRINK_LIST + "'");


        App.showLog(TAG, "---===---DATABASE TABLE UPDATED, ONCREATED CALLED.---===---");

        onCreate(db);
    }

    public void dropAllTable() {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DEPARTMENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_SUBDEPARTMENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_HEALTHTIPS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_HOD + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_DEPRT + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_DOCTOR_SUBDEPRTID + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_OVERVIEW + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_SERVICES + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_TECHNOLOGY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NEWS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_EVENTS + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTRELIANCE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTRELIANCE_SUB + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_PHONEDIRECTORY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_ABOUTAPP + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKERT_TIME + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_MEDICINETRACKERT_DAY + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NOTIFICATION + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME_DRINK_LIST + "'");


        App.showLog(TAG, "---===---DATABASE ALL TABLE DROP.---===---");
        onCreate(db);

    }




    /*
    * Department
    * */
    public void dbInsertDepartment(DepartmentListModel model) {
        try {
            String temp = dbCheckDepartment(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertDepartment");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelDepartmentTbl.ID, model.departmentid);
                values.put(modelDepartmentTbl.IMAGE, model.image);
                values.put(modelDepartmentTbl.ISACTIVE, model.isactive);
                values.put(modelDepartmentTbl.TITLE, model.title);
                values.put(modelDepartmentTbl.DESC, model.desc);
                values.put(modelDepartmentTbl.OVERVIEW, model.overview);
                values.put(modelDepartmentTbl.SERVICES, model.services);
                values.put(modelDepartmentTbl.SPECIALISTS, model.specialists);
                values.put(modelDepartmentTbl.TECHNOLOGY, model.technology);
                values.put(modelDepartmentTbl.DATETIME, model.datetime);
                values.put(modelDepartmentTbl.UPDATED, model.updated);

                db.insert(TABLE_DEPARTMENTS, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckDepartment(DepartmentListModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDepartment");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENTS + " where " + modelDepartmentTbl.ID + " = '" + model.departmentid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateDepartment(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateDepartment(DepartmentListModel model) {
        try {
            //App.showLog(TAG, "dbUpdateDepartment");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelDepartmentTbl.ID, model.departmentid);
            values.put(modelDepartmentTbl.IMAGE, model.image);
            values.put(modelDepartmentTbl.TITLE, model.title);
            values.put(modelDepartmentTbl.ISACTIVE, model.isactive);
            values.put(modelDepartmentTbl.DESC, model.desc);
            values.put(modelDepartmentTbl.OVERVIEW, model.overview);
            values.put(modelDepartmentTbl.SERVICES, model.services);
            values.put(modelDepartmentTbl.SPECIALISTS, model.specialists);
            values.put(modelDepartmentTbl.TECHNOLOGY, model.technology);
            values.put(modelDepartmentTbl.DATETIME, model.datetime);
            values.put(modelDepartmentTbl.UPDATED, model.updated);

            db.update(TABLE_DEPARTMENTS, values, modelDepartmentTbl.ID + "='" + model.departmentid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<DepartmentListModel> getAllDepartments() {

        ArrayList<DepartmentListModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENTS  + " WHERE isactive=1"; //+ " ORDER BY " + "id" + " ASC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String deprtID = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ID));
                        String deprtIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.IMAGE));
                        String deprtTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TITLE));
                        String deprtISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ISACTIVE));
                        String deprtDESC = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DESC));
                        String deprtOVERVIEW = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.OVERVIEW));
                        String deprtSERVICES = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SERVICES));
                        String deprtTECHNOLOGY = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TECHNOLOGY));
                        String deprtSPECIALISTS = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SPECIALISTS));
                        String deprtUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.UPDATED));
                        String deprtDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DATETIME));


                        try {
                            DepartmentListModel modelDeprt = new DepartmentListModel();
                            modelDeprt.departmentid = deprtID;
                            modelDeprt.image = deprtIMAGE;
                            modelDeprt.title = deprtTITLE;
                            modelDeprt.isactive = deprtISACTIVE;
                            modelDeprt.desc = deprtDESC;
                            modelDeprt.overview = deprtOVERVIEW;
                            modelDeprt.services = deprtSERVICES;
                            modelDeprt.technology = deprtTECHNOLOGY;
                            modelDeprt.specialists = deprtSPECIALISTS;
                            modelDeprt.updated = deprtUPDATED;
                            modelDeprt.datetime = deprtDATETIME;
                            data.add(modelDeprt);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<DepartmentListModel> dbSearchDeprt(String strDeprtName) {
        ArrayList<DepartmentListModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();

            String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENTS + " WHERE isactive=1 AND " + modelDepartmentTbl.TITLE + " LIKE '" + strDeprtName + "%'";

            /*String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENTS
                    + " aDeprt LEFT JOIN " + TABLE_SERVICES + " bServices ON aDeprt.departmentid=bServices.departmentid "
                    + " LEFT JOIN " + TABLE_OVERVIEW + " cOverview ON aDeprt.departmentid=cOverview.departmentid "
                    + " WHERE aDeprt.isactive=1 "
                    + " AND aDeprt."+ modelDepartmentTbl.TITLE + " LIKE '" + strDeprtName + "%' "
                    + " OR bServices."+ modelServicesTbl.TITLE + " LIKE '%" + strDeprtName + "%' "
                    + " OR cOverview."+ modelOverviewTbl.DESC + " LIKE '%" + strDeprtName + "%'";*/

           /* String selectQuery = "SELECT aDeprt.*, "
                    + " aDeprt.departmentid as  deprt_id, "
                    + " bServices.departmentid as service_id, "
                    + " cOverview.departmentid as overview_id, "
                    + " aDeprt.title as  deprt_title, "
                    + " bServices.title as  service_title, "
                    + " bServices.description as  service_description, "
                    + " cOverview.description as  overview_description"

                    + " FROM " + TABLE_DEPARTMENTS
                    + " as aDeprt LEFT JOIN " + TABLE_SERVICES + " as bServices ON aDeprt.departmentid=bServices.departmentid "
                    + " LEFT JOIN " + TABLE_OVERVIEW + " as cOverview ON aDeprt.departmentid=cOverview.departmentid "
                    + " WHERE aDeprt.isactive=1 "
                    + " AND aDeprt.title LIKE '" + strDeprtName + "%' "
                    + " OR bServices.title LIKE '%" + strDeprtName + "%' "
                    + " OR cOverview.description LIKE '%" + strDeprtName + "%'"
                    + " OR bServices.description LIKE '%" + strDeprtName + "%'"
                    + " GROUP BY aDeprt.departmentid";*/


            App.showLog(TAG, "Search Deprt: "+selectQuery);


            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String deprtID = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ID));
                        String deprtIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.IMAGE));
                        String deprtTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TITLE));
                        String deprtISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ISACTIVE));
                        String deprtDESC = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DESC));
                        String deprtOVERVIEW = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.OVERVIEW));
                        String deprtSERVICES = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SERVICES));
                        String deprtTECHNOLOGY = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TECHNOLOGY));
                        String deprtSPECIALISTS = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SPECIALISTS));
                        String deprtUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.UPDATED));
                        String deprtDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DATETIME));


                        try {
                            DepartmentListModel modelDeprt = new DepartmentListModel();
                            modelDeprt.departmentid = deprtID;
                            modelDeprt.image = deprtIMAGE;
                            modelDeprt.title = deprtTITLE;
                            modelDeprt.isactive = deprtISACTIVE;
                            modelDeprt.desc = deprtDESC;
                            modelDeprt.overview = deprtOVERVIEW;
                            modelDeprt.services = deprtSERVICES;
                            modelDeprt.technology = deprtTECHNOLOGY;
                            modelDeprt.specialists = deprtSPECIALISTS;
                            modelDeprt.updated = deprtUPDATED;
                            modelDeprt.datetime = deprtDATETIME;
                            data.add(modelDeprt);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<DepartmentListModel> getDepartmentsID(String strDeprtID) {

        ArrayList<DepartmentListModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DEPARTMENTS + " WHERE isactive=1 AND " + modelDepartmentTbl.ID + " = '" + strDeprtID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String deprtID = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ID));
                        String deprtIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.IMAGE));
                        String deprtTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TITLE));
                        String deprtISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ISACTIVE));
                        String deprtDESC = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DESC));
                        String deprtOVERVIEW = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.OVERVIEW));
                        String deprtSERVICES = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SERVICES));
                        String deprtTECHNOLOGY = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TECHNOLOGY));
                        String deprtSPECIALISTS = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SPECIALISTS));
                        String deprtDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DATETIME));
                        String deprtUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.UPDATED));


                        try {
                            DepartmentListModel modelDeprt = new DepartmentListModel();
                            modelDeprt.departmentid = deprtID;
                            modelDeprt.image = deprtIMAGE;
                            modelDeprt.title = deprtTITLE;
                            modelDeprt.isactive = deprtISACTIVE;
                            modelDeprt.desc = deprtDESC;
                            modelDeprt.overview = deprtOVERVIEW;
                            modelDeprt.services = deprtSERVICES;
                            modelDeprt.technology = deprtTECHNOLOGY;
                            modelDeprt.specialists = deprtSPECIALISTS;
                            modelDeprt.datetime = deprtDATETIME;
                            modelDeprt.updated= deprtUPDATED;
                            data.add(modelDeprt);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalDept() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelDepartmentTbl.ID + " FROM " + TABLE_DEPARTMENTS + " where isactive=1 AND " + modelDepartmentTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public void dbDeleteNotAvailable_DeprtID(String deprtID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_DEPARTMENTS + " where " + modelDepartmentTbl.ID + " NOT IN (" + deprtID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
    * Sub-Department
    * */
    public void dbInsertSubDepartment(SubDepartmentModel model) {
        try {
            String temp = dbCheckSubDepartment(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertDepartment");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelSubDepartmentTbl.DEPARTMENTID, model.departmentid);
                values.put(modelSubDepartmentTbl.SUBID, model.subid);
                values.put(modelSubDepartmentTbl.SUBTITLE, model.subtitle);
                values.put(modelSubDepartmentTbl.ISACTIVE, model.isactive);
                values.put(modelSubDepartmentTbl.DATETIME, model.datetime);
                values.put(modelSubDepartmentTbl.UPDATED, model.updated);

                db.insert(TABLE_SUBDEPARTMENTS, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckSubDepartment(SubDepartmentModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDepartment");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_SUBDEPARTMENTS + " where " + modelSubDepartmentTbl.SUBID + " = '" + model.subid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateSubDepartment(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateSubDepartment(SubDepartmentModel model) {
        try {
            //App.showLog(TAG, "dbUpdateDepartment");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelSubDepartmentTbl.DEPARTMENTID, model.departmentid);
            values.put(modelSubDepartmentTbl.SUBID, model.subid);
            values.put(modelSubDepartmentTbl.SUBTITLE, model.subtitle);
            values.put(modelSubDepartmentTbl.ISACTIVE, model.isactive);
            values.put(modelSubDepartmentTbl.DATETIME, model.datetime);
            values.put(modelSubDepartmentTbl.UPDATED, model.updated);

            db.update(TABLE_SUBDEPARTMENTS, values, modelSubDepartmentTbl.SUBID + "='" + model.subid+ "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public void dbDeleteNotAvailable_SubDepartment(String subDepartmentID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_SUBDEPARTMENTS + " where " + modelSubDepartmentTbl.SUBID + " NOT IN (" + subDepartmentID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SubDepartmentModel> getSubDepartments(String deprtID) {

        ArrayList<SubDepartmentModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_SUBDEPARTMENTS + " WHERE isactive=1 AND " + modelSubDepartmentTbl.DEPARTMENTID + " = '" + deprtID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String subDEPARTMENTID = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.DEPARTMENTID));
                        String subSUBID = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.SUBID));
                        String subSUBTITLE = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.SUBTITLE));
                        String subISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.ISACTIVE));
                        String subDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.DATETIME));
                        String subUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelSubDepartmentTbl.UPDATED));


                        try {
                            SubDepartmentModel modelSubDeprt = new SubDepartmentModel();
                            modelSubDeprt.departmentid = subDEPARTMENTID;
                            modelSubDeprt.subid = subSUBID;
                            modelSubDeprt.subtitle = subSUBTITLE;
                            modelSubDeprt.isactive = subISACTIVE;
                            modelSubDeprt.datetime = subDATETIME;
                            modelSubDeprt.updated = subUPDATED;

                            data.add(modelSubDeprt);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }



    /*
    * Sub-Department Overview
    * */
    public void dbInsertOverview(OverviewModel model) {
        try {
            String temp = dbCheckOverview(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertOverview");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelOverviewTbl.ID, model.departmentid);
                values.put(modelOverviewTbl.IMAGE, model.image);
                values.put(modelOverviewTbl.DESC, model.desc);

                db.insert(TABLE_OVERVIEW, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckOverview(OverviewModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckOverview");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_OVERVIEW + " where " + modelOverviewTbl.ID + " = '" + model.departmentid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateOverview(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateOverview(OverviewModel model) {
        try {
            //App.showLog(TAG, "dbUpdateOverview");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelOverviewTbl.ID, model.departmentid);
            values.put(modelOverviewTbl.IMAGE, model.image);
            values.put(modelOverviewTbl.DESC, model.desc);

            db.update(TABLE_OVERVIEW, values, modelOverviewTbl.ID + "='" + model.departmentid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public OverviewModel getOverviewModel(String strDepartmentID) {
        OverviewModel data = new OverviewModel();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_OVERVIEW + " where " + modelOverviewTbl.ID + " = '" + strDepartmentID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String overviewID = cursor.getString(cursor
                                .getColumnIndex(modelOverviewTbl.ID));
                        String overviewIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelOverviewTbl.IMAGE));
                        String overviewDESC = cursor.getString(cursor
                                .getColumnIndex(modelOverviewTbl.DESC));


                        try {

                            data.departmentid = overviewID;
                            data.image = overviewIMAGE;
                            data.desc = overviewDESC;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<String> getSearchOverviewModelID(String strSearch) {
        ArrayList<String> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_OVERVIEW + " where " + modelOverviewTbl.DESC + " LIKE '%" + strSearch + "%'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String overviewID = cursor.getString(cursor
                                .getColumnIndex(modelOverviewTbl.ID));

                        try {

                            data.add(overviewID);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }




    /*
    * Sub-Department Services
    * */
    public void dbInsertServices(String strMainDeprtID, ServicesModel model) {
        try {
            String temp = dbCheckServices(strMainDeprtID, model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertServices");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(modelServicesTbl.MAINID, strMainDeprtID);
                values.put(modelServicesTbl.ID, model.service_subid);
                values.put(modelServicesTbl.TITLE, model.title);
                values.put(modelServicesTbl.DESC, model.desc);
                values.put(modelServicesTbl.ISACTIVE, model.isactive);

                db.insert(TABLE_SERVICES, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckServices(String strMainDeprtID, ServicesModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckServices");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_SERVICES + " where " + modelServicesTbl.MAINID + " = '" + strMainDeprtID + "'"
                    + " AND " + modelServicesTbl.ID + " = '" + model.service_subid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateServices(strMainDeprtID, model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateServices(String strMainDeprtID, ServicesModel model) {
        try {
            //App.showLog(TAG, "dbUpdateServices");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelServicesTbl.MAINID, strMainDeprtID);
            values.put(modelServicesTbl.ID, model.service_subid);
            values.put(modelServicesTbl.TITLE, model.title);
            values.put(modelServicesTbl.DESC, model.desc);
            values.put(modelServicesTbl.ISACTIVE, model.isactive);

            db.update(TABLE_SERVICES, values, modelServicesTbl.MAINID + "='" + strMainDeprtID + "'"
                    + " AND " + modelServicesTbl.ID + " = '" + model.service_subid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<ServicesModel> getServices(String strDepartmentID) {
        ArrayList<ServicesModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_SERVICES + " where " + modelServicesTbl.MAINID + " = '" + strDepartmentID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {


                        String servicesID = cursor.getString(cursor
                                .getColumnIndex(modelServicesTbl.ID));
                        String servicesTITLE = cursor.getString(cursor
                                .getColumnIndex(modelServicesTbl.TITLE));
                        String servicesDESC = cursor.getString(cursor
                                .getColumnIndex(modelServicesTbl.DESC));
                        String servicesISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelServicesTbl.ISACTIVE));


                        try {
                            ServicesModel modelServices = new ServicesModel();
                            modelServices.service_subid = servicesID;
                            modelServices.title = servicesTITLE;
                            modelServices.desc = servicesDESC;
                            modelServices.isactive = servicesISACTIVE;

                            data.add(modelServices);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<String> getSearchServicesID(String strSearch) {
        ArrayList<String> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_SERVICES + " where "
                    + modelServicesTbl.TITLE + " LIKE '%" + strSearch + "%'"
                    + " OR " + modelServicesTbl.DESC + " LIKE '%" + strSearch + "%'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {


                        String servicesMAINID = cursor.getString(cursor
                                .getColumnIndex(modelServicesTbl.MAINID));


                        try {

                            data.add(servicesMAINID);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }



    /*
    * Sub-Department Technology
    * */
    public void dbInsertTechnology(TechnologyModel model) {
        try {
            String temp = dbCheckTechnology(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertTechnology");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(modelTechnologyTbl.ID, model.departmentid);
                values.put(modelTechnologyTbl.IMAGE, model.image);
                values.put(modelTechnologyTbl.DESC, model.desc);

                db.insert(TABLE_TECHNOLOGY, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckTechnology(TechnologyModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckTechnology");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_TECHNOLOGY + " where " + modelTechnologyTbl.ID + " = '" + model.departmentid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateTechnology(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateTechnology(TechnologyModel model) {
        try {
            //App.showLog(TAG, "dbUpdateTechnology");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelTechnologyTbl.ID, model.departmentid);
            values.put(modelTechnologyTbl.IMAGE, model.image);
            values.put(modelTechnologyTbl.DESC, model.desc);

            db.update(TABLE_TECHNOLOGY, values, modelTechnologyTbl.ID + "='" + model.departmentid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public TechnologyModel getTechnologyModel(String strDepartmentID) {
        TechnologyModel data = new TechnologyModel();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_TECHNOLOGY + " where " + modelTechnologyTbl.ID + " = '" + strDepartmentID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String technologyID = cursor.getString(cursor
                                .getColumnIndex(modelTechnologyTbl.ID));
                        String technologyIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelTechnologyTbl.IMAGE));
                        String technologyDESC = cursor.getString(cursor
                                .getColumnIndex(modelTechnologyTbl.DESC));


                        try {

                            data.departmentid = technologyID;
                            data.image = technologyIMAGE;
                            data.desc = technologyDESC;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }



    /*
    * Doctor OR Sub-Department Specialist
    * */
    public void dbInsertDoctor(DoctorModel model) {
        try {
            String temp = dbCheckDoctor(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertDoctor");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put(modelDoctorTbl.DOCID, model.docid);
                values.put(modelDoctorTbl.FAVORITE, "0");  //model.docIsFav
                values.put(modelDoctorTbl.ISACTIVE, model.isactive);
                values.put(modelDoctorTbl.STATUS, model.status);
                values.put(modelDoctorTbl.EMAIL, model.email);
                values.put(modelDoctorTbl.TITLE, model.title);
                values.put(modelDoctorTbl.FIRSTNAME, model.firstname);
                values.put(modelDoctorTbl.LASTNAME, model.lastname);
                values.put(modelDoctorTbl.PHOTO, model.photo);
                values.put(modelDoctorTbl.GENDER, model.gender);
                values.put(modelDoctorTbl.ADDRESS, model.address);
                values.put(modelDoctorTbl.CITY, model.city);
                values.put(modelDoctorTbl.STATE, model.state);
                values.put(modelDoctorTbl.COUNTRY, model.country);
                values.put(modelDoctorTbl.ZIPCODE, model.zipcode);
                values.put(modelDoctorTbl.MOBILE1, model.mobile1);
                values.put(modelDoctorTbl.MOBILE2, model.mobile2);
                values.put(modelDoctorTbl.MOBILE3, model.mobile3);
                values.put(modelDoctorTbl.DOB, model.dob);
                values.put(modelDoctorTbl.DESIGNATION, model.designation);
                values.put(modelDoctorTbl.QUALIFICATIONS, model.qualifications);
                values.put(modelDoctorTbl.LANGUAGES, model.languages);
                values.put(modelDoctorTbl.SERVICE_OFFER, model.service_offer);
                values.put(modelDoctorTbl.SPECIALTY_INTEREST, model.specialty_interest);
                values.put(modelDoctorTbl.AREA_INTEREST, model.area_interest);
                values.put(modelDoctorTbl.FELLOWSHIPS, model.fellowships);
                values.put(modelDoctorTbl.EXPERIENCE, model.experience);
                values.put(modelDoctorTbl.ACHIVEMENTS, model.achivements);
                values.put(modelDoctorTbl.BREAKTHROUGH, model.breakthrough);
                values.put(modelDoctorTbl.EDUCATION, model.education);
                values.put(modelDoctorTbl.DATETIME, model.datetime);
                values.put(modelDoctorTbl.UPDATED, model.updated);

                String strAvailbility="";
                for(int i=0; i<model.availability.length; i++){

                    strAvailbility += model.availability[i];

                    if((i+1) != (model.availability.length)){
                        strAvailbility += ",";
                    }
                }
                values.put(modelDoctorTbl.AVAILABILITY, strAvailbility);


                db.insert(TABLE_DOCTOR, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckDoctor(DoctorModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDoctor");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR + " where " + modelDoctorTbl.DOCID + " = '" + model.docid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateDoctor(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateDoctor(DoctorModel model) {
        try {
            //App.showLog(TAG, "dbUpdateDoctor");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelDoctorTbl.DOCID, model.docid);
            //values.put(modelDoctorTbl.FAVORITE, model.docIsFav);
            values.put(modelDoctorTbl.ISACTIVE, model.isactive);
            values.put(modelDoctorTbl.STATUS, model.status);
            values.put(modelDoctorTbl.EMAIL, model.email);
            values.put(modelDoctorTbl.TITLE, model.title);
            values.put(modelDoctorTbl.FIRSTNAME, model.firstname);
            values.put(modelDoctorTbl.LASTNAME, model.lastname);
            values.put(modelDoctorTbl.PHOTO, model.photo);
            values.put(modelDoctorTbl.GENDER, model.gender);
            values.put(modelDoctorTbl.ADDRESS, model.address);
            values.put(modelDoctorTbl.CITY, model.city);
            values.put(modelDoctorTbl.STATE, model.state);
            values.put(modelDoctorTbl.COUNTRY, model.country);
            values.put(modelDoctorTbl.ZIPCODE, model.zipcode);
            values.put(modelDoctorTbl.MOBILE1, model.mobile1);
            values.put(modelDoctorTbl.MOBILE2, model.mobile2);
            values.put(modelDoctorTbl.MOBILE3, model.mobile3);
            values.put(modelDoctorTbl.DOB, model.dob);
            values.put(modelDoctorTbl.DESIGNATION, model.designation);
            values.put(modelDoctorTbl.QUALIFICATIONS, model.qualifications);
            values.put(modelDoctorTbl.LANGUAGES, model.languages);
            values.put(modelDoctorTbl.SERVICE_OFFER, model.service_offer);
            values.put(modelDoctorTbl.SPECIALTY_INTEREST, model.specialty_interest);
            values.put(modelDoctorTbl.AREA_INTEREST, model.area_interest);
            values.put(modelDoctorTbl.FELLOWSHIPS, model.fellowships);
            values.put(modelDoctorTbl.EXPERIENCE, model.experience);
            values.put(modelDoctorTbl.ACHIVEMENTS, model.achivements);
            values.put(modelDoctorTbl.BREAKTHROUGH, model.breakthrough);
            values.put(modelDoctorTbl.EDUCATION, model.education);
            values.put(modelDoctorTbl.UPDATED, model.updated);
            values.put(modelDoctorTbl.DATETIME, model.datetime);

            String strAvailbility="";
            for(int i=0; i<model.availability.length; i++){

                strAvailbility += model.availability[i];

                if((i+1) != (model.availability.length)){
                    strAvailbility += ",";
                }
            }
            values.put(modelDoctorTbl.AVAILABILITY, strAvailbility);

            db.update(TABLE_DOCTOR, values, modelDoctorTbl.DOCID + "='" + model.docid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public void dbUpdateDoctorFav(String docID, String isFav) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelDoctorTbl.FAVORITE, isFav);

            db.update(TABLE_DOCTOR, values, modelDoctorTbl.DOCID + "='" + docID + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public DoctorModel getDoctorByID(String strDocID) {
        DoctorModel modelDoctor = new DoctorModel();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR + " where " + modelDoctorTbl.DOCID + " = '" + strDocID + "'" + " AND isactive=1";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {


                        String doctorEMAIL = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EMAIL));
                        String doctorSTATUS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATUS));
                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOCID));
                        String doctorFAVORITE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FAVORITE));
                        String doctorISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ISACTIVE));
                        String doctorTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.TITLE));
                        String doctorFIRSTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FIRSTNAME));
                        String doctorLASTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LASTNAME));
                        String doctorPHOTO = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.PHOTO));
                        String doctorGENDER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.GENDER));
                        String doctorADDRESS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ADDRESS));
                        String doctorCITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.CITY));
                        String doctorSTATE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATE));
                        String doctorCOUNTRY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.COUNTRY));
                        String doctorZIPCODE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ZIPCODE));
                        String doctorMOBILE1 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE1));
                        String doctorMOBILE2 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE2));
                        String doctorMOBILE3 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE3));
                        String doctorDOB = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOB));
                        String doctorDESIGNATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DESIGNATION));
                        String doctorQUALIFICATIONS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.QUALIFICATIONS));
                        String doctorLANGUAGES = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LANGUAGES));
                        String doctorSERVICE_OFFER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SERVICE_OFFER));
                        String doctorSPECIALTY_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SPECIALTY_INTEREST));
                        String doctorAREA_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AREA_INTEREST));
                        String doctorFELLOWSHIPS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FELLOWSHIPS));
                        String doctorEXPERIENCE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EXPERIENCE));
                        String doctorACHIVEMENTS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ACHIVEMENTS));
                        String doctorBREAKTHROUGH = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.BREAKTHROUGH));
                        String doctorEDUCATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EDUCATION));
                        String doctorAVAILABILITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AVAILABILITY));
                        String doctorUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.UPDATED));
                        String doctorDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DATETIME));


                        String[] arrAVAILABILITY = doctorAVAILABILITY.split(",");


                        try {

                            modelDoctor.email = doctorEMAIL;
                            modelDoctor.status = doctorSTATUS;
                            modelDoctor.docid = doctorDOCID;
                            modelDoctor.docIsFav = doctorFAVORITE;
                            modelDoctor.isactive = doctorISACTIVE;
                            modelDoctor.title = doctorTITLE;
                            modelDoctor.firstname = doctorFIRSTNAME;
                            modelDoctor.lastname = doctorLASTNAME;
                            modelDoctor.photo = doctorPHOTO;
                            modelDoctor.gender = doctorGENDER;
                            modelDoctor.address = doctorADDRESS;
                            modelDoctor.city = doctorCITY;
                            modelDoctor.state = doctorSTATE;
                            modelDoctor.country = doctorCOUNTRY;
                            modelDoctor.zipcode = doctorZIPCODE;
                            modelDoctor.mobile1 = doctorMOBILE1;
                            modelDoctor.mobile2 = doctorMOBILE2;
                            modelDoctor.mobile3 = doctorMOBILE3;
                            modelDoctor.dob = doctorDOB;
                            modelDoctor.designation = doctorDESIGNATION;
                            modelDoctor.qualifications = doctorQUALIFICATIONS;
                            modelDoctor.languages = doctorLANGUAGES;
                            modelDoctor.service_offer = doctorSERVICE_OFFER;
                            modelDoctor.specialty_interest = doctorSPECIALTY_INTEREST;
                            modelDoctor.area_interest = doctorAREA_INTEREST;
                            modelDoctor.fellowships = doctorFELLOWSHIPS;
                            modelDoctor.experience = doctorEXPERIENCE;
                            modelDoctor.achivements = doctorACHIVEMENTS;
                            modelDoctor.breakthrough = doctorBREAKTHROUGH;
                            modelDoctor.education = doctorEDUCATION;
                            modelDoctor.availability = arrAVAILABILITY;
                            modelDoctor.updated = doctorUPDATED;
                            modelDoctor.datetime = doctorDATETIME;


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return modelDoctor;
    }

    public ArrayList<DoctorModel> getAllDoctor() {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR  + " WHERE isactive=1";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {


                        String doctorEMAIL = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EMAIL));
                        String doctorSTATUS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATUS));
                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOCID));
                        String doctorFAVORITE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FAVORITE));
                        String doctorISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ISACTIVE));
                        String doctorTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.TITLE));
                        String doctorFIRSTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FIRSTNAME));
                        String doctorLASTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LASTNAME));
                        String doctorPHOTO = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.PHOTO));
                        String doctorGENDER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.GENDER));
                        String doctorADDRESS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ADDRESS));
                        String doctorCITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.CITY));
                        String doctorSTATE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATE));
                        String doctorCOUNTRY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.COUNTRY));
                        String doctorZIPCODE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ZIPCODE));
                        String doctorMOBILE1 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE1));
                        String doctorMOBILE2 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE2));
                        String doctorMOBILE3 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE3));
                        String doctorDOB = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOB));
                        String doctorDESIGNATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DESIGNATION));
                        String doctorQUALIFICATIONS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.QUALIFICATIONS));
                        String doctorLANGUAGES = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LANGUAGES));
                        String doctorSERVICE_OFFER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SERVICE_OFFER));
                        String doctorSPECIALTY_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SPECIALTY_INTEREST));
                        String doctorAREA_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AREA_INTEREST));
                        String doctorFELLOWSHIPS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FELLOWSHIPS));
                        String doctorEXPERIENCE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EXPERIENCE));
                        String doctorACHIVEMENTS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ACHIVEMENTS));
                        String doctorBREAKTHROUGH = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.BREAKTHROUGH));
                        String doctorEDUCATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EDUCATION));
                        String doctorAVAILABILITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AVAILABILITY));
                        String doctorUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.UPDATED));
                        String doctorDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DATETIME));

                        String[] arrAVAILABILITY = doctorAVAILABILITY.split(",");

                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.email = doctorEMAIL;
                            modelDoctor.status = doctorSTATUS;
                            modelDoctor.docid = doctorDOCID;
                            modelDoctor.docIsFav = doctorFAVORITE;
                            modelDoctor.isactive = doctorISACTIVE;
                            modelDoctor.title = doctorTITLE;
                            modelDoctor.firstname = doctorFIRSTNAME;
                            modelDoctor.lastname = doctorLASTNAME;
                            modelDoctor.photo = doctorPHOTO;
                            modelDoctor.gender = doctorGENDER;
                            modelDoctor.address = doctorADDRESS;
                            modelDoctor.city = doctorCITY;
                            modelDoctor.state = doctorSTATE;
                            modelDoctor.country = doctorCOUNTRY;
                            modelDoctor.zipcode = doctorZIPCODE;
                            modelDoctor.mobile1 = doctorMOBILE1;
                            modelDoctor.mobile2 = doctorMOBILE2;
                            modelDoctor.mobile3 = doctorMOBILE3;
                            modelDoctor.dob = doctorDOB;
                            modelDoctor.designation = doctorDESIGNATION;
                            modelDoctor.qualifications = doctorQUALIFICATIONS;
                            modelDoctor.languages = doctorLANGUAGES;
                            modelDoctor.service_offer = doctorSERVICE_OFFER;
                            modelDoctor.specialty_interest = doctorSPECIALTY_INTEREST;
                            modelDoctor.area_interest = doctorAREA_INTEREST;
                            modelDoctor.fellowships = doctorFELLOWSHIPS;
                            modelDoctor.experience = doctorEXPERIENCE;
                            modelDoctor.achivements = doctorACHIVEMENTS;
                            modelDoctor.breakthrough = doctorBREAKTHROUGH;
                            modelDoctor.education = doctorEDUCATION;
                            modelDoctor.availability = arrAVAILABILITY;
                            modelDoctor.updated = doctorUPDATED;
                            modelDoctor.datetime = doctorDATETIME;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }



    public int getTotalDoctor() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelDoctorTbl.DOCID + " FROM " + TABLE_DOCTOR + " where  isactive=1 AND " + modelDoctorTbl.DOCID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public ArrayList<DoctorModel> dbGetDocInDeprt(String strDeprtID) {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_DEPRT + " where deprtid = '" + strDeprtID + "'"; //+ " AND isactive=1"
            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorHODTble.DOCID));


                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.docid = doctorDOCID;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }


    public ArrayList<DoctorModel> dbSearchDoc(String strSearch) {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR + " WHERE isactive=1 AND "
                    + modelDoctorTbl.FIRSTNAME + " LIKE '" + strSearch + "%' OR "
                    + modelDoctorTbl.LASTNAME + " LIKE '" + strSearch + "%' OR "

                    + modelDoctorTbl.QUALIFICATIONS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.SERVICE_OFFER + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.SPECIALTY_INTEREST + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.AREA_INTEREST + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.FELLOWSHIPS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.ACHIVEMENTS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.BREAKTHROUGH + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.DESIGNATION + " LIKE '%" + strSearch + "%'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String doctorEMAIL = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EMAIL));
                        String doctorSTATUS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATUS));
                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOCID));
                        String doctorTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.TITLE));
                        String doctorFAVORITE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FAVORITE));
                        String doctorISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ISACTIVE));
                        String doctorFIRSTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FIRSTNAME));
                        String doctorLASTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LASTNAME));
                        String doctorPHOTO = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.PHOTO));
                        String doctorGENDER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.GENDER));
                        String doctorADDRESS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ADDRESS));
                        String doctorCITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.CITY));
                        String doctorSTATE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATE));
                        String doctorCOUNTRY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.COUNTRY));
                        String doctorZIPCODE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ZIPCODE));
                        String doctorMOBILE1 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE1));
                        String doctorMOBILE2 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE2));
                        String doctorMOBILE3 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE3));
                        String doctorDOB = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOB));
                        String doctorDESIGNATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DESIGNATION));
                        String doctorQUALIFICATIONS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.QUALIFICATIONS));
                        String doctorLANGUAGES = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LANGUAGES));
                        String doctorSERVICE_OFFER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SERVICE_OFFER));
                        String doctorSPECIALTY_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SPECIALTY_INTEREST));
                        String doctorAREA_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AREA_INTEREST));
                        String doctorFELLOWSHIPS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FELLOWSHIPS));
                        String doctorEXPERIENCE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EXPERIENCE));
                        String doctorACHIVEMENTS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ACHIVEMENTS));
                        String doctorBREAKTHROUGH = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.BREAKTHROUGH));
                        String doctorEDUCATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EDUCATION));
                        String doctorAVAILABILITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AVAILABILITY));
                        String doctorUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.UPDATED));
                        String doctorDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DATETIME));


                        String[] arrAVAILABILITY = doctorAVAILABILITY.split(",");


                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.email = doctorEMAIL;
                            modelDoctor.status = doctorSTATUS;
                            modelDoctor.docid = doctorDOCID;
                            modelDoctor.docIsFav = doctorFAVORITE;
                            modelDoctor.isactive = doctorISACTIVE;
                            modelDoctor.title = doctorTITLE;
                            modelDoctor.firstname = doctorFIRSTNAME;
                            modelDoctor.lastname = doctorLASTNAME;
                            modelDoctor.photo = doctorPHOTO;
                            modelDoctor.gender = doctorGENDER;
                            modelDoctor.address = doctorADDRESS;
                            modelDoctor.city = doctorCITY;
                            modelDoctor.state = doctorSTATE;
                            modelDoctor.country = doctorCOUNTRY;
                            modelDoctor.zipcode = doctorZIPCODE;
                            modelDoctor.mobile1 = doctorMOBILE1;
                            modelDoctor.mobile2 = doctorMOBILE2;
                            modelDoctor.mobile3 = doctorMOBILE3;
                            modelDoctor.dob = doctorDOB;
                            modelDoctor.designation = doctorDESIGNATION;
                            modelDoctor.qualifications = doctorQUALIFICATIONS;
                            modelDoctor.languages = doctorLANGUAGES;
                            modelDoctor.service_offer = doctorSERVICE_OFFER;
                            modelDoctor.specialty_interest = doctorSPECIALTY_INTEREST;
                            modelDoctor.area_interest = doctorAREA_INTEREST;
                            modelDoctor.fellowships = doctorFELLOWSHIPS;
                            modelDoctor.experience = doctorEXPERIENCE;
                            modelDoctor.achivements = doctorACHIVEMENTS;
                            modelDoctor.breakthrough = doctorBREAKTHROUGH;
                            modelDoctor.education = doctorEDUCATION;
                            modelDoctor.availability = arrAVAILABILITY;
                            modelDoctor.updated = doctorUPDATED;
                            modelDoctor.datetime = doctorDATETIME;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<DoctorModel> dbSearchDoc_AvailableInID(String strSearch, String strDocID) {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR + " WHERE isactive=1 "
                    + " AND " + modelDoctorTbl.DOCID + " IN (" + strDocID + ") AND ("
                    + modelDoctorTbl.FIRSTNAME + " LIKE '" + strSearch + "%' OR "
                    + modelDoctorTbl.LASTNAME + " LIKE '" + strSearch + "%' OR "

                    + modelDoctorTbl.QUALIFICATIONS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.SERVICE_OFFER + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.SPECIALTY_INTEREST + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.AREA_INTEREST + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.FELLOWSHIPS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.ACHIVEMENTS + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.BREAKTHROUGH + " LIKE '%" + strSearch + "%' OR "
                    + modelDoctorTbl.DESIGNATION + " LIKE '%" + strSearch + "%')";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String doctorEMAIL = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EMAIL));
                        String doctorSTATUS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATUS));
                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOCID));
                        String doctorTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.TITLE));
                        String doctorFAVORITE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FAVORITE));
                        String doctorISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ISACTIVE));
                        String doctorFIRSTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FIRSTNAME));
                        String doctorLASTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LASTNAME));
                        String doctorPHOTO = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.PHOTO));
                        String doctorGENDER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.GENDER));
                        String doctorADDRESS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ADDRESS));
                        String doctorCITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.CITY));
                        String doctorSTATE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATE));
                        String doctorCOUNTRY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.COUNTRY));
                        String doctorZIPCODE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ZIPCODE));
                        String doctorMOBILE1 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE1));
                        String doctorMOBILE2 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE2));
                        String doctorMOBILE3 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE3));
                        String doctorDOB = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOB));
                        String doctorDESIGNATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DESIGNATION));
                        String doctorQUALIFICATIONS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.QUALIFICATIONS));
                        String doctorLANGUAGES = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LANGUAGES));
                        String doctorSERVICE_OFFER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SERVICE_OFFER));
                        String doctorSPECIALTY_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SPECIALTY_INTEREST));
                        String doctorAREA_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AREA_INTEREST));
                        String doctorFELLOWSHIPS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FELLOWSHIPS));
                        String doctorEXPERIENCE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EXPERIENCE));
                        String doctorACHIVEMENTS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ACHIVEMENTS));
                        String doctorBREAKTHROUGH = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.BREAKTHROUGH));
                        String doctorEDUCATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EDUCATION));
                        String doctorAVAILABILITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AVAILABILITY));
                        String doctorUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.UPDATED));
                        String doctorDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DATETIME));


                        String[] arrAVAILABILITY = doctorAVAILABILITY.split(",");


                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.email = doctorEMAIL;
                            modelDoctor.status = doctorSTATUS;
                            modelDoctor.docid = doctorDOCID;
                            modelDoctor.docIsFav = doctorFAVORITE;
                            modelDoctor.isactive = doctorISACTIVE;
                            modelDoctor.title = doctorTITLE;
                            modelDoctor.firstname = doctorFIRSTNAME;
                            modelDoctor.lastname = doctorLASTNAME;
                            modelDoctor.photo = doctorPHOTO;
                            modelDoctor.gender = doctorGENDER;
                            modelDoctor.address = doctorADDRESS;
                            modelDoctor.city = doctorCITY;
                            modelDoctor.state = doctorSTATE;
                            modelDoctor.country = doctorCOUNTRY;
                            modelDoctor.zipcode = doctorZIPCODE;
                            modelDoctor.mobile1 = doctorMOBILE1;
                            modelDoctor.mobile2 = doctorMOBILE2;
                            modelDoctor.mobile3 = doctorMOBILE3;
                            modelDoctor.dob = doctorDOB;
                            modelDoctor.designation = doctorDESIGNATION;
                            modelDoctor.qualifications = doctorQUALIFICATIONS;
                            modelDoctor.languages = doctorLANGUAGES;
                            modelDoctor.service_offer = doctorSERVICE_OFFER;
                            modelDoctor.specialty_interest = doctorSPECIALTY_INTEREST;
                            modelDoctor.area_interest = doctorAREA_INTEREST;
                            modelDoctor.fellowships = doctorFELLOWSHIPS;
                            modelDoctor.experience = doctorEXPERIENCE;
                            modelDoctor.achivements = doctorACHIVEMENTS;
                            modelDoctor.breakthrough = doctorBREAKTHROUGH;
                            modelDoctor.education = doctorEDUCATION;
                            modelDoctor.availability = arrAVAILABILITY;
                            modelDoctor.updated = doctorUPDATED;
                            modelDoctor.datetime = doctorDATETIME;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public ArrayList<DoctorModel> getFavoriteDoctor() {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR + " where isactive=1 AND " + modelDoctorTbl.FAVORITE + " = '1' ORDER BY " + modelDoctorTbl.FIRSTNAME + " ASC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {


                        String doctorEMAIL = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EMAIL));
                        String doctorSTATUS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATUS));
                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOCID));
                        String doctorFAVORITE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FAVORITE));
                        String doctorISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ISACTIVE));
                        String doctorTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.TITLE));
                        String doctorFIRSTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FIRSTNAME));
                        String doctorLASTNAME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LASTNAME));
                        String doctorPHOTO = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.PHOTO));
                        String doctorGENDER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.GENDER));
                        String doctorADDRESS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ADDRESS));
                        String doctorCITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.CITY));
                        String doctorSTATE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.STATE));
                        String doctorCOUNTRY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.COUNTRY));
                        String doctorZIPCODE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ZIPCODE));
                        String doctorMOBILE1 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE1));
                        String doctorMOBILE2 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE2));
                        String doctorMOBILE3 = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.MOBILE3));
                        String doctorDOB = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DOB));
                        String doctorDESIGNATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DESIGNATION));
                        String doctorQUALIFICATIONS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.QUALIFICATIONS));
                        String doctorLANGUAGES = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.LANGUAGES));
                        String doctorSERVICE_OFFER = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SERVICE_OFFER));
                        String doctorSPECIALTY_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.SPECIALTY_INTEREST));
                        String doctorAREA_INTEREST = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AREA_INTEREST));
                        String doctorFELLOWSHIPS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.FELLOWSHIPS));
                        String doctorEXPERIENCE = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EXPERIENCE));
                        String doctorACHIVEMENTS = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.ACHIVEMENTS));
                        String doctorBREAKTHROUGH = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.BREAKTHROUGH));
                        String doctorEDUCATION = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.EDUCATION));
                        String doctorAVAILABILITY = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.AVAILABILITY));
                        String doctorUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.UPDATED));
                        String doctorDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDoctorTbl.DATETIME));

                        String[] arrAVAILABILITY = doctorAVAILABILITY.split(",");

                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.email = doctorEMAIL;
                            modelDoctor.status = doctorSTATUS;
                            modelDoctor.docid = doctorDOCID;
                            modelDoctor.docIsFav = doctorFAVORITE;
                            modelDoctor.isactive = doctorISACTIVE;
                            modelDoctor.title = doctorTITLE;
                            modelDoctor.firstname = doctorFIRSTNAME;
                            modelDoctor.lastname = doctorLASTNAME;
                            modelDoctor.photo = doctorPHOTO;
                            modelDoctor.gender = doctorGENDER;
                            modelDoctor.address = doctorADDRESS;
                            modelDoctor.city = doctorCITY;
                            modelDoctor.state = doctorSTATE;
                            modelDoctor.country = doctorCOUNTRY;
                            modelDoctor.zipcode = doctorZIPCODE;
                            modelDoctor.mobile1 = doctorMOBILE1;
                            modelDoctor.mobile2 = doctorMOBILE2;
                            modelDoctor.mobile3 = doctorMOBILE3;
                            modelDoctor.dob = doctorDOB;
                            modelDoctor.designation = doctorDESIGNATION;
                            modelDoctor.qualifications = doctorQUALIFICATIONS;
                            modelDoctor.languages = doctorLANGUAGES;
                            modelDoctor.service_offer = doctorSERVICE_OFFER;
                            modelDoctor.specialty_interest = doctorSPECIALTY_INTEREST;
                            modelDoctor.area_interest = doctorAREA_INTEREST;
                            modelDoctor.fellowships = doctorFELLOWSHIPS;
                            modelDoctor.experience = doctorEXPERIENCE;
                            modelDoctor.achivements = doctorACHIVEMENTS;
                            modelDoctor.breakthrough = doctorBREAKTHROUGH;
                            modelDoctor.education = doctorEDUCATION;
                            modelDoctor.availability = arrAVAILABILITY;
                            modelDoctor.updated = doctorUPDATED;
                            modelDoctor.datetime = doctorDATETIME;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteNotAvailable_DocID(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("DELETE FROM " + TABLE_DOCTOR + " where " + modelDoctorTbl.DOCID + " NOT IN (" + docID + ")");
             // DELETE FROM ListSurvey where id NOT IN (1,3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DepartmentListModel> getDocDeprtName(String docID) {
        ArrayList<DepartmentListModel> data = new ArrayList<>();

        try {
            SQLiteDatabase db = this.getReadableDatabase();

            String selectQuery = "SELECT * FROM " + TABLE_DOCTOR_DEPRT + " a INNER JOIN " + TABLE_DEPARTMENTS + " b ON a.deprtid=b.departmentid WHERE a.docid=" + docID;


            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String deprtID = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ID));
                        String deprtIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.IMAGE));
                        String deprtTITLE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TITLE));
                        String deprtISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.ISACTIVE));
                        String deprtDESC = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DESC));
                        String deprtOVERVIEW = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.OVERVIEW));
                        String deprtSERVICES = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SERVICES));
                        String deprtTECHNOLOGY = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.TECHNOLOGY));
                        String deprtSPECIALISTS = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.SPECIALISTS));
                        String deprtDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.DATETIME));
                        String deprtUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelDepartmentTbl.UPDATED));


                        try {
                            DepartmentListModel modelDeprt = new DepartmentListModel();
                            modelDeprt.departmentid = deprtID;
                            modelDeprt.image = deprtIMAGE;
                            modelDeprt.title = deprtTITLE;
                            modelDeprt.isactive = deprtISACTIVE;
                            modelDeprt.desc = deprtDESC;
                            modelDeprt.overview = deprtOVERVIEW;
                            modelDeprt.services = deprtSERVICES;
                            modelDeprt.technology = deprtTECHNOLOGY;
                            modelDeprt.specialists = deprtSPECIALISTS;
                            modelDeprt.datetime = deprtDATETIME;
                            modelDeprt.updated= deprtUPDATED;
                            data.add(modelDeprt);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection

        }catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }



    /*
    * Doctor SubDepartment - doc in which subDepart he/she belong
    * */
    public ArrayList<String> dbGetDocSubDeprtID(String docID) {
        ArrayList<String> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_SUBDEPRTID + " where " + modelDoctorSubDeprtTble.DOCID + " = '" + docID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String docSUBDEPRTID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorSubDeprtTble.SUBDEPRTID));

                        try {

                            data.add(docSUBDEPRTID);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }


    /*
    * Doctor Is-HOD - doc in which department he/she is HOD
    * */
    public void dbInsertDocHOD(String docID, String docDeprtID) {
        try {
            String temp = dbCheckDocHOD(docID, docDeprtID);
            if (temp == null || temp.length() == 0) {
                //App.showLog(TAG, "dbInsertDocHOD");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelDoctorHODTble.DOCID, docID);
                values.put(modelDoctorHODTble.DEPRTID, docDeprtID);

                db.insert(TABLE_DOCTOR_HOD, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckDocHOD(String docID, String docDeprtID) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDocHOD");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_HOD + " where " + modelDoctorHODTble.DOCID + " = '" + docID + "'"
                    + " AND " + modelDoctorHODTble.DEPRTID + " = '" + docDeprtID + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES


            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public void dbDeleteInsertNew_DocHOD(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //----Delete full table--->  db.delete(TABLE_NAME_DEPARTMENT_DATA_SERVICES_DETAIL, null, null);
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_HOD + " where " + modelDoctorHODTble.DOCID + " = '" + docID + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DoctorModel> dbGetHODInDeprt(String strDeprtID) {
        ArrayList<DoctorModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_HOD + " where deprtid = '" + strDeprtID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String doctorDOCID = cursor.getString(cursor
                                .getColumnIndex(modelDoctorHODTble.DOCID));

                        try {
                            DoctorModel modelDoctor = new DoctorModel();
                            modelDoctor.docid = doctorDOCID;

                            data.add(modelDoctor);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteNotAvailable_DocHODID(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_HOD + " where " + modelDoctorHODTble.DOCID + " NOT IN (" + docID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /*
   * Doctor Deprt - doc in which department he/she belongs
   * */
    public void dbInsertDocDeprt(String docID, String docDeprtID) {
        try {
            String temp = dbCheckDocDeprt(docID, docDeprtID);
            if (temp == null || temp.length() == 0) {
                //App.showLog(TAG, "dbInsertDocDeprt");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelDoctorDeprtTble.DOCID, docID);
                values.put(modelDoctorDeprtTble.DEPRTID, docDeprtID);

                db.insert(TABLE_DOCTOR_DEPRT, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckDocDeprt(String docID, String docDeprtID) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDocDeprt");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_DEPRT + " where " + modelDoctorDeprtTble.DOCID + " = '" + docID + "'"
                    + " AND " + modelDoctorDeprtTble.DEPRTID + " = '" + docDeprtID + "'";

            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public void dbDeleteInsertNew_DocDeprt(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //----Delete full table--->  db.delete(TABLE_NAME_DEPARTMENT_DATA_SERVICES_DETAIL, null, null);
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_DEPRT + " where " + modelDoctorDeprtTble.DOCID + " = '" + docID + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbDeleteNotAvailable_DocDeprtID(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_DEPRT + " where " + modelDoctorDeprtTble.DOCID + " NOT IN (" + docID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /*
     * Doctor SubDeprt - doc in which subdepartment he/she belongs
     * */
    public void dbInsertDocSubDeprt(String docID, String docSubDeprtID) {
        try {
            String temp = dbCheckDocSubDeprt(docID, docSubDeprtID);
            if (temp == null || temp.length() == 0) {
                //App.showLog(TAG, "dbInsertDocDeprt");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelDoctorSubDeprtTble.DOCID, docID);
                values.put(modelDoctorSubDeprtTble.SUBDEPRTID, docSubDeprtID);

                db.insert(TABLE_DOCTOR_SUBDEPRTID, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckDocSubDeprt(String docID, String docSubDeprtID) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckDocDeprt");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_DOCTOR_SUBDEPRTID + " where " + modelDoctorSubDeprtTble.DOCID + " = '" + docID + "'"
                    + " AND " + modelDoctorSubDeprtTble.SUBDEPRTID + " = '" + docSubDeprtID + "'";

            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public void dbDeleteInsertNew_DocSubDeprt(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //----Delete full table--->  db.delete(TABLE_NAME_DEPARTMENT_DATA_SERVICES_DETAIL, null, null);
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_SUBDEPRTID + " where " + modelDoctorSubDeprtTble.DOCID + " = '" + docID + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbDeleteDocSubDeprtID(String docID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_DOCTOR_SUBDEPRTID + " where " + modelDoctorSubDeprtTble.DOCID + " NOT IN (" + docID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }







    /*
    * HealthTips
    * */
    public void dbInsertHealthTips(HealthTipsModel model) {
        try {
            String temp = dbCheckHealthTips(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertHealthTips");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelHealthTipsTbl.ID, model.healthtipid);
                values.put(modelHealthTipsTbl.IMAGE, model.image);
                values.put(modelHealthTipsTbl.ISACTIVE, model.isactive);
                values.put(modelHealthTipsTbl.TITLE, model.title);
                values.put(modelHealthTipsTbl.DESC, model.desc);
                values.put(modelHealthTipsTbl.DATETIME, model.datetime);
                values.put(modelHealthTipsTbl.UPDATED, model.updated);

                db.insert(TABLE_HEALTHTIPS, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckHealthTips(HealthTipsModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckHealthTips");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_HEALTHTIPS + " where " + modelHealthTipsTbl.ID + " = '" + model.healthtipid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateHealthTips(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateHealthTips(HealthTipsModel model) {
        try {
            //App.showLog(TAG, "dbUpdateHealthTips");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelHealthTipsTbl.ID, model.healthtipid);
            values.put(modelHealthTipsTbl.IMAGE, model.image);
            values.put(modelHealthTipsTbl.ISACTIVE, model.isactive);
            values.put(modelHealthTipsTbl.TITLE, model.title);
            values.put(modelHealthTipsTbl.DESC, model.desc);
            values.put(modelHealthTipsTbl.DATETIME, model.datetime);
            values.put(modelHealthTipsTbl.UPDATED, model.updated);

            db.update(TABLE_HEALTHTIPS, values, modelHealthTipsTbl.ID + "='" + model.healthtipid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<HealthTipsModel> getAllHealthTips() {
        ArrayList<HealthTipsModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_HEALTHTIPS + " WHERE isactive = 1  ORDER BY " + modelHealthTipsTbl.DATETIME + " DESC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String healthTipsID = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.ID));
                        String healthTipsIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.IMAGE));
                        String healthTipsISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.ISACTIVE));
                        String healthTipsTITLE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.TITLE));
                        String healthTipsDESC = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.DESC));
                        String healthTipsDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.DATETIME));
                        String healthTipsUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.UPDATED));


                        try {
                            HealthTipsModel modelHealthTips = new HealthTipsModel();
                            modelHealthTips.healthtipid = healthTipsID;
                            modelHealthTips.image = healthTipsIMAGE;
                            modelHealthTips.isactive = healthTipsISACTIVE;
                            modelHealthTips.title = healthTipsTITLE;
                            modelHealthTips.desc = healthTipsDESC;
                            modelHealthTips.datetime = healthTipsDATETIME;
                            modelHealthTips.updated = healthTipsUPDATED;

                            data.add(modelHealthTips);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalHealthTips() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelHealthTipsTbl.ID + " FROM " + TABLE_HEALTHTIPS + " where isactive = 1 AND " + modelHealthTipsTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public boolean dbCheckHealthTipInDB(String strHealthTipID) {
        boolean getEntry = false;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_HEALTHTIPS + " where " + modelHealthTipsTbl.ID + " = '" + strHealthTipID + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = true; //bcz it return no of row greater than 0 having deprt and mainid same
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public HealthTipsModel dbGetSingleHealthTips(String strHealthTipID) {
        HealthTipsModel modelHealthTips = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_HEALTHTIPS + " where  isactive = 1 AND " + modelHealthTipsTbl.ID + " = '" + strHealthTipID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String healthTipsID = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.ID));
                        String healthTipsIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.IMAGE));
                        String healthTipsISACTIVE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.ISACTIVE));
                        String healthTipsTITLE = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.TITLE));
                        String healthTipsDESC = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.DESC));
                        String healthTipsDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.DATETIME));
                        String healthTipsUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelHealthTipsTbl.UPDATED));


                        try {
                            modelHealthTips = new HealthTipsModel();
                            modelHealthTips.healthtipid = healthTipsID;
                            modelHealthTips.image = healthTipsIMAGE;
                            modelHealthTips.isactive = healthTipsISACTIVE;
                            modelHealthTips.title = healthTipsTITLE;
                            modelHealthTips.desc = healthTipsDESC;
                            modelHealthTips.datetime = healthTipsDATETIME;
                            modelHealthTips.updated = healthTipsUPDATED;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return modelHealthTips;
    }

    public void dbDeleteNotAvailable_HealthTipID(String healthThipID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_HEALTHTIPS + " where " + modelHealthTipsTbl.ID + " NOT IN (" + healthThipID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    * News
    * */
    public void dbInsertNews(NewsModel model) {
        try {
            String temp = dbCheckNews(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertNews");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelNewsTbl.ID, model.newsid);
                values.put(modelNewsTbl.TITLE, model.title);
                values.put(modelNewsTbl.DESC, model.desc);
                values.put(modelNewsTbl.IMAGE, model.image);
                values.put(modelNewsTbl.DATETIME, model.datetime);
                values.put(modelNewsTbl.UPDATED, model.updated);

                db.insert(TABLE_NEWS, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckNews(NewsModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckNews");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_NEWS + " where " + modelNewsTbl.ID + " = '" + model.newsid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateNews(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateNews(NewsModel model) {
        try {
            //App.showLog(TAG, "dbUpdateNews");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelNewsTbl.ID, model.newsid);
            values.put(modelNewsTbl.TITLE, model.title);
            values.put(modelNewsTbl.DESC, model.desc);
            values.put(modelNewsTbl.IMAGE, model.image);
            values.put(modelNewsTbl.DATETIME, model.datetime);
            values.put(modelNewsTbl.UPDATED, model.updated);

            db.update(TABLE_NEWS, values, modelNewsTbl.ID + "='" + model.newsid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<NewsModel> getAllNews() {
        ArrayList<NewsModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_NEWS + " ORDER BY " + modelNewsTbl.DATETIME + " DESC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String NewsID = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.ID));
                        String NewsTITLE = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.TITLE));
                        String NewsIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.IMAGE));
                        String NewsDESC = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.DESC));
                        String NewsDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.DATETIME));
                        String NewsUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.UPDATED));


                        try {
                            NewsModel modelNews = new NewsModel();
                            modelNews.newsid = NewsID;
                            modelNews.title = NewsTITLE;
                            modelNews.desc = NewsDESC;
                            modelNews.image = NewsIMAGE;
                            modelNews.datetime = NewsDATETIME;
                            modelNews.updated = NewsUPDATED;
                            data.add(modelNews);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalNews() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelNewsTbl.ID + " FROM " + TABLE_NEWS + " where " + modelNewsTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public boolean dbCheckNewsInDB(String strNewsID) {
        boolean getEntry = false;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_NEWS + " where " + modelNewsTbl.ID + " = '" + strNewsID + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = true; //bcz it return no of row greater than 0 having deprt and mainid same
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public NewsModel dbGetSingleNews(String strNewsID) {
        NewsModel modelNews = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_NEWS + " where " + modelNewsTbl.ID + " = '" + strNewsID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String NewsID = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.ID));
                        String NewsTITLE = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.TITLE));
                        String NewsIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.IMAGE));
                        String NewsDESC = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.DESC));
                        String NewsDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.DATETIME));
                        String NewsUPDATED = cursor.getString(cursor
                                .getColumnIndex(modelNewsTbl.UPDATED));


                        try {
                            modelNews = new NewsModel();
                            modelNews.newsid = NewsID;
                            modelNews.title = NewsTITLE;
                            modelNews.desc = NewsDESC;
                            modelNews.image = NewsIMAGE;
                            modelNews.datetime = NewsDATETIME;
                            modelNews.updated = NewsUPDATED;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return modelNews;
    }

    public void dbDeleteNotAvailable_NewsID(String newsID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_NEWS + " where " + modelNewsTbl.ID + " NOT IN (" + newsID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    * Events
    * */
    public void dbInsertEvents(EventsModel model) {
        try {
            String temp = dbCheckEvents(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertEvents");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelEventsTbl.ID, model.eventid);
                values.put(modelEventsTbl.TITLE, model.title);
                values.put(modelEventsTbl.IMAGE, model.image);
                values.put(modelEventsTbl.DESC, model.desc);
                values.put(modelEventsTbl.START_DATE, model.startdate);
                values.put(modelEventsTbl.END_DATE, model.enddate);
                values.put(modelEventsTbl.START_TIME, model.starttime);
                values.put(modelEventsTbl.END_TIME, model.endtime);

                db.insert(TABLE_EVENTS, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckEvents(EventsModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckEvents");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_EVENTS + " where " + modelEventsTbl.ID + " = '" + model.eventid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateEvents(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateEvents(EventsModel model) {
        try {
            //App.showLog(TAG, "dbUpdateEvents");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelEventsTbl.ID, model.eventid);
            values.put(modelEventsTbl.TITLE, model.title);
            values.put(modelEventsTbl.IMAGE, model.image);
            values.put(modelEventsTbl.DESC, model.desc);
            values.put(modelEventsTbl.START_DATE, model.startdate);
            values.put(modelEventsTbl.END_DATE, model.enddate);
            values.put(modelEventsTbl.START_TIME, model.starttime);
            values.put(modelEventsTbl.END_TIME, model.endtime);

            db.update(TABLE_EVENTS, values, modelEventsTbl.ID + "='" + model.eventid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<EventsModel> getAllEvents() {
        ArrayList<EventsModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_EVENTS + " ORDER BY " + modelEventsTbl.START_DATE + " DESC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String eventID = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.ID));
                        String eventTITLE = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.TITLE));
                        String eventIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.IMAGE));
                        String eventDESC = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.DESC));
                        String eventSTART_DATETIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.START_DATE));
                        String eventEND_DATETIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.END_DATE));
                        String eventSTART_TIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.START_TIME));
                        String eventEND_TIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.END_TIME));


                        try {
                            EventsModel modelEvents = new EventsModel();
                            modelEvents.eventid = eventID;
                            modelEvents.title = eventTITLE;
                            modelEvents.image = eventIMAGE;
                            modelEvents.desc = eventDESC;
                            modelEvents.startdate = eventSTART_DATETIME;
                            modelEvents.enddate = eventEND_DATETIME;
                            modelEvents.starttime = eventSTART_TIME;
                            modelEvents.endtime = eventEND_TIME;
                            data.add(modelEvents);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalEvents() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelEventsTbl.ID + " FROM " + TABLE_EVENTS + " where " + modelEventsTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }

    public boolean dbCheckEventInDB(String strEventID) {
        boolean getEntry = false;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_EVENTS + " where " + modelEventsTbl.ID + " = '" + strEventID + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = true; //bcz it return no of row greater than 0 having deprt and mainid same
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    public EventsModel dbGetSingleEvents(String strEventID) {
        EventsModel modelEvents = null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_EVENTS + " where " + modelEventsTbl.ID + " = '" + strEventID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String eventID = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.ID));
                        String eventTITLE = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.TITLE));
                        String eventIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.IMAGE));
                        String eventDESC = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.DESC));
                        String eventSTART_DATETIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.START_DATE));
                        String eventEND_DATETIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.END_DATE));
                        String eventSTART_TIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.START_TIME));
                        String eventEND_TIME = cursor.getString(cursor
                                .getColumnIndex(modelEventsTbl.END_TIME));


                        try {
                            modelEvents = new EventsModel();
                            modelEvents.eventid = eventID;
                            modelEvents.title = eventTITLE;
                            modelEvents.image = eventIMAGE;
                            modelEvents.desc = eventDESC;
                            modelEvents.startdate = eventSTART_DATETIME;
                            modelEvents.enddate = eventEND_DATETIME;
                            modelEvents.starttime = eventSTART_TIME;
                            modelEvents.endtime = eventEND_TIME;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return modelEvents;
    }

    public void dbDeleteNotAvailable_EventID(String eventID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_EVENTS + " where " + modelEventsTbl.ID + " NOT IN (" + eventID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /*
   * About Reliance
   * */
    public void dbInsertAboutReliance(AboutRelianceModel model) {
        try {
            String temp = dbCheckAboutReliance(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertAboutReliance");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelAboutRelianceTbl.ID, model.mainid);
                values.put(modelAboutRelianceTbl.TITLE, model.title);
                values.put(modelAboutRelianceTbl.IMAGE, model.image);
                values.put(modelAboutRelianceTbl.DESC, model.desc);
                values.put(modelAboutRelianceTbl.URL, model.url);

                db.insert(TABLE_ABOUTRELIANCE, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckAboutReliance(AboutRelianceModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckAboutReliance");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTRELIANCE + " where " + modelAboutRelianceTbl.ID + " = '" + model.mainid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateAboutReliance(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateAboutReliance(AboutRelianceModel model) {
        try {
            //App.showLog(TAG, "dbUpdateAboutReliance");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelAboutRelianceTbl.ID, model.mainid);
            values.put(modelAboutRelianceTbl.TITLE, model.title);
            values.put(modelAboutRelianceTbl.IMAGE, model.image);
            values.put(modelAboutRelianceTbl.DESC, model.desc);
            values.put(modelAboutRelianceTbl.URL, model.url);


            db.update(TABLE_ABOUTRELIANCE, values, modelAboutRelianceTbl.ID + "='" + model.mainid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<AboutRelianceModel> getAllAboutReliance() {
        ArrayList<AboutRelianceModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTRELIANCE;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String aboutRelianceID = cursor.getString(cursor
                                .getColumnIndex(modelAboutRelianceTbl.ID));
                        String aboutRelianceTITLE = cursor.getString(cursor
                                .getColumnIndex(modelAboutRelianceTbl.TITLE));
                        String aboutRelianceIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelAboutRelianceTbl.IMAGE));
                        String aboutRelianceDESC = cursor.getString(cursor
                                .getColumnIndex(modelAboutRelianceTbl.DESC));
                        String aboutRelianceURL = cursor.getString(cursor
                                .getColumnIndex(modelAboutRelianceTbl.URL));


                        try {
                            AboutRelianceModel modelAboutReliance = new AboutRelianceModel();
                            modelAboutReliance.mainid = aboutRelianceID;
                            modelAboutReliance.title = aboutRelianceTITLE;
                            modelAboutReliance.image = aboutRelianceIMAGE;
                            modelAboutReliance.desc = aboutRelianceDESC;
                            modelAboutReliance.url = aboutRelianceURL;

                            data.add(modelAboutReliance);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalAboutReliance() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelAboutRelianceTbl.ID + " FROM " + TABLE_ABOUTRELIANCE + " where " + modelAboutRelianceTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }


    /*
   * Sub-About Reliance
   * */
    public void dbInsertSubAboutReliance(String strMainID, AboutRelianceModel.SubAboutReliance model) {
        try {
            String temp = dbCheckSubAboutReliance(strMainID, model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertSubAboutReliance");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelSubAboutRelianceTbl.MAINID, strMainID);
                values.put(modelSubAboutRelianceTbl.SUBID, model.subid);
                values.put(modelSubAboutRelianceTbl.TITLE, model.title);
                values.put(modelSubAboutRelianceTbl.IMAGE, model.image);
                values.put(modelSubAboutRelianceTbl.DESC, model.desc);
                values.put(modelSubAboutRelianceTbl.URL, model.url);

                db.insert(TABLE_ABOUTRELIANCE_SUB, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckSubAboutReliance(String strMainID, AboutRelianceModel.SubAboutReliance model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckSubAboutReliance");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTRELIANCE_SUB + " where " + modelSubAboutRelianceTbl.MAINID + " = '" + strMainID + "'"
                    + " AND " + modelSubAboutRelianceTbl.SUBID + " = '" + model.subid + "'";
            ;
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateSubAboutReliance(strMainID, model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateSubAboutReliance(String strMainID, AboutRelianceModel.SubAboutReliance model) {
        try {
            //App.showLog(TAG, "dbUpdateSubAboutReliance");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelSubAboutRelianceTbl.MAINID, strMainID);
            values.put(modelSubAboutRelianceTbl.SUBID, model.subid);
            values.put(modelSubAboutRelianceTbl.TITLE, model.title);
            values.put(modelSubAboutRelianceTbl.IMAGE, model.image);
            values.put(modelSubAboutRelianceTbl.DESC, model.desc);
            values.put(modelSubAboutRelianceTbl.URL, model.url);


            db.update(TABLE_ABOUTRELIANCE_SUB, values, modelSubAboutRelianceTbl.MAINID + "='" + strMainID + "'"
                    + " AND " + modelSubAboutRelianceTbl.SUBID + " = '" + model.subid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<AboutRelianceModel.SubAboutReliance> getAllSubAboutReliance(String strMainID) {
        ArrayList<AboutRelianceModel.SubAboutReliance> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTRELIANCE_SUB + " where " + modelSubAboutRelianceTbl.MAINID + " = '" + strMainID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String subAboutRelianceID = cursor.getString(cursor
                                .getColumnIndex(modelSubAboutRelianceTbl.SUBID));
                        String subAboutRelianceTITLE = cursor.getString(cursor
                                .getColumnIndex(modelSubAboutRelianceTbl.TITLE));
                        String subAboutRelianceIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelSubAboutRelianceTbl.IMAGE));
                        String subAboutRelianceDESC = cursor.getString(cursor
                                .getColumnIndex(modelSubAboutRelianceTbl.DESC));
                        String subAboutRelianceURL = cursor.getString(cursor
                                .getColumnIndex(modelSubAboutRelianceTbl.URL));


                        try {
                            AboutRelianceModel.SubAboutReliance modelAboutReliance = new AboutRelianceModel.SubAboutReliance();
                            modelAboutReliance.subid = subAboutRelianceID;
                            modelAboutReliance.title = subAboutRelianceTITLE;
                            modelAboutReliance.image = subAboutRelianceIMAGE;
                            modelAboutReliance.desc = subAboutRelianceDESC;
                            modelAboutReliance.url = subAboutRelianceURL;

                            data.add(modelAboutReliance);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public int getTotalSubAboutReliance(String strMainID) {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + strMainID + " FROM " + TABLE_ABOUTRELIANCE_SUB + " where " + strMainID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }



    /*
   * PhoneDirModel
   * */
    public void dbInsertPhoneDir(PhoneDirModel model) {
        try {
            String temp = dbCheckPhoneDir(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertPhoneDir");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelPhoneDirTbl.ID, model.id);
                values.put(modelPhoneDirTbl.IMAGE, model.image);
                values.put(modelPhoneDirTbl.DESC, model.desc);

                db.insert(TABLE_PHONEDIRECTORY, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckPhoneDir(PhoneDirModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckPhoneDir");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_PHONEDIRECTORY + " where " + modelPhoneDirTbl.ID + " = '" + model.id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdatePhoneDir(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdatePhoneDir(PhoneDirModel model) {
        try {
            //App.showLog(TAG, "dbUpdatePhoneDir");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelPhoneDirTbl.ID, model.id);
            values.put(modelPhoneDirTbl.IMAGE, model.image);
            values.put(modelPhoneDirTbl.DESC, model.desc);

            db.update(TABLE_PHONEDIRECTORY, values, modelPhoneDirTbl.ID + "='" + model.id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public PhoneDirModel getPhoneDirModel() {
        PhoneDirModel data = new PhoneDirModel();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_PHONEDIRECTORY;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String phoneDirID = cursor.getString(cursor
                                .getColumnIndex(modelPhoneDirTbl.ID));
                        String phoneDirIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelPhoneDirTbl.IMAGE));
                        String phoneDirDESC = cursor.getString(cursor
                                .getColumnIndex(modelPhoneDirTbl.DESC));


                        try {

                            data.id = phoneDirID;
                            data.image = phoneDirIMAGE;
                            data.desc = phoneDirDESC;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }


    /*
   * About App
   * */
    public void dbInsertAboutApp(AboutAppModel model) {
        try {
            String temp = dbCheckAboutApp(model);
            if (temp != null && temp.length() > 0) {
            } else {
                //App.showLog(TAG, "dbInsertAboutApp");

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelAboutAppTbl.ID, model.id);
                values.put(modelAboutAppTbl.IMAGE, model.image);
                values.put(modelAboutAppTbl.DESC, model.desc);

                db.insert(TABLE_ABOUTAPP, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckAboutApp(AboutAppModel model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckAboutApp");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTAPP + " where " + modelAboutAppTbl.ID + " = '" + model.id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateAboutApp(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateAboutApp(AboutAppModel model) {
        try {
            //App.showLog(TAG, "dbUpdateAboutApp");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelAboutAppTbl.ID, model.id);
            values.put(modelAboutAppTbl.IMAGE, model.image);
            values.put(modelAboutAppTbl.DESC, model.desc);

            db.update(TABLE_ABOUTAPP, values, modelAboutAppTbl.ID + "='" + model.id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public AboutAppModel getAboutAppModel() {
        AboutAppModel data = new AboutAppModel();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_ABOUTAPP;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String aboutAppID = cursor.getString(cursor
                                .getColumnIndex(modelAboutAppTbl.ID));
                        String aboutAppIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelAboutAppTbl.IMAGE));
                        String aboutAppDESC = cursor.getString(cursor
                                .getColumnIndex(modelAboutAppTbl.DESC));


                        try {

                            data.id = aboutAppID;
                            data.image = aboutAppIMAGE;
                            data.desc = aboutAppDESC;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }






    /*
     * VirtualTourModel
     * */
    public void dbInsertVirtualTour(VirtualTourModel.VirtualTourArr model) {
        try {
            String temp = dbCheckVirtualTour(model);
            if (temp != null && temp.length() > 0) {
            } else {

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelVitualTbl.ID, model.virtualcatid);
                values.put(modelVitualTbl.TITLE, model.virtualcattitle);
                values.put(modelVitualTbl.IMAGE, model.virtualcatimage);

                db.insert(TABLE_VirtualTour, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckVirtualTour(VirtualTourModel.VirtualTourArr model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckPhoneDir");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_VirtualTour + " where " + modelVitualTbl.ID + " = '" + model.virtualcatid + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateVirtualTour(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateVirtualTour(VirtualTourModel.VirtualTourArr model) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelVitualTbl.ID, model.virtualcatid);
            values.put(modelVitualTbl.TITLE, model.virtualcattitle);
            values.put(modelVitualTbl.IMAGE, model.virtualcatimage);

            db.update(TABLE_VirtualTour, values, modelVitualTbl.ID + "='" + model.virtualcatid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<VirtualTourModel.VirtualTourArr> getAllVirtualTour() {
        ArrayList<VirtualTourModel.VirtualTourArr> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_VirtualTour +" ORDER BY " + modelVitualTbl.ID;// + " ASC";;;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String virtualTourID = cursor.getString(cursor
                                .getColumnIndex(modelVitualTbl.ID));
                        String virtualTourTITLE = cursor.getString(cursor
                                .getColumnIndex(modelVitualTbl.TITLE));
                        String virtualTourIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelVitualTbl.IMAGE));



                        try {
                            VirtualTourModel.VirtualTourArr model = new VirtualTourModel.VirtualTourArr();
                            model.virtualcatid = virtualTourID;
                            model.virtualcattitle = virtualTourTITLE;
                            model.virtualcatimage = virtualTourIMAGE;

                            data.add(model);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteNotAvailable_VirtualTour(String subVirtualTourID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_VirtualTour + " where " + modelVitualTbl.ID + " NOT IN (" + subVirtualTourID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalVirtualTour() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelVitualTbl.ID + " FROM " + TABLE_VirtualTour + " where " + modelVitualTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }



    /*
     * VirtualTourModel Details
     * */
    public void dbInsertVirtualTourDetails(VirtualTourModel.VirtualTourDetailArr model) {
        try {
            String temp = dbCheckVirtualTourDetails(model);
            if (temp != null && temp.length() > 0) {
            } else {

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelVitualTblDetails.MAINID, model.virtualcatid);
                values.put(modelVitualTblDetails.SUBID, model.virtualid);
                values.put(modelVitualTblDetails.TITLE, model.virtualtitle);
                values.put(modelVitualTblDetails.IMAGE, model.virtualimage);
                values.put(modelVitualTblDetails.URL, model.virtualurl);

                db.insert(TABLE_VirtualTourDetail, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckVirtualTourDetails(VirtualTourModel.VirtualTourDetailArr model) {
        String getEntry = "";
        try {
            //App.showLog(TAG, "dbCheckPhoneDir");

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;

            String selectQuery = "SELECT  * FROM " + TABLE_VirtualTourDetail + " where " + modelVitualTblDetails.MAINID + " = '" + model.virtualcatid + "'"
                    + " AND " + modelVitualTblDetails.SUBID + " = '" + model.virtualid + "'";

            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateVirtualTourDetails(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateVirtualTourDetails(VirtualTourModel.VirtualTourDetailArr model) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelVitualTblDetails.MAINID, model.virtualcatid);
            values.put(modelVitualTblDetails.SUBID, model.virtualid);
            values.put(modelVitualTblDetails.TITLE, model.virtualtitle);
            values.put(modelVitualTblDetails.IMAGE, model.virtualimage);
            values.put(modelVitualTblDetails.URL, model.virtualurl);

            db.update(TABLE_VirtualTourDetail, values, modelVitualTblDetails.MAINID + "='" + model.virtualcatid + "'"
                                + " AND " + modelVitualTblDetails.SUBID + " = '" + model.virtualid + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<VirtualTourModel.VirtualTourDetailArr> getAllVirtualTourDetails(String virtualTourID) {
        ArrayList<VirtualTourModel.VirtualTourDetailArr> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_VirtualTourDetail + " where " + modelVitualTblDetails.MAINID + " = '" + virtualTourID + "'"
                    + " ORDER BY " + modelVitualTblDetails.SUBID;// + " ASC";;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String virtualTourDetailsMAINID = cursor.getString(cursor
                                .getColumnIndex(modelVitualTblDetails.MAINID));
                        String virtualTourDetailsSUBID = cursor.getString(cursor
                                .getColumnIndex(modelVitualTblDetails.SUBID));
                        String virtualTourDetailsTITLE = cursor.getString(cursor
                                .getColumnIndex(modelVitualTblDetails.TITLE));
                        String virtualTourDetailsIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelVitualTblDetails.IMAGE));
                        String virtualTourDetailsURL = cursor.getString(cursor
                                .getColumnIndex(modelVitualTblDetails.URL));



                        try {
                            VirtualTourModel.VirtualTourDetailArr model = new VirtualTourModel.VirtualTourDetailArr();
                            model.virtualcatid = virtualTourDetailsMAINID;
                            model.virtualid = virtualTourDetailsSUBID;
                            model.virtualtitle = virtualTourDetailsTITLE;
                            model.virtualimage = virtualTourDetailsIMAGE;
                            model.virtualurl = virtualTourDetailsURL;

                            data.add(model);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteNotAvailable_VirtualTourDetails(String subVirtualTourDetailsID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_VirtualTourDetail + " where " + modelVitualTblDetails.SUBID + " NOT IN (" + subVirtualTourDetailsID + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getTotalVirtualTourDetial() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelVitualTblDetails.SUBID + " FROM " + TABLE_VirtualTourDetail + " where " + modelVitualTblDetails.SUBID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }



    /*
    * Medicine Tracker
    * */
    public void dbInsertMedicineTracker(String id, String medicineName, String medicineImg, String medicineType, String medicineDossage, String booleanAlarm) {
        try {
            String temp = dbCheckMedicineTracker(id, medicineName, medicineImg, medicineType, medicineDossage, booleanAlarm);

            if (temp != null && temp.length() > 0) {
            } else {


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelMedicineTrackerTbl.ID, id);
                values.put(modelMedicineTrackerTbl.NAME, medicineName);
                values.put(modelMedicineTrackerTbl.IMAGE, medicineImg);
                values.put(modelMedicineTrackerTbl.TYPE, medicineType);
                values.put(modelMedicineTrackerTbl.DOSSAGE, medicineDossage);
                values.put(modelMedicineTrackerTbl.ALARM, booleanAlarm);

                db.insert(TABLE_MEDICINETRACKER, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckMedicineTracker(String id, String medicineName, String medicineImg, String medicineType, String medicineDossage, String booleanAlarm) {
        String getEntry = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKER + " where " + modelMedicineTrackerTbl.ID + " = '" + id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateMedicineTracker(id, medicineName, medicineImg, medicineType, medicineDossage, booleanAlarm);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateMedicineTracker(String id, String medicineName, String medicineImg, String medicineType, String medicineDossage, String booleanAlarm) {
        try {
            //App.showLog(TAG, "dbUpdateDepartment");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelMedicineTrackerTbl.ID, id);
            values.put(modelMedicineTrackerTbl.NAME, medicineName);
            values.put(modelMedicineTrackerTbl.IMAGE, medicineImg);
            values.put(modelMedicineTrackerTbl.TYPE, medicineType);
            values.put(modelMedicineTrackerTbl.DOSSAGE, medicineDossage);
            values.put(modelMedicineTrackerTbl.ALARM, booleanAlarm);

            db.update(TABLE_MEDICINETRACKER, values, modelMedicineTrackerTbl.ID + "='" + id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<MedicineTrackerModel> getMedicineTracker() {
        ArrayList<MedicineTrackerModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKER;

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String strID = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.ID));
                        String strNAME = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.NAME));
                        String strIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.IMAGE));
                        String strTYPE = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.TYPE));
                        String strDOSSAGE = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.DOSSAGE));
                        String booleanAlarm = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTbl.ALARM));


                        try {

                            MedicineTrackerModel medicineTrackerModel = new MedicineTrackerModel();
                            medicineTrackerModel.id = strID;
                            medicineTrackerModel.name = strNAME;
                            medicineTrackerModel.image = strIMAGE;
                            medicineTrackerModel.type = strTYPE;
                            medicineTrackerModel.dossage = strDOSSAGE;
                            medicineTrackerModel.booleanAlarm = booleanAlarm;

                            data.add(medicineTrackerModel);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }




    /*
    * Medicine Tracker Time
    * */
    public void dbInsertMedicineTrackerTime(String id, ArrayList<MedicineTrackerTimeModel>  arrMedicineTracker_Time) {
        try {
            String temp = dbCheckMedicineTrackerTime(id, arrMedicineTracker_Time);

            if (temp != null && temp.length() > 0) {
            } else {


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelMedicineTrackerTimeTbl.ID, id);
                if(arrMedicineTracker_Time.size() >0 && arrMedicineTracker_Time.get(0).title != null && arrMedicineTracker_Time.get(0).title.length() > 0) {
                    values.put(modelMedicineTrackerTimeTbl.TIMETITLE_1, arrMedicineTracker_Time.get(0).title);
                    values.put(modelMedicineTrackerTimeTbl.TIME12HR_1, arrMedicineTracker_Time.get(0).time12);
                    values.put(modelMedicineTrackerTimeTbl.TIME24HR_1, arrMedicineTracker_Time.get(0).time24);
                }

                if(arrMedicineTracker_Time.size() >1 && arrMedicineTracker_Time.get(1).title != null && arrMedicineTracker_Time.get(1).title.length()>0) {
                    values.put(modelMedicineTrackerTimeTbl.TIMETITLE_2, arrMedicineTracker_Time.get(1).title);
                    values.put(modelMedicineTrackerTimeTbl.TIME12HR_2, arrMedicineTracker_Time.get(1).time12);
                    values.put(modelMedicineTrackerTimeTbl.TIME24HR_2, arrMedicineTracker_Time.get(1).time24);
                }

                if(arrMedicineTracker_Time.size() >2 && arrMedicineTracker_Time.get(2).title != null && arrMedicineTracker_Time.get(2).title.length()>0) {
                    values.put(modelMedicineTrackerTimeTbl.TIMETITLE_3, arrMedicineTracker_Time.get(2).title);
                    values.put(modelMedicineTrackerTimeTbl.TIME12HR_3, arrMedicineTracker_Time.get(2).time12);
                    values.put(modelMedicineTrackerTimeTbl.TIME24HR_3, arrMedicineTracker_Time.get(2).time24);
                }

                db.insert(TABLE_MEDICINETRACKERT_TIME, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckMedicineTrackerTime(String id, ArrayList<MedicineTrackerTimeModel>  arrMedicineTracker_Time) {
        String getEntry = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKERT_TIME + " where " + modelMedicineTrackerTimeTbl.ID + " = '" + id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateMedicineTrackerTime(id, arrMedicineTracker_Time);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateMedicineTrackerTime(String id, ArrayList<MedicineTrackerTimeModel>  arrMedicineTracker_Time) {
        try {
            //App.showLog(TAG, "dbUpdateDepartment");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelMedicineTrackerTimeTbl.ID, id);
            values.put(modelMedicineTrackerTimeTbl.TIMETITLE_1, arrMedicineTracker_Time.get(0).title);
            values.put(modelMedicineTrackerTimeTbl.TIME12HR_1, arrMedicineTracker_Time.get(0).time12);
            values.put(modelMedicineTrackerTimeTbl.TIME24HR_1, arrMedicineTracker_Time.get(0).time24);

            values.put(modelMedicineTrackerTimeTbl.TIMETITLE_2, arrMedicineTracker_Time.get(1).title);
            values.put(modelMedicineTrackerTimeTbl.TIME12HR_2, arrMedicineTracker_Time.get(1).time12);
            values.put(modelMedicineTrackerTimeTbl.TIME24HR_2, arrMedicineTracker_Time.get(1).time24);

            values.put(modelMedicineTrackerTimeTbl.TIMETITLE_3, arrMedicineTracker_Time.get(2).title);
            values.put(modelMedicineTrackerTimeTbl.TIME12HR_3, arrMedicineTracker_Time.get(2).time12);
            values.put(modelMedicineTrackerTimeTbl.TIME24HR_3, arrMedicineTracker_Time.get(2).time24);

            db.update(TABLE_MEDICINETRACKERT_TIME, values, modelMedicineTrackerTimeTbl.ID + "='" + id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<MedicineTrackerTimeModel> getMedicineTrackerTime(String strMedicineID) {
        ArrayList<MedicineTrackerTimeModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKERT_TIME + " where " + modelMedicineTrackerTimeTbl.ID + " = '" + strMedicineID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String strID = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.ID));

                        String strTIMETITLE_1 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIMETITLE_1));
                        String strTIME12HR_1 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME12HR_1));
                        String strTIME24HR_1 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME24HR_1));

                        String strTIMETITLE_2 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIMETITLE_2));
                        String strTIME12HR_2 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME12HR_2));
                        String strTIME24HR_2 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME24HR_2));

                        String strTIMETITLE_3 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIMETITLE_3));
                        String strTIME12HR_3 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME12HR_3));
                        String strTIME24HR_3 = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerTimeTbl.TIME24HR_3));



                        try {

                            if(strTIMETITLE_1 != null && strTIMETITLE_1.length() > 0){
                                data.add(new MedicineTrackerTimeModel(strTIMETITLE_1, strTIME12HR_1, strTIME24HR_1));
                            }

                            if(strTIMETITLE_2 != null && strTIMETITLE_2.length() > 0){
                                data.add(new MedicineTrackerTimeModel(strTIMETITLE_2, strTIME12HR_2, strTIME24HR_2));
                            }

                            if(strTIMETITLE_3 != null && strTIMETITLE_3.length() > 0){
                                data.add(new MedicineTrackerTimeModel(strTIMETITLE_3, strTIME12HR_3, strTIME24HR_3));
                            }





                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }



    /*
    * Medicine Tracker Day
    * */
    public void dbInsertMedicineTrackerDay(String id, ArrayList<MedicineTrackerDaysModel> arrMedicineTracker_Days) {
        try {
            String temp = dbCheckMedicineTrackerDay(id, arrMedicineTracker_Days);

            if (temp != null && temp.length() > 0) {
            } else {


                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelMedicineTrackerDayTbl.ID, id);
                values.put(modelMedicineTrackerDayTbl.SUNDAY_SELECTED, arrMedicineTracker_Days.get(0).isSelected);
                values.put(modelMedicineTrackerDayTbl.MONDAY_SELECTED, arrMedicineTracker_Days.get(1).isSelected);
                values.put(modelMedicineTrackerDayTbl.TUESDAY_SELECTED, arrMedicineTracker_Days.get(2).isSelected);
                values.put(modelMedicineTrackerDayTbl.WEDNESDAY_SELECTED, arrMedicineTracker_Days.get(3).isSelected);
                values.put(modelMedicineTrackerDayTbl.THURDAY_SELECTED, arrMedicineTracker_Days.get(4).isSelected);
                values.put(modelMedicineTrackerDayTbl.FRIDAY_SELECTED, arrMedicineTracker_Days.get(5).isSelected);
                values.put(modelMedicineTrackerDayTbl.SATURDAY_SELECTED, arrMedicineTracker_Days.get(6).isSelected);

                db.insert(TABLE_MEDICINETRACKERT_DAY, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckMedicineTrackerDay(String id, ArrayList<MedicineTrackerDaysModel>  arrMedicineTracker_Days) {
        String getEntry = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKERT_DAY + " where " + modelMedicineTrackerDayTbl.ID + " = '" + id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateMedicineTrackerDay(id, arrMedicineTracker_Days);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateMedicineTrackerDay(String id, ArrayList<MedicineTrackerDaysModel>  arrMedicineTracker_Days) {
        try {
            //App.showLog(TAG, "dbUpdateDepartment");

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelMedicineTrackerTimeTbl.ID, id);
            values.put(modelMedicineTrackerDayTbl.ID, id);
            values.put(modelMedicineTrackerDayTbl.SUNDAY_SELECTED, arrMedicineTracker_Days.get(0).isSelected);
            values.put(modelMedicineTrackerDayTbl.MONDAY_SELECTED, arrMedicineTracker_Days.get(1).isSelected);
            values.put(modelMedicineTrackerDayTbl.TUESDAY_SELECTED, arrMedicineTracker_Days.get(2).isSelected);
            values.put(modelMedicineTrackerDayTbl.WEDNESDAY_SELECTED, arrMedicineTracker_Days.get(3).isSelected);
            values.put(modelMedicineTrackerDayTbl.THURDAY_SELECTED, arrMedicineTracker_Days.get(4).isSelected);
            values.put(modelMedicineTrackerDayTbl.FRIDAY_SELECTED, arrMedicineTracker_Days.get(5).isSelected);
            values.put(modelMedicineTrackerDayTbl.SATURDAY_SELECTED, arrMedicineTracker_Days.get(6).isSelected);

            db.update(TABLE_MEDICINETRACKERT_DAY, values, modelMedicineTrackerDayTbl.ID + "='" + id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<MedicineTrackerDaysModel> getMedicineTrackerDays(String strMedicineID) {
        ArrayList<MedicineTrackerDaysModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_MEDICINETRACKERT_DAY + " where " + modelMedicineTrackerDayTbl.ID + " = '" + strMedicineID + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String strID = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.ID));

                        String strSUNDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.SUNDAY_SELECTED));
                        String strMONDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.MONDAY_SELECTED));
                        String strTUESDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.TUESDAY_SELECTED));
                        String strWEDNESDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.WEDNESDAY_SELECTED));
                        String strTHURDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.THURDAY_SELECTED));
                        String strFRIDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.FRIDAY_SELECTED));
                        String strSATURDAY_SELECTED = cursor.getString(cursor
                                .getColumnIndex(modelMedicineTrackerDayTbl.SATURDAY_SELECTED));



                        try {


                            MedicineTrackerDaysModel medicineTrackerDaysModel = new MedicineTrackerDaysModel();

                            if(strSUNDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[0], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[0], true));


                            if(strMONDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[1], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[1], true));


                            if(strTUESDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[2], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[2], true));




                            if(strWEDNESDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[3], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[3], true));


                            if(strTHURDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[4], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[4], true));

                            if(strFRIDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[5], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[5], true));


                            if(strSATURDAY_SELECTED.equalsIgnoreCase("0"))
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[6], false));
                            else
                                data.add(new MedicineTrackerDaysModel(AppFlag.arrMedicineTracker_MedicineDays[6], true));



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteMedicineID(String medicineID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_MEDICINETRACKER + " where " + modelMedicineTrackerTbl.ID + " = '" + medicineID + "'");
            db.execSQL("DELETE FROM " + TABLE_MEDICINETRACKERT_DAY + " where " + modelMedicineTrackerDayTbl.ID + " = '" + medicineID + "'");
            db.execSQL("DELETE FROM " + TABLE_MEDICINETRACKERT_TIME + " where " + modelMedicineTrackerTimeTbl.ID + " = '" + medicineID + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /*
    * Notification
    * */
    public void dbDeleteTBLNotification() {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            //----Delete full table--->
            db.delete(TABLE_NOTIFICATION, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbInsertNotification(NotificationModel model) {
        try {
            String temp = dbCheckNotification(model);
            if (temp != null && temp.length() > 0) {
            } else {

                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put(modelNotificationTbl.ID, model.noti_id);
                values.put(modelNotificationTbl.TYPE, model.type);
                values.put(modelNotificationTbl.TITLE, model.title);
                values.put(modelNotificationTbl.NOTI_TITLE, model.noti_title);
                values.put(modelNotificationTbl.IMAGE, model.image);
                values.put(modelNotificationTbl.DESC, model.desc);
                values.put(modelNotificationTbl.DATETIME, model.datetime);
                values.put(modelNotificationTbl.DATA_ID, model.data_id);
                values.put(modelNotificationTbl.USER_ID, model.user_id);
                values.put(modelNotificationTbl.IS_READ, model.is_read);

                db.insert(TABLE_NOTIFICATION, null, values);
                db.close();
            }
        } catch (Exception e) {
        }
    }

    public String dbCheckNotification(NotificationModel model) {
        String getEntry = "";
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            String selectQuery = "SELECT  * FROM " + TABLE_NOTIFICATION + " where " + modelNotificationTbl.ID + " = '" + model.noti_id + "'";
            cursor = db.rawQuery(selectQuery, null); //THIS WILL GIVE NO. OF ROW HAVING VALUES

            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    getEntry = "AlreadyExist"; //bcz it return no of row greater than 0 having deprt and mainid same
                    dbUpdateNotification(model);
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return getEntry;
    }

    private void dbUpdateNotification(NotificationModel model) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(modelNotificationTbl.ID, model.noti_id);
            values.put(modelNotificationTbl.TYPE, model.type);
            values.put(modelNotificationTbl.TITLE, model.title);
            values.put(modelNotificationTbl.NOTI_TITLE, model.noti_title);
            values.put(modelNotificationTbl.IMAGE, model.image);
            values.put(modelNotificationTbl.DESC, model.desc);
            values.put(modelNotificationTbl.DATETIME, model.datetime);
            values.put(modelNotificationTbl.DATA_ID, model.data_id);
            values.put(modelNotificationTbl.USER_ID, model.user_id);
            values.put(modelNotificationTbl.IS_READ, model.is_read);

            db.update(TABLE_NOTIFICATION, values, modelNotificationTbl.ID + "='" + model.noti_id + "'", null);
            db.close();
        } catch (Exception e) {
        }
    }

    public ArrayList<NotificationModel> getAllNotification() {
        ArrayList<NotificationModel> data = new ArrayList<>();
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_NOTIFICATION  +" ORDER BY " + modelNotificationTbl.DATETIME + " DESC";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String strID = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.ID));
                        String strTYPE = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.TYPE));
                        String strTITLE = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.TITLE));
                        String strNOTITITLE = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.NOTI_TITLE));
                        String strIMAGE = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.IMAGE));
                        String strDESC = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.DESC));
                        String strDATETIME = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.DATETIME));
                        String strDATA_ID = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.DATA_ID));
                        String strUSER_ID = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.USER_ID));
                        String strIS_READ = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.IS_READ));



                        try {

                            NotificationModel notificationModel = new NotificationModel();
                            notificationModel.noti_id = strID;
                            notificationModel.type = strTYPE;
                            notificationModel.title = strTITLE;
                            notificationModel.noti_title = strNOTITITLE;
                            notificationModel.image = strIMAGE;
                            notificationModel.desc = strDESC;
                            notificationModel.datetime = strDATETIME;
                            notificationModel.data_id = strDATA_ID;
                            notificationModel.user_id = strUSER_ID;
                            notificationModel.is_read = strIS_READ;

                            data.add(notificationModel);



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return data;
    }

    public void dbDeleteNotificationID(String notificationID) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_NOTIFICATION + " where " + modelNotificationTbl.ID + " = '" + notificationID + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getNotificationID(String dataID, String notificationType) {
        String strID="";
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            String selectQuery = "SELECT  * FROM " + TABLE_NOTIFICATION  + " where " + modelNotificationTbl.DATA_ID + " = '" + dataID + "'"
                    + " AND " + modelNotificationTbl.TYPE + " = '" + notificationType + "'";

            Cursor cursor = null;

            cursor = db.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        strID = cursor.getString(cursor
                                .getColumnIndex(modelNotificationTbl.ID));

                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
            db.close(); // Closing database connection
        } catch (Exception e) {

        }
        return strID;
    }

    public void dbDeleteNotificationID_HealthTipEventNews(String dataID, String notificationType) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("DELETE FROM " + TABLE_NOTIFICATION + " where " + modelNotificationTbl.DATA_ID + " = '" + dataID + "'"
                    + " AND " + modelNotificationTbl.TYPE + " = '" + notificationType + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalNotification() {
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT " + modelNotificationTbl.ID + " FROM " + TABLE_NOTIFICATION + " where " + modelNotificationTbl.ID + " IS NOT NULL";
        Cursor c = database.rawQuery(selectQuery, null);
        c.moveToFirst();
        int total = c.getCount();
        c.close();
        return total;
    }




    /*----  Water Tracker  ----*/
    public void insertDrinkList(WaterTrackerChildModel model) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            App.showLog(TAG, "insertDrinkList: Qunatity " + model.drink_list_quantityml);

            values.put("w_DateTime", model.drink_list_time);
            values.put("w_date", model.drink_list_date);
            values.put("w_img", model.drink_list_img);
            values.put("w_quantityML", model.drink_list_quantityml);
            db.insert(TABLE_NAME_DRINK_LIST, null, values);
            db.close();

        } catch (Exception e) {
        }
    }

    public void updateDrinkList(String drink_list_id, String glass_quantity) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();

            App.showLog(TAG, "updateDrinkList: Qunatity " + glass_quantity);

            values.put("w_id", drink_list_id);
            values.put("w_quantityML", glass_quantity);
            db.update(TABLE_NAME_DRINK_LIST, values, " w_id  = '" + drink_list_id + "'", null);
            db.close();

        } catch (Exception e) {
        }
    }

    public ArrayList<WaterTrackerChildModel> getTodaysDrinkList(String dateCurrentYYYYMMDD) {

        ArrayList<WaterTrackerChildModel> data = new ArrayList<WaterTrackerChildModel>();
        try {
            //String selectQuery = "SELECT  * FROM " + TABLE_NAME_DRINK_LIST + " WHERE w_date = '" + dateCurrentYYYYMMDD +"' ORDER BY w_id ASC";
            String selectQuery = "SELECT  * FROM " + TABLE_NAME_DRINK_LIST + " WHERE w_date = '" + dateCurrentYYYYMMDD +"' ORDER BY w_id DESC";

            SQLiteDatabase dbs = this.getReadableDatabase();
            Cursor cursor = null;

            cursor = dbs.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        WaterTrackerChildModel model = new WaterTrackerChildModel();

                        String id = cursor.getString(cursor
                                .getColumnIndex("w_id"));
                        String time = cursor.getString(cursor
                                .getColumnIndex("w_DateTime"));
                        String date = cursor.getString(cursor
                                .getColumnIndex("w_date"));
                        String img = cursor.getString(cursor
                                .getColumnIndex("w_img"));
                        String quantity = cursor.getString(cursor
                                .getColumnIndex("w_quantityML"));

                        try {
                            model.id = id;
                            model.drink_list_time = time;
                            model.drink_list_date = date;
                            model.drink_list_img = img;
                            model.drink_list_quantityml = quantity;
                            data.add(model);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                dbs.close(); // Closing database connection

            }
        } catch (Exception e) {

        }
        return data;
    }

    public void delete_id_DrinkList(String drink_list_id) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();

            App.showLog(TAG, "delete_id_DrinkList: id " + drink_list_id);

            db.execSQL("DELETE FROM " + TABLE_NAME_DRINK_LIST + " WHERE w_id = '" + drink_list_id + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<WaterTrackerChildModel> getDateListFromDB() {
        ArrayList<WaterTrackerChildModel> data = new ArrayList<WaterTrackerChildModel>();
        try {
            //String selectQuery = "SELECT  * FROM " + TABLE_NAME_DRINK_LIST + " GROUP BY w_date ORDER BY w_id DESC";
            //String selectQuery = "SELECT w_date, SUM(w_quantityML)  FROM " + TABLE_NAME_DRINK_LIST + " GROUP BY w_date ORDER BY w_id ASC";
            String selectQuery = "SELECT w_date, SUM(w_quantityML)  FROM " + TABLE_NAME_DRINK_LIST + " GROUP BY w_date ORDER BY w_id DESC";

            SQLiteDatabase dbs = this.getReadableDatabase();
            Cursor cursor = null;

            cursor = dbs.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {
                        WaterTrackerChildModel model = new WaterTrackerChildModel();
                        String date = cursor
                                .getString(cursor.getColumnIndex("w_date"));
                        String quantity = cursor.getString(cursor
                                .getColumnIndex("SUM(w_quantityML)"));

                        try {
                            model.drink_list_date = date;
                            model.drink_list_quantityml = quantity;
                            data.add(model);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                dbs.close(); // Closing database connection
            }
        } catch (Exception e) {
        }
        return data;
    }

    public ArrayList<WaterTrackerChildModel> getFullDBsortByDate() {
        ArrayList<WaterTrackerChildModel> data = new ArrayList<WaterTrackerChildModel>();
        try {

            SQLiteDatabase dbs = this.getReadableDatabase();

            String selectQuery = "SELECT  * FROM "+TABLE_NAME_DRINK_LIST +" ORDER BY w_date DESC";
            App.showLog("--selectQuery--","==selectQuery=="+selectQuery);

            Cursor cursor = null;
            String strTempDate = "";
            String quantityTotal = "0";
            int totalSameDateRow = 0;

            cursor = dbs.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();

                if (cursor.moveToFirst()) {
                    do {
                        WaterTrackerChildModel model = new WaterTrackerChildModel();
                        String id = cursor.getString(cursor
                                .getColumnIndex("w_id"));
                        String date = cursor.getString(cursor
                                .getColumnIndex("w_date"));
                        String time = cursor.getString(cursor
                                .getColumnIndex("w_DateTime"));
                        String img = cursor.getString(cursor
                                .getColumnIndex("w_img"));
                        String quantity = cursor.getString(cursor
                                .getColumnIndex("w_quantityML"));


                        if(strTempDate.equalsIgnoreCase(date))
                        {
                            //totalSameDateRow = cursor.getCount();
                            //totalSameDateRow = totalSameDateRow+1;
                            //App.showLog(TAG, "1"+totalSameDateRow);
                        }
                        else
                        {
                            strTempDate = date;
                            quantityTotal = "0";

                            String selectQueryNew = "SELECT w_id FROM " + TABLE_NAME_DRINK_LIST + " where w_date='"+date+"'";
                            Cursor c_new = dbs.rawQuery(selectQueryNew, null);
                            c_new.moveToFirst();
                            totalSameDateRow = c_new.getCount();
                            c_new.close();

                            String selectQuery2 = "SELECT *,SUM(w_quantityML) From Drink_List WHERE w_date='"+date+"'";
                            App.showLog("--selectQuery2--","==selectQuery2=="+selectQuery);
                            App.showLog("--selectQuery2--","==selectQuery2=="+selectQuery2);
                            Cursor cursor2 = null;
                            cursor2 = dbs.rawQuery(selectQuery2, null);
                            if (cursor2 != null) {
                                cursor2.moveToFirst();


                                if (cursor2.moveToFirst()) {

                                    do{
                                        quantityTotal = cursor2.getString(cursor2.getColumnIndex("SUM(w_quantityML)"));
                                        App.showLog("Q2","========quantityTotal====="+quantityTotal);
                                        break;

                                    } while (cursor2.moveToNext());
                                }
                            }
                        }

                        try {
                            model.id = id;
                            model.drink_list_date = date;
                            model.drink_list_time = time;
                            model.drink_list_quantityml = quantity;
                            model.drink_list_img = img;
                            model.drink_list_total_ofday_quantityml = quantityTotal;
                            model.totalSameDateRow = String.valueOf(totalSameDateRow);
                            data.add(model);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    } while (cursor.moveToNext());
                }
                cursor.close();
                dbs.close(); // Closing database connection
            }
        } catch (Exception e) {
        }
        return data;
    }

    public ArrayList<WaterTrackerParentModel> getGroupChildData(ArrayList<WaterTrackerChildModel> dateListFromDB) {
        Cursor cursor = null;
        SQLiteDatabase dbs = this.getReadableDatabase();

        ArrayList<WaterTrackerParentModel> list = new ArrayList<WaterTrackerParentModel>();
        ArrayList<WaterTrackerChildModel>  ch_list;

        for (int k = 0; k < dateListFromDB.size(); k++) {

            App.showLog(TAG, "1st: "+dateListFromDB.get(k).drink_list_date);
            App.showLog(TAG, "1st: "+dateListFromDB.get(k).drink_list_quantityml);

            WaterTrackerParentModel obj1 = new WaterTrackerParentModel();
            ch_list  = new ArrayList<WaterTrackerChildModel>();

            obj1.dateGroup = dateListFromDB.get(k).drink_list_date;
            obj1.groupQuantityML = dateListFromDB.get(k).drink_list_quantityml;


            //String selectQuery = "SELECT  * FROM " + TABLE_NAME_DRINK_LIST + " WHERE w_date = '"+ dateListFromDB.get(k).getDrink_list_date() + "'";
            String selectQuery = "SELECT  * FROM " + TABLE_NAME_DRINK_LIST + " WHERE w_date = '"+ dateListFromDB.get(k).drink_list_date + "' ORDER BY w_id DESC";

            cursor = dbs.rawQuery(selectQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                if (cursor.moveToFirst()) {
                    do {

                        String id = cursor.getString(cursor
                                .getColumnIndex("w_id"));
                        String time = cursor.getString(cursor
                                .getColumnIndex("w_DateTime"));
                        String date = cursor.getString(cursor
                                .getColumnIndex("w_date"));
                        String img = cursor.getString(cursor
                                .getColumnIndex("w_img"));
                        String quantity = cursor.getString(cursor
                                .getColumnIndex("w_quantityML"));

                        WaterTrackerChildModel objGetset1 = new WaterTrackerChildModel();
                        objGetset1.id = id;
                        objGetset1.drink_list_time = time;
                        objGetset1.drink_list_date = date;
                        objGetset1.drink_list_img = img;
                        objGetset1.drink_list_quantityml = quantity;
                        ch_list.add(objGetset1);


                    } while (cursor.moveToNext());
                }
            }

            obj1.childItem = ch_list;
            list.add(obj1);

        }
        //cursor.close();
        dbs.close(); // Closing database connection

        App.showLog(TAG, "listsize:"+list.size());
        return list;

    }




}

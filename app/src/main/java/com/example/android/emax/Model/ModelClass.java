package com.example.android.emax.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * model class is created here
 */

public class ModelClass implements Parcelable {

    public static final Creator<ModelClass> CREATOR = new Creator<ModelClass>() {
        @Override
        public ModelClass createFromParcel(final Parcel in) {
            return new ModelClass(in);
        }

        @Override
        public ModelClass[] newArray(final int size) {
            return new ModelClass[size];
        }
    };

    private String mdate;
    private String mdistance;
    private String mname;
    private String mdetils;
    private String mdestination;
    private String mrideTime;
    private String mtotalAmount;
    private  String mnumber;

    /**
     *
     * @param date date of ride
     * @param distance distance of ride
     * @param details details of pick up location
     * @param destination details of destination
     * @param rideTime total ride time
     * @param totalAmount total amount word display
     * @param number amount in number displayed
     */
    public ModelClass(final String date, final String distance, final String details, final String destination,
                      final String rideTime, final String totalAmount, final String number) {
        this.mdate = date;
        this.mdistance = distance;
        this.mdetils = details;
        this.mdestination = destination;
        this.mrideTime = rideTime;
        this.mtotalAmount = totalAmount;
        this.mnumber = number;

    }

    /**
     *
     * @param date date of ride
     * @param distance distance of ride
     * @param name name of driver
     * @param details details of pick up location
     */
    public ModelClass(final String date, final String distance, final String name, final String details) {
        this.mdate = date;
        this.mdistance = distance;
        this.mname = name;
        this.mdetils = details;
    }

    /**
     *
     * @param in input
     */
    protected ModelClass(final Parcel in) {
        mdate = in.readString();
        mdistance = in.readString();
        mname = in.readString();
        mdetils = in.readString();
        mdestination = in.readString();
        mrideTime = in.readString();
        mtotalAmount = in.readString();
        mnumber = in.readString();
    }

    /**
     *
     * @return date
     */
    public String getMdate() {
        return mdate;
    }

    /**
     *
     * @return distance
     */

    public String getMdistance() {
        return mdistance;
    }

    /**
     *
     * @return name
     */

    public String getMname() {
        return mname;
    }

    /**
     *
     * @return details
     */

    public String getMdetils() {
        return mdetils;
    }

    /**
     *
     * @return destination
     */

    public String getMdestination() {
        return mdestination;
    }

    /**
     *
     * @return ridetime
     */

    public String getMrideTime() {

        return mrideTime;
    }

    /**
     *
     * @return total amount word
     */

    public String getMtotalAmount() {
        return mtotalAmount;
    }

    /**
     *
     * @return total amount in  number
     */

    public String getMnumber() {
        return  mnumber;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mdate);
        dest.writeString(mdistance);
        dest.writeString(mname);
        dest.writeString(mdetils);
        dest.writeString(mdestination);
        dest.writeString(mrideTime);
        dest.writeString(mtotalAmount);
        dest.writeString(mnumber);
    }
}

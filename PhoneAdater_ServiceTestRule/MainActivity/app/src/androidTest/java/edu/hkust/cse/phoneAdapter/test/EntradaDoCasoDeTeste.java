package edu.hkust.cse.phoneAdapter.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Bento Rafael Siqueir on 20/12/2015.
 */
public class EntradaDoCasoDeTeste {

    private boolean mGpsAvailable = false;
    private String mLocation = "0.0,0.0";
    private  double mSpeed = 0;
    private String[] mBtDeviceList;
    private String mTime = "00:00:00";
    String mWeekday = "sunday";

    public boolean getmGpsAvailable() {
        return mGpsAvailable;
    }

    public void setmGpsAvailable(boolean mGpsAvailable) {
        this.mGpsAvailable = mGpsAvailable;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public double getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(String lastLoc, String curLoc, int duration) {
        double d=calculateDist(lastLoc, curLoc);
        double result=d/(duration/1000.0);
        this.mSpeed = result;
    }

    //Pode setar o valor direto
    public void setmSpeed(int mSpeed) {
        this.mSpeed = mSpeed;
    }

    public String[] getmBtDeviceList() {
        return mBtDeviceList;
    }

    public void setmBtDeviceList(ArrayList<String> mBtDeviceList) {
        this.mBtDeviceList = transformListToArray(mBtDeviceList);
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        SimpleDateFormat mTimeFormat=new SimpleDateFormat("HH:mm:ss");
        this.mTime = mTimeFormat.format(mTime);
    }

    public String getmWeekday() {
        return this.mWeekday;
    }

    public void setmWeekday(int mWeekday){
        String resultado = "";
        switch (mWeekday) {
            case 1:
                resultado = "sunday";
                break;
            case 2:
                resultado = "monday";
                break;
            case 3:
                resultado = "tuesday";
                break;
            case 4:
                resultado = "wednesday";
                break;
            case 5:
                resultado = "thursday";
                break;
            case 6:
                resultado = "friday";
                break;
            case 7:
                resultado = "saturday";
                break;
            default:
                break;
        }
        this.mWeekday = resultado;
    }


    private String[] transformListToArray(ArrayList<String> list){
        String[] s=new String[list.size()];
        for(int i=0;i<list.size();i++){
            s[i]=list.get(i);
        }
        return s;
    }

    /**
     * Calculate distance between two GPS coordinates.
     *
     * @param lastLoc the coordinate (lat, lon) of the previously sensed location
     * @param curLoc the coordinate of the current location
     * @return the distance between two GPS coordinates
     */
    public static double calculateDist(String lastLoc, String curLoc){
        double lat1=0.0;
        double lat2=0.0;
        double long1=0.0;
        double long2=0.0;
        String[] temp=lastLoc.split(",");
        if(temp.length==2){
            lat1=Double.parseDouble(temp[0]);
            long1=Double.parseDouble(temp[1]);
        }

        temp=curLoc.split(",");
        if(temp.length==2){
            lat2=Double.parseDouble(temp[0]);
            long2=Double.parseDouble(temp[1]);
        }

		/*transform to radians */
        lat1=(lat1*Math.PI)/180.0;
        lat2=(lat2*Math.PI)/180.0;
        long1=(long1*Math.PI)/180.0;
        long2=(long2*Math.PI)/180.0;

        double dlat=lat2-lat1;
        double dlong=long2-long1;
        double a= Math.sin(dlat/2)*Math.sin(dlat/2)+Math.sin(dlong/2)*Math.sin(dlong/2)*Math.cos(lat1)*Math.cos(lat2);
        double c=2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d=6371*c;
        return d;
    }
}

package com.functionalpractice.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by nichol on 15/11/13.
 */
public class Picture  implements Parcelable{


    protected Picture(Parcel in) {
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}

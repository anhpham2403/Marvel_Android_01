package com.framgia.moviedb.data.model;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anh on 16/09/2017.
 */

public class Productor extends BaseModel implements Parcelable {
    public static final Creator<Productor> CREATOR = new Creator<Productor>() {
        @Override
        public Productor createFromParcel(Parcel in) {
            return new Productor(in);
        }

        @Override
        public Productor[] newArray(int size) {
            return new Productor[size];
        }
    };
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("logo_path")
    @Expose
    private String mLogoUrl;

    protected Productor(Parcel in) {
        setId(in.readInt());
        mName = in.readString();
        mLogoUrl = in.readString();
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getLogoUrl() {
        return mLogoUrl;
    }

    public void setLogoURL(String logoUrl) {
        mLogoUrl = logoUrl;
        notifyPropertyChanged(BR.logoUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(mName);
        parcel.writeString(mLogoUrl);
    }
}

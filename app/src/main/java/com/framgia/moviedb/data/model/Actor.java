package com.framgia.moviedb.data.model;

import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.moviedb.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by anh on 16/09/2017.
 */

public class Actor extends BaseModel implements Parcelable {
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("profile_path")
    @Expose
    private String mAvatarUrl;
    @SerializedName("birthday")
    @Expose
    private Date mBirthday;
    @SerializedName("biography")
    @Expose
    private String mBiography;
    @SerializedName("place_of_birth")
    @Expose
    private String PlaveOfBirth;

    protected Actor(Parcel in) {
        setId(in.readInt());
        mName = in.readString();
        mAvatarUrl = in.readString();
        mBiography = in.readString();
        PlaveOfBirth = in.readString();
        mBirthday = new Date(in.readLong());
    }

    public static final Creator<Actor> CREATOR = new Creator<Actor>() {
        @Override
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
        notifyPropertyChanged(BR.avatarUrl);
    }
@Bindable
    public Date getBirthday() {
        return mBirthday;
    }

    public void setBirthday(Date birthday) {
        mBirthday = birthday;
        notifyPropertyChanged(BR.birthday);
    }
    @Bindable
    public String getBiography() {
        return mBiography;
    }

    public void setBiography(String biography) {
        mBiography = biography;
        notifyPropertyChanged(BR.biography);
    }
    @Bindable
    public String getPlaveOfBirth() {
        return PlaveOfBirth;
    }

    public void setPlaveOfBirth(String plaveOfBirth) {
        PlaveOfBirth = plaveOfBirth;
        notifyPropertyChanged(BR.plaveOfBirth);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(getId());
        parcel.writeString(mName);
        parcel.writeString(mAvatarUrl);
        parcel.writeString(mBiography);
        parcel.writeString(PlaveOfBirth);
        parcel.writeLong(mBirthday.getTime());
    }
}
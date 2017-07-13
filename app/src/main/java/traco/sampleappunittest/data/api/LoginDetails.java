package traco.sampleappunittest.data.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by tikson.tom on 5/31/2017.
 */

public class LoginDetails {
    @SerializedName("iStatusCode")
    @Expose
    public int iStatusCode;

    @SerializedName("sResult")
    @Expose
    public LoginResult sResult;
    @SerializedName("sMessage")
    @Expose
    public String sMessage;

    public int getiStatusCode() {
        return iStatusCode;
    }

    public void setiStatusCode(int iStatusCode) {
        this.iStatusCode = iStatusCode;
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public class LoginResult {
        @SerializedName("UserID")
        @Expose
        public int UserID;

        @SerializedName("Fullname")
        @Expose
        public String Fullname;

        public boolean getUserFlag() {
            return userFlag;
        }

        public void setUserFlag(boolean userFlag) {
            this.userFlag = userFlag;
        }

        @SerializedName("bNormaluser")
        @Expose
        public boolean  userFlag;
        @SerializedName("ProfileImagePath")
        @Expose
        public String ProfileImagePath;

        @SerializedName("mobilenumber")
        @Expose
        public String mobilenumber;

        public int getUserID() {
            return UserID;
        }

        public void setUserID(int userID) {
            UserID = userID;
        }

        public String getFullname() {
            return Fullname;
        }

        public void setFullname(String fullname) {
            Fullname = fullname;
        }

        public String getProfileImagePath() {
            return ProfileImagePath;
        }

        public void setProfileImagePath(String profileImagePath) {
            ProfileImagePath = profileImagePath;
        }

        public String getMobilenumber() {
            return mobilenumber;
        }

        public void setMobilenumber(String mobilenumber) {
            this.mobilenumber = mobilenumber;
        }

        public String getEmailid() {
            return emailid;
        }

        public void setEmailid(String emailid) {
            this.emailid = emailid;
        }

        @SerializedName("emailid")
        @Expose
        public String emailid;

    }

}

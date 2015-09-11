package remmievail.com.recyclerviewexample.model;

public class Contact {
    private String mFirstName;
    private String mLastName;
    private String mEmail;

    public Contact() {
        mFirstName = "";
        mLastName = "";
        mEmail = "";
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }
}

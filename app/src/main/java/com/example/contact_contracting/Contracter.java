package com.example.contact_contracting;

public class Contracter {
    private String mContarcterNmae;
    private String mContracterAddress;
    private int mImageResourceId;
    public Contracter(String contracterNmae, String contracterAddress,int imageResourceId){
        mContarcterNmae=contracterNmae;
        mContracterAddress=contracterAddress;
        mImageResourceId=imageResourceId;
    }
    public String getmContarcterNmae(){
        return mContarcterNmae;
    }
    public String getmContracterAddress(){
        return mContracterAddress;
    }
    public int getmImageResourceId(){
        return mImageResourceId;
    }

}

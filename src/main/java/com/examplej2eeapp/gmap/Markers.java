package com.examplej2eeapp.gmap;


import java.io.Serializable;

public class Markers implements Serializable  {
private static final long serialVersionUID = -8789920473809744548L;
	int id; 
	double longpos; 
	double latpos; 
	String city;
	String street ;
	String title;
	   @Override
	   public String toString() {
	        return ("Id:"+this.getId()+
	                    " LongPos "+ this.getlongpos() +
	                    " LatPos: "+ this.getlatpos() +
	                    " City : " + this.getcity())+
	        		" Street : " + this.getStreet()+
						" Title : " + this.getTitle();
	   }
	   
	
    public Markers(int id, double longpos, double latpos,String city,String street ,String title) {
         this.id = id;
         this.longpos = longpos;
         this.latpos = latpos;
         this.city = city;
         this.street = street;
         this.title = title;
    }

    public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
         return id;
    }
    public void setId(int id) {
	this.id = id;
    }
    public double getlongpos() {
        return longpos;
   }
   public void setlongpos(double longpos) {
	this.longpos = longpos;
   }
   public double getlatpos() {
       return latpos;
  }
  public void setlatpos(double latpos) {
	this.latpos = latpos;
  }
  public String getcity() {
      return city;
 }
 public void setcity(String city) {
	this.city = city;
	
	
 }
   
}
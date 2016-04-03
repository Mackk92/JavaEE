package com.examplej2eeapp.gmap;

import java.io.Serializable;



import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.google.gson.Gson;




@ManagedBean
@ViewScoped
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4986785986810420408L;

	private MapModel advancedModel;
	public    Marker[] newMarkers ;
	private Marker marker;

	String[][] list = new String[5][3];

	public Boolean ingATM = true;

	public Boolean bzwbkATM = true;

	
	public ArrayList<Markers> arraylistBZWBK = new ArrayList<Markers>();
	public ArrayList<Markers> arraylistING = new ArrayList<Markers>();

	public Test() throws ClassNotFoundException, SQLException {

		DataBase dat = new DataBase();
		dat.setQuary("SELECT LatPosLongPos,Miasto,Ulica,Nazwa FROM ATMBZWBKFINALL");
		dat.start();
		ResultSet rs = dat.getRs();
		while (rs.next()) {

			String result1 = rs.getString(1).substring(10, 19);
			String result2 = rs.getString(1).substring(0, 9);
			
			arraylistBZWBK.add(new Markers(1, Double.parseDouble(result1), Double.parseDouble(result2), rs.getString(2),
					rs.getString(3), rs.getString(4)));
		}
		dat.con.close();

		dat.setQuary("SELECT LatPos,LongPos,Miasto,Ulica,Tytul FROM ATMINGFINALL");
		dat.start();
		rs = dat.getRs();
		while (rs.next()) {

			arraylistING.add(new Markers(1, Double.parseDouble(rs.getString(2)), Double.parseDouble(rs.getString(1)),
					rs.getString(3), rs.getString(4), rs.getString(5)));
		}

		
	}
	@PostConstruct
	public void init(){
		
			advancedModel = new DefaultMapModel();
		if (bzwbkATM) {
			for (Markers p : arraylistBZWBK) {

				marker = new Marker(new LatLng(p.getlatpos(), p.getlongpos()));
				marker.setTitle(p.getTitle());
				marker.setIcon("http://maps.google.com/mapfiles/ms/micons/green-dot.png");
				advancedModel.addOverlay(marker);

			}
		}

		if (ingATM) {

			for (Markers p1 : arraylistING) {

				marker = new Marker(new LatLng(p1.getlatpos(), p1.getlongpos()));
				marker.setTitle(p1.getTitle());
				marker.setIcon("http://maps.google.com/mapfiles/ms/micons/orange-dot.png");
				advancedModel.addOverlay(marker);

			}

		}
	}

	public MapModel getAdvancedModel() {
		return advancedModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }
	public void onINGATMselect() {
		
		advancedModel = null;
		System.out.println("ing "+ingATM);
		init();
	}
	public void onBZWBKATMselect() {
		
		advancedModel = null;
		System.out.println("bzwb "+bzwbkATM);
		init();
	}
	public Boolean getBzwbkATM() {
		return bzwbkATM;
	}

	public void setBzwbkATM(Boolean bzwbkATM) {
		this.bzwbkATM = bzwbkATM;
	}
	public Boolean getIngATM() {
		return ingATM;
	}

	public void setIngATM(Boolean ingATM) {
		this.ingATM = ingATM;
	}


	 
	 public void ajaxPoll() {
	     
	      
	        newMarkers = new Marker[advancedModel.getMarkers().size()];
	        
	        for(int i=0;i < newMarkers.length;i++){
	            newMarkers[i]=advancedModel.getMarkers().get(i);
	        }
	        RequestContext.getCurrentInstance().addCallbackParam("newMarkers",new Gson().toJson(newMarkers));
	       
	       }
	public Marker[] getNewMarkers() {
		return newMarkers;
	}
	public void setNewMarkers(Marker[] newMarkers) {
		this.newMarkers = newMarkers;
	}
	 
	
}

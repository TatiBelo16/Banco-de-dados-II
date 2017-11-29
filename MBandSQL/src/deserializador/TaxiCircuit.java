package deserializador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;


public class TaxiCircuit {
	
	private int placa;
	private Date data;
	private String latitude ;
	private String longetude;
	
	
	public TaxiCircuit(int placa, Date data, String latitude, String longetude) {
		super();
		this.placa = placa;
		this.data = data;
		this.latitude = latitude;
		this.longetude = longetude;
	}


	
	
	public TaxiCircuit() {
		super();
	}




	public int getId() {
		return placa;
	}




	public void setId(int id) {
		this.placa = id;
	}

	public Date getData() {
		return data;
	}




	public void setData(Date data) {
		this.data = data;
	}




	public String getLatitude() {
		return latitude;
	}




	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}




	public String getLongetude() {
		return longetude;
	}




	public void setLongetude(String longetude) {
		this.longetude = longetude;
	}




	@Override
	public String toString() {
		return "TaxiCircuit [id=" + placa + ", data=" + data + ", latitude=" + latitude + ", longetude=" + longetude + "]";
	}
	
	
	

	
	
	

}

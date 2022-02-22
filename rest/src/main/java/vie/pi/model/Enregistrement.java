package vie.pi.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Enregistrement {
	
	private int id ;
	private String label;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Enregistrement [id=" + id + ", label=" + label + ", date=" + date + "]";
	}
	public Enregistrement(int id, String label, Date date) {
		super();
		this.id = id;
		this.label = label;
		this.date = new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	public Enregistrement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

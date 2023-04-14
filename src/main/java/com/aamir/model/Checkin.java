package com.aamir.model;
 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
 
@Entity
public class Checkin {
 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "checkinId")
    @SequenceGenerator(name = "checkinId", sequenceName = "checkin_id_seq", allocationSize = 1)
    private int checkinId;
    private int custId;
	private int packages;
    private int charges;

    public Checkin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Checkin(int checkinId, int custId, int packages, int charges) {
		super();
		this.checkinId = checkinId;
		this.custId = custId;
		this.packages = packages;
		this.charges = charges;
	}
 
    public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public void setPackages(int packages) {
		this.packages = packages;
	}

	public void setCharges(int charges) {
		this.charges = charges;
	}

	public int getCheckinId() {
        return checkinId;
    }
 
    public void setCheckinId(int checkinId) {
        this.checkinId = checkinId;
    }
 
    public int getPackages() {
        return packages;
    }
 
    public void setPack(int packages) {
        this.packages = packages;
    }
    
    public int getCharges() {
        return charges;
    }
 
    public void setCharge(int charges) {
        this.charges = charges;
    }
 
    @Override
	public String toString() {
		return "Checkin [checkinId=" + checkinId + ", custId=" + custId + ", packages=" + packages
				+ ", charges=" + charges + "]";
	}
 
}
package com.spring.myapp.reviewlike;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("reviewlikeres")
@Data
public class Reviewlikeres {
	
	private int reviewid;
	
	private String useraccount;

	public Reviewlikeres(int reviewid, String useraccount) {
		super();
		this.reviewid = reviewid;
		this.useraccount = useraccount;
	}

	public Reviewlikeres() {
		super();
	}

	

}

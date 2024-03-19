package com.spring.myapp.reviewlike;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("reviewlike")
@Data
public class Reviewlike {
	
	private int reviewid;

	private String useraccount;

	public Reviewlike(int reviewid, String useraccount) {
		super();
		this.reviewid = reviewid;
		this.useraccount = useraccount;
	}

	public Reviewlike() {
		super();
	}

}

package com.midmarsh.spring.beans;

import org.springframework.stereotype.Component;

@Component("regionDAO")
public class RegionDAO {

	public String getRegion() {
		return "Region1";
	}
	
}

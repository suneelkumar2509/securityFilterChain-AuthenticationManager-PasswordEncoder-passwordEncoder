package com.springbootsunilblog.springbootsunilblog.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CovidDTO {
	

	    public int date;
	    public int states;
	    public int positive;
	    public int negative;
	    public int pending;
	    public int hospitalizedCurrently;
	    public int hospitalizedCumulative;
	    public int inIcuCurrently;
	    public int inIcuCumulative;
	    public int onVentilatorCurrently;
	    public int onVentilatorCumulative;
	    public Date dateChecked;
	    public int death;
	    public int hospitalized;
	    public int totalTestResults;
	    public Date lastModified;
	    public Object recovered;
	    public int total;
	    public int posNeg;
	    public int deathIncrease;
	    public int hospitalizedIncrease;
	    public int negativeIncrease;
	    public int positiveIncrease;
	    public int totalTestResultsIncrease;
	    public String hash;
	    


}

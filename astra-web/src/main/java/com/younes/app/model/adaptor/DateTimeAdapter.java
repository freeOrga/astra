package com.younes.app.model.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

public class DateTimeAdapter extends XmlAdapter<String, DateTime> {

    //private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public DateTime unmarshal(String v) throws Exception {
        return new DateTime(v);
    }
 
    public String marshal(DateTime v) throws Exception {
        return v.toString("yyyy-MM-dd HH:mm:ss");
    }
}

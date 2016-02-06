package com.younes.app.model.adaptor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;

public class DateAdapter extends XmlAdapter<String, DateTime> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public String marshal(DateTime v) throws Exception {
        return dateFormat.format(v);
    }

    @Override
    public DateTime unmarshal(String v) throws Exception {
        return new DateTime(dateFormat.parse(v));
    }

}

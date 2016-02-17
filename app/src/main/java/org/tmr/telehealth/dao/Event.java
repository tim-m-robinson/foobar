package org.tmr.telehealth.dao;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by tmr on 10/02/2016.
 */
public class Event {

    private Date    _event_date = new Date(0L);
    private Long    _duration_sec = 0L;
    private String  _location = "";
    private String  _event_title = "";
    private String  _event_desc = "";

    public Date get_event_date() {
        return _event_date;
    }

    public void set_event_date(Date _event_date) {
        this._event_date = _event_date;
    }

    public Long get_duration_sec() {
        return _duration_sec;
    }

    public void set_duration_sec(Long _duration_sec) {
        this._duration_sec = _duration_sec;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public String get_event_title() {
        return _event_title;
    }

    public void set_event_title(String _event_title) {
        this._event_title = _event_title;
    }

    public String get_event_desc() {
        return _event_desc;
    }

    public void set_event_desc(String _event_desc) {
        this._event_desc = _event_desc;
    }

    public static Event parseJsonString (String s) throws JSONException,javax.xml.datatype.DatatypeConfigurationException {
        if (s == null) return null;
        Event result = new Event();

        JSONObject json = new JSONObject(s);

        return Event.parseJson(json);
    }

    public static Event parseJson (JSONObject json) throws JSONException {
        if (json == null) return null;
        Event result = new Event();
        DateTimeFormatter dtf = ISODateTimeFormat.dateTimeParser();

        result.set_event_date(dtf.parseDateTime(json.getString("event_date_iso8601")).toDate());
        result.set_duration_sec((long) json.getInt("duration_sec"));
        result.set_event_desc(json.getString("event_desc"));
        result.set_event_title(json.getString("event_title"));
        result.set_location(json.getString("location"));

        return result;
    }

    public String toString() {
        String result = "";

        result+=get_event_date().toString()+"\n";
        result+=get_duration_sec().toString()+"\n";
        result+=get_event_title()+"\n";
        result+=get_event_desc()+"\n";
        result+=get_location()+"\n";

        return result;
    }
}

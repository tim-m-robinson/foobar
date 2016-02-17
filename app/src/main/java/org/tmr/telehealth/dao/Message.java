package org.tmr.telehealth.dao;

/**
 * Created by tmr on 10/02/2016.
 */
public class Message {

    private String _from = "";
    private String _to = "";
    private String _send_date = "";
    private String _message_text = "";

    public String get_from() {
        return _from;
    }

    public void set_from(String _from) {
        this._from = _from;
    }

    public String get_to() {
        return _to;
    }

    public void set_to(String _to) {
        this._to = _to;
    }

    public String get_send_date() {
        return _send_date;
    }

    public void set_send_date(String _send_date) {
        this._send_date = _send_date;
    }

    public String get_message_text() {
        return _message_text;
    }

    public void set_message_text(String _message_text) {
        this._message_text = _message_text;
    }
}

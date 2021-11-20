package com.example.diaryproject.Model;

import androidx.lifecycle.ViewModel;

import com.example.diaryproject.DataUtil.DateFormat;

public class CalendarHeader extends ViewModel {
    String header;
    long mCurrentTime;

    public CalendarHeader() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(long time) {

        String value = DateFormat.getDate(time, DateFormat.CALENDAR_HEADER_FORMAT);
        this.header = value;

    }

    public void setHeader(String header) {

        this.header = header;

    }

}

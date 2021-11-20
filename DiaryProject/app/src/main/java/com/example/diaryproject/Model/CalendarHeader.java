package com.example.diaryproject.Model;

import androidx.lifecycle.ViewModel;

import com.example.diaryproject.DataUtil.DateFormat;

public class CalendarHeader extends ViewModel {
    String header;

    public CalendarHeader() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(long time) {

        String value = DateFormat.getDate(time, DateFormat.YEAR_MONTH_FORMAT);
        this.header = value;

    }

    public void setHeader(String header) {

        this.header = header;

    }

}

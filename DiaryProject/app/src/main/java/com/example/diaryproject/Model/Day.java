package com.example.diaryproject.Model;

import androidx.lifecycle.ViewModel;

import com.example.diaryproject.DataUtil.DateFormat;

import java.util.Calendar;

public class Day extends ViewModel {
    String day;

    public Day() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    // TODO : day에 달력일값넣기
    public void setCalendar(Calendar calendar){

        day = DateFormat.getDate(calendar.getTimeInMillis(), DateFormat.DAY_FORMAT);

    }
}

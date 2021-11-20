package com.example.diaryproject.MainFragment;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.diaryproject.Adapter.CalendarAdapter;
import com.example.diaryproject.DataUtil.DateFormat;
import com.example.diaryproject.DataUtil.Keys;
import com.example.diaryproject.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarFragment extends Fragment {

    public CalendarFragment() {
    }

    public int mCenterPosition;
    private long mCurrentTime;
    public ArrayList<Object> mCalendarList = new ArrayList<>();

    public TextView tvYearMonDay;
    public RecyclerView rvCalendar;
    private CalendarAdapter mAdapter;
    private StaggeredGridLayoutManager manager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup vgViewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_calendar, container, false);

        // Controler설정
        initView(vgViewGroup);
        // Calendar 설정
        initSet();
        // Calendar 설정
        setRecycler();

        return vgViewGroup;
    }

    public void initView(View v){
        tvYearMonDay = v.findViewById(R.id.tvYearMonDay);
        rvCalendar = v.findViewById(R.id.rvCalendar);
    }

    public void initSet(){

        initCalendarList();

    }

    public void initCalendarList() {
        GregorianCalendar cal = new GregorianCalendar();
        setCalendarList(cal);
    }

    public void setCalendarList(GregorianCalendar cal) {

        String sYearMonDay = DateFormat.getDate(cal.getTimeInMillis(), DateFormat.CALENDAR_HEADER_FORMAT);
        tvYearMonDay.setText(sYearMonDay);

        ArrayList<Object> calendarList = new ArrayList<>();

        int iNextMonth = 1;

        try {
            GregorianCalendar calendar = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);

            GregorianCalendar Frcalendar = new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,1);

            mCenterPosition = calendarList.size();


            // 타이틀인듯
            calendarList.add(calendar.getTimeInMillis());

            int iBlackStart = calendar.get(Calendar.DAY_OF_WEEK) - 1; //해당 월에 시작하는 요일 -1 을 하면 빈칸을 구할 수 있겠죠 ?
            int iDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 월에 마지막 요일
            int iBlackEnd = 7 - calendar.get(Frcalendar.DAY_OF_WEEK);

            // EMPTY 생성
            for (int i = 0; i < iBlackStart; i++) {
                calendarList.add(Keys.EMPTY);
            }
            for (int i = 1; i <= iDay; i++) {
                calendarList.add(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), i));
            }
            for (int i = 1; i < iBlackEnd; i++) {
                calendarList.add(Keys.EMPTY);
            }

            // TODO : 결과값 넣을떄 여기다하면될듯

        } catch (Exception e) {
            e.printStackTrace();
        }


        mCalendarList = calendarList;
    }

    private void setRecycler() {

        manager = new StaggeredGridLayoutManager(7, StaggeredGridLayoutManager.VERTICAL);

        mAdapter = new CalendarAdapter(mCalendarList);

        mAdapter.setCalendarList(mCalendarList);
        rvCalendar.setLayoutManager(manager);
        rvCalendar.setAdapter(mAdapter);

        if (mCenterPosition >= 0) {
            rvCalendar.scrollToPosition(mCenterPosition);
        }
    }

}
package com.example.samsung.p0441_simplelistevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    ListView lvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //ищем список
        lvMain = (ListView) findViewById(R.id.lvMain);
        //создаём адаптер
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names, android.R.layout.simple_expandable_list_item_1);
        //устанавливаем адаптер на список
        lvMain.setAdapter(adapter);
        //устанавливаем на список слушатель нажатий элементов
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemClick: pposition = " + position + ", id = " + id);
            }
        });
        //устанавливаем на список слушатель выбора элементов
        lvMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(LOG_TAG, "itemSelect: position = " + position + ", id = " + id);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d(LOG_TAG, "itemSelect: nothing");
            }
        });
        //устанавливаем на список слушатель его прокрутки
        lvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.d(LOG_TAG, "scrollState = " + scrollState
                        + (scrollState == 0 ? " - список закончил прокрутку" :
                           scrollState == 1 ? " - список начал прокрутку" :
                                              " - список \"катнули\" и прокрутка дальше идёт \"по инерции\""));
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.d(LOG_TAG, "scroll: firstVisibleItem = " + firstVisibleItem
                        + ", visibleItemCount = " + visibleItemCount
                        + ", totalItemCount = " + totalItemCount);
            }
        });
    }
}

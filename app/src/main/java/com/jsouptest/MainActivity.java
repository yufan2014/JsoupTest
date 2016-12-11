package com.jsouptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.menu_list)
    TextView menuList;
    @Bind(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        init();
    }

    private void init() {

        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.mzitu.com").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements menu = doc.getElementsByClass("menu");
        String title_str = "";
        for (Element title : menu) {
            title_str+=title+"/n";
        }
        menuList.setText(title_str);
    }
}

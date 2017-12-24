package com.dangxy.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.dangxy.androidpractice.fragment.GankActivity;
import com.dangxy.androidpractice.fragment.ReadhubFragment;
import com.dangxy.androidpractice.readhub.ReadHubActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/23
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.gank)
    Button gank;
    @BindView(R.id.Readhub)
    Button Readhub;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //在Activity中添加fragment
        getSupportFragmentManager().beginTransaction().add(R.id.fl, ReadhubFragment.newInstance(), "readhub").commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.gank, R.id.Readhub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gank:
                intent = new Intent(this, GankActivity.class);
                startActivity(intent);

                break;
            case R.id.Readhub:
                intent = new Intent(this, ReadHubActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}

package com.example.android.emax;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.emax.fragements.JobFragement;

/**
 * home activity is created
 */
public class HomeActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ImageView i;
    private TextView job;
    private JobFragement jobFragement = new JobFragement();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        job = (TextView) findViewById(R.id.tv_jobHistory);
        i = (ImageView) findViewById(R.id.imageViewCustom);

        i.setImageResource(R.drawable.btn_menu_blue);

        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {

                //mDrawerLayout.openDrawer(l);
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        job.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                mDrawerLayout.closeDrawer(Gravity.START);
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.framelayout, jobFragement);
                ft.commit();
            }
        });


    }
}

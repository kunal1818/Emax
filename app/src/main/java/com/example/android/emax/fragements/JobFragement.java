package com.example.android.emax.fragements;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android.emax.R;

/**
 * main fragement of job history button
 */
public class JobFragement extends Fragment {
    private DrawerLayout mDrawerLayout;
    private ImageView i;
    private Button btn1jobHistory, btn2missedJob;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_job_fragement, container, false);
        i = (ImageView) getActivity().findViewById(R.id.imageViewCustom);
        i.setImageResource(R.drawable.btn_menu_blue);
        mDrawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);

        i.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                mDrawerLayout.openDrawer(Gravity.START);
            }
        });

        final ViewPager vp = (ViewPager) view.findViewById(R.id.viewpager);
        vp.setAdapter(new MyPagerAdapter(getChildFragmentManager()));


        btn1jobHistory = (Button) view.findViewById(R.id.btn_jobHistory);
        btn2missedJob = (Button) view.findViewById(R.id.btn_missedJobs);
        btn1jobHistory.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                btn1jobHistory.setBackgroundResource(R.color.blue);
                btn2missedJob.setBackgroundResource(R.color.colorPrimaryDark);
                vp.setCurrentItem(0);

            }
        });

        btn2missedJob.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                btn1jobHistory.setBackgroundResource(R.color.colorPrimaryDark);
                btn2missedJob.setBackgroundResource(R.color.blue);
                vp.setCurrentItem(1);
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                switch (position) {
                    case 0:
                        btn1jobHistory.setBackgroundResource(R.color.blue);
                        btn2missedJob.setBackgroundResource(R.color.colorPrimaryDark);
                        break;
                    case 1:
                        btn1jobHistory.setBackgroundResource(R.color.colorPrimaryDark);
                        btn2missedJob.setBackgroundResource(R.color.blue);
                        break;
                    default:
                        btn1jobHistory.setBackgroundResource(R.color.blue);
                        btn2missedJob.setBackgroundResource(R.color.colorPrimaryDark);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        return view;

    }

    /**
     * page adapter class fragement created here
     */
    class MyPagerAdapter extends FragmentPagerAdapter {
        /**
         *
         * @param fm fragement manager is created here
         */

        public MyPagerAdapter(final FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(final int position) {
            switch (position) {
                case 0:
                    return new JobHistoryFragement();
                case 1:
                    return new MissedJobFragement();
                default:
                    return new JobHistoryFragement();
            }


        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}

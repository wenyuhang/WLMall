package com.wl.wlmall.ui.user;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gyf.immersionbar.ImmersionBar;
import com.wl.wlmall.R;
import com.wl.wlmall.adapter.FragmentViewPager;
import com.wl.wlmall.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * create by wyh on 2018/12/29
 * 个人中心
 */

public class UserFragment extends BaseFragment {


    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
//    @BindView(R.id.view)
//    Toolbar view;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void init(View view) {
//        ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
//        layoutParams.height = SystemUtils.getInstance().getStatusBarHeight(getActivity());
//        toolbar.setLayoutParams(layoutParams);

        //设置ToolBar
//        ImmersionBar.setTitleBar(this, view);


        toolbarLayout.post(() -> {
            int offHeight = toolbarLayout.getHeight() - ImmersionBar.getStatusBarHeight(this);
            appBar.addOnOffsetChangedListener((appBarLayout1, i) -> {
                ImmersionBar.with(this).statusBarDarkFont(Math.abs(i) >= offHeight, 0.2f).init();
            });
        });
//        GlideUtils.load(Utils.getPic(), imgBackground);

        //设置TabLayout
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new UserAdmireFragment());
        fragments.add(new UserVideoFragment());
        FragmentViewPager viewpagerAdapter = new FragmentViewPager(getActivity().getSupportFragmentManager(), fragments, null);
        viewpager.setAdapter(viewpagerAdapter);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewpager);


        //改变颜色
//        ImmersionBar.with(this)
//                .statusBarView(R.id.view)
//                .navigationBarColor(android.R.color.holo_red_dark)
//                .autoDarkModeEnable(true, 0.2f)
//                .init();
    }


}

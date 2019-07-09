package com.wl.wlmall.ui.follow;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * create by wyh on 2018/12/29
 */

public class FollowFragment extends BaseFragment  {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title_follow)
    TextView tvTitleFollow;
    @BindView(R.id.tv_title_push)
    TextView tvTitlePush;
    @BindView(R.id.btn_look_video)
    Button btnLookVideo;
    @BindView(R.id.btn_follower)
    ImageView btnFollower;
    @BindView(R.id.btn_add_follow)
    ImageView btnAddFollow;
    private FollowListFragment followListFragment;
    private AddFollowerFragment addFollowerFragment;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mall;
    }

    @Override
    protected void init(View view) {
        ImmersionBar.with(this)
                .navigationBarColor(R.color.white_a_color)
                .init();
        selectFragment(true);

    }

    /**
     * 是否添加
     *
     * @param type       true  FollowListFragment / flase  AddFollowerFragment
     */
    private void selectFragment(boolean type) {
        FragmentManager fragmentmanager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentmanager.beginTransaction();
        hideFragment(transaction);
//        bottom.setBackgroundColor(ContextCompat.getColor(this, R.color.black_a_color));
        if(type) {
            if (followListFragment == null) {
                followListFragment = new FollowListFragment();
                transaction.add(R.id.frag_content, followListFragment);
            } else {
                transaction.show(followListFragment);
            }
        }else {
            if (addFollowerFragment == null) {
                addFollowerFragment = new AddFollowerFragment();
                transaction.add(R.id.frag_content, addFollowerFragment);
            } else {
                transaction.show(addFollowerFragment);
            }
        }

        transaction.commit();
    }

    /**
     * 隐藏fragment
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (followListFragment != null) {
            transaction.hide(followListFragment);
        }
        if (addFollowerFragment != null) {
            transaction.hide(addFollowerFragment);
        }
    }




    @OnClick({R.id.btn_look_video, R.id.btn_follower, R.id.btn_add_follow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
                //看视频
            case R.id.btn_look_video:
                tvTitleFollow.setVisibility(View.VISIBLE);
                btnAddFollow.setVisibility(View.VISIBLE);
                btnFollower.setVisibility(View.GONE);
                btnLookVideo.setVisibility(View.GONE);
                tvTitlePush.setVisibility(View.GONE);

                selectFragment(true);
                break;
                //查看关注
            case R.id.btn_follower:
                break;
                //添加关注
            case R.id.btn_add_follow:
                tvTitleFollow.setVisibility(View.GONE);
                btnAddFollow.setVisibility(View.GONE);
                btnFollower.setVisibility(View.VISIBLE);
                btnLookVideo.setVisibility(View.VISIBLE);
                tvTitlePush.setVisibility(View.VISIBLE);

                selectFragment(false);
                break;
        }
    }
}
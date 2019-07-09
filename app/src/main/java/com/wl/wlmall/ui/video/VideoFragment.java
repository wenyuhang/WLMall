package com.wl.wlmall.ui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.extras.recyclerview.PullToRefreshRecyclerView;
import com.wl.wlmall.R;
import com.wl.wlmall.base.BaseActivity;
import com.wl.wlmall.base.BaseFragment;
import com.wl.wlmall.desgin.LoveAnimator;
import com.wl.wlmall.desgin.imageWatcher.OnViewPagerListener;
import com.wl.wlmall.desgin.imageWatcher.ViewPagerLayoutManager;
import com.wl.wlmall.desgin.refresh.RefreshHeaderLayout;
import com.wl.wlmall.model.entity.VideoListBean;
import com.wl.wlmall.ui.video.conteact.VideoContract;
import com.wl.wlmall.ui.video.conteact.VideoPresenter;
import com.wl.wlmall.utils.LoadMoreUtils;
import com.wl.wlmall.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * create by wyh on 2018/9/11
 */

public class VideoFragment extends BaseFragment implements PullToRefreshRecyclerView.OnRefreshListener2<RecyclerView>,
        BaseQuickAdapter.RequestLoadMoreListener, VideoContract.View{

    @BindView(R.id.recycler)
    PullToRefreshRecyclerView mRecyclerView;
    @BindView(R.id.img_play)
    ImageView imgPlay;
    private ViewPagerLayoutManager mLayoutManager;
    private static final String TAG = "ViewPagerActivity";
    private VideoListAdapter adapter;
    private RecyclerView rvNews;
    private VideoView videoView;
    private boolean isHide ;       //是否隐藏
    private LoveAnimator loveAnimator;

    private VideoContract.Presenter presenter;
    private ArrayList<VideoListBean.DataBean.RecordsBean> videoLists;

    private int page = 1;
    private int pageSize = 10;
    private List<VideoListBean.DataBean.RecordsBean> data;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void init(View view) {
        new VideoPresenter(this);
        BaseActivity activity = (BaseActivity) getActivity();
        activity.makeStatusBar(R.color.white_a_color, true);
        setAdapter(mRecyclerView,getActivity());
        initListener();
        presenter.getList(page);
    }




    private RecyclerView setAdapter(PullToRefreshRecyclerView refreshLayout, Context context) {
        refreshLayout.setScrollingWhileRefreshingEnabled(true);
        refreshLayout.setHeaderLayout(new RefreshHeaderLayout(context));
        rvNews = refreshLayout.getRefreshableView();
        mLayoutManager = new ViewPagerLayoutManager(getActivity(), OrientationHelper.VERTICAL);
        rvNews.setLayoutManager(mLayoutManager);
        videoLists = new ArrayList<>();
        adapter = new VideoListAdapter(context, videoLists);
//        adapter.setLoadMoreView(new CustomLoadMoreView());
        rvNews.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(VideoFragment.this);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            private  int timeout=400;//双击间四百毫秒延时
            private int clickCount = 0;//记录连续点击次数
            private Handler handler = new Handler();


            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, final View view, int position) {
                clickCount++;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (clickCount == 1) {
                            if (videoView.isPlaying()) {
                                imgPlay.animate().alpha(1f).start();
                                videoView.pause();
                            } else {
                                imgPlay.animate().alpha(0f).start();
                                videoView.start();
                            }
                        }else if(clickCount>=2){
                            loveAnimator = view.findViewById(R.id.layout_love_view);
                            loveAnimator.creatLove();
                        }
                        handler.removeCallbacksAndMessages(null);
                        //清空handler延时，并防内存泄漏
                        clickCount = 0;//计数清零
                    }
                },timeout);//延时timeout后执行run方法中的代码



            }
        });
        return rvNews;

    }


    private void initListener() {
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {

            @Override
            public void onInitComplete() {
                Log.e(TAG, "onInitComplete");
                playVideo(0);
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                Log.e(TAG, "释放位置:" + position + " 下一页:" + isNext);
                int index = 0;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(index);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                Log.e(TAG, "选中位置:" + position + "  是否是滑动到底部:" + isBottom);
                playVideo(0);
            }


        });
    }

    private void playVideo(int position) {
        View itemView = rvNews.getChildAt(0);
        videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final RelativeLayout rootView = itemView.findViewById(R.id.layout_love_view);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(MediaPlayer mp, int what, int extra) {
                    mediaPlayer[0] = mp;
                    mp.setLooping(true);
                    imgThumb.animate().alpha(0).setDuration(200).start();
                    return false;
                }
            });
        }

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if(isHide) {
                    imgPlay.animate().alpha(1f).start();
                    videoView.pause();
                }
            }
        });


        imgPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(1f).start();
                    videoView.pause();
                } else {
                    imgPlay.animate().alpha(0f).start();
                    videoView.start();
                }
            }
        });
    }


    @Override
    protected void onShow() {
        super.onShow();
        isHide = false;
        if (videoView!=null&&!videoView.isPlaying()) {
            imgPlay.animate().alpha(0f).start();
            videoView.start();
        }
    }

    @Override
    protected void onHidden() {
        super.onHidden();
        isHide = true;
        if (videoView!=null&&videoView.isPlaying()) {
            imgPlay.animate().alpha(1f).start();
            videoView.pause();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        isHide = true;
        if (videoView!=null&&videoView.isPlaying()) {
            imgPlay.animate().alpha(1f).start();
            videoView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isHide&&videoView!=null&&!videoView.isPlaying()) {
            imgPlay.animate().alpha(0f).start();
            videoView.start();
        }
        isHide = false;
    }

    private void releaseVideo(int index) {
        View itemView = rvNews.getChildAt(index);
         videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        videoView.stopPlayback();
        if(imgThumb!=null) {
            imgThumb.animate().alpha(1).start();
        }
        imgPlay.animate().alpha(0f).start();
    }
    @Override
    public void onLoadMoreRequested() {
        if(data.size()>=10) {
            page++;
            presenter.getList(page);
        }
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<RecyclerView> refreshView) {
        page = 1;
        presenter.getList(page);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<RecyclerView> refreshView) {

    }

    @Override
    public void showList(VideoListBean videoListBean) {
        data = videoListBean.getData().getRecords();
        LoadMoreUtils.getInstance().setVideoLoadMore(page,pageSize,adapter, data,this,rvNews);
        mRecyclerView.onRefreshComplete();
    }

    @Override
    public void loadFail(String msg) {
        T.s(msg);
    }

    @Override
    public void setRefreshLayoutHide() {
        if (mRecyclerView != null) {
            mRecyclerView.onRefreshComplete();
        }
    }

    @Override
    public void setPresenter(VideoContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onFailed(String msg) {

    }

}

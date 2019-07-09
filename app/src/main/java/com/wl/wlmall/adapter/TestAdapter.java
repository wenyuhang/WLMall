package com.wl.wlmall.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.wl.wlmall.R;

/**
 * @author geyifeng
 * @date 2019/4/19 3:03 PM
 */
public class TestAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TestAdapter() {
        super(R.layout.item_fun);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
    }
}

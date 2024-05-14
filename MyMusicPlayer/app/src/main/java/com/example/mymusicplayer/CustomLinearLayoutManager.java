package com.example.mymusicplayer;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomLinearLayoutManager extends LinearLayoutManager {

    public CustomLinearLayoutManager(Context context){
        super(context);
    }

    @Override
    public boolean canScrollHorizontally() {
        return true;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int travel = super.scrollHorizontallyBy(dx, recycler, state);
        if (travel > 0) {
            // 当向右滑动时，检查是否需要回收最后一行的item
            checkAndRemoveLastRow(recycler);
        }else {
            // 当向左滑动时，检查是否需要回收第一行的item
            checkAndRemoveFirstRow(recycler);
        }
        return travel;
    }

    private void checkAndRemoveFirstRow(RecyclerView.Recycler recycler) {
        if (getChildCount() < 3) return;
        View firstChild = getChildAt(0);
        int firstChildPos = getPosition(firstChild);
        if (firstChildPos == 0) {
            removeAndRecycleView(firstChild, recycler);
        }
    }

    private void checkAndRemoveLastRow(RecyclerView.Recycler recycler) {
        if (getChildCount() < 3) return;
        View lastChild = getChildAt(getChildCount() - 1);
        int lastChildPos = getPosition(lastChild);
        if (lastChildPos >= getItemCount() - 3) {
            removeAndRecycleView(lastChild, recycler);
        }
    }

}

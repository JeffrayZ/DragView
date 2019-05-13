package com.example.dragview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * @ProjectName: DragView
 * @Package: com.example.dragview
 * @ClassName: MyDragView
 * @Description: 可移动的View
 * @Author: Jeffray
 * @CreateDate: 2019/5/13 14:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 14:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MyDragView extends View {
    private int mLastX;
    private int mLastY;

    public MyDragView(Context context) {
        this(context, null);
    }

    public MyDragView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyDragView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyDragView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offSetX = x - mLastX;
                int offSetY = y - mLastY;

                layout(getLeft() + offSetX, getTop() + offSetY, getRight() + offSetX, getBottom() + offSetY);
                mLastX = x;
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                // 这里宽度必须确定宽高
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(200, 200);
                params.setMargins(getLeft(), getTop(), 0, 0);
                setLayoutParams(params);
                break;
            default:
                break;
        }
        return true;
    }
}

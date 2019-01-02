package com.example.mature.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    private Paint paint;
    private int cricleX;
    private int cricleY;

    /**
     * new 一个控件的调用
     * @param context
     */
    public MyView(Context context) {
        this(context,null);
    }

    /**自定义View 包含属性
     *
     * @param context
     * @param attrs
     */
    public MyView(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 自定义view 含属性 和样式
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    /**
     * 初始化对象的方法
     */
    private void init() {
        paint=new Paint();
        paint.setColor(Color.BLACK);   //黑色
        paint.setAntiAlias(true);
   //     paint.setStyle(Paint.Style.FILL);   //实心
        paint.setStyle(Paint.Style.STROKE);   //空心
        paint.setStrokeWidth(20);   //圆宽
    }
    /**
     *   测量
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    /**  在onmeasure 之后
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
    /**
     * 摆放
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    /**
     * 绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(cricleX,cricleY,30,paint);
    }
    /**触摸事件
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:  //按下
                cricleX= (int) event.getX();    //获取父空间 x 轴坐标
                cricleY= (int) event.getY();   //获取父空间 y 轴坐标
                invalidate();   //重绘
                break;
            case MotionEvent.ACTION_MOVE:   //移动
                cricleX= (int) event.getX();
                cricleY= (int) event.getY();
                invalidate();
                break;
            case MotionEvent.ACTION_UP:   //抬起   默认在当前位置
                break;
        }
        return true;  //返回true  证明消费了这个事件(三个事件都运行了,包括按下,滑动,抬起), 则false的话 只走down事件
    }
}

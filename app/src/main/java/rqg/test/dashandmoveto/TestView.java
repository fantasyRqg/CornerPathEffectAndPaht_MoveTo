package rqg.test.dashandmoveto;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * *Created by rqg on 5/3/16.
 */
public class TestView extends View {
    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    CornerPathEffect mCornerPathEffect = new CornerPathEffect(1f);

    boolean isEnablePathEffect = false;
    Path mPath = new Path();

    ArrayList<Point> mPointArrayList;

    public TestView(Context context) {
        this(context, null);
    }

    public TestView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isEnablePathEffect) {
            mPaint.setPathEffect(mCornerPathEffect);
        } else {
            mPaint.setPathEffect(null);
        }
        mPaint.setColor(Color.BLUE);
        canvas.drawPath(mPath, mPaint);


        mPaint.setColor(Color.RED);
        for (Point p : mPointArrayList) {
            canvas.drawPoint(p.x, p.y, mPaint);
        }

    }


    public boolean isEnablePathEffect() {
        return isEnablePathEffect;
    }

    public void setEnablePathEffect(boolean enablePathEffect) {
        isEnablePathEffect = enablePathEffect;
        invalidate();
    }


    public void setPath(ArrayList<Point> pointArrayList) {
        int count = 0;
        mPath.reset();
        for (Point p : pointArrayList) {
            if (count < 2) {
                if (mPath.isEmpty()) {
                    mPath.moveTo(p.x, p.y);
                } else {
                    mPath.lineTo(p.x, p.y);
                }
            } else {
                mPath.moveTo(p.x, p.y);
            }
            count++;
        }

        mPointArrayList = pointArrayList;
    }
}

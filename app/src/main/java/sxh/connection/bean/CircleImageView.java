package sxh.connection.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Mercurian on 2015/6/13.
 */
public class CircleImageView extends ImageView {
    //picture painter
    private Paint mCircleImagePaint;
    //frame painter
    private Paint mCircleBorderPaint;
    //frame width
    private int mBorderWidth = 2;
    //circle bitmap
    private Bitmap mCircleBitmap;
    public CircleImageView(Context context) {
        super(context);
        initView();
    }
    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }
    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }
    /**
     * initialize
     */
    private void initView() {
        //initialze painter
        mCircleImagePaint = new Paint();
        mCircleImagePaint.setAntiAlias(true);
        //initialize frame
        mCircleBorderPaint = new Paint();
        mCircleBorderPaint.setColor(Color.GRAY);
        mCircleBorderPaint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //load bitmap
        mCircleBitmap = LoadBitmapFromDrawable(getDrawable());
        if (mCircleBitmap != null) {
            int mCanvasSize = Math.min(canvas.getWidth(), canvas.getHeight());
            //build bitmap renderer
            BitmapShader bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(mCircleBitmap, mCanvasSize, mCanvasSize, false), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            mCircleImagePaint.setShader(bitmapShader);
            //calculate center
            int mCircleCenterXY = (mCanvasSize - (mBorderWidth * 2)) / 2;
            //draw frame
            canvas.drawCircle(mCircleCenterXY + mBorderWidth, mCircleCenterXY + mBorderWidth, ((mCanvasSize - (mBorderWidth * 2)) / 2) + mBorderWidth, mCircleBorderPaint);
            //draw picture
            canvas.drawCircle(mCircleCenterXY + mBorderWidth, mCircleCenterXY + mBorderWidth, ((mCanvasSize - (mBorderWidth * 2)) / 2) , mCircleImagePaint);
        }
    }
    /**
     * Convert drawable to bitmap
     *
     * @param drawable
     * @return
     */
    private Bitmap LoadBitmapFromDrawable(Drawable drawable) {
        if (drawable == null) {
            return null;
        } else if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
}

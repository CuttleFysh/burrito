package com.cuttlefysh.burrito;


import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

public class FitTextureView extends TextureView
{
    private int ratioW = 0;
    private int ratioH = 0;

    public FitTextureView(Context context)
    {
        this(context, null);
    }

    public FitTextureView(Context context, AttributeSet att)
    {
        this(context, att, 0);
    }

    public FitTextureView(Context context, AttributeSet att, int sy)
    {
        super(context, att, sy);
    }

    public void setAspectRatio(int width, int height)
    {
        if(width < 0 || height < 0)
        {
            throw new IllegalArgumentException("Non negative sizes");
        }
        ratioW = width;
        ratioH = height;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMS, int heightMS)
    {
        super.onMeasure(widthMS, heightMS);
        int width = MeasureSpec.getSize(widthMS);
        int height = MeasureSpec.getSize(heightMS);
        if (0 == ratioW || 0 == ratioH)
        {
            setMeasuredDimension(width, height);
        }
        else
        {
            if (width < height * ratioW / ratioH)
            {
                setMeasuredDimension(width, width * ratioH / ratioW);
            }
            else
            {
                setMeasuredDimension(height * ratioW / ratioH, height);
            }
        }
    }

}

package com.example.shapeanimation;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.shapes.Shape;

public class WeirdShape extends Shape {
    private static final int    COLOUR       = Color.WHITE;
    private static final float  STROKE_WIDTH = 1.0f;
    private static final float  CORNER = 90.0f;

    private final Paint border = new Paint();
    private final Path  path;

    public WeirdShape() {
        path   = new Path();
        border.setColor      (COLOUR);
        border.setStyle      (Paint.Style.FILL);
        border.setStrokeWidth(STROKE_WIDTH);
        border.setAntiAlias  (true);
        border.setDither     (true);
        border.setStrokeJoin (Paint.Join.ROUND);
        border.setStrokeCap  (Paint.Cap.ROUND);
    }

    @Override
    protected void onResize(float width, float height) {
        super.onResize(width, height);

        float dx = STROKE_WIDTH/2.0f;
        float dy = STROKE_WIDTH/2.0f;
        float w  = width  - dx;
        float h  = height - dy;

        path.reset();
        path.moveTo(dx + CORNER, dy);
        path.lineTo(w - CORNER, dy);
        path.lineTo(w, dy + CORNER);
        path.lineTo(w, h);
        path.lineTo(dx + CORNER,h);
        path.lineTo(dx,h - CORNER);
        path.lineTo(dx, dy);
        path.close();
    }

    @Override
    public void draw(Canvas canvas, Paint paint) {
        // TODO Auto-generated method stub
        canvas.drawPath(path,border);
    }
}

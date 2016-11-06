package com.example.pierre.proget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by pierre on 06/11/2016.
 */
public class Image {
 float radius = 80;      // Ball's radius
 float x = radius + 20;  // Ball's center (x,y)
 float y = radius + 40;
 float speedX = 5;       // Ball's speed (x,y)
 float speedY = 3;
 private RectF bounds;   // Needed for Canvas.drawOval
 private Paint paint;    // The paint style, color used for drawing

    // Constructor
    public Image(int color) {
        bounds = new RectF();
        paint = new Paint();
        paint.setColor(color);
    }

    public void moveWithCollisionDetection(Boite box) {
        // Get new (x,y) position
        x += speedX;
        y += speedY;
        // Detect collision and react
        if (x + radius > box.xMax) {
            speedX = -speedX;
            x = box.xMax-radius;
        } else if (x - radius < box.xMin) {
            speedX = -speedX;
            x = box.xMin+radius;
        }
        if (y + radius > box.yMax) {
            speedY = -speedY;
            y = box.yMax - radius;
        } else if (y - radius < box.yMin) {
            speedY = -speedY;
            y = box.yMin + radius;
        }
    }

    public void draw(Canvas canvas) {
        bounds.set(x-radius, y-radius, x+radius, y+radius);
        canvas.drawOval(bounds, paint);
    }
}


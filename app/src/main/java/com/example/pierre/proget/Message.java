package com.example.pierre.proget;

import java.util.Formatter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by pierre on 06/11/2016.
 */
public class Message {

    // Status message to show Ball's (x,y) position and speed.
    private StringBuilder statusMsg = new StringBuilder();
    private Formatter formatter = new Formatter(statusMsg);
    private Paint paint;

    // Constructor
    public Message(int color) {
        paint = new Paint();
        // Set the font face and size of drawing text
        paint.setTypeface(Typeface.MONOSPACE);
        paint.setTextSize(16);
        paint.setColor(color);
    }

    public void update(Image ball) {
        // Build status message
        statusMsg.delete(0, statusMsg.length());   // Empty buffer
        formatter.format("Ball@(%3.0f,%3.0f),Speed=(%2.0f,%2.0f)", ball.x, ball.y,
                ball.speedX, ball.speedY);
    }

    public void draw(Canvas canvas) {
        canvas.drawText(statusMsg.toString(), 10, 30, paint);
    }
}

package com.example.teste;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Example of a custom view to display a gauge
 * @author ruicouto
 *
 */
public class Gauge extends View {
	
	/**
	 * The value of the progress, from 0 to 100 (%)
	 */
	private int progress = 20;
	
	/**
	 * The paint configurations
	 */
	private Paint paint = new Paint();
	
	/**
	 * Default constructor
	 * @param context
	 */
	public Gauge(Context context) {
		super(context);
	}
	
	/**
	 * Default constructor
	 * @param context
	 * @param attrs
	 */
	public Gauge(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	/**
	 * Default constructor
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public Gauge(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	/**
	 * Define the progress.
	 * If bigger or smaller, it will be rounded to 100 or 0, respectively
	 * @param progress A value from 0 to 100. 
	 */
	public void setProgress(int progress) {
		if(progress<0) {
			this.progress = 0;
		} else if(progress>100) {
			this.progress = 100;
		} else {
			this.progress = progress;
		}
		invalidate();
	}
	
	/**
	 * Override of draw method. 
	 * Place code to draw your controller here.
	 */
	@Override
	public void draw(Canvas canvas) {
		//set background color as white
		paint.setColor(Color.WHITE);
		//draw the paint configurations
		canvas.drawPaint(paint);
		//set the paint color as black
		paint.setColor(Color.BLACK);
		//enable antialias to draw smoother
		paint.setAntiAlias(true);
		//define a larger stroke
		paint.setStrokeWidth(2);
		//Draw the line
		canvas.drawLine(getWidth()/2, //from x - bottom, center 
				getHeight(),  //from y - bottom
				progress*getWidth()/100, //to x - map percentage to pixels 
				0, //to y - top
				paint); //paint configurations0
		
		super.draw(canvas); //draw the canvas
	}
	

}

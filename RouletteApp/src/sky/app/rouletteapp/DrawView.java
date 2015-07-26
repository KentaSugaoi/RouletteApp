package sky.app.rouletteapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {

	//共用キャンバス
	private Canvas canvas = null;
	int currentRadius = 0;	//描画開始角度
	int drawRadius = 120;	//描画角
	RectF rect = new RectF(100.0f, 100.0f, 450.0f, 450.0f); //描画対象の円

	private int blueStartRadius = 0;
	private int redStartRadius = 120;
	private int greenStartRadius = 240;

	Paint pGreen = new Paint();
	Paint pRed = new Paint();
	Paint pBlue = new Paint();
	Paint pLine = new Paint();
	Paint pText = new Paint();

	public DrawView(Context context) {
		super(context);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 *
	 * @param canvas
	 */
	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas) {

		this.canvas = canvas;
		canvas.drawColor(Color.WHITE);
		// 円弧を描く
		//青
		pBlue.setStyle(Paint.Style.FILL);
		pBlue.setColor(Color.BLUE);
		pBlue.setAntiAlias(true);
		canvas.drawArc(this.rect, this.blueStartRadius, this.drawRadius, true, pBlue);

		//赤
		pRed.setStyle(Paint.Style.FILL);
		pRed.setColor(Color.RED);
		pRed.setAntiAlias(true);
		canvas.drawArc(this.rect, this.redStartRadius, this.drawRadius, true, pRed);

		//緑
		pGreen.setStyle(Paint.Style.FILL);
		pGreen.setColor(Color.GREEN);
		pGreen.setAntiAlias(true);
		canvas.drawArc(this.rect, this.greenStartRadius, this.drawRadius, true, pGreen);

		//針をつける
		//TODO 三角形にする
		pLine.setStyle(Paint.Style.FILL);
		pLine.setColor(Color.BLACK);
		canvas.drawLine(275, 455, 275, 520, pLine);

		//判定結果
		pText.setColor(Color.BLACK);
		pText.setTextSize(30);
		String resultText ="";
		if (blueStartRadius % 360 < 90 && redStartRadius%360 >= 90){
			resultText = "青";
			pText.setColor(Color.BLUE);
		}
		else if(redStartRadius % 360 < 90 && greenStartRadius%360 >= 90){
			resultText = "赤";
			pText.setColor(Color.RED);

		}
		else if(greenStartRadius % 360 < 90 && blueStartRadius%360 >= 90){
			resultText = "緑";
			pText.setColor(Color.GREEN);

		}
		canvas.drawText("当たりは" + resultText, 230, 600, pText);
		//TODO 図形に文字をつける
		//TODO 回転開始処理を実装
		//TODO 回転終了処理を実装
	}


	/**
	 * onTouch　円を回転させる
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int rotateRadius = 7;	//回転角
		final int ROTATE_COUNT = 300;	//回転回数

		int i;
		for(i=0;i<ROTATE_COUNT;i++){
			//青
			this.blueStartRadius = this.blueStartRadius + rotateRadius;
			//赤
			this.redStartRadius = this.blueStartRadius + this.drawRadius;
			//緑
			this.greenStartRadius = this.redStartRadius + this.drawRadius;

//			//HINT invaridateでondrawを明示的に実行できる
			invalidate();
		}

		return true;

	}
}

package com.example.rouletteapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	private DrawView view = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//初期描画
	    this.view = new DrawView(getApplication());
	    setContentView(view);
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}

		//開始ボタン
		if (id == R.id.startButton){
			// kaii kaii update yamayama
			// sugaoi push
			//view.startRotateCircle();
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * タッチイベント。
	 * タッチされたら回転する
	 */
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//	    try {
//			view.startRotateCircle();
//		} catch (InterruptedException e) {
//			// TODO 自動生成された catch ブロック
//			AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
//            //タイトルを設定する
//            alertDialog.setTitle("エラー");
//            //メッセージ内容を設定する
//            alertDialog.setMessage("エラーが発生しました");
//            alertDialog.show();
//		}
//        return true;
//    }
}

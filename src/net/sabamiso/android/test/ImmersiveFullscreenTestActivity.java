//
// Immersive Fullscreen-Mode�̎g�����T���v��
//
package net.sabamiso.android.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ImmersiveFullscreenTestActivity extends Activity {	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// �^�C�g���\��������
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// �X���[�v���Ȃ��ݒ�
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		// �Ƃ肠�����e�X�g�p�Ƀf�t�H���g��View��ݒ�
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_immersive_fullscreen_test);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		hideSystemUI();
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// Android 5.0�́u��ʂ̌Œ�v���g�����u�Ԃ�IMMERSIVE���[�h���O���̂ŁA�Đݒ肵�Ă���
		hideSystemUI();
	}
		
	private void hideSystemUI() {
		// see also...https://developer.android.com/training/system-ui/immersive.html
		View decor = this.getWindow().getDecorView();
		decor.setSystemUiVisibility(
	            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	            | View.SYSTEM_UI_FLAG_FULLSCREEN
	            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}

}

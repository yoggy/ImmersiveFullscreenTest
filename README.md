ImmersiveFullscreenTest
========
Immersive Full-Screen Modeの超シンプルなサンプル。

Immersive Full-Screen Modeの詳細については以下URL参照。
* https://developer.android.com/training/system-ui/immersive.html

<pre>
//
// Immersive Fullscreen-Modeの使い方サンプル
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
        // タイトル表示を消す
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // スリープしない設定
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        // とりあえずテスト用にデフォルトのViewを設定
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
        // Android 5.0の「画面の固定」を使った瞬間にIMMERSIVEモードが外れるので、再設定しておく
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
</pre>

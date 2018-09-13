package cn.zdh.mobshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void share(View view) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        /**
         * 真正分享出去的内容实际上是由下面的这些参数决定的，根据平台不同分别配置
         */
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, cn.sharesdk.framework.Platform.ShareParams paramsToShare) {
                if (Wechat.NAME.equals(platform.getName())) {
                    //微信 分享网址方法是setUrl
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                    paramsToShare.setUrl("http://twx.gxy-ff.com/video/video_detail?videoId=0");
                    paramsToShare.setText("分享的内容");
                    paramsToShare.setTitle("分享的标题");
                }
                if (SinaWeibo.NAME.equals(platform.getName())) {
                    //新浪 分享网址方法是setUrl
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                    paramsToShare.setUrl("http://twx.gxy-ff.com/video/video_detail?videoId=0");
                    paramsToShare.setText("分享的内容");
                    paramsToShare.setTitle("分享的标题");
                }
                if (QQ.NAME.equals(platform.getName())) {
                    //QQ 分享网址方法是setTitleUrl
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                    paramsToShare.setTitleUrl("http://twx.gxy-ff.com/video/video_detail?videoId=0");
                    paramsToShare.setText("分享的内容");
                    paramsToShare.setTitle("分享的标题");
                }
            }
        });


        //回调监听
        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                //成功
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                //失败
            }

            @Override
            public void onCancel(Platform platform, int i) {
                //取消
            }
        });

        // 启动分享GUI
        oks.show(this);


    }


    public void share2(View view) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        //网络地址
        oks.setImageUrl("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2102779687,4279587240&fm=173&app=25&f=JPG?w=640&h=405&s=61C54BAE1B6F3F1D3873CFAC0300F009");
        //回调监听
        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                // 成功
                Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                //失败
            }

            @Override
            public void onCancel(Platform platform, int i) {
                //取消
            }
        });
        oks.show(this);

    }
}
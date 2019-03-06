package com.xcs.news.baseo.fragment;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.utils.Config;


/**
 * Date：2018/3/18 on 下午7:02
 * Describe:
 * Created by:stefan
 */
public class NewsDetailsFragment extends Fragment {
    private View view;
    private WebView webView;
    private ProgressDialog progressDialog;

    public static NewsDetailsFragment newInstance(int position, int type) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("type", type);
        NewsDetailsFragment fragment = new NewsDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_details, container, false);
        Bundle bundle = getArguments();
        webView = view.findViewById(R.id.webview);
        int position = bundle.getInt("position");
        int type = bundle.getInt("type");
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (progressDialog!=null){
                    progressDialog.show();
                }

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog!=null){
                    progressDialog.dismiss();
                }

            }
        });
        if (type == 1) {
            if (position == 0) {
                webView.loadUrl(Config.CPURL115);
            } else if (position == 1) {
                webView.loadUrl(Config.CPURL116);

            } else if (position == 2) {
                webView.loadUrl(Config.CPURL117);
            } else if (position == 3) {
                webView.loadUrl(Config.CPURL118);
            } else if (position == 4) {
                webView.loadUrl(Config.CPURL119);
            } else if (position == 5) {
                webView.loadUrl(Config.CPURL120);
            } else if (position == 6) {
                webView.loadUrl(Config.CPURL121);
            } else if (position == 7) {
                webView.loadUrl(Config.CPURL122);
            } else if (position == 8) {
                webView.loadUrl(Config.CPURL123);
            } else if (position == 9) {
                webView.loadUrl(Config.CPURL124);
            } else if (position == 10) {
                webView.loadUrl(Config.CPURL125);
            } else if (position == 11) {
                webView.loadUrl(Config.CPURL126);
            } else if (position == 12) {
                webView.loadUrl(Config.CPURL127);
            } else if (position == 13) {
                webView.loadUrl(Config.CPURL128);
            } else if (position == 14) {
                webView.loadUrl(Config.CPURL129);
            } else if (position == 15) {
                webView.loadUrl(Config.CPURL130);
            } else if (position == 16) {
                webView.loadUrl(Config.CPURL131);
            } else if (position == 17) {
                webView.loadUrl(Config.CPURL132);
            } else if (position == 18) {
                webView.loadUrl(Config.CPURL133);
            } else if (position == 19) {
                webView.loadUrl(Config.CPURL134);
            } else if (position == 20) {
                webView.loadUrl(Config.CPURL135);
            }
        } else if (type == 2) {
            if (position == 0) {
                webView.loadUrl(Config.CPURL134);
            } else if (position == 1) {
                webView.loadUrl(Config.CPURL135);
            } else if (position == 2) {
                webView.loadUrl(Config.CPURL136);
            } else if (position == 3) {
                webView.loadUrl(Config.CPURL137);

            } else if (position == 4) {
                webView.loadUrl(Config.CPURL138);
            } else if (position == 5) {
                webView.loadUrl(Config.CPURL139);
            } else if (position == 6) {
                webView.loadUrl(Config.CPURL140);
            } else if (position == 7) {
                webView.loadUrl(Config.CPURL141);
            } else if (position == 8) {
                webView.loadUrl(Config.CPURL142);
            } else if (position == 9) {
                webView.loadUrl(Config.CPURL143);
            } else if (position == 10) {
                webView.loadUrl(Config.CPURL144);
            } else if (position == 11) {
                webView.loadUrl(Config.CPURL144);
            } else if (position == 12) {
                webView.loadUrl(Config.CPURL145);
            } else if (position == 13) {
                webView.loadUrl(Config.CPURL146);
            } else if (position == 14) {
                webView.loadUrl(Config.CPURL147);
            } else if (position == 15) {
                webView.loadUrl(Config.CPURL148);
            } else if (position == 16) {
                webView.loadUrl(Config.CPURL149);
            } else if (position == 17) {
                webView.loadUrl(Config.CPURL150);
            } else if (position == 18) {
                webView.loadUrl(Config.CPURL151);
            } else if (position == 19) {
                webView.loadUrl(Config.CPURL152);

            } else if (position == 20) {
                webView.loadUrl(Config.CPURL153);
            } else if (position == 21) {
                webView.loadUrl(Config.CPURL154);

            } else if (position == 22) {
                webView.loadUrl(Config.CPURL155);

            } else if (position == 23) {
                webView.loadUrl(Config.CPURL156);

            } else if (position == 24) {
                webView.loadUrl(Config.CPURL157);
            }
        } else if (type == 3) {
            if (position == 0) {
                webView.loadUrl(Config.CPURL198);
            } else if (position == 1) {
                webView.loadUrl(Config.CPURL158);
            } else if (position == 2) {
                webView.loadUrl(Config.CPURL159);
            } else if (position == 3) {
                webView.loadUrl(Config.CPURL160);
            } else if (position == 4) {
                webView.loadUrl(Config.CPURL161);
            } else if (position == 5) {
                webView.loadUrl(Config.CPURL162);
            } else if (position == 6) {
                webView.loadUrl(Config.CPURL163);
            } else if (position == 7) {
                webView.loadUrl(Config.CPURL164);
            } else if (position == 8) {
                webView.loadUrl(Config.CPURL165);
            } else if (position == 9) {
                webView.loadUrl(Config.CPURL166);
            } else if (position == 10) {
                webView.loadUrl(Config.CPURL168);
            } else if (position == 11) {
                webView.loadUrl(Config.CPURL169);
            } else if (position == 12) {
                webView.loadUrl(Config.CPURL170);
            } else if (position == 13) {
                webView.loadUrl(Config.CPURL171);
            } else if (position == 14) {
                webView.loadUrl(Config.CPURL172);
            } else if (position == 15) {
                webView.loadUrl(Config.CPURL173);
            } else if (position == 16) {
                webView.loadUrl(Config.CPURL174);
            } else if (position == 17) {
                webView.loadUrl(Config.CPURL175);
            } else if (position == 18) {
                webView.loadUrl(Config.CPURL176);
            } else if (position == 19) {
                webView.loadUrl(Config.CPURL177);
            } else if (position == 20) {
                webView.loadUrl(Config.CPURL178);
            } else if (position == 21) {
                webView.loadUrl(Config.CPURL179);

            } else if (position == 22) {
                webView.loadUrl(Config.CPURL180);
            } else if (position == 23) {
                webView.loadUrl(Config.CPURL154);
            }

        } else if (type == 4) {
            if (position == 0) {
            } else if (position == 1) {
                webView.loadUrl(Config.CPURL180);
            } else if (position == 2) {
                webView.loadUrl(Config.CPURL181);
            } else if (position == 3) {
                webView.loadUrl(Config.CPURL182);
            } else if (position == 4) {
                webView.loadUrl(Config.CPURL183);
            } else if (position == 5) {
                webView.loadUrl(Config.CPURL184);
            } else if (position == 6) {
                webView.loadUrl(Config.CPURL185);
            } else if (position == 7) {
                webView.loadUrl(Config.CPURL186);
            } else if (position == 8) {
                webView.loadUrl(Config.CPURL187);
            } else if (position == 9) {
                webView.loadUrl(Config.CPURL188);
            } else if (position == 10) {
                webView.loadUrl(Config.CPURL189);
            } else if (position == 11) {
                webView.loadUrl(Config.CPURL190);
            } else if (position == 12) {
                webView.loadUrl(Config.CPURL191);
            } else if (position == 13) {
                webView.loadUrl(Config.CPURL192);
            } else if (position == 14) {
                webView.loadUrl(Config.CPURL193);
            } else if (position == 15) {
                webView.loadUrl(Config.CPURL194);
            } else if (position == 16) {
                webView.loadUrl(Config.CPURL195);
            } else if (position == 17) {
                webView.loadUrl(Config.CPURL196);
            } else if (position == 18) {
                webView.loadUrl(Config.CPURL197);
            } else if (position == 19) {
                webView.loadUrl(Config.CPURL198);
            } else if (position == 20) {
                webView.loadUrl(Config.CPURL199);
            } else if (position == 21) {
                webView.loadUrl(Config.CPURL200);

            } else if (position == 22) {
                webView.loadUrl(Config.CPURL201);
            } else if (position == 23) {
                webView.loadUrl(Config.CPURL209);
            }

        } else if (type == 5) {
            if (position == 0) {
            } else if (position == 1) {
                webView.loadUrl(Config.CPURL202);
            } else if (position == 2) {
                webView.loadUrl(Config.CPURL203);
            } else if (position == 3) {
                webView.loadUrl(Config.CPURL204);
            } else if (position == 4) {
                webView.loadUrl(Config.CPURL205);
            } else if (position == 5) {
                webView.loadUrl(Config.CPURL206);
            } else if (position == 6) {
                webView.loadUrl(Config.CPURL207);
            } else if (position == 7) {
                webView.loadUrl(Config.CPURL208);
            } else if (position == 8) {
                webView.loadUrl(Config.CPURL209);
            } else if (position == 9) {
                webView.loadUrl(Config.CPURL210);
            } else if (position == 10) {
                webView.loadUrl(Config.CPURL211);
            } else if (position == 11) {
                webView.loadUrl(Config.CPURL212);
            } else if (position == 12) {
                webView.loadUrl(Config.CPURL213);
            } else if (position == 13) {
                webView.loadUrl(Config.CPURL214);
            } else if (position == 14) {
                webView.loadUrl(Config.CPURL215);
            } else if (position == 15) {
                webView.loadUrl(Config.CPURL198);
            } else if (position == 16) {
                webView.loadUrl(Config.CPURL182);
            } else if (position == 17) {
                webView.loadUrl(Config.CPURL196);
            } else if (position == 18) {
                webView.loadUrl(Config.CPURL197);
            } else if (position == 19) {
                webView.loadUrl(Config.CPURL198);
            } else if (position == 20) {
                webView.loadUrl(Config.CPURL199);
            } else if (position == 21) {
                webView.loadUrl(Config.CPURL200);

            } else if (position == 22) {
                webView.loadUrl(Config.CPURL201);
            } else if (position == 23) {
                webView.loadUrl(Config.CPURL190);
            }


        }
        return view;
    }
}

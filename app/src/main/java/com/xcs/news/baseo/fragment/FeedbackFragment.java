package com.xcs.news.baseo.fragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xcs.news.baseo.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment implements View.OnClickListener {


    public FeedbackFragment() {
        // Required empty public constructor
    }

    private Button submit;
    private Handler handler;
    private ProgressDialog progressDialog;
    private EditText edit_text;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_feedback, container, false);
        initData(view);
        return view;
    }

    public void initData(View view) {

        submit = (Button) view.findViewById(R.id.btn_ok);
        edit_text=view.findViewById( R.id.et_content);
        submit.setOnClickListener(this);
        handler = new Handler();
        progressDialog = new ProgressDialog(getActivity());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_ok:
                if (edit_text.getText().toString().equals("")) {
                    Snackbar.make(submit, "反馈意见不能为空", 1).show();
                    return;
                } else if (edit_text.getText().toString().trim().length() < 10) {
                    Snackbar.make(submit, "描述的问题不能少于10个字！", 1).show();
                    return;
                }
                progressDialog.setMessage("正在反馈，请稍后");
                progressDialog.show();
                handler.postDelayed(() -> {
                    Snackbar.make(submit, "反馈成功", 1).show();
                    progressDialog.dismiss();
                    edit_text.setText("");


                }, 1000);
                break;
        }
    }
}

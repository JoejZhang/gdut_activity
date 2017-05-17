package com.rdc.gdut_activity.model;

import com.rdc.gdut_activity.constant.Constant;
import com.rdc.gdut_activity.contract.ScoreContract;
import com.rdc.gdut_activity.utils.OkHttpResultCallback;
import com.rdc.gdut_activity.utils.OkHttpUtil;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;

/**
 * Created by PC on 2017/5/16.
 */

public class ScoreModel {
    private Map<String,String> mBodyMap;
    private ScoreContract.Presenter mPresenter;

    public ScoreModel(ScoreContract.Presenter presenter){
        mBodyMap = new HashMap<>();
        mPresenter = presenter;
    }


    public void login(String account,String pwd){
        mBodyMap.clear();
        mBodyMap.put(Constant.LOGIN_BODY_NAME_ACCOUNT,"3115005289");
        mBodyMap.put(Constant.LOGIN_BODY_NAME_PWD,"15626227808aa");
        mBodyMap.put(Constant.LOGIN_BODY_NAME_VERIFYCODE,Constant.LOGIN_BODY_VALUE_VERIFYCODE);
        OkHttpUtil.getInstance().postAsync(Constant.EDUCATION_SYSTEM_LOGIN_URL, new OkHttpResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mPresenter.loginError(e.getMessage());
            }

            @Override
            public void onResponse(byte[] bytes) {
                mPresenter.loginSuccess();
            }
        },mBodyMap,null);
    }

    public void queryScore(String time){
        mBodyMap.clear();
        mBodyMap.put(Constant.SCORE_BODY_NAME_XNXQDM,time);
        mBodyMap.put(Constant.SCORE_BODY_NAME_JHLXDM,"");
        mBodyMap.put(Constant.SCORE_BODY_NAME_PAGE,Constant.SCORE_BODY_VALUE_PAGE);
        mBodyMap.put(Constant.SCORE_BODY_NAME_ROWS,Constant.SCORE_BODY_VALUE_ROWS);
        mBodyMap.put(Constant.SCORE_BODY_NAME_ORDER,Constant.SCORE_BODY_VALUE_ORDER);
        OkHttpUtil.getInstance().postAsync(Constant.EDUCATION_SYSTEM_SCORE_URL, new OkHttpResultCallback() {
            @Override
            public void onError(Call call, Exception e) {
                mPresenter.queryError(e.getMessage());
            }

            @Override
            public void onResponse(byte[] bytes) {
                mPresenter.querySuccess(bytes);
            }
        },mBodyMap,null);
    }




}

package siri.apisiri.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import siri.apisiri.R;
import siri.apisiri.ui.voice.NaverVoiceActivity;
import siri.apisiri.utils.TypefaceUtil;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.tv_title1)
    TextView mTvTitleTop;
    @BindView(R.id.tv_title2)
    TextView mTvTitleBottom;
    @BindView(R.id.btn_login_student)
    Button mLoginButtonStudent;
    @BindView(R.id.btn_login_normal)
    Button mLoginButtonNormal;
    @BindView(R.id.voice_btn)
    Button mVoiceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceUtil.loadTypeface(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mTvTitleTop.setTypeface(TypefaceUtil.typeface);
        mTvTitleBottom.setTypeface(TypefaceUtil.typeface_m);

        mLoginButtonStudent.setTypeface(TypefaceUtil.typeface);
        mLoginButtonNormal.setTypeface(TypefaceUtil.typeface);
        mVoiceButton.setTypeface(TypefaceUtil.typeface);
    }

    @OnClick(R.id.btn_login_student)
    public void onClickStudent() {
        startActivity(new Intent(LoginActivity.this, LoginStudentActivity.class));
        finish();
    }

    @OnClick(R.id.btn_login_normal)
    public void onClickNormal() {
        startActivity(new Intent(LoginActivity.this, LoginNormalActivity.class));
        finish();
    }

    @OnClick(R.id.voice_btn)
    public void onClickVoice() {
        startActivity(new Intent(LoginActivity.this, NaverVoiceActivity.class));
    }
}

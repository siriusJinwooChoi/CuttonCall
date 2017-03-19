package siri.apisiri.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import siri.apisiri.R;
import siri.apisiri.ui.login.facebook.FacebookActivity;
import siri.apisiri.ui.main.MainActivity;
import siri.apisiri.utils.AsteriskPasswordTransformationMethod;
import siri.apisiri.utils.TypefaceUtil;

public class LoginNormalActivity extends AppCompatActivity {

    private ActionBar mActionBar;

    @BindView(R.id.tv_student_id)
    TextView mTvStudentId;
    @BindView(R.id.tv_student_password)
    TextView mTvStudentPw;
    @BindView(R.id.et_student_id)
    EditText mEtStudentId;
    @BindView(R.id.et_student_pw)
    EditText mEtStudentPw;
    @BindView(R.id.login_button)
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        TypefaceUtil.loadTypeface(this);
        setContentView(R.layout.activity_login_normal);
        ButterKnife.bind(this);

        mActionBar = getSupportActionBar();
        final TextView TextViewNewFont = new TextView(LoginNormalActivity.this);
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        TextViewNewFont.setLayoutParams(layoutparams);
        TextViewNewFont.setText("일반인 가입하기");

        // TextView Color
        TextViewNewFont.setTextColor(getResources().getColor(R.color.colorWhite));

        TextViewNewFont.setGravity(Gravity.CENTER_HORIZONTAL);
        TextViewNewFont.setTextSize(18);

        TextViewNewFont.setTypeface(TypefaceUtil.typeface_m);

        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setCustomView(TextViewNewFont);

        mTvStudentId.setTypeface(TypefaceUtil.typeface_m);
        mTvStudentPw.setTypeface(TypefaceUtil.typeface_m);
        mEtStudentId.setTypeface(TypefaceUtil.typeface_m);
        mEtStudentPw.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        mEtStudentPw.setTypeface(TypefaceUtil.typeface_m);
        mLoginButton.setTypeface(TypefaceUtil.typeface_m);
    }

    @OnClick(R.id.login_button)
    public void login() {
        startActivity(new Intent(LoginNormalActivity.this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.facebook_login)
    public void facebookLogin() {
        startActivity(new Intent(LoginNormalActivity.this, FacebookActivity.class));
        finish();
    }
}

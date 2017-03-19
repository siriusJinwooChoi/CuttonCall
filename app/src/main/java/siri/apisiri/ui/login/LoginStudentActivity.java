package siri.apisiri.ui.login;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import siri.apisiri.R;
import siri.apisiri.ui.login.adapter.MySpinnerAdapter;
import siri.apisiri.utils.AsteriskPasswordTransformationMethod;
import siri.apisiri.utils.TypefaceUtil;

public class LoginStudentActivity extends AppCompatActivity {

    @BindView(R.id.textView2)
    TextView mTvSelectSchool;
    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.login_button)
    Button mLoginButton;
    @BindView(R.id.tv_student_id)
    TextView mStudentId;
    @BindView(R.id.tv_student_password)
    TextView mStudentPassword;
    @BindView(R.id.et_student_id)
    EditText mEtStudentId;
    @BindView(R.id.et_student_pw)
    EditText mEtStudentPw;

    private ActionBar mActionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TypefaceUtil.loadTypeface(this);
        setContentView(R.layout.activity_login_student);
        ButterKnife.bind(this);

        mActionBar = getSupportActionBar();
        final TextView TextViewNewFont = new TextView(LoginStudentActivity.this);
        FrameLayout.LayoutParams layoutparams = new FrameLayout.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        TextViewNewFont.setLayoutParams(layoutparams);
        TextViewNewFont.setText("대학생 가입하기");

        // TextView Color
        TextViewNewFont.setTextColor(getResources().getColor(R.color.colorWhite));

        TextViewNewFont.setGravity(Gravity.CENTER_HORIZONTAL);
        TextViewNewFont.setTextSize(18);

        TextViewNewFont.setTypeface(TypefaceUtil.typeface_m);

        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        mActionBar.setCustomView(TextViewNewFont);

        mTvSelectSchool.setTypeface(TypefaceUtil.typeface_m);
        mLoginButton.setTypeface(TypefaceUtil.typeface_m);

        mStudentId.setTypeface(TypefaceUtil.typeface_m);
        mStudentPassword.setTypeface(TypefaceUtil.typeface_m);

        mEtStudentId.setTypeface(TypefaceUtil.typeface_m);
        mEtStudentPw.setTransformationMethod(new AsteriskPasswordTransformationMethod());
        mEtStudentPw.setTypeface(TypefaceUtil.typeface_m);

        MySpinnerAdapter adapter = new MySpinnerAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                Arrays.asList(getResources().getStringArray(R.array.array))
        );

        mSpinner.setAdapter(adapter);
    }

}

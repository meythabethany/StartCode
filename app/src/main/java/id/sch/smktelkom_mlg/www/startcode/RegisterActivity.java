package id.sch.smktelkom_mlg.www.startcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import id.sch.smktelkom_mlg.www.startcode.Database.DatabaseHelper;
import id.sch.smktelkom_mlg.www.startcode.Database.InputValidation;
import id.sch.smktelkom_mlg.www.startcode.Database.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private LinearLayout linearLayout;

    private TextInputLayout textInputLayoutNisn;
    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutTelp;
    private TextInputLayout textInputLayoutSekolah;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    private TextInputEditText textInputEditTextNisn;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextTelp;
    private TextInputEditText textInputEditTextSekolah;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;

    private AppCompatTextView appCompatTextViewLoginLink;
    private Button appCompatButtonRegister;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        linearLayout = findViewById(R.id.linear);

        textInputLayoutNisn = findViewById(R.id.DaftarNISN);
        textInputLayoutName = findViewById(R.id.DaftarNama);
        textInputLayoutEmail = findViewById(R.id.DaftarEmail);
        textInputLayoutTelp = findViewById(R.id.DaftarTelp);
        textInputLayoutSekolah = findViewById(R.id.DaftarSekolah);
        textInputLayoutPassword = findViewById(R.id.DaftarPassword);
        textInputLayoutConfirmPassword = findViewById(R.id.DaftarConfirm);

        textInputEditTextNisn = findViewById(R.id.daftarNISN);
        textInputEditTextName = findViewById(R.id.daftarNama);
        textInputEditTextEmail = findViewById(R.id.daftarEmail);
        textInputEditTextTelp = findViewById(R.id.daftarTelp);
        textInputEditTextSekolah = findViewById(R.id.daftarSekolah);
        textInputEditTextPassword = findViewById(R.id.daftarPassword);
        textInputEditTextConfirmPassword = findViewById(R.id.daftarConfirmPassword);

        appCompatButtonRegister = findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = findViewById(R.id.appCompatTextViewLoginLink);
    }

    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);
    }

    private void initObjects() {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;
            case R.id.appCompatTextViewLoginLink:
                Intent intentRegister = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextNisn, textInputLayoutNisn, getString(R.string.error_message_nisn))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextName, textInputLayoutName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextTelp, textInputLayoutTelp, getString(R.string.error_message_telp))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextSekolah, textInputLayoutSekolah, getString(R.string.error_message_sklh))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }
        if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                textInputLayoutConfirmPassword, getString(R.string.error_password_match))) {
            return;
        }

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setNisn(Integer.parseInt(textInputEditTextNisn.getText().toString().trim()));
            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setTelp(textInputEditTextTelp.getText().toString().trim());
            user.setSekolah(textInputEditTextSekolah.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());

            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(linearLayout, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();


        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(linearLayout, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        textInputEditTextNisn.setText(null);
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextTelp.setText(null);
        textInputEditTextSekolah.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
    }
}

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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private LinearLayout linearLayout;

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private AppCompatTextView appCompatTextViewDaftarLink;
    private Button appCompatButtonLogin;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {

        linearLayout = findViewById(R.id.linearL);

        textInputLayoutEmail = findViewById(R.id.Email);
        textInputLayoutPassword = findViewById(R.id.Password);

        textInputEditTextEmail = findViewById(R.id.EMAIL);
        textInputEditTextPassword = findViewById(R.id.PASSWORD);

        appCompatButtonLogin = findViewById(R.id.Mulai);
        appCompatTextViewDaftarLink = findViewById(R.id.appCompatTextViewDaftarLink);
    }

    private void initListeners() {
        appCompatButtonLogin.setOnClickListener(this);
        appCompatTextViewDaftarLink.setOnClickListener(this);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Mulai:
                verifyFromSQLite();
                break;

            case R.id.appCompatTextViewDaftarLink:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(textInputEditTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(textInputEditTextPassword, textInputLayoutPassword, getString(R.string.error_message_password))) {
            return;
        }

        if (databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim()
                , textInputEditTextPassword.getText().toString().trim())) {


            Intent accountsIntent = new Intent(activity, HomeActivity.class);
            accountsIntent.putExtra("EMAIL", textInputEditTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);


        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(linearLayout, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
    }

}

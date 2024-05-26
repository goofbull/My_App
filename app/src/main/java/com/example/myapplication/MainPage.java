package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class MainPage extends AppCompatActivity {
    Connection connect;
    String ConnectionResult= "";
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        configureGoToQRButton();
    }

    private void configureGoToQRButton()
    {
        Button btnGoToQR = (Button) findViewById(R.id.btnGoToQR);
        btnGoToQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainPage.this, QRScann.class));
            }
        });
    }

    public void GetTextFromSQL(View v)
    {
        TextView tx1 = (TextView) findViewById(R.id.textView);
        TextView tx2 = (TextView) findViewById(R.id.textView2);
        TextView tx3 = (TextView) findViewById(R.id.textView3);
        TextView tx4 = (TextView) findViewById(R.id.textView4);

        try {
            ConnectHelper connectHelper = new ConnectHelper();
            connect = connectHelper.connectionclass();
            if(connect != null)
            {
                String query = "Select * from Product";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while(rs.next())
                {
                    tx1.setText(rs.getString(1));
                    tx2.setText(rs.getString(2));
                    tx3.setText(rs.getString(3));
                    tx4.setText(rs.getString(4));
                }
            }
            else{
                ConnectionResult = "Check Connection";
            }
        }
        catch (Exception ex){
            Log.e("error", Objects.requireNonNull(ex.getMessage()));
        }
    }

}
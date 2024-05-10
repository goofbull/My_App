package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    Connection connect;
    String ConnectionResult= "";
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
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
                String query = "Select from Product";
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

        }
    }

}
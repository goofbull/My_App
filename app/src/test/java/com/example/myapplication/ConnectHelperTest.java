package com.example.myapplication;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.MockedStatic;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectHelperTest {
    @Test
    public void testConnection_Success() {
        ConnectHelper connectHelper = new ConnectHelper();
        Connection connection = connectHelper.connectionclass();

        // Проверяем, что соединение успешно
        assertNotNull("Connection should not be null", connection);
    }

    @Test
    public void testConnection_Failure() {
        ConnectHelper connectHelper = new ConnectHelper() {
            @Override
            public Connection connectionclass() {
                ip = "invalid_ip";
                database = "invalid_db";
                uname = "invalid_user";
                pass = "invalid_password";
                return super.connectionclass();
            }
        };

        Connection connection = connectHelper.connectionclass();

        assertNull("Connection should be null", connection);
    }
}
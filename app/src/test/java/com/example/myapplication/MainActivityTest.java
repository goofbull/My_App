package com.example.myapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

public class MainActivityTest {
    @Before
    public void setUp() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync(() -> {
            MainActivity mainActivity = new MainActivity();
            mainActivity.onCreate(null);
        });
    }

    @Test
    public void testGetTextFromSQL_ValidData() throws Exception {
        // Ввод данных в поля, если необходимо
        // Например, можно создать текстовые поля для ввода логина и пароля


        onView(withId(R.id.loadBtn)).perform(click());

        // Проверяем, что данные были получены и отображены в текстовых полях
        onView(withId(R.id.textView)).check(matches(withText("Product1")));
        onView(withId(R.id.textView2)).check(matches(withText("Product2")));
        onView(withId(R.id.textView3)).check(matches(withText("Product3")));
        onView(withId(R.id.textView4)).check(matches(withText("Product4")));
    }

    @Test
    public void testGetTextFromSQL_NoConnection() throws Exception {
        // Измените настройки, чтобы симулировать отсутствие подключения.
        // Вы можете вручную изменить настройки подключения перед запуском теста.


        onView(withId(R.id.loadBtn)).perform(click());

        // Проверяем, что отображается сообщение о проблеме с соединением
        onView(withId(R.id.textView)).check(matches(withText("Check Connection")));
    }
}
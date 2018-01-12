/*
 * Copyright (C) 2017 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of rebase-android
 *
 * rebase-android is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * rebase-android is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with rebase-android. If not, see <http://www.gnu.org/licenses/>.
 */

package com.dangxy.androidpractice.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * @author drakeet
 */
public class Colorful {

    private static final String KEY_STYLE_NAME = "key_style_name";
    // TODO: 2017/2/25 to be flexible
    private static final String[] STYLE_NAMES = {
        "Default",
        "DarkMagenta"
    };
    private static final int[] STYLES = {
    };
    private Activity activity;


    private Colorful(Activity activity) {
        this.activity = activity;
    }


    @SuppressWarnings("WeakerAccess")
    public class Theme {

        String styleName;


        Theme(String styleName) {
            this.styleName = styleName;
        }


        public void apply() {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
            preferences.edit().putString(KEY_STYLE_NAME, styleName).apply();
            activity.recreate();
        }
    }


    public static void init(Activity activity) {
        String styleName = getCurrentStyleName(activity);
        int styleId = STYLES[getStyleIndexByName(styleName)];
        activity.setTheme(styleId);
    }


    public static Colorful of(Activity activity) {
        return new Colorful(activity);
    }


    public Theme changeOne() {
        int styleIndex = getStyleIndexByName(getCurrentStyleName(activity));
        styleIndex++;
        String styleName = STYLE_NAMES[styleIndex % STYLES.length];
        return new Theme(styleName);
    }


    private static String getCurrentStyleName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(KEY_STYLE_NAME, STYLE_NAMES[0]);
    }


    private static int getStyleIndexByName(String styleName) {
        for (int i = 0; i < STYLE_NAMES.length; i++) {
            if (STYLE_NAMES[i].equals(styleName)) {
                return i;
            }
        }
        return 0;
    }
}

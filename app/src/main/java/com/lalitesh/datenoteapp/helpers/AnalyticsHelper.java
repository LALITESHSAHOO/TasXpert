/*
 * Copyright (C) 2018 Lalitesh Sahoo (lsdevloper@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.lalitesh.datenoteapp.helpers;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.lalitesh.datenoteapp.BuildConfig;
import com.lalitesh.datenoteapp.utils.Constants;
import org.piwik.sdk.Piwik;
import org.piwik.sdk.Tracker;

import java.net.MalformedURLException;


public class AnalyticsHelper {

	private static Tracker tracker;

	private static boolean enabled;

	public enum CATEGORIES {ACTION, SETTING, UPDATE}


	public static void init(Application application, boolean enableAnalytics) {
		enabled = enableAnalytics && !TextUtils.isEmpty(BuildConfig.ANALYTICS_URL);
		if (tracker == null && enabled) {
			try {
				tracker = Piwik.getInstance(application).newTracker(BuildConfig.ANALYTICS_URL, 1);
				tracker.setUserId(Settings.Secure.getString(application.getContentResolver(), Settings.Secure
						.ANDROID_ID));
				tracker.trackAppDownload();
			} catch (MalformedURLException e) {
				Log.e(Constants.TAG, "Malformed url to get analytics tracker", e);
			}
		}
	}


	public static Tracker getTracker() {
		return tracker;
	}


	public static void trackScreenView(String screenName) {
		if (checkInit()) {
			tracker.trackScreenView(screenName);
		}
	}


	public static void trackEvent(CATEGORIES category, String action) {
		if (checkInit()) {
			tracker.trackEvent(category.name(), action);
		}
	}


	public static void trackActionFromResourceId(Activity activity, int resourceId) {
		if (checkInit()) {
			try {
				tracker.trackEvent(CATEGORIES.ACTION.name(), activity.getResources().getResourceEntryName(resourceId));
			} catch (Resources.NotFoundException e) {
				Log.w(Constants.TAG, "No resource name found for request id");
			}
		}
	}


	private static boolean checkInit() {
		if (enabled && tracker == null) {
			throw new NullPointerException("Call AnalyticsHelper.init() before using analytics tracker");
		}
		return enabled;
	}
}
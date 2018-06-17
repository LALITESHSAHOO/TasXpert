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

package com.lalitesh.datenoteapp.utils;

import android.content.Context;
import android.util.Log;

import java.io.Closeable;
import java.io.IOException;


/**
 * Various utility methods
 */
public class SystemHelper {

	/**
	 * Performs a full app restart
	 */
	public static void restartApp(final Context mContext, Class activityClass) {
//		Intent intent = new Intent(mContext, activityClass);
//		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		int mPendingIntentId = Long.valueOf(Calendar.getInstance().getTimeInMillis()).intValue();
//		PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, mPendingIntentId, intent,
//				PendingIntent.FLAG_CANCEL_CURRENT);
//		AlarmManager mgr = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
//		mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
		System.exit(0);
	}


	/**
	 * Performs closure of multiple closeables objects
	 *
	 * @param closeables Objects to close
	 */
	public static void closeCloseable(Closeable... closeables) {
		for (Closeable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (IOException e) {
					Log.w(Constants.TAG, "Can't close " + closeable, e);
				}
			}
		}
	}
}

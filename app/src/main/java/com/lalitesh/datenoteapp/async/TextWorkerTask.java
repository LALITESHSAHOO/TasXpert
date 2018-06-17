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

package com.lalitesh.datenoteapp.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.lalitesh.datenoteapp.R;
import com.lalitesh.datenoteapp.models.Note;
import com.lalitesh.datenoteapp.utils.TextHelper;

import java.lang.ref.WeakReference;


public class TextWorkerTask extends AsyncTask<Note, Void, Spanned[]> {

    private final WeakReference<Activity> mActivityWeakReference;
    private Activity mActivity;
    private TextView titleTextView;
    private TextView contentTextView;
    private boolean expandedView;


    public TextWorkerTask(Activity activity, TextView titleTextView,
                          TextView contentTextView, boolean expandedView) {
        mActivityWeakReference = new WeakReference<>(activity);
        mActivity = activity;
        this.titleTextView = titleTextView;
        this.contentTextView = contentTextView;
        this.expandedView = expandedView;
    }


    @Override
    protected Spanned[] doInBackground(Note... params) {
        return TextHelper.parseTitleAndContent(mActivity, params[0]);
    }


    @Override
    protected void onPostExecute(Spanned[] titleAndContent) {
        if (isAlive()) {
            titleTextView.setText(titleAndContent[0]);
            if (titleAndContent[1].length() > 0) {
                String htmlString = Html.toHtml(titleAndContent[1]);
               if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    contentTextView.setText(Html.fromHtml(htmlString,Html.FROM_HTML_MODE_LEGACY));
                } else {
                    contentTextView.setText(Html.fromHtml(htmlString));
                }
                //contentTextView.setText(titleAndContent[1]);
                contentTextView.setVisibility(View.VISIBLE);
            } else {
                if (expandedView) {
                    contentTextView.setVisibility(View.INVISIBLE);
                } else {
                    contentTextView.setVisibility(View.GONE);
                }
            }
        }
    }


    /**
     * Cheks if activity is still alive and not finishing
     *
     * @param weakDetailFragmentReference
     * @return True or false
     */
    private boolean isAlive() {
        return mActivityWeakReference != null
                && mActivityWeakReference.get() != null;

    }

}
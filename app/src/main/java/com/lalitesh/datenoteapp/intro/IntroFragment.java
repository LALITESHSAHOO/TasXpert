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

package com.lalitesh.datenoteapp.intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.lalitesh.datenoteapp.R;


public class IntroFragment extends Fragment {

	@Bind(R.id.intro_background)
	View background;

	@Bind(R.id.intro_title)
	TextView title;

	@Bind(R.id.intro_image)
	ImageView image;

	@Bind(R.id.intro_image_small)
	ImageView image_small;

	@Bind(R.id.intro_description)
	TextView description;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.intro_slide, container, false);
		ButterKnife.bind(this, v);
		return v;
	}
}
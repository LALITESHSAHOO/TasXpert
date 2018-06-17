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

import android.graphics.Color;
import android.os.Bundle;
import com.lalitesh.datenoteapp.R;


public class IntroSlide2 extends IntroFragment {

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		background.setBackgroundColor(Color.parseColor("#F58D74"));
		title.setText("Elegant UI");
		image.setImageResource(R.drawable.slide2);
		description.setText(R.string.tour_listactivity_home_detail);
	}
}
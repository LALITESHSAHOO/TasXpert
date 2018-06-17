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

package com.lalitesh.datenoteapp.fab;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.view.ViewPropertyAnimator;

/**
 * Created by Toan Vu on 6/23/16.
 */
public class FabAnimationUtils {
    public static final int ANIM_NONE = 0;
    public static final int ANIM_TRANSLATION_Y = 1;
    public static final int ANIM_SCALE = 2;
    public static final int ANIM_FADE = 3;
    public static final int ANIM_TRANSLATION_X = 4;
    //time animation when scrolling
    private static final int TRANSLATE_DURATION_MILLIS = 250;
    private static final Interpolator mInterpolator = new AccelerateDecelerateInterpolator();
    private static final Interpolator mInterpolatorAccelerate = new AccelerateInterpolator();
    private static final Interpolator mInterpolatorDecelerate = new DecelerateInterpolator();
    private static final OvershootInterpolator mInterpolatorOverShoot = new OvershootInterpolator();

    static void scale(View group, View view, boolean visible) {
        AnimListener animListener = new AnimListener(group, visible);
        float scale = visible ? 1 : 0;
        Interpolator interpolator = visible ? mInterpolatorOverShoot : mInterpolatorAccelerate;
        ViewPropertyAnimator.animate(view).setInterpolator(interpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .scaleX(scale);
        ViewPropertyAnimator.animate(view).setInterpolator(interpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .scaleY(scale).setListener(animListener);

    }

    static void translationY(View view, boolean visible, int height, int marginBottom) {
        int translationY = visible ? 0 : height + marginBottom;
        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .translationY(translationY);
    }

    static void translationX(View group, View view, boolean visible, int width, int marginRight) {
        int translationX = visible ? 0 : width + marginRight;
        ViewPropertyAnimator.animate(group).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .translationX(translationX);
        float rotate = visible ? -720 : 720;
                ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .rotation(rotate);
    }

    static void fade(View group,boolean visible) {
        AnimListener animListener = new AnimListener(group, visible);
        float scale = visible ? 1 : 0;
        Interpolator interpolator = visible ? mInterpolator : mInterpolatorAccelerate;
        ViewPropertyAnimator.animate(group).setInterpolator(interpolator)
                .setDuration(TRANSLATE_DURATION_MILLIS)
                .alpha(scale).setListener(animListener);

    }
    //TODO: later
    static void rotate(View view, boolean visible, int height, int marginBottom) {
        float rotateXBy = visible ? 500 : -500;
        float rotateX = visible ? -30 : -30;
        float rotateYBy = visible ? 0 : 0;
        float rotateY = visible ? 30 : 390;
//        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
//                .setDuration(TRANSLATE_DURATION_MILLIS)
//                .rotation(rotateXBy);
//        ViewPropertyAnimator.animate(view).setInterpolator(mInterpolator)
//                .setDuration(TRANSLATE_DURATION_MILLIS)
//                .rotationYBy(rotateYBy).rotationY(rotateY);

        translationY(view, visible, height, marginBottom);
    }


    static class AnimListener implements Animator.AnimatorListener {
        private View view;
        private boolean visible;

        public AnimListener(View view, boolean visible) {
            this.view = view;
            this.visible = visible;
        }

        @Override
        public void onAnimationStart(Animator animation) {
            view.setVisibility(View.VISIBLE);
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

}

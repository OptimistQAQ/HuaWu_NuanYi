package com.example.lbstest.CardView.card;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nhaarman.listviewanimations.swinginadapters.AnimationAdapter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

public class CardsAnimationAdapter extends AnimationAdapter {
    private float mTranslationY = 400;
    private float mRotationX = 15;
    private long mDuration = 400;
    private long mDelay = 30;

    public CardsAnimationAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
    }

    @Override
    protected long getAnimationDelayMillis() {
        return mDelay;
    }

    @Override
    protected long getAnimationDurationMillis() {
        return mDuration;
    }

    @Override
    public Animator[] getAnimators(ViewGroup viewGroup, View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationY", mTranslationY, 0),
                ObjectAnimator.ofFloat(view, "rotationX", mRotationX, 0)
        };
    }
}

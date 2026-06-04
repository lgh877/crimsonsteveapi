package com.crimsonsteve.crimsonsteveapi.utils.animations;

import java.util.List;

public class FadingOutAnimation {
    private List<FadingOutAnimation> ownerList;
    public static final int DEFAULT_FADE_OUT = 5;
    public final int finalTime, maxFadeOutTime, animIdx;
    public int remainingFadeOutTime;
    public boolean shouldBeRemoved = false;

    public FadingOutAnimation(List<FadingOutAnimation> ownerList, int finalTime, int fadeOutTime, int animIdx) {
        this.ownerList = ownerList;
        this.finalTime = finalTime;
        this.animIdx = animIdx;
        remainingFadeOutTime = maxFadeOutTime = fadeOutTime;
    }

    public FadingOutAnimation(List<FadingOutAnimation> ownerList, int finalTime, int animIdx) {
        this(ownerList, finalTime, DEFAULT_FADE_OUT, animIdx);
    }

    public void tick() {
        remainingFadeOutTime--;
        shouldBeRemoved = remainingFadeOutTime == 0;
    }

    public void cleanup() {
        this.ownerList.remove(this);
    }
}
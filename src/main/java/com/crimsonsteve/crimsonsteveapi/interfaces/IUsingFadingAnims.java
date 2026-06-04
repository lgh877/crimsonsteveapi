package com.crimsonsteve.crimsonsteveapi.interfaces;

import com.crimsonsteve.crimsonsteveapi.utils.animations.FadingOutAnimation;

import java.util.List;

public interface IUsingFadingAnims extends IUsingCustomVanillaAnimations {
    List<FadingOutAnimation> getFadingAnims();

    float getFadeInTime(float partialTicks);
}
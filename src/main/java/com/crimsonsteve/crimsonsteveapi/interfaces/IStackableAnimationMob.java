package com.crimsonsteve.crimsonsteveapi.interfaces;

import com.crimsonsteve.crimsonsteveapi.utils.animations.BaseAnimation;

import java.util.concurrent.CopyOnWriteArrayList;

public interface IStackableAnimationMob {
    CopyOnWriteArrayList<? extends BaseAnimation> getAnimList();
}

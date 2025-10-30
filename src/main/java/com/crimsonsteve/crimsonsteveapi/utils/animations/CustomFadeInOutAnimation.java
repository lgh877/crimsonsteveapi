package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;

import java.util.List;

public class CustomFadeInOutAnimation extends UsualAnimation {
    public CustomFadeInOutAnimation(AnimationDefinition anim, int tick, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount, int lifeTime) {
        super(anim, tick, amplitude, ownerList, maxActiveAmount, lifeTime);
    }

    public float getFadeInFactor(float fadeFactor) {
        return fadeFactor;
    }

    public float getFadeOutFactor(float fadeFactor) {
        return fadeFactor;
    }

    @Override
    protected void doAnimate(HierarchicalModel<?> m, float tick, float speed, float fadeFactor) {
        if (!fullyActive) {
            AnimUtil.animateAmplitude(m, animState, anim, tick, speed, amplitude * getFadeInFactor(fadeFactor));
        } else
            AnimUtil.animateAmplitude(m, animState, anim, tick, speed, amplitude * getFadeOutFactor(fadeFactor));
    }
}

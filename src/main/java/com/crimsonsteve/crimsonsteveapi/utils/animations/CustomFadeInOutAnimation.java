package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.EntityModel;

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
    protected void doAnimate(EntityModel<?> m, float tick, float speed, float fadeFactor) {
        if (!fullyActive) {
            AnimUtil.animateAmplitude(getKeyframeAnimation(m), animState, tick, speed, amplitude * getFadeInFactor(fadeFactor));
        } else
            AnimUtil.animateAmplitude(getKeyframeAnimation(m), animState, tick, speed, amplitude * getFadeOutFactor(fadeFactor));
    }
}

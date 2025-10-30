package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.world.entity.AnimationState;

import java.util.List;

public class UsualAnimation extends BaseAnimation {
    protected int lifeTime;
    protected AnimationState animState;

    public UsualAnimation(AnimationDefinition anim, AnimationState animState, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount, int lifeTime) {
        super(anim, amplitude, ownerList, maxActiveAmount);
        this.lifeTime = lifeTime;
        this.animState = animState;
    }

    public UsualAnimation(AnimationDefinition anim, int tick, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount, int lifeTime) {
        super(anim, amplitude, ownerList, maxActiveAmount);
        this.lifeTime = lifeTime;
        this.animState = new AnimationState();
        animState.start(tick);
    }

    @Override
    protected void doAnimate(HierarchicalModel<?> m, float tick, float speed, float fadeFactor) {
        AnimUtil.animateAmplitude(m, animState, anim, tick, speed, amplitude * fadeFactor);
    }

    @Override
    protected boolean evaluateActive() {
        return lifeTime-- > 0;
    }

    @Override
    public void discard() {
        super.discard();
        animState.stop();
    }
}

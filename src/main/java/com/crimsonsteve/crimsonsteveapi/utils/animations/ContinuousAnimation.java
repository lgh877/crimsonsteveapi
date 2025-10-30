package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.world.entity.AnimationState;

import java.util.List;
import java.util.function.BooleanSupplier;

public class ContinuousAnimation extends BaseAnimation {
    private final BooleanSupplier syncSupplier;
    private final AnimationState animState;

    public ContinuousAnimation(AnimationDefinition anim, AnimationState animState, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount, BooleanSupplier syncSupplier) {
        super(anim, amplitude, ownerList, maxActiveAmount);
        this.syncSupplier = syncSupplier;
        this.animState = animState;
    }

    public ContinuousAnimation(AnimationDefinition anim, int tick, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount, BooleanSupplier syncSupplier) {
        super(anim, amplitude, ownerList, maxActiveAmount);
        this.syncSupplier = syncSupplier;
        this.animState = new AnimationState();
        animState.start(tick);
    }

    @Override
    protected void doAnimate(HierarchicalModel<?> m, float tick, float speed, float fadeFactor) {
        AnimUtil.animateAmplitude(m, animState, anim, tick, speed, amplitude * fadeFactor);
    }

    @Override
    protected boolean evaluateActive() {
        return syncSupplier.getAsBoolean();
    }

    @Override
    public void discard() {
        super.discard();
        animState.stop();
    }

}

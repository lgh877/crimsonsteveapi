package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;

import java.util.List;

public abstract class BaseAnimation {
    public boolean active = true, fullyActive = false, isInstant = false;
    protected float amplitude;
    protected float remainingFadeTicks = 0;
    protected final float maxActiveAmount;
    protected final AnimationDefinition anim;
    protected final List<BaseAnimation> ownerList;
    public float speed = 1f;

    public BaseAnimation(AnimationDefinition anim, float amplitude, List<BaseAnimation> ownerList, int maxActiveAmount) {
        this.anim = anim;
        this.amplitude = amplitude;
        this.maxActiveAmount = maxActiveAmount;
        this.ownerList = ownerList;
    }

    public final void animate(HierarchicalModel<?> model, float tick, float partialTicks) {
        float factor;
        if (active)
            factor = fullyActive ? 1f : (remainingFadeTicks + partialTicks) / maxActiveAmount;
        else
            factor = (remainingFadeTicks - partialTicks) / maxActiveAmount;
        doAnimate(model, tick, speed, factor);
    }

    public final void tick() {
        if (!active) {
            if (--remainingFadeTicks == 0 || isInstant) {
                ownerList.remove(this);
            }
        } else {
            if (!fullyActive) {
                remainingFadeTicks++;
                if (remainingFadeTicks == maxActiveAmount)
                    fullyActive = true;
            }
            active = evaluateActive();
        }
    }

    public void discard() {
        ownerList.remove(this);
    }

    protected abstract void doAnimate(HierarchicalModel<?> model, float tick, float speed, float fadeFactor);

    protected abstract boolean evaluateActive();
}


package com.crimsonsteve.crimsonsteveapi.utils.animations.models;

import com.crimsonsteve.crimsonsteveapi.interfaces.IUsingFadingAnims;
import com.crimsonsteve.crimsonsteveapi.utils.animations.FadingOutAnimation;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.animation.AnimationDefinition;

import java.util.function.Function;
import java.util.List;

public abstract class FadingAnimsModel<E extends Entity & IUsingFadingAnims> extends HierarchicalModel<E> {
    public FadingAnimsModel() {
        super(RenderType::entityCutoutNoCull);
    }

    public FadingAnimsModel(Function<ResourceLocation, RenderType> p_170623_) {
        super(p_170623_);
    }

    public void applyFadingAnims(E entity, float partialTicks, AnimationDefinition[] animations) {
        List<FadingOutAnimation> list = entity.getFadingAnims();
        float animTicks = entity.getAnimTicks(partialTicks);
        this.animateWalk(animations[entity.getAnimIndex()], animTicks, entity.getFadeInTime(partialTicks), 1f, 1f);
        for (int i = list.size() - 1; i >= 0; i--) {
            FadingOutAnimation anim = list.get(i);
            if (anim.shouldBeRemoved) {
                anim.cleanup();
                continue;
            }
            this.animateWalk(animations[anim.animIdx], anim.finalTime, (float) Math.max(anim.remainingFadeOutTime - partialTicks, 0) / anim.maxFadeOutTime, 1f, 1f);
        }
    }
}
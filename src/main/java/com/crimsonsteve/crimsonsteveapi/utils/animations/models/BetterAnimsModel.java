package com.crimsonsteve.crimsonsteveapi.utils.animations.models;

import com.crimsonsteve.crimsonsteveapi.interfaces.IUsingCustomVanillaAnimations;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.animation.AnimationDefinition;

import java.util.function.Function;

public abstract class BetterAnimsModel<E extends Entity & IUsingCustomVanillaAnimations> extends HierarchicalModel<E> {
    public BetterAnimsModel() {
        super(RenderType::entityCutoutNoCull);
    }

    public BetterAnimsModel(Function<ResourceLocation, RenderType> p_170623_) {
        super(p_170623_);
    }

    public void applyAnims(E entity, float partialTicks, AnimationDefinition[] animations) {
        float animTicks = entity.getAnimTicks(partialTicks);
        this.animateWalk(animations[entity.getAnimIndex()], animTicks, 1f, 1f, 1f);
    }
}
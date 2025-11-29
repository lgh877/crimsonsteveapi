package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.world.entity.AnimationState;
import org.joml.Vector3f;

public class AnimUtil {
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

    public static void animateAmplitude(HierarchicalModel<?> model, AnimationState anim, AnimationDefinition animDef, float tick, float speed, float amplitude) {
        anim.updateTime(tick, speed);
        anim.ifStarted((p_233392_) -> {
            KeyframeAnimations.animate(model, animDef, p_233392_.getAccumulatedTime(), amplitude, ANIMATION_VECTOR_CACHE);
        });
    }

    public static void animateWalkAmplitude(HierarchicalModel<?> model, AnimationDefinition animDef, float limbSwing, float limbSwingAmount, float speed, float amplitude) {
        long i = (long) (limbSwing * 50.0F * speed);
        float f = limbSwingAmount * amplitude;
        KeyframeAnimations.animate(model, animDef, i, f, ANIMATION_VECTOR_CACHE);
    }

    public static void animationBasedYawControl(HierarchicalModel<?> model, AnimationDefinition lookLeft, AnimationDefinition lookRight, float headYaw){
        if(headYaw > 0) KeyframeAnimations.animate(model, lookLeft, 1, headYaw, ANIMATION_VECTOR_CACHE);
        else if(headYaw != 0) KeyframeAnimations.animate(model, lookRight, 1, -headYaw, ANIMATION_VECTOR_CACHE);
    }

    public static void animationBasedPitchControl(HierarchicalModel<?> model, AnimationDefinition lookUp, AnimationDefinition lookDown, float headPitch){
        if(headPitch > 0) KeyframeAnimations.animate(model, lookDown, 1, headPitch, ANIMATION_VECTOR_CACHE);
        else if(headPitch != 0) KeyframeAnimations.animate(model, lookUp, 1, -headPitch, ANIMATION_VECTOR_CACHE);
    }
}

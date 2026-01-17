package com.crimsonsteve.crimsonsteveapi.utils.animations;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.world.entity.AnimationState;
import org.joml.Vector3f;

public class AnimUtil {
    public static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

    public static void animateAmplitude(KeyframeAnimation keyframeAnimation, AnimationState anim, float tick, float speed, float amplitude) {
        anim.ifStarted((p_427385_) -> keyframeAnimation.apply((long)((float)p_427385_.getTimeInMillis(tick) * speed), amplitude));
    }

    public static void animateWalkAmplitude(KeyframeAnimation keyframeAnimation, float limbSwing, float limbSwingAmount, float speed, float amplitude) {
        long i = (long)(limbSwing * 50.0F * speed);
        float f = limbSwingAmount * amplitude;
        keyframeAnimation.apply(i, f);
        /*
        long i = (long) (limbSwing * 50.0F * speed);
        float f = limbSwingAmount * amplitude;
        KeyframeAnimations.animate(model, animDef, i, f, ANIMATION_VECTOR_CACHE);
         */
    }

    public static void animationBasedYawControl(KeyframeAnimation lookLeft, KeyframeAnimation lookRight, float headYaw){
        if(headYaw > 0) lookRight.apply(0L, headYaw);
        else lookLeft.apply(0L, headYaw);
        //if(headYaw > 0) KeyframeAnimations.animate(model, lookRight, 1, headYaw, ANIMATION_VECTOR_CACHE);
        //else if(headYaw != 0) KeyframeAnimations.animate(model, lookLeft, 1, -headYaw, ANIMATION_VECTOR_CACHE);
    }

    public static void animationBasedPitchControl(KeyframeAnimation lookUp, KeyframeAnimation lookDown, float headPitch){
        if(headPitch > 0) lookDown.apply(0L, headPitch);
        else lookUp.apply(0L, -headPitch);
        //if(headPitch > 0) KeyframeAnimations.animate(model, lookDown, 1, headPitch, ANIMATION_VECTOR_CACHE);
        //else if(headPitch != 0) KeyframeAnimations.animate(model, lookUp, 1, -headPitch, ANIMATION_VECTOR_CACHE);
    }
}

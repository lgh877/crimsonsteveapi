package com.crimsonsteve.crimsonsteveapi.interfaces;

import com.crimsonsteve.crimsonsteveapi.utils.animations.BaseAnimation;
import net.minecraft.client.model.EntityModel;

import java.util.concurrent.CopyOnWriteArrayList;

public interface IStackableAnimationMob {
    CopyOnWriteArrayList<? extends BaseAnimation> getAnimList();

    default void animateMob(EntityModel<?> entityModel, float ageInTicks, float partialTicks){
        for (BaseAnimation anim : getAnimList()) {
            anim.animate(entityModel, ageInTicks, partialTicks);
        }
    }

    default void tickAnims(){
        for (BaseAnimation anim : getAnimList()) {
            anim.tick();
        }
    }
}

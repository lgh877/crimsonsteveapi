package com.crimsonsteve.crimsonsteveapi.interfaces;

import com.crimsonsteve.crimsonsteveapi.utils.animations.BaseAnimation;
import net.minecraft.client.model.HierarchicalModel;

import java.util.concurrent.CopyOnWriteArrayList;

public interface IStackableAnimationMob {
    CopyOnWriteArrayList<? extends BaseAnimation> getAnimList();

    default void animateMob(HierarchicalModel<?> hierarchicalModel, float ageInTicks, float partialTicks){
        for (BaseAnimation anim : getAnimList()) {
            anim.animate(hierarchicalModel, ageInTicks, partialTicks);
        }
    }

    default void tickAnims(){
        for (BaseAnimation anim : getAnimList()) {
            anim.tick();
        }
    }
}

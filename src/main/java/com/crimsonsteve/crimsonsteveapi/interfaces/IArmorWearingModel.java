package com.crimsonsteve.crimsonsteveapi.interfaces;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.entity.EquipmentSlot;

public interface IArmorWearingModel {
    void translateArmor(EquipmentSlot modelPart, PoseStack stack, boolean innerModel);
}

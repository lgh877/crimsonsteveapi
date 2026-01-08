package com.crimsonsteve.crimsonsteveapi.layers;
/*
import com.crimsonsteve.crimsonsteveapi.interfaces.IHierarchicalHeadedModel;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.blockentity.SkullBlockRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.SkullModelBase;
import net.minecraft.client.model.EntityModel;

import java.util.Map;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.authlib.GameProfile;

@OnlyIn(Dist.CLIENT)
public class HierarchicalCustomHeadLayer<T extends LivingEntity, M extends EntityModel<T> & IHierarchicalHeadedModel> extends RenderLayer<T, M> {
    private final float scaleX;
    private final float scaleY;
    private final float scaleZ;
    private final Map<SkullBlock.Type, SkullModelBase> skullModels;
    private final ItemInHandRenderer itemInHandRenderer;

    public HierarchicalCustomHeadLayer(RenderLayerParent<T, M> p_234829_, EntityModelSet p_234830_, ItemInHandRenderer p_234831_) {
        this(p_234829_, p_234830_, 1.0F, 1.0F, 1.0F, p_234831_);
    }

    public HierarchicalCustomHeadLayer(RenderLayerParent<T, M> p_234822_, EntityModelSet p_234823_, float p_234824_, float p_234825_, float p_234826_, ItemInHandRenderer p_234827_) {
        super(p_234822_);
        this.scaleX = p_234824_;
        this.scaleY = p_234825_;
        this.scaleZ = p_234826_;
        this.skullModels = SkullBlockRenderer.createSkullRenderers(p_234823_);
        this.itemInHandRenderer = p_234827_;
    }

    public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int p_116733_, T mob, float p_116735_, float p_116736_, float p_116737_, float p_116738_, float p_116739_, float p_116740_) {
        ItemStack itemstack = mob.getItemBySlot(EquipmentSlot.HEAD);
        if (!itemstack.isEmpty()) {
            Item item = itemstack.getItem();
            poseStack.pushPose();
            poseStack.scale(this.scaleX, this.scaleY, this.scaleZ);
            /*
            if (p_116734_.isBaby() && !(p_116734_ instanceof Villager)) {
                float f = 2.0F;
                float f1 = 1.4F;
                poseStack.translate(0.0D, 0.03125D, 0.0D);
                poseStack.scale(0.7F, 0.7F, 0.7F);
                poseStack.translate(0.0D, 1.0D, 0.0D);
            }
            */
/*
            this.getParentModel().translateToHead(poseStack);
            if (item instanceof BlockItem && ((BlockItem) item).getBlock() instanceof AbstractSkullBlock) {
                float f2 = 1.1875F;
                poseStack.scale(1.1875F, -1.1875F, -1.1875F);
                GameProfile gameprofile = null;
                if (itemstack.hasTag()) {
                    CompoundTag compoundtag = itemstack.getTag();
                    if (compoundtag.contains("SkullOwner", 10)) {
                        gameprofile = NbtUtils.readGameProfile(compoundtag.getCompound("SkullOwner"));
                    }
                }
                poseStack.translate(-0.5D, 0.0D, -0.5D);
                SkullBlock.Type skullblock$type = ((AbstractSkullBlock) ((BlockItem) item).getBlock()).getType();
                SkullModelBase skullmodelbase = this.skullModels.get(skullblock$type);
                RenderType rendertype = SkullBlockRenderer.getRenderType(skullblock$type, gameprofile);
                SkullBlockRenderer.renderSkull((Direction) null, 180.0F, p_116735_, poseStack, multiBufferSource, p_116733_, skullmodelbase, rendertype);
            } else if (!(item instanceof ArmorItem) || ((ArmorItem) item).getEquipmentSlot() != EquipmentSlot.HEAD) {
                translateToHead(poseStack);
                this.itemInHandRenderer.renderItem(mob, itemstack, ItemDisplayContext.HEAD, false, poseStack, multiBufferSource, p_116733_);
            }
            poseStack.popPose();
        }
    }

    public static void translateToHead(PoseStack poseStack) {
        float f = 0.625F;
        poseStack.translate(0.0D, -0.25D, 0.0D);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
        poseStack.scale(0.625F, -0.625F, -0.625F);
    }
}
*/

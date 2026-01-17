package com.crimsonsteve.crimsonsteveapi.utils;

import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

public class VectorHelper {
    public static Vec3 calculateViewVector(float xRot, float yRot) {
        float f = xRot * (Mth.PI / 180F);
        float f1 = -yRot * (Mth.PI / 180F);
        float f2 = Mth.cos(f1);
        float f3 = Mth.sin(f1);
        float f4 = Mth.cos(f);
        float f5 = Mth.sin(f);
        return new Vec3((double) (f3 * f4), (double) (-f5), (double) (f2 * f4));
    }

    public static Vec3 calculateFlatViewVector(float yRot) {
        float f1 = -yRot * (Mth.PI / 180F);
        float f2 = Mth.cos(f1);
        float f3 = Mth.sin(f1);
        return new Vec3((double) f3, 0, (double) f2);
    }
}

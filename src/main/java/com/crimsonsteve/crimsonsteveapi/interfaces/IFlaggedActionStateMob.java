package com.crimsonsteve.crimsonsteveapi.interfaces;

public interface IFlaggedActionStateMob extends IActionStateMob {
    boolean getFlagActionState(int input);
    void setFlagActionState(int input, boolean flag);
}

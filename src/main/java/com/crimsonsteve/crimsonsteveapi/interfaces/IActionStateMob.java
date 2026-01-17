package com.crimsonsteve.crimsonsteveapi.interfaces;

public interface IActionStateMob {
    int getActionState();

    void setActionState(int input);

    boolean isInAction();

    boolean isInDeathAction();
}

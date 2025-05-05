package com.karpeko.c.themes.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.karpeko.c.R;
import com.karpeko.c.databinding.Quest2Binding;
import com.karpeko.c.databinding.Quest3Binding;

public class Quest3 extends Quest {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quest3, container, false);
        answer(view, new Quest4());

        return view;
    }
}

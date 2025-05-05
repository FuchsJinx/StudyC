package com.karpeko.c.themes.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.karpeko.c.R;
import com.karpeko.c.databinding.Quest1Binding;

public class Quest12 extends Quest {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quest12, container, false);
        answer(view, new Quest13());

        return view;
    }
}

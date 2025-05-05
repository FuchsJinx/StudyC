package com.karpeko.c.themes.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.karpeko.c.R;
import com.karpeko.c.databinding.Quest1Binding;
import com.karpeko.c.databinding.Quest2Binding;

public class Quest2 extends Quest {

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.quest2, container, false);
            answer(view, new Quest3());

            return view;
        }
}

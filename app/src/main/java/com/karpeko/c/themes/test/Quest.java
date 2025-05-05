package com.karpeko.c.themes.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.karpeko.c.R;
import com.karpeko.c.databinding.Quest1Binding;

import java.util.Objects;

public class Quest extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected void answer(View view, Fragment fragment) {
        Button isRightButton = view.findViewById(R.id.isRight);
        isRightButton.setOnClickListener(v -> {
            CountingResults.isRightAnswer++;
            transition(fragment);
        });

        Button isFalseButton1 = view.findViewById(R.id.isFalse1);
        isFalseButton1.setOnClickListener(v -> transition(fragment));
        Button isFalseButton2 = view.findViewById(R.id.isFalse2);
        isFalseButton2.setOnClickListener(v -> transition(fragment));
        Button isFalseButton3 = view.findViewById(R.id.isFalse3);
        isFalseButton3.setOnClickListener(v -> transition(fragment));
    }

    private void transition(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
        this.onDestroyView();
    }
}

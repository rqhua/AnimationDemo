package com.rqhua.demo.animationdemo;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {

    private View view;
    private MyAnimation animation;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation = new MyAnimation();
//        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatCount(1);
        view = findViewById(R.id.text);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        animationTest();
//        view.startAnimation(animation);
        Animator animator = AnimatorInflater.loadAnimator(this, R.animator.afasd);
// 载入XML动画

        animator.setTarget(view);
// 设置动画对象

        animator.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        view.clearAnimation();
    }

    public void animationTest(){
        ObjectAnimator animator = new ObjectAnimator();
        ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.5f, 0.8f, 1.0f);
        ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(view, "scaleX", 0.0f, 1.0f);
        ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(view, "scaleY", 0.0f, 2.0f);
        ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
        ObjectAnimator transXAnim = ObjectAnimator.ofFloat(view, "translationX", 100, 400);
//        ObjectAnimator transYAnim = ObjectAnimator.ofFloat(view, "tranlsationY", 100, 750);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim/*, transYAnim*/);
//                set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
        set.setDuration(3000);
        set.start();
    }
}
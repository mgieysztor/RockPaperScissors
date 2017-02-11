package com.sdacademy.gieysztor.michal.rockpaperscissors;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final int ATTACK_ROCK = 0;
    public static final int ATTACK_PAPER = 1;
    public static final int ATTACK_SCISSORS = 2;
    private int computerAttack;
    private int myDrawableAttack;
    private int computerDrawableAttack;
    private int myAttack;
    Random generator = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private enum VictoryState {
        WIN,
        LOOSE,
        EVEN

    }

    public VictoryState getVictoryState() {
        if (myAttack == computerAttack) {
            return VictoryState.EVEN;
        } else if (myAttack == ATTACK_SCISSORS && computerAttack == ATTACK_PAPER
                || myAttack == ATTACK_PAPER && computerAttack == ATTACK_ROCK
                || myAttack == ATTACK_ROCK && computerAttack == ATTACK_SCISSORS) {
            return VictoryState.WIN;
        } else {
            return VictoryState.LOOSE;
        }
    }

    public void checkVictory (){
        VictoryState victoryState= getVictoryState();

        String msg = "Remis";

    }

    public void attack(View view) {
        switch (view.getId()) {
            case R.id.rock:
                myAttack = ATTACK_ROCK;
                break;
            case R.id.paper:
                myAttack = ATTACK_PAPER;
                break;
            case R.id.scissors:
                myAttack = ATTACK_SCISSORS;
                break;
        }
        computerAttack = generator.nextInt(ATTACK_SCISSORS + 1);

        myDrawableAttack = getDrawableId(myAttack);
        computerDrawableAttack = getDrawableId(computerAttack);

        Drawable drawable = ContextCompat.getDrawable(this, myDrawableAttack);
        myChoose.setImageDrawable(ContextCompat.getDrawable(this, computerDrawableAttack));
    }

    private int getDrawableId(int attackType) {
        switch (attackType) {
            case ATTACK_ROCK:
                return R.drawable.ic_rock_24dp;
            case ATTACK_PAPER:
                return R.drawable.ic_paper_24dp;
            case ATTACK_SCISSORS:
                return R.drawable.ic_scissors_24dp;
            default:
                return android.R.drawable.stat_notify_error;
        }

    }
}

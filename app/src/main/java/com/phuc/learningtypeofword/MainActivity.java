package com.phuc.learningtypeofword;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView numOfWordTV;
    TextView endOfWordTV;
    Button nounBT;
    Button adjBT;
    Button verbBT;
    Button advBT;
    Button restartBT;
    ArrayList<Word> root = Word.getListWord();
    ArrayList<Word> words = new ArrayList<>();
    ArrayList<Integer> listPos;
    int total = root.size();
    int numCorrect;
    int numComplete;
    String numOfWord = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectComponent();
        newGame();

        nounBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(0);
            }
        });

        adjBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(1);
            }
        });

        verbBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(2);
            }
        });

        advBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCorrect(3);
            }
        });

        restartBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newGame();
            }
        });
    }

    void newGame() {
        numCorrect = 0;
        numComplete = 0;
        listPos = randListPos();
        words.clear();
        for(int i = 0; i < listPos.size(); i++){
            words.add(root.get(listPos.get(i)));
        }
        endOfWordTV.setText(words.get(0).getEndOfWord());
        updateNumOfWord();
    }

    void checkCorrect(int typeInput) {
        if(typeInput == words.get(numComplete).getWordType()) {
            numCorrect++;
            updateNumOfWord();
        }
        if(numComplete < total - 1) {
            numComplete++;
            updateNumOfWord();
            endOfWordTV.setText(words.get(numComplete).getEndOfWord());
        }
        else {
            Toast.makeText(getApplicationContext(), "You've finished! Press RESTART to play again1", Toast.LENGTH_LONG).show();
        }
    }

    void updateNumOfWord(){
        numOfWord = numCorrect + "/" + numComplete + "/" + total;
        numOfWordTV.setText(numOfWord);
    }

    void connectComponent() {
        numOfWordTV = (TextView) findViewById(R.id.num_of_word_tv);
        endOfWordTV = (TextView) findViewById(R.id.end_of_word_tv);
        nounBT = (Button) findViewById(R.id.noun_bt);
        adjBT = (Button) findViewById(R.id.adj_bt);
        verbBT = (Button) findViewById(R.id.verb_bt);
        advBT = (Button) findViewById(R.id.adv_bt);
        restartBT = (Button) findViewById(R.id.restart_bt);
        endOfWordTV.setTextSize(50);
    }

    ArrayList<Integer> randListPos() {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < total; i++){
            tmp.add(i);
        }
        for(int i = 0; i < total; i++){
            int pos = new Random().nextInt(tmp.size());
            list.add(tmp.get(pos));
            tmp.remove(tmp.get(pos));
        }
        return list;
    }
}

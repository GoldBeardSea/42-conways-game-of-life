package com.gbbeard.conwaysgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConwaysActivity extends AppCompatActivity
        implements ViewTreeObserver.OnGlobalLayoutListener, View.OnTouchListener{

    public ImageView imageView;
    public Bitmap mBitmap;
    public Canvas mCanvas;


    private Button mTick;
    protected CellEngine engine;
    public int SIZE;
    public static final int cellSize = 20;
    boolean[][] cells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        engine = new CellEngine();
        cells = new boolean[cellSize][cellSize];
        for (int row = 0; row < cellSize; row ++) {
            for (int col = 0; col < cellSize; col++) {
                cells[row][col] = Math.random() < .5;
            }
        }

        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if(viewTreeObserver.isAlive()){
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }

        mTick = findViewById(R.id.tick);
        mTick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int row = 0; row < cells.length; row++) {
                    for (int col = 0; col < cells[row].length; col++) {
                        int cell = engine.checkCells(cells, row, col);
                        if (cell < 2) {
                            cells[row][col] = false;
                        } else if (cell == 2 || cell == 3) {
                            cells[row][col] = true;
                        } else if (cell > 3) {
                            cells[row][col] = false;
                        } else if (cell == 3) {
                            cells[row][col] = true;
                        }
                    }
                }
                drawGrid();
            }
        });

    }

    @Override
    public void onGlobalLayout() {
        initBitmap();

    }

    public void initBitmap(){

        imageView.setOnTouchListener(this);
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        drawGrid();

    }
    public void drawGrid(){

        int height = mCanvas.getHeight();
        int width = mCanvas.getWidth();
        int smallest = Math.min(width, height);
        SIZE = smallest/cells.length;

        float x0 = 0;
        float y0 = 0;

        float x1= SIZE;
        float y1 = SIZE;
        for(int row = 0; row < cells.length; row++){
            x0 = 0;
            x1 = SIZE;
            for(int col = 0; col < cells.length; col++){

                int color;

                if(cells[row][col] == true){
                    color = Color.BLACK;
                } else{
                    color = Color.WHITE;
                }

                Paint brush = new Paint(Paint.ANTI_ALIAS_FLAG);
                brush.setColor(color);

                mCanvas.drawRect(x0,y0,x1,y1,brush);

                x0 += SIZE;
                x1 += SIZE;

            }
            y0 += SIZE;
            y1 += SIZE;
        }

        imageView.setImageBitmap(mBitmap);
    }

    private int xDown;
    private int yDown;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float xx = motionEvent.getX();
        float yy = motionEvent.getY();
        drawGrid();
        if (action == MotionEvent.ACTION_DOWN) {
            xDown = (int) xx / cellSize;
            yDown = (int) yy / cellSize;
            return true;
        }
        return false;
    }

}

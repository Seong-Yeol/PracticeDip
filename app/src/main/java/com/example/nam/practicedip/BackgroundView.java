package com.example.nam.practicedip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by Nam on 2016-04-30.
 */
public class BackgroundView extends View {
    public BackgroundView(Context context){
        super(context);
    }

    public void onDraw(Canvas canvas){
        Bitmap bit;

        Bitmap corner_block1;
        Bitmap corner_block2;
        Bitmap corner_block3;
        Bitmap corner_block4;
        Bitmap top_block;
        Bitmap bottom_block;
        Bitmap left_block;
        Bitmap right_block;

        Bitmap lion;

        Matrix mat = new Matrix();


        bit = BitmapFactory.decodeResource(getResources(),R.mipmap.corner_block_chip);
        corner_block1 = Bitmap.createBitmap(bit,
                0, 0,
                (int)getResources().getDimension(R.dimen.corner_block_width), (int)getResources().getDimension(R.dimen.corner_block_height));
        mat.postScale(-1,1);
        corner_block2 = Bitmap.createBitmap(corner_block1,0,0,corner_block1.getWidth(),corner_block1.getHeight(),mat,true);
        mat.postScale(-1,-1);
        corner_block3 = Bitmap.createBitmap(corner_block1,0,0,corner_block1.getWidth(),corner_block1.getHeight(),mat,true);
        mat.postScale(-1,1);
        corner_block4 = Bitmap.createBitmap(corner_block1,0,0,corner_block1.getWidth(),corner_block1.getHeight(),mat,true);

        bit = BitmapFactory.decodeResource(getResources(),R.mipmap.top_block_chip);
        top_block = Bitmap.createBitmap(bit, 0, 0,
                (int)getResources().getDimension(R.dimen.top_block_width),
                (int)getResources().getDimension(R.dimen.top_block_height));
        mat.postScale(-1,1);
        bottom_block = Bitmap.createBitmap(top_block,0,0,top_block.getWidth(),top_block.getHeight(), mat, true);

        bit = BitmapFactory.decodeResource(getResources(), R.mipmap.left_block_chip);
        left_block = Bitmap.createBitmap(bit,0,0,
                (int)getResources().getDimension(R.dimen.vertical_block_chip_width),
                (int)getResources().getDimension(R.dimen.vertical_block_chip_height));
        mat.postScale(-1,1);
        right_block = Bitmap.createBitmap(left_block, 0,0,left_block.getWidth(),left_block.getHeight(),mat,true);

        bit = BitmapFactory.decodeResource(getResources(),R.mipmap.lion_chip);
        lion = Bitmap.createBitmap(bit, 0, 0,
                (int)getResources().getDimension(R.dimen.lion_chip_width),
                (int)getResources().getDimension(R.dimen.lion_chip_height));

        int width_picxels = this.getWidth();
        int heidth_picxels = this.getHeight();

        int cbwidth = corner_block1.getWidth();
        int cbheight = corner_block1.getHeight();
        int tbwidth = top_block.getWidth();
        int tbheight = top_block.getHeight();
        int vbwidth = left_block.getWidth();
        int vbheigh = right_block.getHeight();



        for(int i=1; cbwidth+tbwidth*i < width_picxels ; ++i){
            canvas.drawBitmap(top_block, null, new Rect(cbwidth+tbwidth*(i-1),0,cbwidth+tbwidth*i,tbheight), null);
            canvas.drawBitmap(bottom_block, null, new Rect(cbwidth+tbwidth*(i-1),heidth_picxels-tbheight,cbwidth+tbwidth*i,heidth_picxels), null);
        }

        for(int i=1; cbheight+vbheigh*i < heidth_picxels ; ++i){
            canvas.drawBitmap(left_block, null, new Rect(0,cbheight+vbheigh*(i-1),vbwidth,cbheight+vbheigh*i), null);
            canvas.drawBitmap(right_block, null, new Rect(width_picxels-vbwidth,cbheight+vbheigh*(i-1),width_picxels,cbheight+vbheigh*i), null);
        }

        canvas.drawBitmap(corner_block1, null, new Rect(0,0,cbwidth,cbheight), null);
        canvas.drawBitmap(corner_block2, null, new Rect(width_picxels-cbwidth,0,width_picxels,cbheight), null);
        canvas.drawBitmap(corner_block3, null, new Rect(0,heidth_picxels-cbheight,cbwidth,heidth_picxels), null);
        canvas.drawBitmap(corner_block4, null, new Rect(width_picxels-cbwidth,heidth_picxels-cbheight,width_picxels,heidth_picxels), null);

        canvas.drawBitmap(lion, null, new Rect(width_picxels-lion.getWidth(),heidth_picxels-lion.getHeight(),width_picxels,heidth_picxels),null);
    }
}

package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Diamond implements Obj {

    private final static float[] VERTICES = {
            // top
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f, -0.5f,
            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f, -0.5f,
            // upper-left
            -1, 0, -1,
            -0.5f, 0.5f, -0.5f,
            -1, 0, 1,
            -0.5f, 0.5f, 0.5f,
            // upper-right
            1, 0, -1,
            0.5f, 0.5f, -0.5f,
            1, 0, 1,
            0.5f, 0.5f, 0.5f,
            // upper-back
            -1, 0, -1,
            -0.5f, 0.5f, -0.5f,
            1, 0, -1,
            0.5f, 0.5f, -0.5f,
            // upper-front
            -1, 0, 1,
            -0.5f, 0.5f, 0.5f,
            1, 0, 1,
            0.5f, 0.5f, 0.5f,
            // lower-left
            -1, 0, -1,
            0, -2, 0,
            -1, 0, 1,
            // lower-right
            1, 0, -1,
            0, -2, 0,
            1, 0, 1,
            // lower-back
            -1, 0, -1,
            0, -2, 0,
            1, 0, -1,
            // lower-front
            -1, 0, 1,
            0, -2, 0,
            1, 0, 1,
    };

    private final FloatBuffer vbuf;

    Diamond() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        //top
        gl.glNormal3f(0, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        // upper-left
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 4, 4);

        // upper-right
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 8, 4);

        // upper-back
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);

        // upper-front
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);

        // lower-left
        gl.glNormal3f(-1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 20, 3);

        // lower-right
        gl.glNormal3f(1, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 23, 3);

        // lower-back
        gl.glNormal3f(0, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 26, 3);

        // lower-front
        gl.glNormal3f(0, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 29, 3);
    }
}

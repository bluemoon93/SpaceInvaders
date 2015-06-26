/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anibleach;

/**
 *
 * @author asus
 */


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
 
public class quad {
 
    public void start() {
        try {
	    Display.setDisplayMode(new DisplayMode(800,600));
	    Display.create();
	} catch (LWJGLException e) {
	    e.printStackTrace();
	    System.exit(0);
	}
        
        int i=0;
        int f=0;
        float color1=(float) Math.random(), color2=(float) Math.random(), color3=(float) Math.random();
	// init OpenGL
	GL11.glMatrixMode(GL11.GL_PROJECTION);
	GL11.glLoadIdentity();
	GL11.glOrtho(0, 800, 0, 600, 1, -1);
	GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
	while (!Display.isCloseRequested()) {
	    // Clear the screen and depth buffer
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
		
	    // set the color of the quad (R,G,B,A)
	    //GL11.glColor3f(0.5f,0.5f,1.0f);
            f=(f+1)%100;
            if(f==0){
                i=(i+1)%200;
                if(i==0){
                    color1=(float) Math.random();
                    color2=(float) Math.random();
                    color3=(float) Math.random();
                }
            }
            GL11.glColor3f(color1, color2, color3);
	    // draw quad
            GL11.glBegin(GL11.GL_POLYGON);
                GL11.glVertex2f(400+i,100);
		GL11.glVertex2f(400+i+200,100);
		GL11.glVertex2f(400+i+200,100+200-i*2);
                GL11.glVertex2f(400+i+100,100+300);
                GL11.glVertex2f(100+2*i,100+200-1);
            GL11.glEnd();
            
            
            GL11.glColor3f(0.5f,0.5f,1.0f);
	    GL11.glBegin(GL11.GL_QUADS);
	        GL11.glVertex2f(100,100);
		GL11.glVertex2f(100+200,100);
		GL11.glVertex2f(100+200,100+200);
                GL11.glVertex2f(100+100,100+300);
		//GL11.glVertex2f(100,100+200);
	    GL11.glEnd();
 
	    Display.update();
	}
 
	Display.destroy();
    }
}

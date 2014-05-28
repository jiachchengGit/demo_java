package com.jcc.demo.img2ie.servlet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * Servlet implementation class ImgShowServlet
 */
public class ImgShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /** (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("get the request from ie.");
	    ServletOutputStream os = response.getOutputStream();
	    File file = new File("D:/demo/111.jpg");
	    if(file.exists()){
    	    BufferedImage readImg = ImageIO.read(file);
    	    ImageIO.write(readImg, "JPEG", os);
	    }
	    os.close();
	}
}

//name: 3D Renderer
//a software based renderer capable of displaying a 3D shape
//Author: Brandon Jameson
//Github: https://github.com/JamesonGG/3D-Renderer

package myRenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class renderer {
	static JComboBox<String> shapes;
	static JPanel renderPanel;
	public static JFrame frame;
	public static Container pane;
	
	public static JSlider headingSlider;
	public static JSlider pitchSlider;
	
	public static String[] shapeList;
	
	@SuppressWarnings("serial")
	public static void main (String[] args) {
		//This is just some setup for the program to work. Realistically,
		//This should really be in it's own function, like Init().
		frame = new JFrame();
		pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//note for me: This creates a horizontal slider.
		headingSlider = new JSlider(-180, 180, 0);
		pane.add(headingSlider, BorderLayout.SOUTH);
		
		//same as above, but a vertical slider.
		pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
		pane.add(pitchSlider, BorderLayout.EAST);
		
		shapeList = new String[]{"Cube", "Diamond", "Sphere", "Tetrahderon", "Pyramid"};
		
		shapes = new JComboBox<String>(shapeList);
	    
	    shapes.setBounds(0, 0, 200, 24);
        pane.add(shapes);
		
		
		renderPanel = new JPanel() {
			public void paintComponent(Graphics graphics) {
				Graphics2D graphics2 = (Graphics2D) graphics;
				graphics2.setColor(Color.BLACK);
				graphics2.fillRect(0, 0, getWidth(), getHeight());
				
				//rendering data goes here :
				ArrayList<Triangle> triangles = new ArrayList<>();
				
				//Uncomment this for a cube
				
				//X+
				triangles.add(new Triangle(new Vertex(100, -100, 100),
	                                  new Vertex(100, 100, -100),
	                                  new Vertex(100, 100, 100),
	                                  Color.RED));
	            triangles.add(new Triangle(new Vertex(100, -100, 100),
	                                  new Vertex(100, -100, -100),
	                                  new Vertex(100, 100, -100),
	                                  Color.RED));
	            //X-
	            triangles.add(new Triangle(new Vertex(-100, -100, 100),
	                                  new Vertex(-100, 100, 100),
	                                  new Vertex(-100, -100, -100),
	                                  Color.RED));
	            triangles.add(new Triangle(new Vertex(-100, 100, 100),
	                                  new Vertex(-100, 100, -100),
	                                  new Vertex(-100, -100, -100),
	                                  Color.RED));
	            //Y+
	            triangles.add(new Triangle(new Vertex(100, -100, 100),
	                                  new Vertex(-100, -100, 100),
	                                  new Vertex(-100, -100, -100),
	                                  Color.GREEN));
	            triangles.add(new Triangle(new Vertex(-100, -100, -100),
	                                  new Vertex(100, -100, -100),
	                                  new Vertex(100, -100, 100),
	                                  Color.GREEN));
	            //Y-
	            triangles.add(new Triangle(new Vertex(-100, 100, 100),
	                                  new Vertex(100, 100, 100),
	                                  new Vertex(-100, 100, -100),
	                                  Color.GREEN));
	            triangles.add(new Triangle(new Vertex(100, 100, 100),
	                                  new Vertex(100, 100, -100),
	                                  new Vertex(-100, 100, -100),
	                                  Color.GREEN));
	            //Z+
	            triangles.add(new Triangle(new Vertex(-100, -100, 100),
	                                  new Vertex(100, -100, 100),
	                                  new Vertex(-100, 100, 100),
	                                  Color.BLUE));
	            triangles.add(new Triangle(new Vertex(100, -100, 100),
	                                  new Vertex(100, 100, 100),
	                                  new Vertex(-100, 100, 100),
	                                  Color.BLUE));
	            //Z-
	            triangles.add(new Triangle(new Vertex(-100, 100, -100),
	                                  new Vertex(100, 100, -100),
	                                  new Vertex(-100, -100, -100),
	                                  Color.BLUE));
	            triangles.add(new Triangle(new Vertex(-100, -100, -100),
	                                  new Vertex(100, 100, -100),
	                                  new Vertex(100, -100, -100),
	                                  Color.BLUE));
	            
				
				//Uncomment this for a diamond
				/*
				triangles.add(new Triangle(new Vertex(0, 50, 200),
						   new Vertex(200, 50, 0),
						   new Vertex(0, 250, 0),
						   Color.BLUE));
				triangles.add(new Triangle(new Vertex(0, 50, 200),
			  			   new Vertex(0, -150, 0),
			  			   new Vertex(200, 50, 0),
			  			   Color.RED));
				triangles.add(new Triangle(new Vertex(-200, 50, 0),
			  			   new Vertex(0, 50, 200),
			  			   new Vertex(0, 250, 0),
			  			   Color.GREEN));
				triangles.add(new Triangle(new Vertex(-200, 50, 0),
			  			   new Vertex(0, 50, 200),
			  			   new Vertex(0, -150, 0),
			  			   Color.WHITE));
				triangles.add(new Triangle(new Vertex(0, 50, -200),
						   new Vertex(200, 50, 0),
						   new Vertex(0, 250, 0),
						   Color.WHITE));
				triangles.add(new Triangle(new Vertex(0, 50, -200),
			  			   new Vertex(0, -150, 0),
			  			   new Vertex(200, 50, 0),
			  			   Color.GREEN));
				triangles.add(new Triangle(new Vertex(-200, 50, 0),
			  			   new Vertex(0, 50, -200),
			  			   new Vertex(0, 250, 0),
			  			   Color.RED));
				triangles.add(new Triangle(new Vertex(0, -150, 0),
			  			   new Vertex(0, 50, -200),
			  			   new Vertex(-200, 50, 0),
			  			   Color.BLUE));
			  	*/
				
				//Uncomment this for a pyramid
				/*
				//X+
				triangles.add(new Triangle(new Vertex(0, 200, 200),
						   new Vertex(200, 200, 200),
						   new Vertex(0, -200, 0),
						   Color.RED));
				triangles.add(new Triangle(new Vertex(0, 200, 200),
						   new Vertex(-200, 200, 200),
						   new Vertex(0, -200, 0),
						   Color.RED));
				//X-
				triangles.add(new Triangle(new Vertex(0, 200, -200),
						   new Vertex(200, 200, -200),
						   new Vertex(0, -200, 0),
						   Color.MAGENTA));
				triangles.add(new Triangle(new Vertex(0, 200, -200),
						   new Vertex(-200, 200, -200),
						   new Vertex(0, -200, 0),
						   Color.MAGENTA));
				//Z+
				triangles.add(new Triangle(new Vertex(-200, 200, 200),
						   new Vertex(-200, 200, 0),
						   new Vertex(0, -200, 0),
						   Color.BLUE));
				triangles.add(new Triangle(new Vertex(-200, 200, -200),
						   new Vertex(-200, 200, 0),
						   new Vertex(0, -200, 0),
						   Color.BLUE));
				//Z-
				triangles.add(new Triangle(new Vertex(200, 200, 200),
						   new Vertex(200, 200, 0),
						   new Vertex(0, -200, 0),
						   Color.CYAN));
				triangles.add(new Triangle(new Vertex(200, 200, -200),
						   new Vertex(200, 200, 0),
						   new Vertex(0, -200, 0),
						   Color.CYAN));
				//base
				triangles.add(new Triangle(new Vertex(-200, 200, 200),
                        new Vertex(200, 200, 200),
                        new Vertex(-200, 200, -200),
                        Color.GREEN));
				triangles.add(new Triangle(new Vertex(200, 200, 200),
                        new Vertex(200, 200, -200),
                        new Vertex(-200, 200, -200),
                        Color.GREEN));
                */
				
				//Uncomment this for a tetrahedron
                /*
				triangles.add(new Triangle(	new Vertex(100, 100, 100),
										new Vertex(-100, -100, 100),
										new Vertex(-100, 100, -100),
										Color.WHITE));
				triangles.add(new Triangle(	new Vertex(100, 100, 100),
										new Vertex(-100, -100, 100),
										new Vertex(100, -100, -100),
										Color.RED));
				triangles.add(new Triangle(	new Vertex(-100, 100, -100),
										new Vertex(100, -100, -100),
										new Vertex(100, 100, 100),
										Color.GREEN));
				triangles.add(new Triangle(	new Vertex(-100, 100, -100),
										new Vertex(100, -100, -100),
										new Vertex(-100, -100, 100),
										Color.BLUE));
				*/
										
				//uncomment this with any shape above to create a sphere
                /*
				for (int i = 0; i < 4; i++) {
					triangles = inflate(triangles);
				}
				*/
				//end rendering data input.
				
	            
	            //this takes headingSlider value, and converts it into a transform
	            //to be used to rotate on the z plane
				double heading = Math.toRadians(headingSlider.getValue());
				Matrix3 headingTransform = new Matrix3(new double[] {
					Math.cos(heading), 0, -Math.sin(heading),
					0, 1, 0,
					Math.sin(heading), 0, Math.cos(heading)
				});
				
				//like above, but with the x plane.
				double pitch = Math.toRadians(pitchSlider.getValue());
				Matrix3 pitchTransform = new Matrix3(new double[] {
					1, 0, 0,
					0, Math.cos(pitch), Math.sin(pitch),
					0, -Math.sin(pitch), Math.cos(pitch)
				});
				
				Matrix3 transform = headingTransform.multiply(pitchTransform);
				
				//this displays the inputed data as a projected 3d object
				BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
				
				//zBuffer is used to control the order of drawing triangles
				double[] zBuffer = new double[img.getWidth() * img.getHeight()];
				
				for (int q = 0; q < zBuffer.length; q++) {
					zBuffer[q] = Double.NEGATIVE_INFINITY;
				}
				
				//here we loop through triangle : triangles, and we quickly calculate their
				//properties in 3d space using some geometry, like vertex positions,
				//side lengths, normals, area, and orientation to the "camera" (V3.zero)
				
				for (Triangle triangle : triangles) {
					Vertex vertex1 = transform.transform(triangle.vertex1);
					vertex1.xPos += getWidth()/2;
					vertex1.yPos += getHeight()/2;
					Vertex vertex2 = transform.transform(triangle.vertex2);
					vertex2.xPos += getWidth()/2;
					vertex2.yPos += getHeight()/2;
					Vertex vertex3 = transform.transform(triangle.vertex3);
					vertex3.xPos += getWidth()/2;
					vertex3.yPos += getHeight()/2;
					
					 Vertex ab = new Vertex(vertex2.xPos - vertex1.xPos, vertex2.yPos - vertex1.yPos, vertex2.zPos - vertex1.zPos);
                     Vertex ac = new Vertex(vertex3.xPos - vertex1.xPos, vertex3.yPos - vertex1.yPos, vertex3.zPos - vertex1.zPos);
					
					Vertex norm = new Vertex(
					         ab.yPos * ac.zPos - ab.zPos * ac.yPos,
					         ab.zPos * ac.xPos - ab.xPos * ac.zPos,
					         ab.xPos * ac.yPos - ab.yPos * ac.xPos
					    );
					double normalLength =
					        Math.sqrt(norm.xPos * norm.xPos + norm.yPos * norm.yPos + norm.zPos * norm.zPos);
					    norm.xPos /= normalLength;
					    norm.yPos /= normalLength;
					    norm.zPos /= normalLength;
					    
					double angleCos = Math.abs(norm.zPos);
					
					
					int minX = (int) Math.max(0, Math.ceil(Math.min(vertex1.xPos, Math.min(vertex2.xPos, vertex3.xPos))));
					int maxX = (int) Math.min(img.getWidth() - 1,
											  Math.floor(Math.max(vertex1.xPos, Math.max(vertex2.xPos, vertex3.xPos))));
					
					int minY = (int) Math.max(0, Math.ceil(Math.min(vertex1.yPos, Math.min(vertex2.yPos, vertex3.yPos))));
				    int maxY = (int) Math.min(img.getHeight() - 1,
				                              Math.floor(Math.max(vertex1.yPos, Math.max(vertex2.yPos, vertex3.yPos))));
				    
				    double triangleArea = 	
				    (vertex1.yPos - vertex3.yPos) * (vertex2.xPos - vertex3.xPos) + (vertex2.yPos - vertex3.yPos) * (vertex3.xPos - vertex1.xPos);
				    
				    //this little bit of code is just calculating the depth of each triangle
				    //based off the x and y co-ordinates of each vertex, divided by the area.
				    //Essentially, this is giving a float, with lower values being "further"
				    //away from the viewport. These values are indexed to be called above
				    //by the zBuffer, and we're also looking at the cosine of the triangle
				    //relative to the viewport, and applying a shadow based off the formula
				    //in the getShade function.
				    for (int y = minY; y <= maxY; y++) {
				    	for (int x = minX; x <= maxX; x++) {
				    		 double b1 = 
				    			((y - vertex3.yPos) * (vertex2.xPos - vertex3.xPos) + 
				    				(vertex2.yPos - vertex3.yPos) * (vertex3.xPos - x)) / triangleArea;
				    	     double b2 =
				    	     	((y - vertex1.yPos) * (vertex3.xPos - vertex1.xPos) +
				    	     		(vertex3.yPos - vertex1.yPos) * (vertex1.xPos - x)) / triangleArea;
				    	     double b3 =
				    	     	((y - vertex2.yPos) * (vertex1.xPos - vertex2.xPos) + 
				    	        	(vertex1.yPos - vertex2.yPos) * (vertex2.xPos - x)) / triangleArea;
				    	            
				    	     if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1) {
				    	    	 
				    	    	 double depth = b1 * vertex1.zPos + b2 * vertex2.zPos + b3 * vertex3.zPos;
					    	     int zIndex = y * img.getWidth() + x;
					    	     if (zBuffer[zIndex] < depth) {
					    	    	 img.setRGB(x, y, getShade(triangle.color, angleCos).getRGB());
					    	    	 zBuffer[zIndex] = depth;
					    	     }
				    	     }
				    	}
				    }
				}
				graphics2.drawImage(img, 0, 0, null);
			}
		};
		
		pane.add(renderPanel, BorderLayout.CENTER);
		
		//Here we wait for any change to the slider value, and if there is,
		//we repaint the renderPanel to the new calculated shape.
		headingSlider.addChangeListener(e -> renderPanel.repaint());
		pitchSlider.addChangeListener(e -> renderPanel.repaint());
		
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//this function is just creating a linear colour gradient which gradually darkens based
	//off of some inputed double value, which is the cosine of the triangle relative
	//to the camera. This gives the illusion of shadows appearing on the triangles
	//as they turn away from the camera, which is also a pseudo-light source.
	public static Color getShade(Color color, double shade) {
		double redLinear = Math.pow(color.getRed(), 2.4) * shade;
		double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
		double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;
		
		int red = (int) Math.pow(redLinear, 1/2.4);
		int green = (int) Math.pow(greenLinear, 1/2.4);
		int blue = (int) Math.pow(blueLinear, 1/2.4);
		return new Color(red, green, blue);
	}
	
	//We're taking the average of vertex positions to get the midpoint, and simple creating
	//new triangles using these averaged points to create curves.
	public static ArrayList<Triangle> inflate (List<Triangle> triangles) {
		ArrayList<Triangle> result = new ArrayList<>();
		for (Triangle triangle : triangles) {
			Vertex inflate1 = new Vertex ((triangle.vertex1.xPos + triangle.vertex2.xPos)/2,
										  (triangle.vertex1.yPos + triangle.vertex2.yPos)/2,
										  (triangle.vertex1.zPos + triangle.vertex2.zPos)/2);
			Vertex inflate2 = new Vertex ((triangle.vertex2.xPos + triangle.vertex3.xPos)/2,
					  					  (triangle.vertex2.yPos + triangle.vertex3.yPos)/2,
					  					  (triangle.vertex2.zPos + triangle.vertex3.zPos)/2);
			Vertex inflate3 = new Vertex ((triangle.vertex1.xPos + triangle.vertex3.xPos)/2,
					  					  (triangle.vertex1.yPos + triangle.vertex3.yPos)/2,
					  					  (triangle.vertex1.zPos + triangle.vertex3.zPos)/2);
			
			result.add(new Triangle(triangle.vertex1, inflate1, inflate3, triangle.color));
			result.add(new Triangle(triangle.vertex2, inflate1, inflate2, triangle.color));
			result.add(new Triangle(triangle.vertex3, inflate2, inflate3, triangle.color));
			result.add(new Triangle(inflate1, inflate2, inflate3, triangle.color));
		}
		//looping through the result list, we apply some simple addition and multiplication
		//using the vertex coordinates, then divide this value by some float, higher is smoother.
		//Then we root this value to get a length for our new edges, and divide the vertex coordinates
		//by this length to create some very nice curvy edges.
		for (Triangle triangle : result) {
			for (Vertex vertex : new Vertex[] {triangle.vertex1, triangle.vertex2, triangle.vertex3}) {
				double length = Math.sqrt(vertex.xPos * vertex.xPos + vertex.yPos * vertex.yPos + vertex.zPos * vertex.zPos) / Math.sqrt(30000);
				vertex.xPos /= length;
				vertex.yPos /= length;
				vertex.zPos /= length;
			}
		}
		return result;
	}

	
}

//The next 2 classes are simply storing data for the Vertex and Triangle object
//which we need to create 3d objects.
class Vertex {
	double xPos;
	double yPos;
	double zPos;
	Vertex (double xData, double yData, double zData) {
		this.xPos = xData;
		this.yPos = yData;
		this.zPos = zData;
	}
}


class Triangle {
	Vertex vertex1;
	Vertex vertex2;
	Vertex vertex3;
	Color color;
	Triangle (Vertex data1, Vertex data2, Vertex data3, Color colorData) {
		this.vertex1 = data1;
		this.vertex2 = data2;
		this.vertex3 = data3;
		this.color = colorData;
	}
}


//This is probably the part i least understand.
//The multiply function is, I believe, creating a 3x3 matrix, and cross-multiplying
//values in this matrix for use in our main Renderer class.

//the transform function is taking in a Vertex, and is applying the values
//from the multiplied matrix in order to manipulate the Vertex in
//order to transform/rotate the Vertex.
class Matrix3 {
	double[] values;
	
	Matrix3(double[] values) {
		this.values = values;
	}
	
	Matrix3 multiply(Matrix3 other) {
		double[] result = new double[9];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				for (int i = 0; i < 3; i++) {
					result[row * 3 + col] +=
					this.values[row * 3 + i] * other.values[i * 3 + col];
				}
			}
		}
		return new Matrix3(result);
	}
	Vertex transform(Vertex in) {
        return new Vertex(
            in.xPos * values[0] + in.yPos * values[3] + in.zPos * values[6],
            in.xPos * values[1] + in.yPos * values[4] + in.zPos * values[7],
            in.xPos * values[2] + in.yPos * values[5] + in.zPos * values[8]
        );
	}
}

/*Closing Thoughts:
	This program *REALLY* struggles at large resolutions (4k and beyond).
	This is due to the fact it is entirely CPU bound, and does not take advantage of multi-threading.
	This probably wouldnt really even help that much and realistically, this kind of thing is written as a shader
	or by OpenGL for a reason. OpenGL alone has a ton of optimizations this can't ever do, 
	There really wasn't any reason to write this on the CPU other than why not? ¯\_(ツ)_/¯
	
	I imagine another big performance hog would be high-vertice shapes, like 10k+ triangle shapes. Since this is still CPU
	bound, calculating all of the transforms on such a shape really wouldn't be fun.
	
	Oh also, it's really painful to create new shapes, lots of napkin mapping and a lot of guess-work.
	I do plan on trying to figure out how to add on a .obj parser in order to display custom 3d objects,
	like models from Blender or 3Ds. That'd be pretty neat!
	
	Thanks for taking your time having a look at this, still working on it!
		-Brandon
*/

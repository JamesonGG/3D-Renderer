//3D Renderer
//Brandon Jameson
//A simple software-based 3D rendering solution based of Rasterization, includes a zBuffer
//Working on a UI to swap shapes rendered on the fly based off selection.
//Planning on translation, scaling and roll control.

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
	
	@SuppressWarnings("serial")
	public static void main (String[] args) {
		
		JFrame frame = new JFrame();
		Container pane = frame.getContentPane();
		pane.setLayout(new BorderLayout());
		
		//note for me: This creates a horizontal slider.
		JSlider headingSlider = new JSlider(-180, 180, 0);
		pane.add(headingSlider, BorderLayout.SOUTH);
		
		//same as above, but a vertical slider.
		JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
		pane.add(pitchSlider, BorderLayout.EAST);
		
		String[] shapeList = {"Cube", "Diamond", "Sphere", "Tetrahderon"};
		
		shapes = new JComboBox<String>(shapeList);
        
        shapes.addActionListener(shapes);
	    
	    shapes.setBounds(0, 0, 200, 24);
        pane.add(shapes);
        shapes.getItemAt(0);
		
		
		renderPanel = new JPanel() {
			public void paintComponent(Graphics graphics) {
				Graphics2D graphics2 = (Graphics2D) graphics;
				graphics2.setColor(Color.BLACK);
				graphics2.fillRect(0, 0, getWidth(), getHeight());
				
				//rendering data goes here :
				ArrayList<Triangle> triangles = new ArrayList<>();
				
				//Uncomment this for a cube
				/*
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
	                                  Color.ORANGE));
	            triangles.add(new Triangle(new Vertex(100, 100, 100),
	                                  new Vertex(100, 100, -100),
	                                  new Vertex(-100, 100, -100),
	                                  Color.ORANGE));
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
	            */
				
				//Uncomment this for a diamond
				
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
				
				//Uncomment this for a pyramid
				//TODO
				
				
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
				}*/
				//end rendering data input.
				
				double heading = Math.toRadians(headingSlider.getValue());
				Matrix3 headingTransform = new Matrix3(new double[] {
					Math.cos(heading), 0, -Math.sin(heading),
					0, 1, 0,
					Math.sin(heading), 0, Math.cos(heading)
				});
				
				double pitch = Math.toRadians(pitchSlider.getValue());
				Matrix3 pitchTransform = new Matrix3(new double[] {
					1, 0, 0,
					0, Math.cos(pitch), Math.sin(pitch),
					0, -Math.sin(pitch), Math.cos(pitch)
				});
				
				Matrix3 transform = headingTransform.multiply(pitchTransform);
				
				//this displays the inputed data as a projected 3d object
				BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
				
				double[] zBuffer = new double[img.getWidth() * img.getHeight()];
				
				for (int q = 0; q < zBuffer.length; q++) {
					zBuffer[q] = Double.NEGATIVE_INFINITY;
				}
				
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
		
		headingSlider.addChangeListener(e -> renderPanel.repaint());
		pitchSlider.addChangeListener(e -> renderPanel.repaint());
		
		
		
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static Color getShade(Color color, double shade) {
		double redLinear = Math.pow(color.getRed(), 2.4) * shade;
		double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
		double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;
		
		int red = (int) Math.pow(redLinear, 1/2.4);
		int green = (int) Math.pow(greenLinear, 1/2.4);
		int blue = (int) Math.pow(blueLinear, 1/2.4);
		return new Color(red, green, blue);
	}
	
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


//math to make object manipulation possible.
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

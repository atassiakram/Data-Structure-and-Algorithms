/*
 * Point3D (x,y,z)
 *
 * CSI2510 Algorithmes et Structures de Donnees
 * www.uottawa.ca
 *
 * Robert Laganiere, 2022
 *
*/ 

public class Point3D {

  private double x;
  private double y;
  private double z;
  
  private double R,G,B;
  public int label=-1; // not used here

  // constructs point (x,y,z)
  public Point3D(double x, double y, double z) {
       
    this.x= x;
    this.y= y;
    this.z= z;
  }
  
  // gets x-coordinate
  public double getX() {
	  return x;
  }

  // gets y-coordinate
  public double getY() {
	  return y;
  }	

  // gets z-coordinate
  public double getZ() {
	  return z;
  }

  // gets coordinate x, y or z if axis 0, 1, or 2
  public double get(int axis) {
	  
	  switch(axis) {
		  case 0: return x;
		  case 1: return y;
		  case 2: return z;
		  default: return 0.0;
	  }		  
  }

    //when we get Noise
    public void setNoise(){
        label = 0;
        R=G=B=0;
    }
    //method to tell if label is Noise
    public boolean isNoise(){
        return label == 0;
    }


    //method to tell if label is defined
    public boolean isDefined(){
        return label != -1;
    }


    // gets the euclidean distance between two points
  public double distance(Point3D pt) {
     return Math.sqrt((this.getX()-pt.getX())*(this.getX()-pt.getX()) +  
	                        (this.getY()-pt.getY())*(this.getY()-pt.getY()) +
	                        (this.getZ()-pt.getZ())*(this.getZ()-pt.getZ()) );
  }
  
  // gets String representation
  public String toString() {
	  
	  return "("+x+","+y+","+z+")";
  }

    public int getClusterLabel() {
        return label;
    }

    public void setClusterLabel(int numberOfClusters) {
        double coefficient = Math.sqrt(label);
        R = 1* coefficient %1;
        G = 2* coefficient %1;
        B = 3* coefficient %1;
        this.label = label;
    }
}




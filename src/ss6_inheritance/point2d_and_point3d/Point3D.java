package ss6_inheritance.point2d_and_point3d;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(){
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }
    public float[] getXYZ() {
        return new float[]{getX(),getY(),getZ()};
    }
    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        setX(x);
        setY(y);
        setZ(z);
    }

    @Override
    public String toString() {
        return "point3D ("+getX()+
                ","+getY()+
                ","+getZ()+")"+
                ", and "+super.toString();
    }
}

package ss6_inheritance.point_moveable_point;

import ss6_inheritance.point2d_and_point3d.Point2D;

public class MoveAblePoint extends Point2D {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveAblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint(){
    }

    public float getXSpeed(){
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        return new float[]{getXSpeed(),getYSpeed()};
    }
    public void setSpeed(float xSpeed, float ySpeed){
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
    }

    @Override
    public String toString() {
        return super.toString()+
                ", speed= ("+getXSpeed()+
                ","+getYSpeed()+
                ")";
    }
    public MoveAblePoint move(){
        float resutlX  = getX();
        float resultY = getY();
        resutlX += getXSpeed();
        resultY += getYSpeed();
        setX(resutlX);
        setY(resultY);
        return this;
    }
}

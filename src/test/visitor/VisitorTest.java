package test.visitor;

/**
 * VisitorTest.
 *
 * @author Ilya_Gulevskiy
 */
public class VisitorTest {
    public static void go() {
        Point p = new Point2d( 1, 2 );
        Visitor v = new Chebyshev();
        p.accept( v );
        System.out.println( p.getMetric() );

        Point p2 = new Point3d( 1, 2, 3 );
        Visitor v2 = new Euclid();
        p2.accept( v2 );
        System.out.println( p2.getMetric() );
    }
}

interface Visitor {
    public void visit ( Point2d p );
    public void visit ( Point3d p );
}

abstract class Point {
    public abstract void accept ( Visitor v );
    private double metric = -1;
    public double getMetric () {
        return metric;
    }
    public void setMetric ( double metric ) {
        this.metric = metric;
    }
}

class Point2d extends Point {
    public Point2d ( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public void accept ( Visitor v ) {
        v.visit( this );
    }

    private double x;
    public double getX () { return x; }

    private double y;
    public double getY () { return y; }
}

class Point3d extends Point {
    public Point3d ( double x, double y, double z ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void accept ( Visitor v ) {
        v.visit( this );
    }

    private double x;
    public double getX () { return x; }

    private double y;
    public double getY () { return y; }

    private double z;
    public double getZ () { return z; }
}

class Euclid implements Visitor {
    public void visit ( Point2d p ) {
        p.setMetric( p.getX() + p.getY() );
    }
    public void visit ( Point3d p ) {
        p.setMetric( p.getX() + p.getY() + p.getZ() );
    }
}

class Chebyshev implements Visitor {
    public void visit(Point2d p) {
        p.setMetric(p.getX() * p.getY());
    }

    public void visit(Point3d p) {
        p.setMetric(p.getX() * p.getY() * p.getZ());
    }
}

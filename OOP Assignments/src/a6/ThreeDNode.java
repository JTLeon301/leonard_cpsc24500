package a6;

public class ThreeDNode extends Node {
	private static final int MINVAL = -100;
	private static final int MAXVAL = 100;
	private int z;

    /**
     * Default constructor
     * Sets the value of x,y,z to 0.
     */
    public ThreeDNode() {
        super(); // Call the superclass's default constructor to set x and y to 0.
        this.z = 0;
    }

    /**
     * Copy constructor 
     * Creates a new ThreeDNode with the same coordinates as the provided one.
     * @param other ThreeDNode to copy from.
     */
    public ThreeDNode(ThreeDNode other) {
        super(other); // Use the superclass's copy constructor to copy x and y.
        this.z = other.z;
    }

    /**
     * Constructor that accepts the values for x,y,z.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param z The z coordinate.
     * @throws IllegalArgumentException if the values are out of range.
     */
    public ThreeDNode(int x, int y, int z) {
        super(x, y); // Use the superclass's constructor for x and y.
        validateZ(z);
        this.z = z;
    }

    /**
     * Validates the z coordinate.
     * @param z The z value to validate.
     * @throws IllegalArgumentException if the z value is out of the acceptable range.
     */
    private void validateZ(int z) {
        if (z < MINVAL || z > MAXVAL) {
            throw new IllegalArgumentException("The value of z must be in the range of [" + MINVAL + ',' + MAXVAL + "].");
        }
    }

    public void setZ(int z) {
        validateZ(z);
        this.z = z;
    }

    public int getZ() {
        return this.z;
    }

    /**
     * Adds the coordinates of the given ThreeDNode to this node.
     * @param other The ThreeDNode to add to this node.
     * @throws IllegalArgumentException if the result is out of range.
     */
    @Override
    public void add(Node other) {
        super.add(other); // Adds x and y from the other node.
        if (other instanceof ThreeDNode) {
            int newZ = this.z + ((ThreeDNode) other).getZ();
            validateZ(newZ);
            this.z = newZ;
        }
    }

    @Override
    public String toString() {
        return "ThreeDNode(x=" + getX() + ", y=" + getY() + ", z=" + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return this.z == other.z;
    }
    
    public int getCoordinateSum() {
        return super.getCoordinateSum() + getZ();
    }
}

package hw.hw003.B03_02;

public class Root {
    private boolean isRoot;
    private int rootsCount; // 0, 1, 2 or -1 for infinity
    private double root1, root2;

    public Root(boolean isRoot, int rootsCount, double root1, double root2){
        this.isRoot = isRoot;
        this.rootsCount = rootsCount;
        this.root1 = root1;
        this.root2 = root2;
    }

    public Root(boolean isRoot){
        this.isRoot = isRoot;
    }

    public double getMaxRoot(){
        if (rootsCount == -1 || !isRoot)
            return Double.NEGATIVE_INFINITY;

        return Math.max(root1, root2);
    }

    public boolean getIsRoot(){
        return isRoot;
    }

    public boolean isInfinity(){
        return rootsCount == -1;
    }


}

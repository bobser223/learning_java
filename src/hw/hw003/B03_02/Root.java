package hw.hw003.B03_02;

import java.util.Objects;

public class Root {
    private boolean isRoot;
    private int rootsCount; // 0, 1, 2 or -1 for infinity
    private double root1, root2;

    public Root(){
        this.isRoot = false;
        this.rootsCount = -1;
        this.root1 = this.root2 = Double.NEGATIVE_INFINITY;
    }

    public Root(boolean isRoot, int rootsCount, double root1, double root2){
        this.isRoot = isRoot;
        this.rootsCount = rootsCount;
        this.root1 = root1;
        this.root2 = root2;
    }

    public Root(boolean isRoot){
        this.isRoot = isRoot;
    }

    public Root(Root other){
        this.isRoot = other.isRoot;
        this.rootsCount = other.rootsCount;
        this.root1 = other.root1;
        this.root2 = other.root2;
    }

    public Root copy(){
        return new Root(this);
    }



    public double getMaxRoot(){
        if (rootsCount == -1 || !isRoot)
            return Double.NEGATIVE_INFINITY;

        return Math.max(root1, root2);
    }

    @Override
    public String toString() {
        if (!isRoot) return "No roots";
        if (rootsCount == -1) return "Infinite roots";
        if (rootsCount == 1) return "One root: x = " + root1;
        if (rootsCount == 2) return "Two roots: x1 = " + root1 + ", x2 = " + root2;
        return "Invalid state";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Root other = (Root) obj;
        return isRoot == other.isRoot &&
                rootsCount == other.rootsCount &&
                Double.compare(root1, other.root1) == 0 &&
                Double.compare(root2, other.root2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRoot, rootsCount, root1, root2);
    }


    public boolean getIsRoot(){
        return isRoot;
    }

    public boolean isInfinity(){
        return rootsCount == -1;
    }


}

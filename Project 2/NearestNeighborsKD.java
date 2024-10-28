import java.util.List;
import java.util.Stack;

public class NearestNeighborsKD {
    List<Point3D> listOfAllPoints;
    KDTree kdTree;
    /**
     * Constructor to get the list of all the points, and creates the respective KDTree
     * @param listOfAllPoints
     */
    public NearestNeighborsKD(List<Point3D> listOfAllPoints) {
        this.listOfAllPoints = listOfAllPoints;
        getKDTree();

    }

    /**
     * This method will call the KDTree method for getting neighbors
     * @param point
     * @param eps
     * @return neighbors
     */
    public List<Point3D> rangeQuery(Point3D point,double eps){
        Stack<Point3D> neighbors = new Stack<>();
        rangeQuery(point,eps,neighbors,kdTree.getRoot());
        return neighbors;
    }

    /**
     * recursive rangeQuery that implements the KD algorithm
     * @param point
     * @param eps
     * @param neighbors
     * @param node
     * @return neighbors
     */
    private void rangeQuery(Point3D point, double eps, Stack<Point3D> neighbors, KDTree.KDNode node){
        if(node == null){
            return;
        }
        Point3D potentialNeighbor = node.point;
        if(point.distance(potentialNeighbor)<eps){
            neighbors.push(potentialNeighbor);
        }
        if(point.get(node.axis) - eps <= node.value){
            rangeQuery(point,eps,neighbors,node.left);
        }
        if(point.get(node.axis) + eps > node.value){
            rangeQuery(point,eps,neighbors,node.right);
        }
    }


    /**
     * takes all the points and creates a K-D Tree
     */
    private void getKDTree(){
        KDTree kdTree = new KDTree();
        for(int i=0;i<listOfAllPoints.size();i++){
            //every point starts at the root
            Point3D point = listOfAllPoints.get(i);
            kdTree.add(point);
        }
        this.kdTree = kdTree;
    }
}

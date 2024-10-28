public class KDTree{

    public class KDNode{
        public Point3D point;
        public int axis;
        public double value;
        public KDNode left;
        public KDNode right;


        public KDNode(Point3D point, int axis) {
            this.point = point;
            this.axis = axis;
            this.value = point.get(axis);
            left = null;
            right = null;
        }
    }
    private KDNode root;
    KDNode getRoot(){
        return root;
    }
    int size = 0;


    public KDTree(){
        root = null;
    }


    void add(Point3D point){
        size++;
        if(root ==null){
            root = new KDNode(point,0);
            return;
        }
        insert(point,root,0);
    }


    public KDNode insert(Point3D point, KDNode node, int axis){
        if(node ==null){
            node = new KDNode(point,axis);
        }
        else if(point.get(axis)<= node.value){
            node.left = insert(point,node.left,(axis+1)%3);
        }
        else if(point.get(axis)>node.value){
            node.right = insert(point,node.right,(axis+1)%3);
        }
        return node;
    }
}
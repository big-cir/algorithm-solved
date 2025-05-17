import java.util.*;

class Solution {
    
    static class Node {
        int vertex;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int vertex, int x, int y) {
            this.vertex = vertex;
            this.x = x;
            this.y = y;
        }    
    }
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        
nodes.sort((a, b) -> b.y != a.y ? b.y - a.y : a.x - b.x);

        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insert(root, nodes.get(i));
        }
        
        List<Integer> preResult = new ArrayList<>();
        preOrder(preResult, root);
        List<Integer> postResult = new ArrayList<>();
        postOrder(postResult, root);
        
        int[][] answer = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preResult.get(i);
            answer[1][i] = postResult.get(i);
        }
        
        return answer;
    }
    
    private void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insert(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    private void preOrder(List<Integer> list, Node node) {
        if (node == null) return;
        list.add(node.vertex);
        preOrder(list, node.left);
        preOrder(list, node.right);
    }
    
    private void postOrder(List<Integer> list, Node node) {
        if (node == null) return;
        postOrder(list, node.left);
        postOrder(list, node.right);
        list.add(node.vertex);
    }
}

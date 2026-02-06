/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private static Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Node answer = new Node(node.val);
        map.put(node, answer);
        helper(node, answer);

        return answer;
    }

    private void helper(Node node, Node answer) {
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                Node exist = map.get(neighbor);
                answer.neighbors.add(exist);
            } else {
                Node createNode = new Node(neighbor.val);
                map.put(neighbor, createNode);
                answer.neighbors.add(createNode);
                
                helper(neighbor, createNode);
            }
        }
    }
}

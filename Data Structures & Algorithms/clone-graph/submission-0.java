/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node clone = new Node(node.val);
        
        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        q.offer(node);
        map.put(node, clone);

        while(!q.isEmpty()){
            Node currentNode = q.poll();
            for(Node n : currentNode.neighbors){
                if(!map.containsKey(n)){
                    q.offer(n);
                    Node nClone = new Node(n.val);
                    map.put(n, nClone);
                }
                map.get(currentNode).neighbors.add(map.get(n));
            }
            
        }
        return clone;
    }
}
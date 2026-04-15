class Solution{
    // Encodes a tree to a single string.
    // we use breadth first search here
    public String serialize(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>(); // creating a queue for storing the nodes of the tree
        queue.offer(root); // adding the root of the tree

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // getting the current node

            if (node == null) {
                result.append("null,"); // add null to the queue
            } else {
                result.append(node.val).append(","); // adding the nodes in a comma separated way
                queue.offer(node.left); // add the left node to the queue
                queue.offer(node.right); // add the right node to the queue
            }
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0)
            return null;

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0])); // getting the root of the binary tree

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // adding the root to the queue

        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll(); // getting the parent node of the tree

            // Left node insertion
            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left; // adding to the left of the parent node
                queue.offer(left); // adding the left node to the queue
            }
            i++; // increment so that we get the next node

            // Right node insertion
            if (!values[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right; // adding to the right of the parent node
                queue.offer(right); // adding the right node to the queue
            }
            i++; // increment so that we get the next node
        }

        return root;
    }
}
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        addNext(root, result);
        return result;
    }

    private void addNext(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            addNext(root.children.get(i), result);
        }
    }
}

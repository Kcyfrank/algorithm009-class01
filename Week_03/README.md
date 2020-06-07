###学习笔记

####第 7 课 | 泛型递归、树的递归
> 泛型递归模板
```
 public void recur(int level, int param){
    //terminator
    if(level> MAC_LEVEL) {
        //process result
        return;
    }
    // process current login  
    process(level,param);
    //drill down
    recur(level:level+1,newParam);
    //restore current status
}
```
>树的递归模板
```
List<Integer> res = new ArrayList<>();
private void preorder(TreeNode root){
    if(root!=null){
        res.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }    
}

private void inorder(TreeNode root){
    if(root!=null){
        preorder(root.left);
        res.add(root.val);
        preorder(root.right);
    }    
}

private void postorder(TreeNode root){
    if(root!=null){
        preorder(root.left);
        preorder(root.right);
        res.add(root.val);
    }    
}
```

####第 8 课 | 分治、回溯


>回溯模板
```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
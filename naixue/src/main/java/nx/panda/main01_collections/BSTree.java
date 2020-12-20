package nx.panda.main01_collections;

import java.util.Stack;

/**
 * 二叉搜索树的递归遍历和非递归遍历的实现
 * 三种方法：前序遍历，中序遍历，后序遍历
 * @author panda
 * @date 2020-12-20
 */
public class BSTree {
	
	//记录每次的结果
	private static String result = "";
	
	public static void main(String[] asgs) {
      TreeNode rootNode = initTreeNode();
      System.out.println("初始化的二叉搜索树:(7,3,10,5,1,9,12)"); 
      //递归实现
      recursionOrder(rootNode); 		  
      //非递归实现
      notRecursionOrder(rootNode);
	}
	
	/**
	 * 递归实现
	 * @param rootNode
	 */
	private static void recursionOrder(TreeNode rootNode) {
		  //前序遍历
		  result = "";
		  result = prevOrder(rootNode);
		  System.out.println("递归: 前序遍历结果:"+result); 
		  
		  //中序遍历
		  result = "";
		  result = centerOrder(rootNode);
		  System.out.println("递归: 中序遍历结果:"+result); 
		  
		  //后序遍历
		  result = "";
		  result = afterOrder(rootNode);
		  System.out.println("递归: 后序递归遍历结果:"+result);
	}
	
	/**
	 * 非递归实现
	 * @param rootNode
	 */
	private static void notRecursionOrder(TreeNode rootNode) {
		//前序遍历
		  result = "";
		  result = prevOrder2(rootNode);
		  System.out.println("非递归 :前序遍历结果:"+result); 
		  
		  //中序遍历
		  result = "";
		  result = centerOrder2(rootNode);
		  System.out.println("非递归 :中序遍历结果:"+result); 
		  
		  //后序遍历
		  result = "";
		  result = afterOrder2(rootNode);
		  System.out.println("非递归 :后序遍历结果:"+result);
	}	
	 
	/**
	 * 初始化Node，填充数据
	 * @return
	 */
	private static TreeNode initTreeNode() {
		// (7,3,10,5,1,9,12)
		TreeNode rootNode = new TreeNode("7");
		rootNode.setLeft(new TreeNode("3"));
		rootNode.setRight(new TreeNode("10"));
	    rootNode.getLeft().setLeft(new TreeNode("1"));
	    rootNode.getLeft().setRight(new TreeNode("5"));
	    rootNode.getRight().setLeft(new TreeNode("9"));
	    rootNode.getRight().setRight(new TreeNode("12"));
	    return rootNode;
	}
	
	/**
	 * 递归:前序遍历
	 * 访问顺序：先根节点，再左子树，最后右子树；
	 * @param rootNode
	 * @return
	 */
	private static String prevOrder(TreeNode rootNode) {
		// 1先根节点
		if(null != rootNode) 
			result +=  rootNode.getValue() + ",";
		// 2再左子树
		if (null != rootNode.getLeft()) 
			prevOrder(rootNode.getLeft());
		// 3最后右子树
		if (null != rootNode.getRight())
			prevOrder(rootNode.getRight());
		return result;
	}	
	
	/**
	 * 递归：中序遍历:先左子树，再根节点，最后右子树；
	 * @param rootNode
	 * @return
	 */
	private static String centerOrder(TreeNode rootNode) {
		// 1左子树
		if (null != rootNode.getLeft()) 
			centerOrder(rootNode.getLeft());
		// 2根节点
		if(null != rootNode) 
			result +=  rootNode.getValue() + ",";
		// 3最后右子树
		if (null != rootNode.getRight())
			centerOrder(rootNode.getRight());
		return result;
	}		
	
	/**
	 * 递归：后序遍历:先左子树,再右子树, 最后根节点，；
	 * @param rootNode
	 * @return
	 */
	private static String afterOrder(TreeNode rootNode) {
		// 1左子树
		if (null != rootNode.getLeft()) 
			afterOrder(rootNode.getLeft());
		// 2右子树
		if (null != rootNode.getRight())
			afterOrder(rootNode.getRight());
		// 3根节点
		if(null != rootNode) 
			result +=  rootNode.getValue() + ",";
		return result;
	}
	
	
	/**
	 * 非递归:前序遍历
	 * 访问顺序：先根节点，再左子树，最后右子树；
	 * @param rootNode
	 * @return
	 */
	private static String prevOrder2(TreeNode rootNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = rootNode;
        while (node != null || !stack.empty()) {
            if (node != null) {
                result = result + node.getValue() + ",";
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
		return result;
	}
	
	/**
	 * 非递归：中序遍历
	 * @param rootNode
	 * @return
	 */
	public static String centerOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                result += tem.getValue() + ",";
                node = tem.right;
            }
        }
       return result; 
    }	
	
	/**
	 * 非递归：后序遍历
	 * @param rootNode
	 * @return
	 */
	public static String afterOrder2(TreeNode root) {
        TreeNode cur, pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                result += cur.getValue() + ",";
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
        }
        return result;
    }
	
	//树结构：
	static class TreeNode {
		
		private String value;
	    private TreeNode left;
	    private TreeNode right;
		
		public TreeNode(String value) {
			super();
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public TreeNode getLeft() {
			return left;
		}
		
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		
		public TreeNode getRight() {
			return right;
		}
		
		public void setRight(TreeNode right) {
			this.right = right;
		}
		public String getValue() {
			return value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
	}

}

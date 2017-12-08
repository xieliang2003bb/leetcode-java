package serialize_deserialize_binary_tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * Created by lxie on 12/7/17.
 */
public class SerializeDeserializeBTree {

    public static class Solution {
        public static class Codec {

            public static String serialize(TreeNode root) {
                if(root==null){
                    return "";
                }

                StringBuilder sb = new StringBuilder();

                LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

                queue.add(root);
                while(!queue.isEmpty()){
                    TreeNode t = queue.poll();
                    if(t!=null){
                        sb.append(String.valueOf(t.val) + ",");
                        queue.add(t.left);
                        queue.add(t.right);
                    }else{
                        sb.append("#,");
                    }
                }

                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb.toString());
                return sb.toString();
            }

            // Decodes your encoded data to tree.
            public static TreeNode deserialize(String data) {
                if(data==null || data.length()==0)
                    return null;

                String[] arr = data.split(",");
                TreeNode root = new TreeNode(Integer.parseInt(arr[0]));


                LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
                queue.add(root);

                int i=1;
                while(!queue.isEmpty()){
                    TreeNode t = queue.poll();

                    if(t==null)
                        continue;

                    if(!arr[i].equals("#")){
                        t.left = new TreeNode(Integer.parseInt(arr[i]));
                        queue.offer(t.left);

                    }else{
                        t.left = null;
                        queue.offer(null);
                    }
                    i++;

                    if(!arr[i].equals("#")){
                        t.right = new TreeNode(Integer.parseInt(arr[i]));
                        queue.offer(t.right);

                    }else{
                        t.right = null;
                        queue.offer(null);
                    }
                    i++;
                }

                return root;
            }


        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println("result1 = " + Solution.Codec.serialize(root));
        System.out.println("result2 = " + Solution.Codec.deserialize("1,2,3,#,#,#,#"));
    }
}

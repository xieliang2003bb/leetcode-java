package serialize_deserialize_binary_tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 12/7/17.
 */
public class SerializeDeserializeBTree {

    public static class Solution {
        public static class Codec {

            // Encodes a tree to a single string.
            public static String serialize(TreeNode root) {
                String[] out = {""};
                serialize(root, out);
                return out[0];
            }

            private static void serialize(TreeNode root, String[] out) {
                if (root != null) {
                    out[0]  +=  Integer.toString(root.val) + ' ';
                    serialize(root.left, out);
                    serialize(root.right, out);
                } else {
                    out[0] += "# ";
                }
            }


            // Decodes your encoded data to tree.
            public static TreeNode deserialize(String data) {
                if (data == null) return null;
                String[] input = data.split("\\s+");
                List<String>  in = new ArrayList<String>(Arrays.asList(input));
                TreeNode root = deserialize(in);
                return root;
            }

            private static TreeNode deserialize(List<String> in) {
                if (in == null || in.size() == 0) return null;
                String val = in.get(0); in.remove(0);
                if (val.compareTo("#") == 0 || val.compareTo("") == 0)
                    return null;
                TreeNode root = new TreeNode(Integer.valueOf(val));
                root.left = deserialize(in);
                root.right = deserialize(in);
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
        System.out.println("result2 = " + Solution.Codec.deserialize("1 2 # # 3 # #"));
    }
}

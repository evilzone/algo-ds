/ **

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

*/
  
public class Codec {

  private void serializeUtil(TreeNode root, StringBuilder sb) {

      if(root == null) {
          sb.append("# ");
          return;
      }

      sb.append(root.val + " ");

      serializeUtil(root.left, sb);
      serializeUtil(root.right, sb);
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      serializeUtil(root, sb);
      return sb.toString();
  }

  private TreeNode deserializeUtil(Queue<String> queue) {

      if(queue.isEmpty()) {
          return null;
      }

      String token = queue.remove();
      if(token.equals("#")) {
          return null;
      }

      TreeNode root = new TreeNode(Integer.valueOf(token));

      root.left = deserializeUtil(queue);
      root.right = deserializeUtil(queue);

      return root;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
      if(data.isEmpty()) {
          return null;
      }

      String[] strs = data.split("\\s+");
      Queue<String> queue = new LinkedList<>(Arrays.asList(strs));

      return deserializeUtil(queue);
  }
}

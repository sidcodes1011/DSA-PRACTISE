// Question 

// Given a string S of distinct character of size N and their corresponding frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build the Huffman tree 
// print all the huffman codes in preorder traversal of the tree.
// Note: While merging if two nodes have the same value, then the node which occurs at first will be taken on the left of Binary Tree and the other one to the right, 
// otherwise Node with less value will be taken on the left of the subtree and other one to the right.

import java.util.*;

public class haufmanEncoding {

    class Node implements Comparable<Node> {
        int frequency;
        Node left;
        Node right;
        Node(int frequency) {
            this.frequency = frequency;
        }
        public int compareTo(Node other) {
            if (this.frequency == other.frequency) {
                return 1;
            }
            return this.frequency - other.frequency;
        }
    }
    public void generateCodes(Node root, String currentCode, ArrayList<String> huffmanCodes) {
        if (root.left == null && root.right == null) {
            huffmanCodes.add(currentCode);
            return;
        }
        generateCodes(root.left, currentCode + "0", huffmanCodes);
        generateCodes(root.right, currentCode + "1", huffmanCodes);
    }
    public ArrayList<String> huffmanCodes(String S, int[] freq, int N) {

        ArrayList<String> huffmanCodes = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        for (int frequency : freq) {
            minHeap.add(new Node(frequency));
        }
        while (minHeap.size() > 1) {
            Node leftChild = minHeap.poll();
            Node rightChild = minHeap.poll();
            Node mergedNode = new Node(leftChild.frequency + rightChild.frequency);
            mergedNode.left = leftChild;
            mergedNode.right = rightChild;
            minHeap.add(mergedNode);
        }
        Node root = minHeap.poll();
        generateCodes(root, "", huffmanCodes);
        return huffmanCodes;
    }

    public static void main(String[] args) {
        haufmanEncoding obj = new haufmanEncoding();
        String S = "abcdef";
        int[] freq = {5, 9, 12, 13, 16, 45};
        ArrayList<String> result = obj.huffmanCodes(S, freq, S.length());
        System.out.println("Huffman Codes:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(S.charAt(i) + " : " + result.get(i));
        }
    }
}
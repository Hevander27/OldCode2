package main.java;

import java.util.*;

public class BinaryTreeTraversal {

	private static boolean hasSubtree = false;
	private static ArrayList<String> paths = new ArrayList<String>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		String test = "(a(b()())(c(d()())()))";
		createTree(input, "");
		printTree();
		scan.close();
	}

	private static void printTree() {
		for (String path : paths) {
			System.out.println(path);
		}
	}

	private static void createTree(String t, String nPath) {
		String tree = t.trim();
		if (tree.length() > 1 && tree.charAt(0) == '(' && tree.charAt(tree.length() - 1) == ')') {
			int nodes = 0;
			int counter = 0;
			int enclosureIndex = -1;
			String path = "";
			for (int i = 0; i < tree.length(); i++) {
				if (i > 0 && tree.charAt(i) != '(' && tree.charAt(i) != ')' &&
					!Character.isWhitespace(tree.charAt(i)) && path.length() == 0) {
					path += tree.charAt(i);
					nPath += nPath.length() == 0 ? path : " " + path;
				}
				else if ((i > 0 && i < tree.length() - 1) && nPath.length() > 0 && nodes < 2) {
					if (tree.charAt(i) == '(') {
						counter++;
						if (enclosureIndex == -1) enclosureIndex = i;
					}
					if (tree.charAt(i) == ')') {
						counter--;
						if (counter == 0) {
							nodes++;
							if (!hasSubtree) hasSubtree = true;
							String process = processTree(tree.substring(enclosureIndex, i + 1), nPath);
							if (!isExistingSubset(process)) paths.add(process);
							enclosureIndex = -1;
						}
					}
				}
			}

			if (!hasSubtree) {
				paths.add(path);
			}
		}
	}

	private static boolean isExistingSubset(String path) {
		for (String nPath : paths) {
			if (nPath.contains(path)) return true;
		}
		return false;
	}

	private static String processTree(String tree, String path) {
		String decomposedTree = tree.substring(1, tree.length());		
		if (tree.length() < 2)                                              return path;
		if (decomposedTree.length() < 2)                                    return path;
		if (tree.charAt(0) != '(' || tree.charAt(tree.length() - 1) != ')') return path;
		createTree(tree, path);
		return processTree(decomposedTree, path);
	}
}

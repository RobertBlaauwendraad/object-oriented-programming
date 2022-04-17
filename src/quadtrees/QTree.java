package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
	private QuadTreeNode root;

	public QTree(Reader input) {
		root = readQTree(input);
	}

	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	private static QuadTreeNode readQTree(Reader input) {
		try {
			char nextBit = (char) input.read();
			if (nextBit == '1') { // 4 Subtrees
				GreyNode greyNode = new GreyNode();
				for (int i = 0; i < 4; i++) {
					greyNode.addNodeToChildren(readQTree(input));
				}
				return greyNode;
			} else if (nextBit == '0') { // Leaf
				char leafColor = (char) input.read();
				if (leafColor == '0') { // Black leaf
					return new BlackLeaf();
				} else if (leafColor == '1') { // White leaf
					return new WhiteLeaf();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public static QuadTreeNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		boolean bitValue = bitmap.getBit(x, y);
		for (int i = x; i < width + x; i++) {
			for (int j = y; j < width + y; j++) {
				if (bitValue != bitmap.getBit(i, j)) { // Not everything is the same color
					GreyNode greyNode = new GreyNode();
					int halfWidth = width / 2;
					greyNode.addNodeToChildren(bitmap2QTree(x, y, halfWidth, bitmap));
					greyNode.addNodeToChildren(bitmap2QTree(x + halfWidth, y, halfWidth, bitmap));
					greyNode.addNodeToChildren(bitmap2QTree(x + halfWidth, y + halfWidth, halfWidth, bitmap));
					greyNode.addNodeToChildren(bitmap2QTree(x, y + halfWidth, halfWidth, bitmap));
					return greyNode;
				}
			}
		}
		if (bitValue) { // White leaf
			return new WhiteLeaf();
		} else { // Black leaf
			return new BlackLeaf();
		}
	}
}

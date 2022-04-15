package quadtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GreyNode implements QuadTreeNode {
	List<QuadTreeNode> children = new ArrayList<QuadTreeNode>();

	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		int newWidth = width / 2;
		for (int i = 0; i < children.size(); i++) {
			QuadTreeNode currentNode = children.get(i);
			switch (i) {
				case 0 -> currentNode.fillBitmap(x, y, newWidth, bitmap);
				case 1 -> currentNode.fillBitmap(x + newWidth, y, newWidth, bitmap);
				case 2 -> currentNode.fillBitmap(x + newWidth, y + newWidth, newWidth, bitmap);
				case 3 -> currentNode.fillBitmap(x, y + newWidth, newWidth, bitmap);
			}
		}
	}

	@Override
	public void writeNode(Writer out) {
		try {
			out.write("1");
			// TODO: Make sure we write the 4 next nodes as well
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void addNodeToChildren(QuadTreeNode node) {
		children.add(node);
	}
}

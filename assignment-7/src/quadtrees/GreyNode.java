package quadtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GreyNode implements QuadTreeNode {
	private final List<QuadTreeNode> children = new ArrayList<QuadTreeNode>();

	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		int halfWidth = width / 2;
		children.get(0).fillBitmap(x, y, halfWidth, bitmap);
		children.get(1).fillBitmap(x + halfWidth, y, halfWidth, bitmap);
		children.get(2).fillBitmap(x + halfWidth, y + halfWidth, halfWidth, bitmap);
		children.get(3).fillBitmap(x, y + halfWidth, halfWidth, bitmap);
	}

	@Override
	public void writeNode(Writer out) {
		try {
			out.write("1");
			children.get(0).writeNode(out);
			children.get(1).writeNode(out);
			children.get(2).writeNode(out);
			children.get(3).writeNode(out);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void addNodeToChildren(QuadTreeNode node) {
		children.add(node);
	}
}

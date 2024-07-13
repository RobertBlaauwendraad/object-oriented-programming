
package quadtrees;

import java.io.Writer;

public interface QuadTreeNode {
	void fillBitmap(int x, int y, int width, Bitmap bitmap);

	void writeNode(Writer out);
}

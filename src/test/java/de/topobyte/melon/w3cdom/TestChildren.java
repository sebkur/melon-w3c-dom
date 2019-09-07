// Copyright 2019 Sebastian Kuerten
//
// This file is part of melon-w3c-dom.
//
// melon-w3c-dom is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// melon-w3c-dom is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with melon-w3c-dom. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.melon.w3cdom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class TestChildren
{

	@Test
	public void test()
			throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = Util.document("test2.xml");

		for (Node root : DomUtil.iterable(doc.getChildNodes())) {
			List<Node> directItems = DomUtil
					.getChildElementsByTagName((Element) root, "item");

			Assert.assertEquals(2, directItems.size());

			Assert.assertEquals("foo",
					DomUtil.getAttribute(directItems.get(0), "name"));
			Assert.assertEquals("bar",
					DomUtil.getAttribute(directItems.get(1), "name"));

			List<Node> nodes = DomUtil.getChildElementsByTagName((Element) root,
					"node");

			Assert.assertEquals(2, nodes.size());

			for (Node node : nodes) {
				String nodeName = DomUtil.getAttribute(node, "name");
				List<Node> items = DomUtil
						.getChildElementsByTagName((Element) node, "item");

				Assert.assertEquals(2, items.size());

				Assert.assertEquals(nodeName + "-foo",
						DomUtil.getAttribute(items.get(0), "name"));
				Assert.assertEquals(nodeName + "-bar",
						DomUtil.getAttribute(items.get(1), "name"));
			}
		}
	}

}

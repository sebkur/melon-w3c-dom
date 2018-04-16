// Copyright 2018 Sebastian Kuerten
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
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestIterable
{

	@Test
	public void testIteration()
			throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("test.xml");
		Document doc = builder.parse(is);

		NodeList items = doc.getElementsByTagName("item");

		int i = 0;

		NodeListIterable iterable = new NodeListIterable(items);
		for (Node node : iterable) {
			int p = i++;
			if (p == 0) {
				Assert.assertEquals("foo=\"bar\"", "bar",
						DomUtil.getAttribute(node, "foo"));
				Assert.assertEquals("test=\"foo\"", "foo",
						DomUtil.getAttribute(node, "test"));
			} else if (p == 1) {
				Assert.assertNull("foo is null",
						DomUtil.getAttribute(node, "foo"));
				Assert.assertEquals("test=\"bar\"", "bar",
						DomUtil.getAttribute(node, "test"));
			}
		}
	}

}

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

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestAttributes
{

	@Test
	public void testGetAttribute()
			throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = Util.document("test.xml");

		NodeList items = doc.getElementsByTagName("item");

		Node item0 = items.item(0);
		Assert.assertEquals("foo=\"bar\"", "bar",
				DomUtil.getAttribute(item0, "foo"));
		Assert.assertEquals("test=\"foo\"", "foo",
				DomUtil.getAttribute(item0, "test"));

		Node item1 = items.item(1);
		Assert.assertNull("foo is null", DomUtil.getAttribute(item1, "foo"));
		Assert.assertEquals("test=\"bar\"", "bar",
				DomUtil.getAttribute(item1, "test"));
	}

	@Test
	public void testGetValue()
			throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = Util.document("test.xml");

		NodeList items = doc.getElementsByTagName("item");

		NamedNodeMap attrs0 = items.item(0).getAttributes();
		Assert.assertEquals("foo=\"bar\"", "bar",
				DomUtil.getValue(attrs0, "foo"));
		Assert.assertEquals("test=\"foo\"", "foo",
				DomUtil.getValue(attrs0, "test"));

		NamedNodeMap attrs1 = items.item(1).getAttributes();
		Assert.assertNull("foo is null", DomUtil.getValue(attrs1, "foo"));
		Assert.assertEquals("test=\"bar\"", "bar",
				DomUtil.getValue(attrs1, "test"));
	}

}

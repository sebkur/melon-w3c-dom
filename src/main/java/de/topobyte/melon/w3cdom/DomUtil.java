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

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomUtil
{

	final static Logger logger = LoggerFactory.getLogger(DomUtil.class);

	public static String getAttribute(Node node, String name)
	{
		return getValue(node.getAttributes(), name);
	}

	public static String getValue(NamedNodeMap attrs, String name)
	{
		Node item = attrs.getNamedItem(name);
		if (item == null) {
			return null;
		}
		return item.getNodeValue();
	}

	public static Iterable<Node> iterable(NodeList list)
	{
		return new NodeListIterable(list);
	}

	public static List<Node> getChildElementsByTagName(Node node, String name)
	{
		List<Node> results = new ArrayList<>();
		for (Node child : iterable(node.getChildNodes())) {
			if (!(child instanceof Element)) {
				continue;
			}
			if (child.getNodeName().equals(name)) {
				results.add(child);
			}
		}
		return results;
	}

}

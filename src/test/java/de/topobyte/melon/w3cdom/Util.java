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
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Util
{

	public static Document document(String resource)
			throws IOException, SAXException, ParserConfigurationException
	{
		InputStream input = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(resource);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(input);
	}

}

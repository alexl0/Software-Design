package html;

import collections.Recorrible;

public class HtmlGenerator {
	public String writeHtml(Recorrible recorrible) {
		StringBuilder result = new StringBuilder();
		result.append("<html>\n");
		result.append("  <body>\n");
		result.append("    <ul>\n");

		for (int i = 0; i < recorrible.size(); i++) {
			result.append("      <li>" + recorrible.getElementAt(i) + "</li>\n");
		}

		result.append("    </ul>\n");
		result.append("  </body>\n");
		result.append("</html>\n");
		return result.toString();
	}
}
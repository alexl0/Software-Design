package html;

import collections.Iterator;

public class HtmlGenerator 
{
	public String writeHtml(Iterator iterator) 
    {    	
		StringBuilder result = new StringBuilder();
		result.append("<html>\n");
		result.append("  <body>\n");
		result.append("    <ul>\n");

        while (iterator.hasNext()) {
        	result.append("      <li>" + iterator.next() + "</li>\n");
        }
        	
        result.append("    </ul>\n");
        result.append("  </body>\n");
        result.append("</html>\n");
        return result.toString();
    }
}

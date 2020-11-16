package html;

import collections.Queue;

public class HtmlGenerator 
{
	public String writeHtml(Queue queue) 
    {    	
		StringBuilder result = new StringBuilder();
		result.append("<html>\n");
		result.append("  <body>\n");
		result.append("    <ul>\n");

        for (int i = 0; i < queue.size(); i++) {
        	result.append("      <li>" + queue.getElementAt(i) + "</li>\n");
        }
    	
	    result.append("    </ul>\n");
	    result.append("  </body>\n");
	    result.append("</html>\n");
	    return result.toString();
    }
}
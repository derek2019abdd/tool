import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
  public List<String> matchMultiline(String content, String pattern) {
    Matcher regexMatcher = Pattern.compile(pattern, Pattern.DOTALL).matcher(content);
    List<String> allMatches = new ArrayList<String>();
    while (regexMatcher.find()) {
      allMatches.add(regexMatcher.group());
    }
    return allMatches;
  }
//        <h:graphicImage id="pic2" styleClass="img" url="image/java.jpg" alt="${Bean.pic.text}"
//        title="example pic" rendered=${!empty Bean.pic}/>
  public String mapper(String element){
    Map<String, String> attributes = getAttributes(element);
    StringBuilder result = new StringBuilder();
    if(attributes.containsKey("rendered")){
      result.append("<c:if test=").append(handleRendered(attributes.get("rendered"))).append(">\n");
    }
    result.append("<img ");
    for(String key : attributes.keySet()){
      if(!key.equals("rendered")){
        result.append(key).append("=").append(handleXSS(attributes.get(key))).append(" ");
      }
    }
    result.deleteCharAt(result.length()-1).append("/>\n");
    if(attributes.containsKey("rendered")){
      result.append("</c:if>");
    }
    return result.toString();
  }

  private Map<String,String> getAttributes(String element){
      element = element.replace("<h:graphicImage", "").replace("/>", "").trim();

      Map<String, String> attributes = new HashMap<>();
      for(int i = 0; i < element.length(); i++){
        while(i < element.length() && Character.isWhitespace(element.charAt(i))){
          i++;
        }
        if(i >= element.length()){
          break;
        }
        StringBuilder keyBuffer = new StringBuilder();
        StringBuilder valBuffer = new StringBuilder();
        while(element.charAt(i) != '='){
          keyBuffer.append(element.charAt(i++));
        }
        i++;
        valBuffer.append(element.charAt(i++));
        while(element.charAt(i) != '"'){
          valBuffer.append(element.charAt(i++));
        }
        valBuffer.append(element.charAt(i++));
        attributes.put(keyBuffer.toString() ,valBuffer.toString());
      }
      return attributes;
  }
  private String mapKey(String key){
    return switch (key){
      case "value":
      case "url":
        yield "src";
      case "styleClass":
        yield "class";
      default:
        yield key;
    };
  }
  private String handleXSS(String value){
    return value.replace("${", "${fn:escaleXml(").replace("}", ")}");
  }
//  rendered=${!empty Bean.pic} -> <c:if test=${!empty fn:escapeXML(Bean.pic)}
  private String handleRendered(String value){
    return value.replace("${!empty ","${!empty fn:escapeXML(").replace("}", ")}");
  }
}

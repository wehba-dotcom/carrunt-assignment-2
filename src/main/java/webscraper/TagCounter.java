package webscraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class TagCounter {
  private String url;
  private String title;
  private String detials;
  private int h1Count,h2Count, divCount, bodyCount;
  private boolean isCalled=false;
  TagCounter(String url,String detials){
    this.url = url;
    this.detials=detials;
  }
  
  /*
  Connect to the URL and count the number of h1, h2, div and body Tags
  */
  public void doWork() {
    if(isCalled){
      return; //Tag values allready set
    }
    isCalled= true;
    Document doc;
    try {
      doc = Jsoup.connect(url).get();
      // get page title

      this.title = doc.title();
      Elements h1s = doc.select("h1");
      this.h1Count = h1s.size();
      Elements h2s = doc.select("h2");
      this.h2Count = h2s.size();
      Elements divs = doc.select("div");
      this.divCount = divs.size();
      Elements bodys = doc.select("body");
      this.bodyCount = bodys.size();
     /* bodys = doc.select("body");
      this.detials= bodys.text();*/
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public String getDetials() {
    return detials;
  }

  public void setDetials(String detials) {
    this.detials = detials;
  }

  public String getUrl(){
    return url;
  }
  public String getTitle() {
    return title;
  }

  public int getH1Count() {
    return h1Count;
  }

  public int getH2Count() {
    return h2Count;
  }

  public int getDivCount() {
    return divCount;
  }

  public int getBodyCount() {
    return bodyCount;
  }
  
}

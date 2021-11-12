package webscraper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;


class TagDTOs {
    public String title;
    public String timeSpent;
    public String detials;
    List<TagDTO> tags = new ArrayList<>();

    

    public TagDTOs(String title, List<TagDTO> tags,long time,String detials) {
     this.timeSpent = "" +((time) / 1_000_000) + " ms.";
     this.tags = tags; 
     this.title = title;
     this.detials=detials;
    }
}

public class TagDTO {
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  public TagDTO(TagCounter tc) {
    this.url = tc.getUrl();
    this.divCount = tc.getDivCount();
    this.bodyCount = tc.getBodyCount();
    this.detials =tc.getDetials();
  }
  
  public static String getTagsAsJson(String title, List<TagCounter> tagCounters,long time,String detials){
    List<TagDTO> tagCounterDTOs = new ArrayList<>();
    for(TagCounter tc : tagCounters){
        tagCounterDTOs.add(new TagDTO(tc));
    }
    return GSON.toJson(new TagDTOs(title, tagCounterDTOs,time,detials));
   }
    
   public static String getTagDTOList(String title, List<TagDTO> tagDtos,long time,String detials){
    List<TagDTO> tagCounterDTOs = new ArrayList<>();
    for(TagDTO dto : tagDtos){
        tagCounterDTOs.add(dto);
    }
    return GSON.toJson(new TagDTOs(title, tagCounterDTOs,time,detials));
   }
  
  public String url;
  public String detials;
  public int divCount;
  public int bodyCount;
}

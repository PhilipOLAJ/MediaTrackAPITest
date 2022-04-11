package model;

public class MediaModel {
    public String type;
    public String id;
    public String segment_type;
    public String title_list;
    public TitleList titleList;
    public int synopses;
    public int image_url;
    public OffSet offSet;
    public Uris uris;

    public MediaModel(String type, String id, String segment_type, String title_list, TitleList titleList, int synopses, int image_url, OffSet offSet, Uris uris) {
        this.type = type;
        this.id = id;
        this.segment_type = segment_type;
        this.title_list = title_list;
        this.titleList = titleList;
        this.synopses = synopses;
        this.image_url = image_url;
        this.offSet = offSet;
        this.uris = uris;
    }
    public MediaModel(){

    }
}

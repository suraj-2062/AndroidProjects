package com.example.calculatorconverter;

public class GetData {
    private String title,content,image_url,source_url;

    public GetData(String title, String content, String image_url, String source_url) {
        this.title = title;
        this.content = content;
        this.image_url = image_url;
        this.source_url = source_url;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return content;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSource_url() {
        return source_url;
    }
}

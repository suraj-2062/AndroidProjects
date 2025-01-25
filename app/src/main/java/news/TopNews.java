package news;

public class TopNews {
    public static void main(String args[]) {
        TopNews obj=new TopNews();
        String str=obj.generateTopNewsToUrl();
        System.out.println(str);
    }

    public String generateTopNewsToUrl() {
        String str = "https://www.inshorts.com/api/en/news?category=top_stories&max_limit=10&include_card_data=true&news_offset=xtnqdv2g-1";
        return str;
    }
}

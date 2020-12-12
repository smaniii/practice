package com.seth.hackerrank;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceCheck {

    //O(ep + ps) where ep is the number of expected products and ps is the number of products sold
    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice)
    {
        // Write your code here
        //O(ep) where ep is the number of expected products
        Map<String, Float> mapOfProductNameToExpectedProductPrice = new HashMap<>();
        for (int i = 0; i < products.size(); i++)
        {
            mapOfProductNameToExpectedProductPrice.put(products.get(i), productPrices.get(i));
        }
        //O(ps) where ps is the number of products sold
        int errorPrice = 0;
        for (int i = 0; i < productSold.size(); i++)
        {
            String productSoldName = productSold.get(i);
            Float realSoldPrice = soldPrice.get(i);
            Float expectedSoldPrice = mapOfProductNameToExpectedProductPrice.get(productSoldName);
            if (!realSoldPrice.equals(expectedSoldPrice))
            {
                errorPrice++;
            }
        }
        return errorPrice;
    }

    public static List<String> getArticleTitles(String author)
    {
        int currentPage = 1;
        int totalPages = 0;
        List<String> articles = new ArrayList<>();
        do
        {
            URL url = null;
            try
            {
                String stringBuilder = "https://jsonmock.hackerrank.com/api/articles?author=" +
                        author +
                        "&page=" +
                        currentPage;
                url = new URL(stringBuilder);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }

            HttpURLConnection connection = null;
            try
            {
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            connection.setRequestProperty("accept", "application/json");

            InputStream responseStream = null;
            try
            {
                responseStream = connection.getInputStream();
            } catch (IOException e)
            {
                e.printStackTrace();
            }

            Gson gson = new Gson();
            JsonParser jsonParser = new JsonParser();
            try
            {
                JsonElement jsonElement = jsonParser.parse(new InputStreamReader(responseStream, "UTF-8"));
                Article article = gson.fromJson(jsonElement, Article.class);
                List<Data> data = article.getData();
                for (Data datum : data)
                {
                    if (datum.getTitle() != null)
                    {
                        articles.add(datum.getTitle());
                    }
                    else if (datum.getStory_title() != null)
                    {
                        articles.add(datum.getStory_title());
                    }
                }
                totalPages = article.getTotal_pages();
                currentPage = article.getPage() + 1;
            }
            catch (UnsupportedEncodingException e)
            {
                e.printStackTrace();
            }
        }
        while (totalPages >= currentPage);
        return articles;
    }

    public class Article
    {
        private Integer page;

        private Integer total_pages;

        private List<Data> data;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(Integer total_pages) {
            this.total_pages = total_pages;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    public class Data
    {
        private String title;

        private String story_title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStory_title() {
            return story_title;
        }

        public void setStory_title(String story_title) {
            this.story_title = story_title;
        }
    }

}

class Car
{
    public void topSpeed()
    {
        System.out.println("Top Speed of the vehicle is 100 kmph");
    }

    public void fuelType()
    {
        System.out.println("Car fuel type is Petrol");
    }
}

class SUV extends Car
{
    @Override
    public void fuelType()
    {
        System.out.println("SUV fuel type is Diesel");
    }
}

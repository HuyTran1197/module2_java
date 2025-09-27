package m2_demo.document.controller;

import m2_demo.document.model.News;
import m2_demo.document.service.INewsService;
import m2_demo.document.service.NewsService;
import m2_demo.document.view.NewsView;

import java.util.List;

public class NewsController {
    private static INewsService newsService = new NewsService();

    static void showListNews() {
        List<News> newsList = newsService.getAll();
        NewsView.showList(newsList);
    }

    static void showListNews(List<News> newsList) {
        NewsView.showList(newsList);
    }
    static void addNews() {
        News news = NewsView.inputToAddNews();
        if (news != null) {
            boolean isSuccessAdd = newsService.add(news);
            if (isSuccessAdd) {
                System.out.println("Added news success");
            } else {
                System.out.println("Added news fail");
            }
        }
    }
}

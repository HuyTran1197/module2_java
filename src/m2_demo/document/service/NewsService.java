package m2_demo.document.service;

import m2_demo.document.model.News;
import m2_demo.document.repository.INewsRepo;
import m2_demo.document.repository.NewsRepo;

import java.util.List;

public class NewsService implements INewsService{
    private static INewsRepo newsRepo = new NewsRepo();

    @Override
    public List<News> getAll(){
        return newsRepo.getAll();
    }

    @Override
    public boolean add(News news){
        if (news==null){
            return false;
        }
        for (News n : newsRepo.getAll()){
            if (n.getIdDocument().equals(news.getIdDocument())){
                System.out.println("id is already exists");
                return false;
            }
        }
        List<News> list = getAll();
        int id = 1;
        if (!list.isEmpty()){
            id = list.get(list.size()-1).getId()+1;
        }
        news.setId(id);
        return newsRepo.add(news);
    }

    @Override
    public boolean delete(String id){
        return newsRepo.delete(id);
    }

    @Override
    public List<News> find(String name){
        return newsRepo.find(name);
    }

    public News findByID(String id){
        List<News> newsList = getAll();
        for (News n : newsList){
            if (n.getIdDocument().equals(id)){
                return n;
            }
        }
        return null;
    }
}

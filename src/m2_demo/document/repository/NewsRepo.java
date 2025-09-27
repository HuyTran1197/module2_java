package m2_demo.document.repository;

import m2_demo.document.model.News;
import m2_demo.document.util.ReadAndWriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsRepo implements INewsRepo{
    private final String NEWS_FILE = "src/m2_demo/document/data/news.csv";

    @Override
    public List<News> getAll(){
        List<News> newsList = new ArrayList<>();
        try {
            List<String> stringList = ReadAndWriteFile.readFileCSV(NEWS_FILE);
            String[] arr;
            for (String line : stringList){
                arr = line.split(",");
                News news = new News(Integer.parseInt(arr[0]),
                        arr[1],
                        arr[2],
                        arr[3],
                        arr[4],
                        Integer.parseInt(arr[5]),
                        Integer.parseInt(arr[6])
                        );
                newsList.add(news);
            }
        } catch (IOException e) {
            System.out.println("file read fail");
        }
        return newsList;
    }

    @Override
    public boolean add(News news){
        List<String> list = new ArrayList<>();
        list.add(news.getInfoCSV());
        try {
            ReadAndWriteFile.writeListStringToCSV(NEWS_FILE,list,true);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id){
        boolean isSuccessDelete = false;
        List<News> newsList = getAll();
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getIdDocument().equals(id)){
                newsList.remove(i);
                isSuccessDelete = true;
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (News n : newsList){
            stringList.add(n.getInfoCSV());
        }
        try {
            ReadAndWriteFile.writeListStringToCSV(NEWS_FILE,stringList,false);
        } catch (IOException e) {
            System.out.println("file write fail");
            return false;
        }
        return isSuccessDelete;
    }

    @Override
    public List<News> find(String name){
        List<News> newsList = getAll();
        List<News> newList = new ArrayList<>();
        for (News n : newsList){
            if (n.getIdDocument().equalsIgnoreCase(name)){
                newList.add(n);
                return newList;
            }
        }
        for (News n : newsList){
            if (n.getNameDocument().toLowerCase().contains(name.toLowerCase())){
                newList.add(n);
            }
        }
        return newList;
    }
}

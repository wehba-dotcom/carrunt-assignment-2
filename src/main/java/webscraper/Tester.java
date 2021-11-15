package webscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Tester {

    public static List<TagCounter> runThread() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=185723d3-1399-4cfe-b82d-add500d7c113","First del om thread"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=99074628-9fe8-496c-8e8e-add500d7c118","Secund del om thread"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=a7c2ca5e-21ac-4116-83e6-add60184ea15","Third del om thread"));

        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }
    public static List<TagCounter> runSequental() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=d944e4c5-4ee1-4539-8a21-add4010232b0", "First del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=f730364f-2ba9-411b-9fb2-add40102329c", "Secund del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=2bc9f118-3f2b-4374-902d-add40102329c", "Third del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=785daf97-4ccc-4569-a09e-add4010232a2", "Fouth del about JWT"));
        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }
    public static List<TagCounter> runParrallel() throws Exception{
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=d944e4c5-4ee1-4539-8a21-add4010232b0","First del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=f730364f-2ba9-411b-9fb2-add40102329c","Secund del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=2bc9f118-3f2b-4374-902d-add40102329c","Third del about JWT"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=785daf97-4ccc-4569-a09e-add4010232a2","Fouth del about JWT"));
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Future<TagCounter>> list = new ArrayList<>();
        for (TagCounter tc : urls) {
            Future<TagCounter> fut = executorService.submit(() -> {
                tc.doWork();
                return tc;
            });
            list.add(fut);
        }
        List<TagCounter> result = new ArrayList<>();
        for (Future<TagCounter> fut : list) {
            result.add(fut.get());
        }
        return result;
    }
    public static List<TagCounter> runRouting() throws Exception{
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=998aa360-8863-4cbe-8680-add301006293","First del about routing"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=63ed4ec4-2cd4-4931-b978-add300f57530","Secund del about routing"));
        urls.add(new TagCounter("https://cphbusiness.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=63ed4ec4-2cd4-4931-b978-add300f57530","Third del about routing"));

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        List<Future<TagCounter>> list = new ArrayList<>();
        for (TagCounter tc : urls) {
            Future<TagCounter> fut = executorService.submit(() -> {
                tc.doWork();
                return tc;
            });
            list.add(fut);
        }
        List<TagCounter> result = new ArrayList<>();
        for (Future<TagCounter> fut : list) {
            result.add(fut.get());
        }
        return result;
    }


    public static void main(String[] args) {
        long timeSequental;
        long start = System.nanoTime();

        List<TagCounter> fetchedData = new Tester().runSequental();
        long end = System.nanoTime();
        timeSequental = end - start;
        System.out.println("Time Sequential: " + ((timeSequental) / 1_000_000) + " ms.");

        for (TagCounter tc : fetchedData) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
        }

        /*
        
        start = System.nanoTime();
        //TODO Add your parrallel calculation here     
        long timeParallel = System.nanoTime() - start;
        System.out.println("Time Parallel: " + ((timeParallel) / 1_000_000) + " ms.");
        System.out.println("Paralle was " + timeSequental / timeParallel + " times faster");
       
         */
    }
}

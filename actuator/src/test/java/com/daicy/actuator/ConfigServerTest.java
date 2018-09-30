package com.daicy.actuator;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ConfigServerTest {

//    @Value("${daicy.lucky-word}")
//    String luckyWord;
//    @Test
//    public void test(){
//        System.out.println(luckyWord);
//    }
    static Set<String> downUrls = Sets.newHashSet();

    @Test
    public void testaa() throws IOException {
//
//        String site="https://vcloud.keepyoga.com/";
//        String site2="https://vcloud.keepyoga.com/";
//          downImages("https://vcloud.keepyoga.com/weixin/img/icon-my-together.png");
        String targetUrl = "https://vcloud.keepyoga.com/weixin/venue.php?brand_id=5996&venue_id=1&rn=2ff2ae16";
//        downUrls.add(targetUrl);
        try {
            findUrl(targetUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(doc.html());
//        FileUtils.writeStringToFile(new File("weixin/venue.php"),Jsoup.connect(targetUrl).get().html(html));
//        for (String url:downUrls){
//            downFile(url);
//            Thread.sleep();
//        }
    }

    public void findUrl(String url) throws IOException, InterruptedException {
        for (String str:downUrls){
            if(url.startsWith(str)){
                return;
            }
        }
        downFile(url);
        Set<String> urls = Sets.newHashSet();
        Document doc = Jsoup.connect(url).get();
        Elements as = doc.select("[href]");
        for (Element a : as) {
            String href = a.attr("abs:href");
            downFile(href);
            urls.add(href);
            Thread.sleep(1000);
        }

        Elements srcs = doc.select("[src]");
        for (Element a : srcs) {
            String href = a.attr("abs:src");
            System.out.println(href);
            downFile(href);
            urls.add(href);
            Thread.sleep(1000);
        }
        for (String urlStr:urls){
            if(urlStr.indexOf(".png?")>0||urlStr.indexOf(".js?")>0){
                continue;
            }
            findUrl(urlStr);
        }
    }

    public void downFile(String url) throws IOException {
       String[] urls = url.split("\\?");
       if(downUrls.contains(urls[0])){
             return;
        }
       downUrls.add(urls[0]);
       String[] strs = urls[0].split("com/");
       if(strs.length>1){
           String fileName = strs[1];
           if(fileName.endsWith(".png")||fileName.endsWith(".js")){
               downImages(url);
               return;
           }
           System.out.println(fileName);
//           fileName = fileName.replace(".php",".html");
           FileUtils.writeStringToFile(new File(fileName),Jsoup.connect(url).get().html());
       }
    }

    /**
     * 下载图片到指定目录
     *
     */
    public static void downImages(String imgUrl) {
        String[] imgUrls = imgUrl.split("\\?");
        String newImgUrl = imgUrls[0];
        String[] strs = imgUrls[0].split("com/");
        // 截取图片文件名
        String fileName = newImgUrl.substring(newImgUrl.lastIndexOf('/') + 1, newImgUrl.length());
        if(strs.length>1) {
            fileName = strs[1];
        }
//        // 若指定文件夹没有，则先创建
//        File dir = new File(filePath);
//        if (!dir.exists()) {
//            dir.mkdirs();
//        }

//        try {
//            // 文件名里面可能有中文或者空格，所以这里要进行处理。但空格又会被URLEncoder转义为加号
//            String urlTail = URLEncoder.encode(fileName, "UTF-8");
//            // 因此要将加号转化为UTF-8格式的%20
//            newImgUrl = newImgUrl.substring(0, newImgUrl.lastIndexOf('/') + 1) + urlTail.replaceAll("\\+", "\\%20");
//
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        // 写出的路径
        File file = new File(fileName);

        try {
            // 获取图片URL
            URL url = new URL(newImgUrl);
            // 获得连接
            URLConnection connection = url.openConnection();
            // 设置10秒的相应时间
            connection.setConnectTimeout(10 * 1000);
            // 获得输入流
            InputStream in = connection.getInputStream();
            // 获得输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            // 构建缓冲区
            byte[] buf = new byte[1024];
            int size;
            // 写入到文件
            while (-1 != (size = in.read(buf))) {
                out.write(buf, 0, size);
            }
            out.close();
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

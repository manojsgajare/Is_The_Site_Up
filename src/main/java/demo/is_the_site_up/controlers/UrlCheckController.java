
//http://localhost:8080/check?url=<Paste URL Here>
//follow this url check pattern to check any url site is up or not

package demo.is_the_site_up.controlers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlCheckController {
    private final String SITE_IS_UP = "Site is up!";
    private final String SITE_IS_DOWN = "Site is down!";
    private final String INCORRECT_URL  = "URL is incorrect!";


 
    @GetMapping("/check")
public String getUrlStatusMessage(@RequestParam String url){

    String returnMessage =" ";
    try {
        URL ObjeUrl = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ObjeUrl.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCodeCategory = conn.getResponseCode() / 100;
       if( responseCodeCategory != 2 || responseCodeCategory != 3){
        returnMessage = SITE_IS_UP;
       }
       else{
        returnMessage = SITE_IS_UP;
       }
    } catch (MalformedURLException e) {
        returnMessage = INCORRECT_URL;
    } catch (IOException e) {
        returnMessage = SITE_IS_DOWN;
    }

    return returnMessage;
}

}

package resume.creator.android;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ResumeService {
    public List<Resume> GetResumeList() throws IOException  {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://10.0.2.2:8080/resume/list?userId=1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            Gson gson = new Gson();
            Type listType = TypeToken.getParameterized(List.class, Resume.class).getType();

            String resumeList = response.body().string();
            return gson.fromJson(resumeList, listType);
        } catch (Exception e) {
            return new ArrayList<>();
        }

        //return new ArrayList<Resume>();
    }
}

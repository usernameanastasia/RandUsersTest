package usernameanastasia.randusersapp.Model;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private List<Result> results = new ArrayList<>();

    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
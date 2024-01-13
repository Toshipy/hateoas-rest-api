package springboot.hateoasrestapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class Greeting extends RepresentationModel<Greeting> {
    private final String content;

    //Jackson JSONライブラリがこのコンストラクタを使用してJSONデータからGreetingオブジェクトを作成する
    // 具体的には、もしJSONデータが { "content": "Hello, World!" } のような形式であれば、このJSONオブジェクトから
    // Greeting インスタンスを生成する際に、"Hello, World!" という文字列が content 引数としてコンストラクタに渡されます。
    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}

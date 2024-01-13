package springboot.hateoasrestapi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s";

    @RequestMapping("greeting")
    public HttpEntity<Greeting> greeting (
            @RequestParam(value="name", defaultValue= "World") String name) {
            Greeting greeting = new Greeting(String.format(TEMPLATE, name));
            // linkTo(...): Spring HATEOASの機能の一つで、リソースへのリンクを生成します。
            // methodOn メソッドはSpring MVCのコントローラーのメソッドに対するプロキシを作成し、そのメソッドの呼び出しを模倣します。
            // このリンクはリソース自身を参照しており、クライアントはこのリンクを使用してリソースにアクセスできます。
            greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}

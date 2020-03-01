package org.hero.controller;

import lombok.extern.log4j.Log4j;
import org.hero.domain.SampleVO;
import org.hero.domain.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

    @GetMapping(value = "/getText",produces = "text/plain; charset=UTF-8")
    public String getText(){
        log.info("MIME TYPE: "+ MediaType.TEXT_PLAIN_VALUE);
        return "Hello 한국말로는 안녕";
    }

    @GetMapping(value = "/getSample",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public SampleVO getSample(){
        return new SampleVO(20,"Kim","YeongUng");
    }

    @GetMapping(value = "/check",params = {"height","weight"})
    public ResponseEntity<SampleVO> check(Double height,Double weight){
        SampleVO vo = new SampleVO(0,""+height,""+weight);

        ResponseEntity<SampleVO> result = null;

        if(height<150)
            result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
        else
            result = ResponseEntity.status(HttpStatus.OK).body(vo);

        return result;
    }

    @GetMapping("/product/{cat}/{pid}")
    public String[] getPath(@PathVariable("cat") String cat,@PathVariable("pid") Integer pid){
        return new String[] {"category: "+cat,"productid: "+pid };
    }

    @PostMapping("/ticket")
    public Ticket convert(@RequestBody Ticket ticket){
        log.info("convert..........ticket: "+ticket);

        return ticket;
    }
}

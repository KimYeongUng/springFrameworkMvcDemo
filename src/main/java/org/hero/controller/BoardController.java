package org.hero.controller;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.hero.domain.BoardVO;
import org.hero.domain.Criteria;
import org.hero.domain.PageDTO;
import org.hero.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService service;

    @GetMapping("/list")
    public void list(Criteria cri,Model model){
        log.info("list.....");
        int total = service.getTotal(cri);
        log.info("total: "+total);
        model.addAttribute("list",service.getList(cri));
        model.addAttribute("pageMaker",new PageDTO(cri,total));
    }

    @GetMapping({"/get","/modify"})
    public void get(@RequestParam("bno")Long bno, Model model, @ModelAttribute("cri")Criteria cri){
        log.info("/get or modify");
        model.addAttribute("board",service.get(bno));
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(BoardVO board, RedirectAttributes rttr){
        log.info("register: "+board);
        service.register(board);
        rttr.addFlashAttribute("result",board.getBno());

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardVO board,RedirectAttributes rttr,@ModelAttribute("cri")Criteria cri){
        log.info("modify: "+board);

        if(service.modify(board)){
            rttr.addFlashAttribute("result","success");
        }

        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        rttr.addAttribute("type",cri.getType());
        rttr.addAttribute("keyword",cri.getKeyword());

        return "redirect:/board/list";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") Long bno,RedirectAttributes rttr,@ModelAttribute("cri")Criteria cri){
        log.info("remove....... "+bno);
        if(service.remove(bno)){
            rttr.addFlashAttribute("result","success");
        }
        rttr.addAttribute("pageNum",cri.getPageNum());
        rttr.addAttribute("amount",cri.getAmount());
        rttr.addAttribute("type",cri.getType());
        rttr.addAttribute("keyword",cri.getKeyword());
        return "redirect:/board/list";
    }
}
